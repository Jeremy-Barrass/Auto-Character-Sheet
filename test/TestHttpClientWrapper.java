import HtmlParser.HttpClientWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest(HttpClientWrapper.class)
public class TestHttpClientWrapper {
    @Test
    public void testGetHtmlData_WhenPassedAUrl_itGetsTheHtmlFromThatPage() {
        // arrange
        HttpClientWrapper clientWrapper = new HttpClientWrapper();

        // act
        String result = clientWrapper.getHtmlData("/test/testHelpers/test-page.html");

        // assert
        Assert.assertEquals("<!DOCTYPE html>\n<htmlL>\n<head>\n<meta charset=\"utf-8\">\nTest\n</head>\n<body>\nHello World!\n</body>\n</html>", result);
    }
}
