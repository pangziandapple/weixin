package apple.pangzi.controller;

import apple.pangzi.data.CommonMessage;
import apple.pangzi.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Value("${weixin.token}")
    private String token;

    @PostMapping(value = "/api", produces = MediaType.APPLICATION_XML_VALUE)
    public String token(@RequestBody String requestBody) {
        logger.info("requestBody" + requestBody);
        CommonMessage commonMessage = XmlUtil.stringToBean(requestBody, CommonMessage.class);
        commonMessage.setContent("测试");
        String toUser = commonMessage.getFromUserName();
        commonMessage.setFromUserName(commonMessage.getToUserName());
        commonMessage.setToUserName(toUser);
        commonMessage.setMsgId(null);
        return XmlUtil.beanToString(commonMessage);
    }

}
