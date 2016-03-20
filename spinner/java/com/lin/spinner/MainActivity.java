package com.lin.spinner;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class MainActivity extends Activity {
    private Spinner sp1,sp2,sp3;
    private Context context;
    private String[] plane =new String[]{"Mercury 水星","Venus 金星","Earth 地球","Mars 火星","Jupiter 木星","Saturn 土星","Uranus 天王星","Neptune 海王星"};
    private String[][] counties={{"台灣","+886"},{"日本","+81"},{"美國","+1"},{"韓國","+81"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        //XML宣告
        sp1 = (Spinner) findViewById(R.id.spinner);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object obj = parent.getItemAtPosition(position);
                Toast.makeText(context, "選擇: " + obj, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //JAVA實作1
        sp2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> plan_adapter = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,plane);

        plan_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(plan_adapter);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object obj = parent.getItemAtPosition(position);
                Toast.makeText(context,"選擇: "+obj,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //JAVA實作2
        sp3 = (Spinner) findViewById(R.id.spinner3);
        List<Map<String,String>> data = new ArrayList<Map<String,String>>();
        for(String[] country:counties){
            Map<String,String> map = new HashMap<String,String>();
            map.put("country_name",country[0]);
            map.put("country_code",country[1]);
            data.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                context,data,android.R.layout.simple_expandable_list_item_2,
                new String[]{"country_name","country_code"}
                ,new int[]{android.R.id.text1,android.R.id.text2});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapter);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Map<String,String> map =(Map<String,String>) parent.getItemAtPosition(position);
                Toast.makeText(context,"country_name: "+map.get("country_name")+""+"country_code: "+map.get("country_code"),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
