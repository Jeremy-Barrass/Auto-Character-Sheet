package HtmlParser;

import interfaces.iHttpClientWrapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newBuilder;


public class HttpClientWrapper implements iHttpClientWrapper {
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;

    public HttpClientWrapper() {
        client = newBuilder().build();
    }

    public String getHtmlData(String url) throws IOException {
        request = HttpRequest.newBuilder().uri(URI.create(url)).build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(response -> {
//                System.out.println(response.statusCode());
//                return response;
//        }).thenApply(HttpResponse::body).thenAccept(System.out::println);
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("Request failed");
            e.printStackTrace();
        }
        return response.body();
    }
}
