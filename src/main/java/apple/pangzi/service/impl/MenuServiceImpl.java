package apple.pangzi.service.impl;

import apple.pangzi.service.MenuService;
import apple.pangzi.util.HttpClientUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    HttpClientUtils httpClientUtils;

    @Override
    public boolean add(JSONObject menuJson) {
        return false;
    }

}
