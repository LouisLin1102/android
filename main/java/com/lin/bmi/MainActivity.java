package com.lin.bmi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Context context;
    private EditText bmi_height,bmi_weight;
    private TextView bmi_record;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        bmi_height = (EditText) findViewById(R.id.bmi_hight);
        bmi_weight = (EditText) findViewById(R.id.bmi_weight);
        bmi_record = (TextView) findViewById(R.id.bmi_record);
    }

    public void onClick(View view){
        try{
            int height = Integer.parseInt(bmi_height.getText().toString());
            int weight = Integer.parseInt(bmi_weight.getText().toString());
            Bundle extras = new Bundle();
            extras.putInt("height",height);
            extras.putInt("weight",weight);

            Intent intent = new Intent(context,BMIActivity.class);
            intent.putExtras(extras);
            startActivityForResult(intent, 1);

        }catch (Exception e){
            Toast.makeText(context,"ERROR",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == resultCode) {
            String record = data.getStringExtra("bmi_record");
            bmi_record.setText(getResources().getString(R.string.bmi_record)
                    + record);
        }
        super.onActivityResult(requestCode, resultCode, data);
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
