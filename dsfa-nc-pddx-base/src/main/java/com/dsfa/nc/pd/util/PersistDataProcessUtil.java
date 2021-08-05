package com.dsfa.nc.pd.util;


import com.dsfa.platform.sdk.json.JSONArray;
import com.dsfa.platform.sdk.json.JSONObject;
import com.dsfa.platform.starter.meta.core.model.persist.PersistData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import jdk.internal.org.objectweb.asm.TypeReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MapTrimUtil
 * @Description TODO
 * @Author pocky
 * @Date 2021/8/4
 **/
public class PersistDataProcessUtil {
    public static Map<String, Object> trimPrefixNamespace(String namespace, Map<String, Object> map1) {
        Map<String, Object> res = new HashMap<>();
        namespace = namespace.replace(".", "_");
        for (String key1 : map1.keySet()) {
            String newKey = key1.replace(namespace + ".", "");
            if (map1.get(key1) instanceof JSONArray) { // 存在子表,使用递归方式解析
                JSONArray arr = (JSONArray) map1.get(key1);
                List<Map> list = new LinkedList<>();
                for (int i = 0; i < arr.size(); i++) {
                    JSONObject jo = arr.getJSONObject(i);
                    // jo -> map
                    Map<String, Object> map2 = new HashMap();
                    for (String key2 : jo.keySet()) {
                        map2.put(key2 ,jo.get(key2));
                    }

                    // 递归
                    Map<String, Object> map3 = trimPrefixNamespace(key1, map2);
                    list.add(map3);
                }
                res.put(newKey, list);
                continue;
            }
            res.put(newKey, map1.get(key1));
        }
        return res;
    }

    public static <T> T loadAsForm(PersistData persistData, Class<T> target) {
        Map<String, Object> data = trimPrefixNamespace(persistData.getNamespace(), persistData.getData());
        T res = null;
        try {
            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(data);
            om.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode jn = om.readTree(json);
            res = om.readValue(om.treeAsTokens(jn), target);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
