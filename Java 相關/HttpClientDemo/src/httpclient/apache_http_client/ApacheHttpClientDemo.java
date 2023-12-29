package httpclient.apache_http_client;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import bean.Post;

public class ApacheHttpClientDemo {

	public static void main(String[] args) throws Exception {
		getMethod();
		postMethod();
	}
	
	public static void getMethod() throws Exception {
		URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_OK) {
			String jsonResponse = IOUtils.toString(con.getInputStream());
			Post post = new Gson().fromJson(jsonResponse, Post.class);
			System.out.println(post);
		} else {
			System.out.println("GET request did not work.");
		}
	}
	
	public static void postMethod() throws Exception {
		URL url = new URL("https://jsonplaceholder.typicode.com/posts");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setDoOutput(true); 
        
		Post nPost = Post.builder().id(101).title("foo").body("bar").userId(1).build();
		try (OutputStream os = con.getOutputStream()) {
            IOUtils.write(new Gson().toJson(nPost), os, StandardCharsets.UTF_8.toString());
        }
		
		int responseCode = con.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_CREATED) {
			String jsonResponse = IOUtils.toString(con.getInputStream());
			Post post = new Gson().fromJson(jsonResponse, Post.class);
			System.out.println(post);
		} else {
			System.out.println("Post request did not work.");
		}
	}

}
