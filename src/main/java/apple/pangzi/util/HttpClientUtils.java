package apple.pangzi.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClientUtils {

    @Autowired
    private RestTemplate restTemplate;

    public String get(String url) {
        String resBody = restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
        return resBody;
    }

    public JSONObject post(String url, JSONObject params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(params, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, entity, String.class);
        String body = responseEntity.getBody();
        return JSONObject.parseObject(body);
    }
}
