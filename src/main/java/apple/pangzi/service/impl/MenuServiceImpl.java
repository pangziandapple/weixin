package apple.pangzi.service.impl;

import apple.pangzi.data.WeiXinUrl;
import apple.pangzi.service.AccessTokenService;
import apple.pangzi.service.MenuService;
import apple.pangzi.util.HttpClientUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    private Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    HttpClientUtils httpClientUtils;

    @Autowired
    AccessTokenService accessTokenService;

    @Override
    public JSONObject add(JSONObject menuJson) {
        if (menuJson == null) {
            menuJson = new JSONObject();
            JSONArray menuArray = new JSONArray();
            JSONObject menu1 = new JSONObject();
            menu1.put("type", "view");
            menu1.put("name", "测试菜单");
            menu1.put("url", "https://www.baidu.com");
            menuArray.add(menu1);
            menuJson.put("button", menuArray);
        }
        JSONObject body = httpClientUtils.post(WeiXinUrl.CREATE_MENU_URL + "?access_token=" + accessTokenService.get(), menuJson);
        logger.info(body.toString());
        return body;
    }

}
