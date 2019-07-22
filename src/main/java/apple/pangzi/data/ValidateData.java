package apple.pangzi.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateData {

    private String signature;

    private Long timestamp;

    private String nonce;

    private String echostr;

    public Map<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("timestamp", timestamp.toString());
        map.put("nonce", nonce);
        return map;
    }

    public List<String> toList() {
        List<String> list = new ArrayList<>();
        list.add(timestamp.toString());
        list.add(nonce.toString());
        return list;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    @Override
    public String toString() {
        return "ValidateData{" +
                "signature='" + signature + '\'' +
                ", timestamp=" + timestamp +
                ", nonce='" + nonce + '\'' +
                ", echostr='" + echostr + '\'' +
                '}';
    }
}
