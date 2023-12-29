package httpclient.unirest;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import bean.Post;

public class UniRestDemo {

	public static void main(String[] args) throws Exception {
		getMethod();
		postMethod();
	}

	public static void getMethod() throws Exception {
        HttpResponse<JsonNode> response = Unirest.get("https://jsonplaceholder.typicode.com/posts/1")
                .header("Accept", "application/json")
                .asJson();

        if (response.getStatus() == 200) {
            Post post = new Gson().fromJson(response.getBody().toString(), Post.class);
            System.out.println(post);
        } else {
            System.out.println("GET request did not work. Status code: " + response.getStatus());
        }
    }

    public static void postMethod() throws Exception {
        // Create Post object
        Post nPost = Post.builder().id(101).title("foo").body("bar").userId(1).build();

        // Convert Post object to JSON string
        String jsonInputString = new Gson().toJson(nPost);

        HttpResponse<JsonNode> response = Unirest.post("https://jsonplaceholder.typicode.com/posts")
                .header("Content-Type", "application/json")
                .body(jsonInputString)
                .asJson();

        if (response.getStatus() == 201) {
            Post post = new Gson().fromJson(response.getBody().toString(), Post.class);
            System.out.println(post);
        } else {
            System.out.println("POST request did not work. Status code: " + response.getStatus());
        }
    }
    
}
