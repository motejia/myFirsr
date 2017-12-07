package com.example.acer.anmiatinoshow.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by acer on 2017/12/5.
 */

public class CircleView extends android.support.v7.widget.AppCompatImageView{

    private Matrix matrix;
    private Paint paint;
    private Bitmap mbitmap;
    private BitmapShader shader;

    public CircleView(Context context) {
        this(context,null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        matrix = new Matrix();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    public void draw(Canvas canvas) {
        Drawable drawable = getDrawable();
        Bitmap bitmap = getDrawable(drawable);
        if(bitmap != null){
            int width = getWidth();
            int height = getHeight();
            long min = Math.min(width, height);
            if(shader ==null || bitmap.equals(mbitmap)){
                mbitmap = bitmap;
                shader = new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            }
            if(shader != null){
                matrix.setScale(min/mbitmap.getWidth(),min/mbitmap.getHeight());
                shader.setLocalMatrix(matrix);
            }
            paint.setShader(shader);
            long l = min / 2;
            canvas.drawCircle(l,l,l,paint);
        }else{
            super.draw(canvas);
        }
    }

    private Bitmap getDrawable(Drawable drawable) {
        if(drawable instanceof BitmapDrawable){
            return ((BitmapDrawable)drawable).getBitmap();
        }else if(drawable instanceof ColorDrawable){
            Rect bounds = drawable.getBounds();
            int height = bounds.height();
            int width = bounds.width();
            Bitmap bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas();
            int color = ((ColorDrawable) drawable).getColor();
            canvas.drawARGB(Color.alpha(color),Color.red(color),Color.green(color),Color.blue(color));
            return bitmap;
        }
        return null;
    }
}
