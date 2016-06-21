package com.ztesoft.zsmart.datamall.myservice;

import android.test.AndroidTestCase;
import android.util.Log;

import com.ztesoft.zsmart.datamall.myservice.ormlite.bean.City;
import com.ztesoft.zsmart.datamall.myservice.ormlite.db.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends AndroidTestCase {
    public void testAddCity() {

        City u1 = new City("zhy", "2B青年");
        DatabaseHelper helper = DatabaseHelper.getHelper(getContext());
        try {
            helper.getCityDao().create(u1);
            u1 = new City("zhy2", "2B青年");
            helper.getCityDao().create(u1);
            u1 = new City("zhy3", "2B青年");
            helper.getCityDao().create(u1);
            u1 = new City("zhy4", "2B青年");
            helper.getCityDao().create(u1);
            u1 = new City("zhy5", "2B青年");
            helper.getCityDao().create(u1);
            u1 = new City("zhy6", "2B青年");
            helper.getCityDao().create(u1);

            testList();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void testDeleteCity() {
        DatabaseHelper helper = DatabaseHelper.getHelper(getContext());
        try {
            helper.getCityDao().deleteById(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void testUpdateCity() {
        DatabaseHelper helper = DatabaseHelper.getHelper(getContext());
        try {
            City u1 = new City("zhy-android", "2B青年");
            u1.setId(3);
            helper.getCityDao().update(u1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void testList() {
        DatabaseHelper helper = DatabaseHelper.getHelper(getContext());
        try {
            City u1 = new City("zhy-android", "2B青年");
            u1.setId(2);
            List<City> Citys = helper.getCityDao().queryForAll();
            Log.e("TAG", Citys.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}