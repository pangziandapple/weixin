package apple.pangzi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class StringUtil {

    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    public static String mapToString(Map<String, String> map) {
        if (map.isEmpty()) {
            return "";
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        StringBuffer valueStr = new StringBuffer();
        for (String key : list) {
            logger.info(key);
            valueStr.append(map.get(key));
        }
        return valueStr.toString();
    }

    public static String listToString(List<String> list){
        if(list == null || list.size() == 0){
            return "";
        }

        Collections.sort(list);
        StringBuffer valueStr = new StringBuffer();
        for (String val : list) {
            valueStr.append(val);
        }
        return valueStr.toString();
    }
}
