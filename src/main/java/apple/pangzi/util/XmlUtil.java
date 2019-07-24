package apple.pangzi.util;

import apple.pangzi.data.CommonMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlUtil {

    private static ObjectMapper xmlMapper = new XmlMapper();

    static {
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        xmlMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        xmlMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);
    }

    public static <T> T stringToBean(String xml, Class<T> t) {
        try {
            return xmlMapper.readValue(xml, t);
        } catch (Exception e) {
            return null;
        }
    }

    public static String beanToString(Object object) {
        try {
            return xmlMapper.writeValueAsString(object);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String xml = "<xml><ToUserName><![CDATA[gh_014b7a811988]]></ToUserName>" +
                "<FromUserName><![CDATA[oqFvaw2MsXo2tWuaJdlwa1DSKyK0]]></FromUserName>" +
                "<CreateTime>1563949375</CreateTime><MsgType><![CDATA[text]]></MsgType>" +
                "<Content><![CDATA[哈]]></Content><MsgId>22390372205284456</MsgId></xml>";
        CommonMessage commonMessage = stringToBean(xml, CommonMessage.class);
        System.out.println(beanToString(commonMessage));
    }
}
