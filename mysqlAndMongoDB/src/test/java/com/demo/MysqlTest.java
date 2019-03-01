package com.demo;

import com.demo.dao.api.IMysqlDataRepository;
import com.demo.model.MysqlDataModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * @AUTH zhaomengxia
 * @DATE 2018/4/23
 * @description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MysqlTest {

    @Autowired
    IMysqlDataRepository mysqlDataRepository;

    @Test
    public void save() {
        MysqlDataModel mysqlDataModel = new MysqlDataModel();
        mysqlDataModel.setDeviceId("001");
        mysqlDataModel.setFactorId("0001");
        mysqlDataModel.setTime(System.currentTimeMillis());
        mysqlDataModel.setValue(new Random().nextDouble() * 1000);
        mysqlDataRepository.save(mysqlDataModel);
    }
}
