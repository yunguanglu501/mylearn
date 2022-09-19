package com.example.learn.fx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.example.learn.common.Result;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Type;
import java.util.List;

public class Test01 {
    public static void main(String[] args) throws Exception{
        String x = "{\n" +
                "    \"data\":{\n" +
                "        \"name\":\"username\",\n" +
                "        \"value\":\"root\"\n" +
                "    },\n" +
                "    \"msg\":\"Success\",\n" +
                "    \"ret\":0\n" +
                "}";
        FxPerson fxPerson = JSON.parseObject(null, FxPerson.class);
        System.out.println("fxPerson = " + fxPerson);
//        CommonResult<FxItem> fxItem = JSON.parseObject(x, new TypeReference<CommonResult<FxItem>>(){});
//        System.out.println("fxItem = " + fxItem);
//        FxItem data = fxItem.getData();
//        System.out.println("data = " + data);
//        CommonResult<FxItem> fxItemCommonResult = parseResultV2(x, FxItem.class);
//        CommonResult<FxItem> fxItemCommonResult = CommonResult.parseResultV2(x, FxItem.class);
//        System.out.println("fxItemCommonResult = " + fxItemCommonResult);
//        FxItem data = fxItemCommonResult.getData();
//        System.out.println("data = " + data);
//        FxItem fxItem = CommonResult.parseResultV3(x, FxItem.class);
//        System.out.println("fxItem = " + fxItem);
//        String y = "{\n" +
//                "\t\"data\": {\n" +
//                "\t\t\"gender\": \"男\",\n" +
//                "\t\t\"age\": \"12\",\n" +
//                "\t\t\"name\": \"张三\"\n" +
//                "\t},\n" +
//                "\t\"msg\": \"Success\",\n" +
//                "\t\"ret\": 0\n" +
//                "}";
////        parseResultV2()
//        CommonResult<FxPerson> fxPersonCommonResult = parseResultV2(y, FxPerson.class);
//        FxPerson data1 = fxPersonCommonResult.getData();
//        System.out.println("data1 = " + data1);
//
//        String z = "{\n" +
//                "\t\"data\": [{\n" +
//                "\t\t\"gender\": \"男\",\n" +
//                "\t\t\"age\": \"12\",\n" +
//                "\t\t\"name\": \"张三\"\n" +
//                "\t},\n" +
//                "\t{\n" +
//                "\t\t\"gender\": \"女\",\n" +
//                "\t\t\"age\": \"14\",\n" +
//                "\t\t\"name\": \"赵敏\"\n" +
//                "\t}],\n" +
//                "\t\"msg\": \"Success\",\n" +
//                "\t\"ret\": 0\n" +
//                "}";
//
//        CommonResult<List<FxPerson>> listCommonResult = parseListResult(z, FxPerson.class);
//        System.out.println("listCommonResult = " + listCommonResult);
//        List<FxPerson> data2 = listCommonResult.getData();
//        System.out.println("data2 = " + data2);
    }


//    private static <T> CommonResult<T> parseResultV2(String json, Class<T> clazz) {
//        return JSON.parseObject(json, new TypeReference<CommonResult<T>>(clazz) {
//        });
//    }

    private static <T> CommonResult<List<T>> parseListResult(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, buildType(CommonResult.class, List.class, clazz));
    }

    private static Type buildType(Type... types) {
        ParameterizedTypeImpl beforeType = null;
        if (types != null && types.length > 0) {
            for (int i = types.length - 1; i > 0; i--) {
                beforeType = new ParameterizedTypeImpl(new Type[]{beforeType == null ? types[i] : beforeType}, null, types[i - 1]);
            }
        }
        return beforeType;
    }



}
