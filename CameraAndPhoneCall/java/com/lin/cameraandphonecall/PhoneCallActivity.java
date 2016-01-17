package com.lin.cameraandphonecall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lin.cameraandphonecall.R;

/**
 * Created by Lin on 2016/1/14.
 */
public class PhoneCallActivity extends Activity{
    private Context context;
    private EditText phoneNum;
    private String action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.actitity_phonecall);
        super.onCreate(savedInstanceState);
        context = this;
        phoneNum = (EditText) findViewById(R.id.phoneNum);
        action = Intent.ACTION_CALL;
    }
    public void onClick(View view){
        String num = phoneNum.getText().toString();
        if(null==num || num.equals("")){
            Toast.makeText(context,"ERROR",Toast.LENGTH_LONG).show();
        }else{
            Uri uri = Uri.parse("tel:"+num);
            Intent intent =new Intent(action,uri);
            startActivity(intent);
        }
    }

}
