package httpclient.apache_http_client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import bean.Post;

public class ApacheHttpClientDemo {

	public static void main(String[] args) throws Exception {
		getMethod();
		postMethod();
	}
	
	public static void getMethod() throws IOException {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet("https://jsonplaceholder.typicode.com/posts/1");

			try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
				int statusCode = response.getStatusLine().getStatusCode();

				if (statusCode == 200) {
					HttpEntity entity = response.getEntity();
					String jsonResponse = EntityUtils.toString(entity);
					Post post = new Gson().fromJson(jsonResponse, Post.class);
					System.out.println(post);
				} else {
					System.out.println("GET request did not work. Status code: " + statusCode);
				}
			}
		}
	}

	public static void postMethod() throws IOException {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpPost httpPost = new HttpPost("https://jsonplaceholder.typicode.com/posts");

			// Set headers
			httpPost.setHeader("Content-Type", "application/json; charset=UTF-8");

			// Create Post object
			Post nPost = Post.builder().id(101).title("foo").body("bar").userId(1).build();

			// Convert Post object to JSON string
			String jsonInputString = new Gson().toJson(nPost);

			// Set the request body
			httpPost.setEntity(new StringEntity(jsonInputString, StandardCharsets.UTF_8));

			try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
				int statusCode = response.getStatusLine().getStatusCode();

				if (statusCode == 201) {
					HttpEntity entity = response.getEntity();
					String jsonResponse = EntityUtils.toString(entity);
					Post post = new Gson().fromJson(jsonResponse, Post.class);
					System.out.println(post);
				} else {
					System.out.println("POST request did not work. Status code: " + statusCode);
				}
			}
		}
	}

}
