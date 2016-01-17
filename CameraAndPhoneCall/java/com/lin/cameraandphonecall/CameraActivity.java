package com.lin.cameraandphonecall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Lin on 2016/1/14.
 */
public class CameraActivity extends Activity{
    private Context context;
    private  String action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_camera);
        super.onCreate(savedInstanceState);
        context = this;
    }
    public void onClick(View view){
        action = MediaStore.ACTION_IMAGE_CAPTURE;
        Intent intent = new Intent(action);
        startActivityForResult(intent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        if(requestCode == 0){
            Bundle bundle = data.getExtras();
            Bitmap bmp = (Bitmap) bundle.get("data");
            iv.setImageBitmap(bmp);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
