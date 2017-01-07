package com.example.zq.commonuieffect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.zq.commonuieffect.views.CurtainView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        Intent intent = new Intent();
        switch (vId) {
            case R.id.btn1:
                intent.setClass(this, SwipeItemActivity.class);
                break;
            case R.id.btn2:
                intent.setClass(this, CurtainViewActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
