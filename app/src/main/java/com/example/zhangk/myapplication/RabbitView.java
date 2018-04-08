package com.example.zhangk.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class RabbitView extends View{

    public float bitmapX ;
    public float bitmapY ;

    public RabbitView(Context context) {
        super(context);
        bitmapX = 100;
        bitmapY = 20;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_192);
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint);

        Log.i("paint",bitmapX+", " + bitmapY);
        if(bitmap.isRecycled()){
            bitmap.recycle();
        }
    }
}
