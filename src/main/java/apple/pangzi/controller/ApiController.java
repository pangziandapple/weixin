package apple.pangzi.controller;

import apple.pangzi.data.CommonMessage;
import apple.pangzi.data.WeiXinMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ApiController {

    private Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Value("${weixin.token}")
    private String token;

    @PostMapping(value = "/api",  produces = MediaType.APPLICATION_XML_VALUE)
    public CommonMessage token(@RequestBody String requestBody) {
        logger.info("requestBody" + requestBody);
        CommonMessage weiXinMessage = new CommonMessage();
        weiXinMessage.setMsgType("<![CDATA[text]]>");
        weiXinMessage.setContent("<![CDATA[您好！]]>");
        weiXinMessage.setFromUserName("<![CDATA[gh_014b7a811988]]>");
        weiXinMessage.setToUserName("<![CDATA[oqFvaw2MsXo2tWuaJdlwa1DSKyK0]]>");
        weiXinMessage.setCreateTime(new Date().getTime());
        weiXinMessage.setMsgId("22389079612823204");
        return weiXinMessage;
    }

}
