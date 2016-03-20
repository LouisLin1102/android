package com.lin.progressbar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends Activity {
    private SeekBar seekBar;
    private RatingBar ratingBar;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
    }

    public void onClick(View view){

        try{
            switch(view.getId()){
                case R.id.button:
                    int seekBarProcess = seekBar.getProgress();
                    Toast.makeText(context,"SeekBar Process : "+seekBarProcess,Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button2:
                    int ratingBarProcess = ratingBar.getProgress();
                    Toast.makeText(context,"RatingBar Process : "+ratingBarProcess,Toast.LENGTH_SHORT).show();
                    break;
            }

        }catch (Exception e){
            Log.e("error","");
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
