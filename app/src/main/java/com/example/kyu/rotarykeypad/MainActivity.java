package com.example.kyu.rotarykeypad;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends Activity implements OnTouchListener{
    private ImageView wheel;
    private double mCurrAngle = 0;
    private double mPrevAngle = 0;
    RelativeLayout layout;
    ImageView bask;
    TextView textbox;
    TextView num00, num01, num02, num03, num04, num05, num06, num07, num08, num09;
    CharSequence num = null;
    int click_count = 0;
    int random_num;
    int rand_x = 0;
    int rand_y = 0;
    int tmp;
    Random random = new Random();

    final int arr[] = new int[10];
    boolean _switch[] = new boolean[arr.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textbox= findViewById(R.id.box);
        layout = findViewById(R.id.layout);
        num00 = findViewById(R.id.text00);
        num01 = findViewById(R.id.text01);
        num02 = findViewById(R.id.text02);
        num03 = findViewById(R.id.text03);
        num04 = findViewById(R.id.text04);
        num05 = findViewById(R.id.text05);
        num06 = findViewById(R.id.text06);
        num07 = findViewById(R.id.text07);
        num08 = findViewById(R.id.text08);
        num09 = findViewById(R.id.text09);

        wheel=(ImageView)findViewById(R.id.imageView1);
        wheel.setOnTouchListener(this);

        random_num = random.nextInt(4);

        for (int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        System.out.println("\n섞기 전");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }

        for (int i=0; i<_switch.length; i++){
            _switch[i] = true;
        }

        int w=0;
        int r;
        while (w<arr.length){
            r = (int)(Math.random()*arr.length);
            if(_switch[r]){
                _switch[r] = false;
                arr[w] = r;
                w++;
            }
        }
        System.out.println("\n섞은 후");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }

        num00.setText(arr[0]+"");
        num01.setText(arr[1]+"");
        num02.setText(arr[2]+"");
        num03.setText(arr[3]+"");
        num04.setText(arr[4]+"");
        num05.setText(arr[5]+"");
        num06.setText(arr[6]+"");
        num07.setText(arr[7]+"");
        num08.setText(arr[8]+"");
        num09.setText(arr[9]+"");

        ImageButton btn = (ImageButton)findViewById(R.id.imageButton);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event
                textbox.setText("");

                for (int i=0; i<arr.length; i++){
                    arr[i] = i;
                }
                System.out.println("\n섞기 전");
                for (int i=0; i<arr.length; i++){
                    System.out.print(arr[i]+" ");
                }

                for (int i=0; i<_switch.length; i++){
                    _switch[i] = true;
                }

                int w=0;
                int r;
                while (w<arr.length){
                    r = (int)(Math.random()*arr.length);
                    if(_switch[r]){
                        _switch[r] = false;
                        arr[w] = r;
                        w++;
                    }
                }
                System.out.println("\n섞은 후");
                for (int i=0; i<arr.length; i++){
                    System.out.print(arr[i]+" ");
                }

                rand_x = random.nextInt(200);
                rand_y = random.nextInt(700);

                layout.setX(-100 + rand_x);
                layout.setY(-300 + rand_y);

                num00.setText(arr[0]+"");
                num01.setText(arr[1]+"");
                num02.setText(arr[2]+"");
                num03.setText(arr[3]+"");
                num04.setText(arr[4]+"");
                num05.setText(arr[5]+"");
                num06.setText(arr[6]+"");
                num07.setText(arr[7]+"");
                num08.setText(arr[8]+"");
                num09.setText(arr[9]+"");

            }
        });

        btn.bringToFront();
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
                if(click_count == 4){
                    //textbox.setText("");
                    click_count = 0;
                }
                mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                System.out.println(mCurrAngle);
                if(39<mCurrAngle && mCurrAngle<55){
                    num = arr[1]+"";
                }else if(8<mCurrAngle && mCurrAngle<25){
                    num = arr[2]+"";
                }else if(-5>mCurrAngle && mCurrAngle>-23){
                    num = arr[3]+"";
                }else if(-36>mCurrAngle && mCurrAngle>-53){
                    num = arr[4]+"";
                }else if(-68>mCurrAngle && mCurrAngle>-85){
                    num = arr[5]+"";
                }else if(-97>mCurrAngle && mCurrAngle>-113){
                    num = arr[6]+"";
                }else if(-128>mCurrAngle && mCurrAngle>-143){
                    num = arr[7]+"";
                }else if(-155>mCurrAngle && mCurrAngle>-175){
                    num = arr[8]+"";
                }else if(156<mCurrAngle && mCurrAngle<174){
                    num = arr[9]+"";
                }else if(129<mCurrAngle && mCurrAngle<143){
                    num = arr[0]+"";
                }
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
                if(89<mCurrAngle && mCurrAngle<109 && num != null){
                    textbox.append(num);
                }
                System.out.println("Action Up");
                mPrevAngle = mCurrAngle = 0;
                wheel.clearAnimation();
                click_count++;
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