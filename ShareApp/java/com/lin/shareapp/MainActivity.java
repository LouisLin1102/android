package com.lin.shareapp;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class MainActivity extends Activity {
    private Context context;
    private ImageView mImg;
    private EditText enterText;
    private  String action;
    private DisplayMetrics mPhone;
    private final static int CAMERA = 66 ;
    private final static int PHOTO = 99 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        enterText = (EditText) findViewById(R.id.setText);
        mPhone = new DisplayMetrics();
        mImg = (ImageView) findViewById(R.id.img);

    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.setBtn:
                String shareText = enterText.getText().toString();
                Intent setIntent = new Intent();
                action = Intent.ACTION_SEND;
                setIntent.setAction(action);
                setIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                setIntent.setType("text/plain");
                startActivity(Intent.createChooser(setIntent,"choose"));
                break;
            case R.id.openBtn:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PHOTO);
                break;
            case R.id.setAllBtn:
                String sText = enterText.getText().toString();

                Intent sIntent = new Intent();

                action = Intent.EXTRA_STREAM;
                ArrayList test = new ArrayList();
                test.add(sText);




                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {

        if ((requestCode == CAMERA || requestCode == PHOTO ) && data != null)
        {

            Uri uri = data.getData();
            ContentResolver cr = this.getContentResolver();

            try
            {

//                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                BitmapFactory.Options mOptions = new BitmapFactory.Options();
                mOptions.inSampleSize = 2;
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri),null,mOptions);

//                if(bitmap.getWidth()>bitmap.getHeight())ScalePic(bitmap,mPhone.heightPixels);
//                else
                    ScalePic(bitmap,mPhone.widthPixels);
            }
            catch (FileNotFoundException e)
            {
                Log.e("ddd","aaaa");
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void ScalePic(Bitmap bitmap,int phone)
    {

//        float mScale = 1 ;
//
//        if(bitmap.getWidth() > phone )
//        {
//
//            mScale = (float)phone/(float)bitmap.getWidth();
//
//            Matrix mMat = new Matrix() ;
//            mMat.setScale(mScale, mScale);
//
//            Bitmap mScaleBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), mMat, false);
//            mImg.setImageBitmap(mScaleBitmap);
//        }
//        else
            mImg.setImageBitmap(bitmap);
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
