package com.demo;

import com.demo.dao.api.IMongodbDataDAO;
import com.demo.model.MongodbDataModel;
import org.joda.time.DateTime;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * @AUTH zhaomengxia
 * @DATE 2018/4/20
 * @description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MongodbTest {

    @Autowired
    IMongodbDataDAO mongodbDataDAO;

    @org.junit.Test
    public void test1() {
        MongodbDataModel mongodbDataModel = new MongodbDataModel();
//        Long time = new DateTime().plusDays(-1).getMillis();
//        while (time < System.currentTimeMillis()) {
//            mongodbDataModel.setId(time);
//            mongodbDataModel.setDeviceId("0001");
//            mongodbDataModel.setFactorId("002");
//            mongodbDataModel.setTime(time);
//            mongodbDataModel.setValue(new Random().nextDouble() * 100);
//            mongodbDataDAO.save(mongodbDataModel);
//            time = new DateTime(time).plusMinutes(1).getMillis();
//        }
    }

    @org.junit.Test
    public void test2() {
        System.out.println(mongodbDataDAO.findAll().size());
    }

    @org.junit.Test
    public void test3() {
        System.out.println(mongodbDataDAO.find());
    }

    @org.junit.Test
    public void test4() {
        System.out.println(mongodbDataDAO.update(null));
    }

    @org.junit.Test
    public void test5() {
        System.out.println(mongodbDataDAO.delete(null));
    }
}
