package com.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @AUTH zhaomengxia
 * @DATE 2018/4/18
 * @description:
 **/
@Document(collection = "data_model")
public class MongodbDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Field("factor_id")
    private String factorId;

    @Field("device_id")
    private String deviceId;

    @Field("time")
    private Long time;

    @Field("value")
    private Double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFactorId() {
        return factorId;
    }

    public void setFactorId(String factorId) {
        this.factorId = factorId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MongodbDataModel{" +
                "id=" + id +
                ", factorId='" + factorId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", time=" + time +
                ", value=" + value +
                '}';
    }
}
