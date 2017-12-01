package com.example.wxc.wangxinchi1130;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * author:Created by WangXinChi on 2017/11/30.
 */

public class DrawView extends View {
    float x= 100f;
    float y= 100f;
    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        canvas.drawCircle(120,40,20,p);
        p.setAntiAlias(true);
        canvas.drawCircle(x,y,40,p);
        p.setColor(Color.RED);// 设置绿色
        canvas.drawLine(120, 80, 200, 80, p);// 画线
        canvas.drawLine(220, 80, 380, 160, p);// 斜线
        Shader mShader = new LinearGradient(0, 0, 100, 100,
                new int[] { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.LTGRAY }, null, Shader.TileMode.REPEAT);
        p.setShader(mShader);
        RectF oval2 = new RectF(60, 200, 200, 240);
        canvas.drawArc(oval2, 200, 130, true, p);
        oval2.set(210,100,250,130);
        canvas.drawOval(oval2, p);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x= event.getX();
        y=event.getY();
        invalidate();
        return true;
    }
}
