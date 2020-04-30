import api.APIClient;
import api.APIException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class APIClientTest {
    private APIClient apiClient;
    @Before
    public void setup(){
        this.apiClient = new APIClient("https://postman-echo.com/");
    }
    private Object sendPost(String url, Map data) throws IOException, APIException {
        System.out.println("Send post url: " + url + " data: " + data);
        Object response = this.apiClient.sendPost(url, data);
        System.out.println("Receive: " + response.toString());
        return response;
    }
    private Object sendGet(String url) throws IOException, APIException {
        System.out.println("Send get url " + url);
        Object response = this.apiClient.sendGet(url);
        System.out.println("Receive: " + response.toString());
        return response;
    }
    @Test
    public void apiShouldPost() throws IOException, APIException {
        Map data = new HashMap();
        data.put("status_id", "status");
       sendPost("post",data);
    }

    @Test
    public void apiShouldGet() throws IOException, APIException {
        Map data = new HashMap();
        sendGet("get?foo1=bar1&foo2=bar2");
    }
}
