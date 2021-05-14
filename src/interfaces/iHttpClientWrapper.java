package interfaces;

import java.io.IOException;

public interface iHttpClientWrapper {
    String getHtmlData(String url) throws IOException;
}
