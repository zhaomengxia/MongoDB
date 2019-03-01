package com.demo.dao.api;

import com.demo.model.MysqlDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @AUTH zhaomengxia
 * @DATE 2018/4/23
 * @description:
 **/
public interface IMysqlDataRepository extends JpaRepository<MysqlDataModel, Long> {
}
