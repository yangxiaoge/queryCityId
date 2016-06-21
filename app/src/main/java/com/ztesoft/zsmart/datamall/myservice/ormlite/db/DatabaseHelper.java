package com.ztesoft.zsmart.datamall.myservice.ormlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.ztesoft.zsmart.datamall.myservice.ormlite.bean.City;

import java.sql.SQLException;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-06-21 9:57
 * Version: 1.0
 * TaskId:
 * Description: 参考 鸿洋: http://blog.csdn.net/lmj623565791/article/details/39121377
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String TABLE_NAME = "weather_cityid.db";

    // cityDao ，每张表对于一个
    private Dao<City, Integer> cityDao;

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, City.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, City.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static DatabaseHelper instance;

    /**
     * 单例获取该Helper
     *
     * @param context 上下文
     * @return instance
     */
    public static synchronized DatabaseHelper getHelper(Context context) {
        if (instance == null) {
            synchronized (DatabaseHelper.class) {
                if (instance == null) {
                    instance = new DatabaseHelper(context);
                }
            }
        }

        return instance;
    }

    /**
     * 获得cityDao
     *
     * @return
     * @throws SQLException
     */

    public Dao<City, Integer> getCityDao() throws SQLException {
        if (cityDao == null) {
            cityDao = getDao(City.class);
        }
        return cityDao;
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        super.close();
        cityDao = null;
    }
}
