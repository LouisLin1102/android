package com.lin.activitytohtml;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lin on 2016/3/15.
 */
public class PageActivity extends Activity{
    private TextView textView;
    private ImageView imageView;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);

        String title = getIntent().getStringExtra("title");
        int resId = getIntent().getIntExtra("resId",0);
        int txtId = getIntent().getIntExtra("txtId",0);
        String txt = getResources().getString(txtId);
        showData(title,resId,txt);
    }

    private void showData(String title,int resId,String txt){
        try{
        setTitle(title);
//            Toast.makeText(this,txt,Toast.LENGTH_SHORT).show();
            String html = null;
        switch (title){

            case "taiwan_info":
                html = txt.replaceAll(title,"<u><font color='yellow' >"+title+"Android HTML"+"</font></u>");
                break;
            case "sanya_info":
                html = txt.replaceAll(title,"<u><font color='red' >"+title+"Android HTML"+"</font></u><br>");
                break;
            case "great_view":
                html = txt.replaceAll(title,"<u><font color='black' >"+title+"Android HTML"+"</font></u>");
                break;
        }


        textView.setText(Html.fromHtml(html));
        imageView.setImageResource(resId);
        }catch (Exception e){
            Log.e("ddd", "aaaa");
        }


    }
}
