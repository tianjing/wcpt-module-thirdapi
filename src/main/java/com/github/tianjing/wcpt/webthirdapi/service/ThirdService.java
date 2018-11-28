package com.github.tianjing.wcpt.webthirdapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.tianjing.wcpt.webthirdapi.client.WcptClient;
import com.github.tianjing.wcpt.webthirdapi.core.Constants;
import tgtools.exceptions.APPErrorException;

/**
 * @author 田径
 * @Title
 * @Description
 * @date 16:31
 */
public class ThirdService {

    protected String appId;
    protected String host;
    protected int port;
    protected WcptClient client;

    public ThirdService(String pAppId, String pHost, int pPort) {
        appId = pAppId;
        host = pHost;
        port = pPort;
        client = new WcptClient(pAppId);
        client.setHost(host);
        client.setPort(port);
    }

    public static void main(String[] args) {
        String vAppId="6718AC63-5D41-431E-A077-FDAFDASFDAS";
        String vIp="192.168.1.134";
        int vPort=1340;
        String vUserId="1";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        try {
            //ThirdService vService = new ThirdService(vAppId, "172.17.3.106", 1340);
            //vService.pushNotify("<a href='site:///core/client/goto?userId=A0233B6D9C65F851F77382C637BCD992&url=http://172.17.3.106:1338/bus/client/autologin?userId=A0233B6D9C65F851F77382C637BCD992&url=/bus/eltqyxsjsbb/ddhbxxhz.html?userId=A0233B6D9C65F851F77382C637BCD992&taskId=9' target='_blank' class='a-link'>自定义内容</a>",2);
            //vService.pushUserNotify("推送的内容",1,vUserId);
            //vService.pushNotify("一个测试的应用消息",1);
            ArrayNode user= vService.listUser();
            ArrayNode user1= vService.listAllUser();
            //ArrayNode user2=vService.listOnlineUser();
            ArrayNode user3=vService.listDeptAllParent("2A3287A6-6073-48F3-A096-8CD55E3D4A81-00104");
            ArrayNode user4=vService.listOmsAllParent("04B1ED43-0FE8-434B-82D4-67F5E34CF536-47814");
            ArrayNode user5=vService.listSystemGroup();
            ArrayNode user6=vService.listGroupUser("B3440F57-B5BB-49B6-B0D1-9819FE41F5EE");
            ArrayNode user7=vService.listRole();
            ArrayNode user8=vService.listRoleUser("92BA4C35-1568-467A-9508-2B4AE4928546");

            System.out.println("end");
            // ArrayNode vUsers= vService.listUser();
            //System.out.println(vUsers);
        } catch (APPErrorException e) {
            e.printStackTrace();
        }
    }

    /**
     * 应用推送通知
     * @param pContent
     * @param pContentType
     * @throws APPErrorException
     */
    public void pushNotify(String pContent, int pContentType) throws APPErrorException {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        vJson.put("content", pContent);
        vJson.put("contentType", pContentType);
        JsonNode res = client.invoke("pushNotify", vJson);
        System.out.println(res);
    }

    /**
     * 应用推送通知给1个用户
     * @param pContent
     * @param pContentType
     * @param pRevicer
     * @throws APPErrorException
     */
    public void pushUserNotify(String pContent, int pContentType, String pRevicer) throws APPErrorException {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        vJson.put("content", pContent);
        vJson.put("contentType", pContentType);
        vJson.put("revicer", pRevicer);
        client.invoke("pushUserNotify", vJson);
    }

    /**
     * 获取当前应用关联的所有用户
     * @return
     * @throws APPErrorException
     */
    public ArrayNode listUser() throws APPErrorException {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        return (ArrayNode) client.invoke("listUser", null);
    }

    /**
     * 获取在线用户信息
     * @return
     * @throws APPErrorException
     */
    public ArrayNode listOnlineUser() throws APPErrorException {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        return (ArrayNode) client.invoke("listOnlineUser", null);
    }

    /**
     * 获取所有用户信息
     * @return
     * @throws APPErrorException
     */
    public ArrayNode listAllUser() throws APPErrorException {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        return (ArrayNode) client.invoke("listAllUser", null);
    }

    /**
     * 根据 dept id 从根到叶的所有节点
     * @param pDeptId
     * @return
     * @throws APPErrorException
     */
    public ArrayNode listDeptAllParent(String pDeptId) throws APPErrorException {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        vJson.put("id",pDeptId);
        return (ArrayNode) client.invoke("listDeptAllParent", vJson);
    }

    /**
     * 根据 oms id 从根到叶的所有节点
     * @param pOmsId
     * @return
     * @throws APPErrorException
     */
    public ArrayNode listOmsAllParent(String pOmsId) throws APPErrorException {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        vJson.put("id",pOmsId);
        return (ArrayNode) client.invoke("listOmsAllParent", vJson);
    }

    /**
     * 获取所有系统分组
     * @return
     * @throws APPErrorException
     */
    public ArrayNode listSystemGroup() throws APPErrorException
    {
        return (ArrayNode) client.invoke("listSystemGroup", null);
    }

    /**
     * 根据分组ID 获取所有用户
     * @param pGroupId
     * @return
     * @throws APPErrorException
     */
    public ArrayNode listGroupUser(String pGroupId) throws APPErrorException
    {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        vJson.put("id",pGroupId);
        return (ArrayNode) client.invoke("listGroupUser", vJson);
    }



    /**
     * 获取所有橘角色
     * @return
     * @throws APPErrorException
     */
    public ArrayNode listRole() throws APPErrorException
    {
        return (ArrayNode) client.invoke("listRole", null);
    }

    /**
     * 根据角色ID 获取所有用户
     * @param pRoleId
     * @return
     * @throws APPErrorException
     */
    public ArrayNode listRoleUser(String pRoleId) throws APPErrorException
    {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        vJson.put("id",pRoleId);
        return (ArrayNode) client.invoke("listRoleUser", vJson);
    }




}