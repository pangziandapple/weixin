package apple.pangzi.service.impl;

import apple.pangzi.service.AccessTokenService;
import apple.pangzi.util.HttpClientUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {

    @Value("${weixin.app-id}")
    private String appId;

    @Value("${weixin.app-secret}")
    private String appSecret;

    @Autowired
    private HttpClientUtils httpClientUtils;

    @Override
    public String get() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret;
        String body = httpClientUtils.get(url);
        if (StringUtils.isEmpty(body)) {
            return "";
        }

        JSONObject respBody = JSONObject.parseObject(body);
        return respBody.getString("access_token");
    }
}
