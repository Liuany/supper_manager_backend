package com.example.xiaochun;

import com.example.xiaochun.model.entity.MemberInfo;
import com.example.xiaochun.service.MemberInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseTest {

    @Test
    public void createEntity(){
        MemberInfo mi = new MemberInfo();
        mi.setId("001");
        mi.setAddress("天鹅小区");
        System.out.println(mi.getId());
        System.out.println(mi.getAddress());
    }
}
