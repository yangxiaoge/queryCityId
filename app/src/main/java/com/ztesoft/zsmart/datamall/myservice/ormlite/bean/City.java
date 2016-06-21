package com.ztesoft.zsmart.datamall.myservice.ormlite.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-06-21 9:49
 * Version: 1.0
 * TaskId:
 * Description:
 */

// 先在City类上添加@DatabaseTable(tableName = "tb_cityId")，标明这是数据库中的一张表
@DatabaseTable(tableName = "tb_cityId")
public class City {
    // generatedId 表示id为主键且自动生成
    @DatabaseField(generatedId = true)
    private int id;

    // @DatabaseField(columnName = "cityId") ，columnName的值为该字段在数据中的列名
    @DatabaseField(columnName = "cityId")
    private String cityId;

    @DatabaseField(columnName = "cityName")
    private String cityName;

    public City() {
    }

    public City(String cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
