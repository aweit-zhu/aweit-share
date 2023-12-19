package org.cdri;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class YahooFinance {

	private final static String blueColor = "\033[1;34m";

	private final static String resetColor = "\033[0m";

	public static void main(String[] args) throws ParseException, ClientProtocolException, IOException {
		System.setProperty("stock.api.url",
				"https://query1.finance.yahoo.com/v7/finance/download/%s?period1=%s&period2=%s&interval=1d&events=history");
		getStockData("0050.TW", "2023-12-18", "2023-12-19");
	}

	/**
	 * 
	 * @param stockNo: 股票號碼
	 * @return
	 * @throws IOException
	 */
	public static String getLatestStockData(String stockNo) throws IOException {
		LocalDate endDate = LocalDate.now();
		LocalDate startDate = endDate.minusDays(1);
		return getStockData(stockNo, startDate, endDate);
	}

	/**
	 * 
	 * @param stockNo:   股票號碼:0050.TW
	 * @param startDate: 起始日期:2023-12-01
	 * @param endDate:   結束日期:2023-12-31
	 * @return
	 * @throws IOException
	 */
	public static String getStockData(String stockNo, String startDateString, String endDateString) throws IOException {
		LocalDate endDate = LocalDate.parse(endDateString);
		LocalDate startDate = LocalDate.parse(startDateString);
		return getStockData(stockNo, startDate, endDate);
	}

	/**
	 * 
	 * @param stockNo:   股票號碼
	 * @param startDate: 起始日期
	 * @param endDate:   結束日期
	 * @return
	 * @throws IOException
	 */
	public static String getStockData(String stockNo, LocalDate startDate, LocalDate endDate) throws IOException {
		// 將開始和結束日期轉換為 Unix 時間戳（秒為單位）
		long period1 = startDate.atStartOfDay(ZoneId.of("UTC")).toEpochSecond();
		long period2 = endDate.atStartOfDay(ZoneId.of("UTC")).toEpochSecond();
		String url = String.format(System.getProperty("stock.api.url") != null ? System.getProperty("stock.api.url")
				: "https://query1.finance.yahoo.com/v7/finance/download/%s?period1=%s&period2=%s&interval=1d&events=history",
				stockNo, period1, period2);
		System.out.printf("%s%n", blueColor + url + resetColor);
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(url);
			String csvData = EntityUtils.toString(httpClient.execute(request).getEntity());
			// �N CSV �ഫ�� JSON
			String json = convertCsvToJson(csvData);
			System.out.printf("%s%n", blueColor + json + resetColor);
			return json;
		}
	}

	// CSV 轉 Json
	private static String convertCsvToJson(String csvData) throws IOException {
		try (CSVParser parser = CSVParser.parse(csvData, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
			List<Map<String, String>> records = new ArrayList<>();
			for (CSVRecord record : parser) {
				Map<String, String> map = new HashMap<>();
				record.toMap().forEach(map::put);
				records.add(map);
			}
			if (records.size() == 1) {
				return new Gson().toJson(records.get(0));
			} else {
				return new Gson().toJson(records);
			}
		}
	}
}
