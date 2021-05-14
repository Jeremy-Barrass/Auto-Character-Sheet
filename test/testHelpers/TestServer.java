package testHelpers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsServer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class TestServer implements Runnable {
    static String page;
    HttpsServer server;

    public TestServer() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader((String.format("%s/test/testHelpers/test-page.html", System.getProperty("user.dir")))))) {
            while (reader.readLine() != null) {
                page += reader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Test server failed to start.");
            e.printStackTrace();
        }
        server = HttpsServer.create(new InetSocketAddress(5000), 0);
    }

    public void run() {
        server.createContext("/", new RequestHandler());
        server.setExecutor(null);
        server.start();

//        try {
//            ServerSocket sock = new ServerSocket(5000);
//
//            while (!Thread.currentThread().isInterrupted()) {
//                Socket connectionSock = sock.accept();
//                PrintWriter writer = new PrintWriter(connectionSock.getOutputStream());
//                writer.println(page);
//                writer.close();
//            }
//        } catch (IOException e) {
//            System.out.println("Test server failed to connect");
//            e.printStackTrace();
//        }
    }

    static class RequestHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            exchange.sendResponseHeaders(200, page.getBytes(StandardCharsets.UTF_8).length);
            OutputStream os = exchange.getResponseBody();
            os.write(page.getBytes(StandardCharsets.UTF_8));
            os.close();
        }
    }
}
