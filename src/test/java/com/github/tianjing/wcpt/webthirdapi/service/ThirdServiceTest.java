package com.github.tianjing.wcpt.webthirdapi.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import tgtools.exceptions.APPErrorException;

public class ThirdServiceTest {

    @org.junit.Test
    public void main() {
            String vAppId="自己查";
            String vIp="192.168.1.134";
            int vPort=1340;
            String vUserId="自己查";
            ThirdService vService = new ThirdService(vAppId, vIp, vPort);
            try {
                vService.pushNotify("<a href='site:///core/client/goto?userId=A0233B6D9C65F851F77382C637BCD992&url=http://172.17.3.106:1338/bus/client/autologin?userId=A0233B6D9C65F851F77382C637BCD992&url=/bus/eltqyxsjsbb/ddhbxxhz.html?userId=A0233B6D9C65F851F77382C637BCD992&taskId=9' target='_blank' class='a-link'>自定义内容</a>",2);
                vService.pushUserNotify("推送的内容",1,vUserId);
                vService.pushNotify("一个测试的应用消息",1);
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
}