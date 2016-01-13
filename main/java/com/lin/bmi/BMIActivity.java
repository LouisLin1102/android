package com.lin.bmi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Lin on 2016/1/11.
 */
public class BMIActivity extends Activity{
    private TextView bmi_result;
    private String bmi_record;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        bmi_result = (TextView) findViewById(R.id.bmi_result);

        Bundle extras = getIntent().getExtras();
        double h = extras.getInt("height");
        double w = extras.getInt("weight");
        double bmiValue = (w/Math.pow(h,2))*10000;
        NumberFormat t = new DecimalFormat("##.00");
        bmi_record = String.format("%s %s %s",bmi_result.getText().toString(),t.format(bmiValue),getMessage(bmiValue));
        bmi_result.setText(bmi_record);
    }
    private String getMessage(double bmiValue){

        String message = "";
        if (bmiValue > 0 && bmiValue < 20) {
            message = getResources().getString(R.string.bmi_low);
        } else if (bmiValue >= 20 && bmiValue < 26) {
            message = getResources().getString(R.string.bmi_normal);
        } else if (bmiValue >= 26 && bmiValue < 30) {
            message = getResources().getString(R.string.bmi_high);
        } else if (bmiValue >= 30 && bmiValue <= 100) {
            message = getResources().getString(R.string.bmi_overhigh);
        } else {
            message = getResources().getString(R.string.bmi_value_error);
        }
        return message;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem backItem = menu.add(0, 0, 0, "<GO BACK");
        backItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (item.getItemId() == 0) {
            Intent intent = new Intent();
            intent.putExtra("bmi_record", bmi_record);
            setResult(1, intent);
            finish();
        }
        return super.onMenuItemSelected(featureId, item);
    }
}
