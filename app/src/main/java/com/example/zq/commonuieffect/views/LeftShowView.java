package com.example.zq.commonuieffect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zq.commonuieffect.R;

/**
 * Created by zhenqiang on 2017/1/7.
 */

/**
 * 左划删除按钮(非Listiew)
 */
public class LeftShowView extends LinearLayout implements View.OnTouchListener {


    private static final String TAG = "LeftShowView";

    private TextView scrollView;
    private TextView button;

    private View rootView;

    public LeftShowView(Context context) {
        super(context);
        init(context);
    }

    public LeftShowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LeftShowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    private void init(final Context context) {
        rootView = LayoutInflater.from(context).inflate(R.layout.left_show_view_layout, this, false);
        scrollView = (TextView) rootView.findViewById(R.id.scrollView);
        button = (TextView) rootView.findViewById(R.id.button);
        addView(rootView);
        scrollView.setOnTouchListener(this);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了隐藏的内容", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private int downX;
    private int moveX;
    private int scrollX;

    private int currentScrollX = 0;

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getRawX();
                return true;
            case MotionEvent.ACTION_MOVE:
                moveX = (int) event.getRawX();
                scrollX = moveX - downX;
                if (scrollX < 0) {
                    //向左滑动
                    rootView.scrollTo(Math.min(-(scrollX - currentScrollX), button.getWidth()), 0);
                } else {
                    //向右滑动
                    if (scrollX > currentScrollX) {
                        scrollX = currentScrollX;
                    }
                    rootView.scrollTo(-(scrollX - currentScrollX), 0);//起始坐标没有变，这里花了一个小时才找对坐标.
                }
                break;
            case MotionEvent.ACTION_UP:
                currentScrollX = rootView.getScrollX();
                break;
        }
        return false;
    }
}
