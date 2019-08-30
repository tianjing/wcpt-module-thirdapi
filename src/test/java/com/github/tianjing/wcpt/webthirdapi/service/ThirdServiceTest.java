package com.github.tianjing.wcpt.webthirdapi.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import tgtools.exceptions.APPErrorException;

public class ThirdServiceTest {
    String vAppId = "6718AC63-5D41-431E-A077-FDAFDASFDAS";
    //String vIp = "172.17.3.106";
    String vIp = "192.168.1.135";

    int vPort = 1340;


    @Test
    public void pushNotify() throws APPErrorException {
        String vUserId = "15fc352f-409b-42be-be24-c3289d755711";
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        vService.pushNotify("<a href='site:///core/client/goto?userId=1&url=http%253A%252F%252F192.168.88.211%253A1338%252Fbus%252Fclient%252Fautologin%253FuserId%253D1%2526url%253D%25252Fbus%25252Flzxd%25252Fsb.html%25253FidSet%25253D231232%252526orderPerson%25253D%25252525E7%2525252594%25252525B0%25252525E5%25252525BE%2525252584%252526orderTime%25253D1543398073754%252526orderUnit%25253D%25252525E6%25252525B1%252525259F%25252525E8%252525258B%252525258F%25252525E7%252525259C%2525252581%252526content%25253D%25252525E5%25252525A1%25252525AB%25252525E5%2525252586%2525252599%25252525E7%252525259A%2525252584%25252525E5%2525252586%2525252585%25252525E5%25252525AE%25252525B9%252526areaId%25253D0' target='_blank' class='a-link'>自定义内容</a>", 2);
        vService.pushNotify("一个site://测试的应用消息", 1);
    }

    @Test
    public void pushNotify2() throws APPErrorException {
        String vUserId = "15fc352f-409b-42be-be24-c3289d755711";
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
    public void listUser() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user1 = vService.listUser();
    }

    @Test
    public void listOnlineUser() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user2 = vService.listOnlineUser();
    }

    @Test
    public void listAllUser() {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
    }

    @Test
    public void listDeptAllParent() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user3 = vService.listDeptAllParent("2A3287A6-6073-48F3-A096-8CD55E3D4A81-00104");
    }

    @Test
    public void listOmsAllParent() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user4 = vService.listOmsAllParent("04B1ED43-0FE8-434B-82D4-67F5E34CF536-47814");
    }

    @Test
    public void listSystemGroup() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user5 = vService.listSystemGroup();

    }

    @Test
    public void listGroupUser() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user6 = vService.listGroupUser("B3440F57-B5BB-49B6-B0D1-9819FE41F5EE");
    }

    @Test
    public void listRole() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user7 = vService.listRole();
    }

    @Test
    public void listRoleUser() throws APPErrorException {
        ThirdService vService = new ThirdService(vAppId, vIp, vPort);
        ArrayNode user8 = vService.listRoleUser("92BA4C35-1568-467A-9508-2B4AE4928546");
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
        String vUserId = "15fc352f-409b-42be-be24-c3289d755711";
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