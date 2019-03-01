package com.demo.dao.imp;

import com.demo.dao.api.IMongodbDataDAO;
import com.demo.model.MongodbDataModel;
import com.mongodb.WriteResult;
import com.mongodb.bulk.DeleteRequest;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @AUTH zhaomengxia
 * @DATE 2018/4/20
 * @description:
 **/
@Repository
public class MongodbDataDAO implements IMongodbDataDAO {


    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public void save(MongodbDataModel mongodbDataModel) {
        mongoTemplate.insert(mongodbDataModel);

    }

    @Override
    public void saveAll(List<MongodbDataModel> mongodbDataModel) {
        mongoTemplate.insertAll(mongodbDataModel);
    }

    @Override
    public MongodbDataModel delete(MongodbDataModel mongodbDataModel) {
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is(1524118683159L));
        DeleteResult result = mongoTemplate.remove(query, MongodbDataModel.class,"data_model");
        System.out.println(result);
        return null;
    }

    @Override
    public MongodbDataModel update(MongodbDataModel mongodbDataModel) {
        Query query = new Query();
        query.addCriteria(Criteria.where("time").is(1524118683159L));
        Update update = new Update().set("time", 15241186831589L).set("_id", 1524118683159L)
                .set("device_id", "001").set("value", 0.021313).set("factor_id", "0001");
        mongoTemplate.upsert(query, update, MongodbDataModel.class);
        return null;
    }

    @Override
    public MongodbDataModel find() {
        Query query = new Query();
        query.addCriteria(Criteria.where("time").is(1524118683158L).andOperator(Criteria.where("device_id").is("0001")));
        return mongoTemplate.findOne(query, MongodbDataModel.class);
    }

    @Override
    public List<MongodbDataModel> findAll() {
        Query query = new Query();
//        in查询
//        query.addCriteria(new Criteria("device_id").in("0001","0002"));
//        not in查询
//        query.addCriteria(new Criteria("device_id").nin("0001","0002"));
//        equal查询
//        query.addCriteria(new Criteria("device_id").is("0001"));
//        not equal
//        query.addCriteria(new Criteria("device_id").ne("0001"));
//        大于
//        query.addCriteria(new Criteria("time").gt(1524118683158L));
//        小于
//        query.addCriteria(new Criteria("time").lt(1524118683158L));
//        大于等于
//        query.addCriteria(new Criteria("time").gte(1524118683158L));
//        小于等于
//        query.addCriteria(new Criteria("time").lte(1524118683158L));
//        like
//        query.addCriteria(new Criteria("device_id").regex("01"));
//        not like
//        query.addCriteria(new Criteria("device_id").not().regex("01"));
//        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(new Criteria("device_id").regex("01")),
//                Aggregation.match(new Criteria("device_id").not().regex("01")));
//        return mongoTemplate.aggregate(aggregation, "data_model", MongodbDataModel.class);
//        or
        query.addCriteria(new Criteria().orOperator(new Criteria("device_id").regex("01"), new Criteria("device_id").not().regex("01")));
        System.out.println(query.toString());
        return mongoTemplate.find(query, MongodbDataModel.class);
    }
}
