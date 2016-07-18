package com.test.questway.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

/**
 * Created by Owner on 7/12/2016.
 */
public class Photo {
    public static Bitmap getCircularBitmap(Bitmap bmp, int radius) {
      //  int radius = (int) (ProfileActivity.density * 60);
        Bitmap sbmp;
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        if(bmp.getWidth() != radius || bmp.getHeight() != radius) {
            if (bmp.getWidth() > bmp.getHeight()) {
                sbmp = Bitmap.createBitmap(bmp, (width - height) / 2, 0, height, height);
            } else {
                sbmp = Bitmap.createBitmap(bmp, 0, (height - width) / 2, width, width);
            }
            //   sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
        } else {
            sbmp = bmp;
        }
        Bitmap ssbmp = Bitmap.createScaledBitmap(sbmp, radius, radius, false);
        Bitmap output = Bitmap.createBitmap(ssbmp.getWidth(),
                ssbmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xffa19774;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, ssbmp.getWidth(), ssbmp.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));
        canvas.drawCircle(ssbmp.getWidth() / 2+0.7f, ssbmp.getHeight() / 2+0.7f,
                ssbmp.getWidth() / 2+0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(ssbmp, rect, rect, paint);

        return output;
    }
}
