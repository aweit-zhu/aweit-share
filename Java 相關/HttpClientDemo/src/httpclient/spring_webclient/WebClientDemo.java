package httpclient.spring_webclient;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import bean.Post;

public class WebClientDemo {

	public static void main(String[] args) throws Exception {
		getMethod();
		postMethod();
	}

	public static void getMethod() {
        WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

        Post post = webClient.get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(Post.class)
                .block();

        if (post != null) {
            System.out.println(post);
        } else {
            System.out.println("GET request did not work.");
        }
    }

    public static void postMethod() {
        WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

        // Create Post object
        Post nPost = Post.builder().id(101).title("foo").body("bar").userId(1).build();

        Post post = webClient.post()
                .uri("/posts")
                .header("Content-Type", "application/json")
                .body(BodyInserters.fromValue(nPost))
                .retrieve()
                .bodyToMono(Post.class)
                .block();

        if (post != null) {
            System.out.println(post);
        } else {
            System.out.println("POST request did not work.");
        }
    }

}
