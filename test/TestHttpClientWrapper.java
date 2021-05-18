import HtmlParser.HttpClientWrapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import testHelpers.TestServer;

import java.io.IOException;

@PrepareForTest(HttpClientWrapper.class)
public class TestHttpClientWrapper {
    TestServer server;

    @Before
    public void setUp() throws IOException {
        server = new TestServer();
        server.run();
    }

    @After
    public void tearDown(){
        server.finish();
    }

    @Test
    public void testGetHtmlData_WhenPassedAUrl_itGetsTheHtmlFromThatPage() throws IOException {
        // arrange
        HttpClientWrapper clientWrapper = new HttpClientWrapper();

        // act
        String result = clientWrapper.getHtmlData("http://127.0.0.1:5000"); // String.format("https://127.0.0.1:5000%s/test/testHelpers/test-page.html", System.getProperty("user.dir")));

        // assert
        Assert.assertEquals("<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <meta charset=\"utf-8\">\n"
                + "    <title>Test</title>\n"
                + "  </head>\n"
                + "  <body>\n"
                + "    Hello World!\n"
                + "  </body>\n"
                + "</html>\n",
                result);
    }
}
