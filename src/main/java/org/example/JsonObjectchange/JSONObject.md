发送http请求
<P>
OkHttpClient client = new OkHttpClient();
Headers headers = new Headers.Builder().add("TENANT_ID", "1").build(); //设置请求头
Request request1 = new Request.Builder().url(url).headers(headers).build();
Response response = client.newCall(request1).execute();
String body = response.body().string();  //获取body体
SONObject object = JSON.parseObject(body);  //转换json
<P>
下边为java中发送http请求返回数据
<p>
{
    "code": "0",
    "msg": "success",
    "state": true,
    "data": [
        {
            "id": 83,
            "createDate": "2020/08/11 17:09:08",
            "userId": 302,
            "type": 0,
            "user": {
                "name": "尼古拉斯赵四",
                "sex": "0",
                "mobile": "17695552323"
            }
        },
        {
            "id": 82,
            "createDate": "2020/08/11 12:24:11",
            "userId": 295,
            "type": 0,
            "user": {
                "name": "宇智波刘能",
                "sex": "0",
                "mobile": "17695552323"
            }
        },
        }
<p>
获取data数据
<p>JSONObject dataObj = object.getJSONObject(“data”);
<p>
转换数组
<p>JSONArray arr = object.getJSONArray(“data”);
<p>
再将数组转换成集合
<p>returnEntities = JSON.parseObject(JSONStr,new TypeReference<List>(){});
<p>
将data转换成对象
<p>
String JSONStr = JSON.toJSONString(dataObj);
BusLine busLine = JSON.parseObject(JSONStr, ReturnEntity.class);
<p>
ReturnEntity为实体类entity
<p>
导包：
   <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>1.2.58</version>
    </dependency>
<p>



