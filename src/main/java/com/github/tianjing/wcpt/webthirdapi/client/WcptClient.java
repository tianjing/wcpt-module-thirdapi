package com.github.tianjing.wcpt.webthirdapi.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.tianjing.wcpt.webthirdapi.core.Constants;
import tgtools.exceptions.APPErrorException;
import tgtools.json.JSONObject;
import tgtools.net.WebClient;
import tgtools.util.StringUtil;
import tgtools.web.util.ValidateHelper;

import java.io.IOException;

/**
 * @author 田径
 * @Title
 * @Description
 * @date 16:30
 */
public class WcptClient {

    private String appId;
    private String token;
    private String host;
    private int port;

    public WcptClient(String pAppId) {
        appId = pAppId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String pHost) {
        host = pHost;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int pPort) {
        port = pPort;
    }

    protected void initParam() throws APPErrorException {
        ValidateHelper.validEmptyParam(appId, "appid");
        ValidateHelper.validEmptyParam(host, "host");
        if (port < 1) {
            throw new APPErrorException("port错误；port：" + String.valueOf(port));
        }

    }

    public String getToken() throws APPErrorException {
        initParam();
        String url = "http://${host}:${port}/core/third/gettoken";
        url = StringUtil.replace(url, "${host}", host);
        url = StringUtil.replace(url, "${port}", String.valueOf(port));

        JSONObject vParam = new JSONObject();
        vParam.put("appid", appId);
        String vResult = getWebClient(url).doInvokeAsString(vParam.toString());
        JsonNode vResultNode = getResult(vResult);

        return vResultNode.asText();
    }

    protected JsonNode getResult(String pResult) throws APPErrorException {
        try {
            ObjectNode vResultNode = (ObjectNode) Constants.JOSNMAPPER.readTree(pResult);
            if (vResultNode.has("status")) {
                if (vResultNode.get("status").asBoolean()) {
                    return vResultNode.get("data");
                }
                throw new APPErrorException("服务器返回错误；内容：" + vResultNode.get("data").asText());
            }
            throw new APPErrorException("服务器返回未知内容：" + vResultNode.toString());
        } catch (JsonProcessingException e) {
            throw new APPErrorException("服务返回内容不是json；" + "Result：" + pResult + "原因：" + e.toString());
        } catch (IOException e) {
            throw new APPErrorException("服务返回内容不是json；" + "Result：" + pResult + "原因：" + e.toString());

        }
    }

    protected WebClient getWebClient(String pUrl) {
        WebClient vWebClient = new WebClient();
        vWebClient.setUrl(pUrl);
        vWebClient.setContentType("application/json");
        vWebClient.setMethod("POST");
        return vWebClient;
    }

    public JsonNode invoke(String pOperation,JsonNode pMessage) throws APPErrorException {
        initParam();
        if (StringUtil.isNullOrEmpty(token)) {
            token = getToken();
        }
        String url = "http://${host}:${port}/core/third/invoke";
        url = StringUtil.replace(url, "${host}", host);
        url = StringUtil.replace(url, "${port}", String.valueOf(port));
        ObjectNode vParam = Constants.JOSNMAPPER.createObjectNode();
        vParam.put("appid", appId);
        vParam.put("token", token);
        vParam.put("data", pMessage);
        vParam.put("operation",pOperation);
        String vResult = getWebClient(url).doInvokeAsString(vParam.toString());
        return getResult(vResult);
    }
}
