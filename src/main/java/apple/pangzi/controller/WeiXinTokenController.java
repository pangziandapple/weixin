package apple.pangzi.controller;

import apple.pangzi.data.ValidateData;
import apple.pangzi.util.SecurityUtil;
import apple.pangzi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class WeiXinTokenController {

    private Logger logger = LoggerFactory.getLogger(WeiXinTokenController.class);

    @Value("${weixin.token}")
    private String token;

    @GetMapping("/token")
    public String token(ValidateData validateData) {
        logger.info("token验证");
        List<String> params = validateData.toList();
        params.add(token);
        String sign = SecurityUtil.shaEncode(StringUtil.listToString(params));
        if (sign.equals(validateData.getSignature())) {
            return validateData.getEchostr();
        }
        return "false";
    }

}
