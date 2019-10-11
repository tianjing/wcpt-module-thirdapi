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
    public ArrayNode listAllUser(int pPageIndex) throws APPErrorException {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        vJson.put("pageIndex",pPageIndex);
        return (ArrayNode) client.invoke("listAllUser", vJson);
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


    /**
     * 根据机构ID 获取机构信息
     * @param pDeptId
     * @return
     * @throws APPErrorException
     */
    public ObjectNode getDept(String pDeptId) throws APPErrorException
    {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        vJson.put("id",pDeptId);
        return (ObjectNode) client.invoke("getDept", vJson);
    }

    /**
     * 根据 用户ID 获取用户机构信息
     * 注意：一个用户可能有多个机构
     * @param pUserId
     * @return
     * @throws APPErrorException
     */
    public ArrayNode getUserDept(String pUserId) throws APPErrorException
    {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        vJson.put("id",pUserId);
        return (ArrayNode) client.invoke("getUserDept", vJson);
    }

    /**
     * 根据 inst id 获取 网厂用户信息
     * @param pInstId
     * @return
     * @throws APPErrorException
     */
    public ArrayNode listUserByInstId(String pInstId) throws APPErrorException
    {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        vJson.put("instId",pInstId);
        return (ArrayNode) client.invoke("listUserByInstId", vJson);
    }

    /**
     * 根据 机构ID 获取 网厂用户信息
     * @param pDeptId
     * @return
     * @throws APPErrorException
     */
    public ArrayNode listUserByDeptId(String pDeptId) throws APPErrorException
    {
        ObjectNode vJson = Constants.JOSNMAPPER.createObjectNode();
        vJson.put("id",pDeptId);
        return (ArrayNode) client.invoke("listUserByDeptId", vJson);
    }
}