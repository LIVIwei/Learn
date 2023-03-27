package org.example.JsonObjectchange.domain;

import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

/**
 * 直连交行-》数币 请求报文体
 *
 *
 */
@JSONType(orders = {"biz_content","msg_id","timestamp","encrypt_key","sign"})
public class BCMReqBody {
    /**
     * 加密密文
     */
    @NotBlank(message = "加密密文不能为空")
//    @Length(max = 500)
    @JsonProperty("biz_content")
    private String bizContent;

    /**
     * 流水id
     *
     */
    @NotBlank(message = "流水不能为空")
//    @Length(max = 500)
    @JsonProperty("msg_id")
    private String msgId;

    /**
     * 时间  yyyy-mm-dd HH:MM:ss
     */
    @NotBlank(message = "时间不能为空")
//    @Length(max = 500)
    @JsonProperty("timestamp")
    private String timestamp;


    /**
     * 对称秘钥
     */
    @NotBlank(message = "对称秘钥不能为空")
//    @Length(max = 500)
    @JsonProperty("encrypt_key")
    private String encryptKey;

    /**
     * 签名
     */
    @NotBlank(message = "签名不能为空")
//    @Length(max = 500)
    @JsonProperty("sign")
    private String sign;



    public String getBizContent() {
        return bizContent;
    }

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "BCMReqBody{" +
                "bizContent='" + bizContent + '\'' +
                ", msgId='" + msgId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", encryptKey='" + encryptKey + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }

    /**
     * 验签需要固定顺序字符串
     * @return
     */
    public String toJsonString() {
        return  '{' +
                "\"biz_content\":" +"\""+ bizContent + "\"," +
                "\"msg_id\":" +"\""+ msgId + "\"," +
                "\"timestamp\":" +"\""+ timestamp + "\"," +
                "\"encrypt_key\":" +"\""+ encryptKey + "\"," +
                "\"sign\":" +"\""+ sign + "\""+
                '}';
    }
}

