package com.example.zhangk.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class RabbitView extends View{

    private float bitmapX ;
    private float bitmapY ;
    private float spaceX = 0;
    private float spaceY = 0;
    private Bitmap bitmap;

    public RabbitView(Context context) {
        super(context);
        bitmapX = 100;
        bitmapY = 20;

        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher_96);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        canvas.drawBitmap(bitmap, bitmapX - spaceX, bitmapY - spaceY, paint);

        if(bitmap.isRecycled()){
            bitmap.recycle();
        }
    }


    public void setMove(MotionEvent motionEvent) {
        bitmapX = motionEvent.getX();
        bitmapY = motionEvent.getY();
        invalidate();
    }

    public void setDow(MotionEvent motionEvent) {
        spaceX = motionEvent.getX() - bitmapX;
        spaceY = motionEvent.getY() - bitmapY;
        Log.i("dow", spaceX+", " + spaceY);
    }

    public void setUp(){
        bitmapX = bitmapX - spaceX;
        bitmapY = bitmapY - spaceY;

        spaceX = 0;
        spaceY = 0;
    }
}
