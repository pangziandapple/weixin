package apple.pangzi.util;

import apple.pangzi.data.CommonMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlUtil {

    public static <T> T stringToBean(String xml, Class<T> t){
        ObjectMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        xmlMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        xmlMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);
        try {
            return xmlMapper.readValue(xml, t);
        }catch (Exception e){
            return null;
        }
    }
}
