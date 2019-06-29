import java.util.HashMap;
import java.util.Map;

/**
 * Created by cl on 2018/1/26.
 */
public class TestImpl implements TestInterface {
    public void say() {
    }

    public static void main(String[] args) {
        String json = "fsf{\"status\":200,\"path\":\"/v1/version/\",\"iot_version\":V1.0.0.0(91a),\"genDate\":Jun  5 2018,10:55:36,\"sdk_version\":1.4.0(c599790),\"hardware\":0.1,\"product\":plug,\"nonce\":4443}asfa";
        System.out.println(getByJson(json));

    }

    public static Map getByJson(String json) {
        Map map = new HashMap();
        if (json.contains("}")) {
            int index = json.indexOf("}");
            json = json.substring(0, index);
        }
        if (json.contains("{")) {
            int index = json.indexOf("{");
            json = json.substring(index+1, json.length());
        }
        json = json.replace("\"", "");
        String[] split1 = json.split(",");
        for (String split2 : split1) {
            String[] split3 = split2.split(":");
            String split4 = split3[0];
            String split5 = split3[1];
            map.put(split4, split5);
        }
        return map;
    }
}
