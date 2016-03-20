package com.lin.webview2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
    private Context context;
    private WebView webView;
    private EditText editText1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        editText1 = (EditText) findViewById(R.id.editText);
        webView = (WebView) findViewById(R.id.webView);
        // 支援 java script (警告:小心跨站script攻擊)
        webView.getSettings().setJavaScriptEnabled(true);
        // 支援放大縮小
        webView.getSettings().setSupportZoom(true);
        // 支援多點觸控式放大縮小
        webView.getSettings().setBuiltInZoomControls(true);
        // 讓 webview 具有 Progress 功能
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                setTitle("Loading..." + progress + "%");
                setProgress(progress * 100);
                if (progress == 100) {
                    setTitle(R.string.app_name);
                    Toast.makeText(context, "網頁載入完成 !", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
    public void onClick(View view) {
        String url = editText1.getEditableText().toString();
        webView.loadUrl(url);
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
