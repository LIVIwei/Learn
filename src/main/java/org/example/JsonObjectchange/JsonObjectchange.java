package org.example.JsonObjectchange;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.EntityUtils;
import org.example.JsonObjectchange.domain.BCMReqBody;
import org.example.JsonObjectchange.domain.CompanyQueryAmountInfoRespBody;

import java.util.Map;

/**
 * @Author: LIVI
 * @Time: 2022/09/23  09:56
 * @Description: JSONObject转对象、集合、数组
 */
public class JsonObjectchange {

    /**
     * JSON.parseObject（String str）是将str转化为相应的JSONObject对象，
     * 其中str是“键值对”形式的json字符串，转化为JSONObject对象之后就可以使用其内置的方法，
     * 进行各种处理了。
     * */
    String response = "返回的是jason串";
    CompanyQueryAmountInfoRespBody respBody = JSONObject.toJavaObject(JSONObject.parseObject(response), CompanyQueryAmountInfoRespBody.class);


    /**
     * JSONObject转对象
    * */
    JSONObject reqMsg;
    BCMReqBody bcmReqBody = JSONObject.toJavaObject(reqMsg, BCMReqBody.class);






}
