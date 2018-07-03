package com.example.kyu.rotarykeypad;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnTouchListener{
    private ImageView wheel;
    private double mCurrAngle = 0;
    private double mPrevAngle = 0;
    ImageView bask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wheel=(ImageView)findViewById(R.id.imageView1);
        wheel.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(final View v, MotionEvent event) {
        final float xc = wheel.getWidth() / 2;
        final float yc = wheel.getHeight() /2;

        final float x = event.getX();
        final float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                System.out.println("Action Down");
                mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                System.out.println(mCurrAngle);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                mPrevAngle = mCurrAngle;
                mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                mPrevAngle -= 40;
                animate(mPrevAngle, mCurrAngle, 0);
                break;
            }
            case MotionEvent.ACTION_UP : {
                System.out.println("Action Up");
                mPrevAngle = mCurrAngle = 0;
                wheel.clearAnimation();
                break;
            }
        }
        return true;
    }

    private void animate(double fromDegrees, double toDegrees, long durationMillis) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(durationMillis);
        //rotate.setFillEnabled(true);
        rotate.setFillAfter(true); //움직이지 않으면 최초로 돌아가게 됨
        wheel.startAnimation(rotate);
        System.out.println(mCurrAngle);
    }
}