package com.ztesoft.zsmart.datamall.myservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ztesoft.zsmart.datamall.myservice.ormlite.bean.City;
import com.ztesoft.zsmart.datamall.myservice.ormlite.db.DatabaseHelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private City city;
    private EditText cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = (EditText) findViewById(R.id.cityName);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, MyService.class);
        this.startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, MyService.class);
        this.stopService(intent);
    }

    public void saveCityDB(View view) {
        Toast.makeText(this, "hah ", Toast.LENGTH_SHORT).show();
        findCityId();
    }

    private void findCityId() {

        try {
//            InputStreamReader inputReader = new InputStreamReader(getResources().getAssets().open("citycode.txt"));
            InputStreamReader inputReader = new InputStreamReader(this.getClass()
                    .getClassLoader()
                    .getResourceAsStream("assets/" + "citycode.txt")
                    , "utf-8"
            );
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            String[] str;

            while ((line = bufReader.readLine()) != null) {
                str = line.split("=");
                if (str.length == 2 && null != str[1] && !"".equals(str[1])) {
                    System.out.println("city name: " + str[1] + " city id: " + str[0]);

                    databaseHelper = DatabaseHelper.getHelper(MainActivity.this);
                    city = new City(str[0], str[1]);
                    databaseHelper.getCityDao().create(city);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void queryCity(View view) {
        String name = cityName.getText().toString().trim();
        databaseHelper = DatabaseHelper.getHelper(MainActivity.this);
        try {
            List<City> city = databaseHelper.getCityDao().queryBuilder().where().eq("cityName", name).query();
            System.out.println(city.size() > 0 ? city.get(0).getCityId() : "无数据");
            Toast.makeText(this, (city.size() > 0 ? name + " 的城市id为: " + city.get(0).getCityId() : "无数据"), Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
