package HtmlParser;

import interfaces.iHttpClientWrapper;
import sun.net.www.http.HttpClient;

public class HttpClientWrapper extends HttpClient implements iHttpClientWrapper {
    public String getHtmlData(String url) {
        return null;
    }
}
