package com.hsuan.games;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;

public class PlayerInfoActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edPhone;
    private Spinner spiSex;
    private Spinner spiAges;
    private Spinner spiCity;
    private Spinner spiArea;
    private String name;
    private String[] area;
    private String[] sex;
    private ArrayList<String> ages;
    private String[] city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
        findviews();
        spinner();
    }
    private void findviews() {
        edName = (EditText) findViewById(R.id.ed_name);
        edPhone = (EditText) findViewById(R.id.ed_phone);
        spiSex = (Spinner) findViewById(R.id.spi_sex);
        spiAges = (Spinner) findViewById(R.id.spi_ages);
        spiCity = (Spinner) findViewById(R.id.spi_city);
        spiArea = (Spinner) findViewById(R.id.spi_area);
    }

    public void spinner() {
        sex = new String[]{"男", "女"};
        ArrayAdapter ad_sex = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sex);
        spiSex.setAdapter(ad_sex);

        ages = new ArrayList<>();
        for (int i = 15; i <= 100; i++) {
            ages.add(i + "");
        }
        ArrayAdapter ad_ages = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ages);
        spiAges.setAdapter(ad_ages);


        city = new String[]{"新北市", "台北市", "基隆市", "桃園市"};
        ArrayAdapter ad_city = new ArrayAdapter(this, android.R.layout.simple_list_item_1, city);
        spiCity.setAdapter(ad_city);
        spiCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, final int i1, long l) {
                area = null;
                switch (i1) {
                    case 0:
                        area = new String[]{"新莊區", "板橋區", "中和區", "三重區", "新店區", "土城區", "永和區", "蘆洲區", "汐止區", "樹林區", "淡水區", "三峽區", "林口區", "鶯歌區", "五股區", "泰山區", "瑞芳區", "八里區", "深坑區", "三芝區", "萬里區", "金山區", "貢寮區", "石門區", "雙溪區", "石碇區", "坪林區", "烏來區", "平溪區"};
                        break;
                    case 1:
                        area = new String[]{"大安區", "士林區", "內湖區", "文山區", "北投區", "中山區", "信義區", "松山區", "萬華區", "中正區", "大同區", "南港區"};
                        break;
                    case 2:
                        area = new String[]{"仁愛區", "中正區", "信義區", "中山區", "安樂區", "七堵區", "暖暖區"};
                        break;
                    case 3:
                        area = new String[]{"桃園區", "中壢區", "平鎮區", "八德區", "楊梅區", "蘆竹區", "龜山區", "龍潭區", "大溪區", "大園區", "觀音區", "新屋區", "復興區"};
                        break;
                }
                ArrayAdapter ad_area = new ArrayAdapter(PlayerInfoActivity.this, android.R.layout.simple_list_item_1, area);
                spiArea.setAdapter(ad_area);
                spiArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long l) {
                        getIntent().putExtra("INFO_CITY", city[i1]);
                        getIntent().putExtra("INFO_AREA", area[i2]);
                        setResult(RESULT_OK, getIntent());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void ok(View view) {
        name = edName.getText().toString();
        getIntent().putExtra("INFO_NAME", name);
        setResult(RESULT_OK, getIntent());
        finish();
    }

}
