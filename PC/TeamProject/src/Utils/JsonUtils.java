package Utils;

import com.google.gson.Gson;

import java.util.List;

/**
 * Json序列化和反序列化工具类
 */
public class JsonUtils {
    //创建第三方工具
    private static Gson gson = new Gson();

    /**
     * 定义一个将JavaBean转换成Json格式数据的方法
     */
    public static String JsonSerialize(Object obj){
        return gson.toJson(obj);

    }
    public static String JsonSerializeList(List list){
        return gson.toJson(list);
    }

    /**
     * 定义一个利用第三方工具包的反序列化Json数据的方法
     */
    public static <T> T JsonDeserialization(String result,Class<T> classzz){
        return gson.fromJson(result,classzz);
    }
}
