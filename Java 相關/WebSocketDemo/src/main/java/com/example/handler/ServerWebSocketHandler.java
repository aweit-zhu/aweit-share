package com.example.handler;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.HtmlUtils;

import com.example.dao.SemiProductStockDaoImpl;
import com.example.entity.SemiProductStock;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Component("serverWebSocketHandler")
public class ServerWebSocketHandler extends TextWebSocketHandler {

	enum Prop {

		TYPE("type"), CONTENT("content");

		private String name;

		private Prop(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

	private final Gson gson = new Gson();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("Server connection opened");
		sessions.add(session);
		JsonObject messageObject = getJsonMessage("response", "one-time message from server");
		logger.info("Server sends: {}", messageObject);
		session.sendMessage(new TextMessage(gson.toJson(messageObject)));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		logger.info("Server connection closed: {}", status);
		sessions.remove(session);
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String request = message.getPayload();
		logger.info("Server received: {}", request);

		JsonObject messageObject = getJsonMessage("response",
				String.format("response from server to '%s'", HtmlUtils.htmlEscape(request)));
		logger.info("Server sends: {}", messageObject);
		session.sendMessage(new TextMessage(gson.toJson(messageObject)));
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) {
		logger.info("Server transport error: {}", exception.getMessage());
	}

	private void sendMessageToClient(WebSocketSession session, String message) throws IOException {
		JsonObject messageObject = getJsonMessage("response", message);
		session.sendMessage(new TextMessage(gson.toJson(messageObject)));
	}

	private void sendMessageToAllClients(String message) throws IOException {
		for (WebSocketSession session : sessions) {
			sendMessageToClient(session, message);
		}
	}

	private JsonObject getJsonMessage(String type, Object content) {
		JsonObject messageObject = new JsonObject();
		messageObject.addProperty(Prop.TYPE.getName(), type);
		messageObject.addProperty(Prop.CONTENT.getName(), content.toString());
		return messageObject;
	}

	/**
	 * 排程程式
	 */
	@Autowired
	private SemiProductStockDaoImpl semiProductStockDao;

	//@Scheduled(fixedRate = 10 * 1000) // 每 10 秒執行一次
	public void sendPeriodicMessages() throws IOException {
		List<SemiProductStock> semiProductStocks = semiProductStockDao.findLatestSemiProductStock();
		for (WebSocketSession session : sessions) {
			if (session.isOpen()) {
				JsonObject stockObject = new JsonObject();
				stockObject.addProperty(Prop.TYPE.getName(), "stocks");
				stockObject.add(Prop.CONTENT.getName(), gson.toJsonTree(semiProductStocks));
				logger.info("Server sends: {}", stockObject);
				session.sendMessage(new TextMessage(gson.toJson(stockObject)));
			}
		}
	}
}