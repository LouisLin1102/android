package com.lin.activitytohtml;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){


        try{

            Intent intent = new Intent(this,PageActivity.class);
            intent.putExtra("title",view.getTag().toString());
            switch (view.getId()){
                case R.id.iBtn1:
                    intent.putExtra("resId",R.drawable.banner1);
                    intent.putExtra("txtId",R.string.taiwan_info);
                    break;
                case R.id.iBtn2:
                    intent.putExtra("resId",R.drawable.banner2);
                    intent.putExtra("txtId",R.string.sanya_info);
                    break;
                case R.id.iBtn3:
                    intent.putExtra("resId",R.drawable.banner3);
                    intent.putExtra("txtId",R.string.great_view);
                    break;
            }
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, findViewById(view.getId()), view.getTag().toString()).toBundle());
        }catch (Exception e){
            Log.e("ddd", "aaaa");
        }




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
