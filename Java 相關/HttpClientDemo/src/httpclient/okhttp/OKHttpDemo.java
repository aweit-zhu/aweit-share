package httpclient.okhttp;

import java.io.IOException;

import com.google.gson.Gson;

import bean.Post;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpDemo {

	public static void main(String[] args) throws Exception {
		getMethod();
		postMethod();
	}
	
	public static void getMethod() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                Post post = new Gson().fromJson(jsonResponse, Post.class);
                System.out.println(post);
            } else {
                System.out.println("GET request did not work. Response code: " + response.code());
            }
        }
    }

    public static void postMethod() throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Create Post object
        Post nPost = Post.builder().id(101).title("foo").body("bar").userId(1).build();

        // Convert Post object to JSON string
        String jsonInputString = new Gson().toJson(nPost);

        // Set the request body
        RequestBody requestBody = RequestBody.create(jsonInputString, MediaType.parse("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                Post post = new Gson().fromJson(jsonResponse, Post.class);
                System.out.println(post);
            } else {
                System.out.println("POST request did not work. Response code: " + response.code());
            }
        }
    }

	

}
