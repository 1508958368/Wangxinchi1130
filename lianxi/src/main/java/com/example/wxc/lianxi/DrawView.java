package com.example.wxc.lianxi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * author:Created by WangXinChi on 2017/11/30.
 */

public class DrawView extends View {
    float x=100f;
    float y=100f;
    Paint mPaint = null;
    // 环形渐变渲染
    Shader mRadialGradient = null;
    public DrawView(Context context) {
        super(context);
        mRadialGradient = new RadialGradient(240, 240, 240, new int[] {
                Color.YELLOW, Color.GREEN, Color.TRANSPARENT, Color.RED },null,
                Shader.TileMode.REPEAT);

        mPaint = new Paint();
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    protected void onDraw(Canvas canvas) {
        // 绘制环形渐变
        mPaint.setShader(mRadialGradient);
        // 第一个,第二个参数表示圆心坐标
        // 第三个参数表示半径
        canvas.drawCircle(x, y, 200, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
     Toast.makeText(getContext(),"球动了",Toast.LENGTH_SHORT).show();
        x = event.getX();
        y = event.getY();
        invalidate();
        return true;
    }
}
