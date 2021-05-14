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
    Thread serverThread;

    @Before
    public void setUp() throws IOException {
        Runnable server = new TestServer();
        serverThread = new Thread(server);
        serverThread.start();
    }

    @After
    public void tearDown(){
        serverThread.interrupt();
    }

    @Test
    public void testGetHtmlData_WhenPassedAUrl_itGetsTheHtmlFromThatPage() throws IOException {
        // arrange
        HttpClientWrapper clientWrapper = new HttpClientWrapper();

        // act
        String result = clientWrapper.getHtmlData("https://127.0.0.1:5000"); // String.format("https://127.0.0.1:5000%s/test/testHelpers/test-page.html", System.getProperty("user.dir")));

        // assert
        Assert.assertEquals("<!DOCTYPE html>\n<htmlL>\n<head>\n<meta charset=\"utf-8\">\nTest\n</head>\n<body>\nHello World!\n</body>\n</html>", result);
    }
}
