package com.example.administrator.widgetdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_withcode = (Spinner) findViewById(R.id.spinner_code);
        data_list = new ArrayList<String>();
        data_list.add("bat");
        data_list.add("lady");
        data_list.add("super");
        data_list.add("unbelievable");
        // 适配器
        arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);

        // 设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 加载适配器
        spinner_withcode.setAdapter(arr_adapter);

        // 为spinner设置监听事件
//        Spinner.OnItemSelectedListener spinner_select = new Spinner.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                selected = spinner_withcode.getSelectedItem().toString();
//                showToast();
//                chooseHeroFromSpinner(selected);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                showToast();
//            }
//        };
//        spinner_withcode.setOnItemSelectedListener(spinner_select);
        final Spinner spinner_xml = (Spinner)findViewById(R.id.spinner);
        int heroId = 0;
        Spinner.OnItemSelectedListener spinner_select = new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected = spinner_xml.getSelectedItem().toString();
                showToast();
//                chooseHeroFromSpinner(selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                showToast();
            }
        };
//        spinner_withcode.setOnItemSelectedListener(spinner_select);
        spinner_xml.setOnItemSelectedListener(spinner_select);
//        if (selected.compareTo("蝙蝠侠") == 0) {
//            heroId = R.drawable.bat;
//        } else if (selected.compareTo("大超") == 0) {
//            heroId = R.drawable.superman;
//        } else if (selected.compareTo("神奇女侠") == 0) {
//            heroId = R.drawable.godess;
//        } else if (selected.compareTo("one老师") == 0) {
//            heroId = R.drawable.one;
//        } else {
//            heroId = R.drawable.bat;
//        }
//        heroImage.setImageResource(heroId);


    }

    private void showToast() {
        Toast.makeText(this, selected, Toast.LENGTH_SHORT).show();
    }

    private void chooseHeroFromSpinner(String string) {
        heroImage = (ImageButton) findViewById(R.id.heroImage);
        int heroId = 0;
        if (string.compareTo("bat") == 0) {
            heroId = R.drawable.bat;
        } else if(string.compareTo("lady") == 0) {
            heroId = R.drawable.godess;
        } else if(string.compareTo("super") == 0) {
            heroId = R.drawable.superman;
        } else if(string.compareTo("unbelievable") == 0) {
            heroId = R.drawable.one;
        }
        heroImage.setImageResource(heroId);
    }

    public void chooseHero(View view) {

        heroImage = (ImageButton)findViewById(R.id.heroImage);
        int heroImageId = 0;

        if (view.getId() == R.id.firstButton) {
            heroImageId = R.drawable.bat;
        } else if (view.getId() == R.id.secondButton) {
            heroImageId = R.drawable.superman;
        } else if (view.getId() == R.id.thirdButton) {
            heroImageId = R.drawable.godess;
        } else if (view.getId() == R.id.fourthButton) {
            heroImageId = R.drawable.one;

        }
        heroImage.setImageResource(heroImageId);


    }

    private Spinner spinner_withcode;
    private List<String>data_list;
    private ArrayAdapter<String> arr_adapter;
    ImageButton heroImage;
    String selected;
}
