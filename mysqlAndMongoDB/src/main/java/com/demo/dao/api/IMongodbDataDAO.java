package com.demo.dao.api;

import com.demo.model.MongodbDataModel;

import java.util.List;

/**
 * @AUTH zhaomengxia
 * @DATE 2018/4/20
 * @description:
 **/
public interface IMongodbDataDAO {

    void save(MongodbDataModel mongodbDataModel);

    void saveAll(List<MongodbDataModel> mongodbDataModel);

    MongodbDataModel delete(MongodbDataModel mongodbDataModel);

    MongodbDataModel update(MongodbDataModel mongodbDataModel);

    MongodbDataModel find();

    List<MongodbDataModel> findAll();
}
