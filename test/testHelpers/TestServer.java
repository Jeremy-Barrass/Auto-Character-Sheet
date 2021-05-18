package testHelpers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class TestServer {
    static File page;
    HttpServer server;

    public TestServer() throws IOException {
        page = new File(String.format("%s/test/testHelpers/test-page.html", System.getProperty("user.dir")));
        server = HttpServer.create(new InetSocketAddress(5000), 0);
    }

    public void run() {
        server.createContext("/", new RequestHandler());
        server.setExecutor(null);
        server.start();
    }

    public void finish() {
        server.stop(0);
    }

    static class RequestHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            exchange.sendResponseHeaders(200, page.length());
            OutputStream os = exchange.getResponseBody();
            os.write(Files.readAllBytes(page.toPath()));
            os.close();
        }

    }
}
