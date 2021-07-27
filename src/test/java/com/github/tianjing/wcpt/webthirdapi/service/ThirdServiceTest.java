package com.github.tianjing.wcpt.webthirdapi.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import tgtools.exceptions.APPErrorException;

public class ThirdServiceTest {
    String vAppId = "E75CBE45-8BCF-4889-8D80-D41DFFA2E247";
    //String vIp = "172.17.3.106";
    String vIp = "192.168.1.137";
    //String vIp = "192.168.88.1";
    //String vIp = "172.17.3.106";
    int vPort = 1340;
    static{
      //  System.setProperty("http.proxySet", "true");
      //  System.setProperty("http.proxyHost", "127.0.0.1");
      //  System.setProperty("http.proxyPort", "8888");
    }

    @Test
    public void pushNotify() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        vService.pushNotify("<a href='site:///core/client/goto?userId=1&url=http%253A%252F%252F192.168.88.211%253A1338%252Fbus%252Fclient%252Fautologin%253FuserId%253D1%2526url%253D%25252Fbus%25252Flzxd%25252Fsb.html%25253FidSet%25253D231232%252526orderPerson%25253D%25252525E7%2525252594%25252525B0%25252525E5%25252525BE%2525252584%252526orderTime%25253D1543398073754%252526orderUnit%25253D%25252525E6%25252525B1%252525259F%25252525E8%252525258B%252525258F%25252525E7%252525259C%2525252581%252526content%25253D%25252525E5%25252525A1%25252525AB%25252525E5%2525252586%2525252599%25252525E7%252525259A%2525252584%25252525E5%2525252586%2525252585%25252525E5%25252525AE%25252525B9%252526areaId%25253D0' target='_blank' class='a-link'>自定义内容</a>", 2);
        vService.pushNotify("一个site://测试的应用消息", 1);
    }

    @Test
    public void pushNotify2() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        vService.pushNotify("一个测试弹窗的应用消息", 3);
    }


    @Test
    public void pushUserNotify1() throws APPErrorException {
        String vUserId = "E5497306-F6D8-412C-83A8-2C7C3C17F412";
        String vContent="<a href='site:///core/' target='_blank' class='a-link'>site变量</a>";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        vService.pushUserNotify(vContent, 2, vUserId);
    }
    @Test
    public void pushUserNotify2() throws APPErrorException {
        String vUserId = "E5497306-F6D8-412C-83A8-2C7C3C17F412";
        String vContent="<a href='http://__ip__:1340/core/' target='_blank' class='a-link'>__ip__变量</a>";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        vService.pushUserNotify(vContent, 2, vUserId);
    }
    @Test
    public void pushUserNotify3() throws APPErrorException {
        String vUserId = "E5497306-F6D8-412C-83A8-2C7C3C17F412";
        String vContent="<a href='http://@ip:1340/core/' target='_blank' class='a-link'>@ip变量</a>";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        vService.pushUserNotify(vContent, 2, vUserId);
    }
    @Test
    public void pushUserNotify4() throws APPErrorException {
        String vUserId = "E5497306-F6D8-412C-83A8-2C7C3C17F412";
        String vContent="<a href='http://@ip:@port/core/' target='_blank' class='a-link'>@ip:@port变量</a>";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        vService.pushUserNotify(vContent, 2, vUserId);
    }
    @Test
    public void pushUserNotify5() throws APPErrorException {
        String vUserId = "E5497306-F6D8-412C-83A8-2C7C3C17F412";
        String vContent="<a href='http://@httpHost/core/' target='_blank' class='a-link'>@httpHost1变量</a>";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        vService.pushUserNotify(vContent, 2, vUserId);
    }

    @Test
    public void pushUserNotify6() throws APPErrorException {
        String vUserId = "C1218268-3D82-4BF0-A71C-2690EDE37CF0";
        String vContent="<a href='http://www.baidu.com/?userId=@userId&loginName=@loginName&t=@time' target='_custom:open:chrome' class='a-link'>userId loginName time url变量 测试</a>";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        vService.pushUserNotify(vContent, 2, vUserId);
    }

    @Test
    public void pushUserNotify7() throws APPErrorException {
        String vUserId = "15fc352f-409b-42be-be24-c3289d755711";
        String vContent="一个测试弹窗的应用消息";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        vService.pushUserNotify(vContent, 3, vUserId);
    }
    @Test
    public void pushUserNotify8() throws APPErrorException {
        String vUserId = "DESID-Dq_S7iHdD5lSQftbzDd_GSgDi5wiWN4JCF4Q94R1B0N-kruAcJZIsQ";
        String vContent="一个测试弹窗的应用消息";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        vService.pushUserNotify(vContent, 3, vUserId);
    }

    @Test
    public void pushUserNotify9() throws APPErrorException {
        String vUserId = "15fc352f-409b-42be-be24-c3289d755711";
        String vContent="{\n" +
                "  \"index\": 0,\n" +
                "  \"cmd\": 0,\n" +
                "  \"sessionId\": \"8E58FBDD-C2EF-4396-A816-4FE23AD30167\",\n" +
                "  \"content\": {\n" +
                "    \"css\": \"background-color:rgba(0,0,0,0.7);color:#fff;font-size:35px;font-family: 微软雅黑;\",\n" +
                "    \"x\": 0,\n" +
                "    \"y\": 50,\n" +
                "    \"text\": \"<div style='color:blue;width:100%;text-align:left;height:35px;margin-bottom: 10px;'>闫朝阳:你好，东善桥演习刘伟；事故汇报：13: 41 东善桥1号主变跳闸，经检查为网络遭受恶意代码攻击，导致1号主变主保护动作，已汇报华东网调。</div>\",\n" +
                "    \"height\": 500\n" +
                "  }\n" +
                "}";

        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        try {
            vService.pushUserNotify(new String(vContent.getBytes("utf-8"), "GB2312"), 5, vUserId);
        }catch (Throwable e)
        {}
    }



    @Test
    public void listUser() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user1 = vService.listUser();
        System.out.println(user1);
    }

    @Test
    public void listOnlineUser() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user1 = vService.listOnlineUser();
        System.out.println(user1);
    }

    @Test
    public void listAllUser() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user1 = vService.listAllUser(1);
        System.out.println(user1);
    }

    @Test
    public void listDeptAllParent() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user1 = vService.listDeptAllParent("2A3287A6-6073-48F3-A096-8CD55E3D4A81-00104");
        System.out.println(user1);
    }

    @Test
    public void listOmsAllParent() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user1 = vService.listOmsAllParent("04B1ED43-0FE8-434B-82D4-67F5E34CF536-47814");
        System.out.println(user1);
    }

    @Test
    public void listSystemGroup() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user1 = vService.listSystemGroup();
        System.out.println(user1);
    }

    @Test
    public void listGroupUser() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user1 = vService.listGroupUser("B3440F57-B5BB-49B6-B0D1-9819FE41F5EE");
        System.out.println(user1);
    }

    @Test
    public void listRole() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user1 = vService.listRole();
        System.out.println(user1);
    }

    @Test
    public void listRoleUser() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user1 = vService.listRoleUser("92BA4C35-1568-467A-9508-2B4AE4928546");
        System.out.println(user1);
    }


    @Test
    public void getDept() throws APPErrorException {
        String vDeptId = "0EB86ACB-FBDE-4F5F-801A-4BDE97BAA440-00005";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ObjectNode user8 = vService.getDept(vDeptId);
        System.out.println(user8);
    }

    @Test
    public void getUserDept() throws APPErrorException {
        //String vUserId = "15fc352f-409b-42be-be24-c3289d755711";
        String vUserId = "5c0814f4-1c02-4d09-a0f9-9fe020529a54";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user8 = vService.getUserDept(vUserId);
        System.out.println(user8);
    }


    @Test
    public void listUserByInstId() throws APPErrorException {
        String vInstId = "15205383";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user8 = vService.listUserByInstId(vInstId);
        System.out.println(user8);
    }

    @Test
    public void listUserByDeptId() throws APPErrorException {
        String vDeptId = "F104A09B-F4C9-4A36-A19E-CBA67775B641-00312";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user8 = vService.listUserByDeptId(vDeptId);
        System.out.println(user8);
    }
}