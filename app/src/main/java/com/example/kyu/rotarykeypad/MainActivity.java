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
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity implements OnTouchListener{
    private ImageView wheel;
    private double mCurrAngle = 0;
    private double mPrevAngle = 0;
    ImageView bask;
    TextView textbox;
    CharSequence num = null;
    int click_count = 0;
    int random_num;
    int tmp;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textbox= findViewById(R.id.box);
        final View bg = (View)findViewById(R.id.bg);
        final View bg01 = (View)findViewById(R.id.bg01);
        final View bg02 = (View)findViewById(R.id.bg02);
        final View bg03 = (View)findViewById(R.id.bg03);
        final View bg04 = (View)findViewById(R.id.bg04);

        wheel=(ImageView)findViewById(R.id.imageView1);
        wheel.setOnTouchListener(this);

        random_num = random.nextInt(4);
        System.out.println(random_num);

        if(random_num == 1){
            bg.setVisibility(View.INVISIBLE);
            bg01.setVisibility(View.VISIBLE);
            bg02.setVisibility(View.INVISIBLE);
            bg03.setVisibility(View.INVISIBLE);
            bg04.setVisibility(View.INVISIBLE);
        }else if(random_num == 2){
            bg.setVisibility(View.INVISIBLE);
            bg01.setVisibility(View.INVISIBLE);
            bg02.setVisibility(View.VISIBLE);
            bg03.setVisibility(View.INVISIBLE);
            bg04.setVisibility(View.INVISIBLE);
        }else if (random_num == 3){
            bg.setVisibility(View.INVISIBLE);
            bg01.setVisibility(View.INVISIBLE);
            bg02.setVisibility(View.INVISIBLE);
            bg03.setVisibility(View.VISIBLE);
            bg04.setVisibility(View.INVISIBLE);
        }else if (random_num == 4){
            bg.setVisibility(View.INVISIBLE);
            bg01.setVisibility(View.INVISIBLE);
            bg02.setVisibility(View.INVISIBLE);
            bg03.setVisibility(View.INVISIBLE);
            bg04.setVisibility(View.VISIBLE);
        }else {
            bg.setVisibility(View.VISIBLE);
            bg01.setVisibility(View.INVISIBLE);
            bg02.setVisibility(View.INVISIBLE);
            bg03.setVisibility(View.INVISIBLE);
            bg04.setVisibility(View.INVISIBLE);
        }

        ImageButton btn = (ImageButton)findViewById(R.id.imageButton);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event
                textbox.setText("");
                tmp = random.nextInt(4);
                System.out.println(tmp);
                if(random_num == tmp){
                    while(random_num == tmp){
                        random_num = random.nextInt(4);
                        System.out.println(random_num);
                    }
                }else {
                    random_num = tmp;
                }

                if(random_num == 1){
                    bg.setVisibility(View.INVISIBLE);
                    bg01.setVisibility(View.VISIBLE);
                    bg02.setVisibility(View.INVISIBLE);
                    bg03.setVisibility(View.INVISIBLE);
                    bg04.setVisibility(View.INVISIBLE);
                }else if(random_num == 2){
                    bg.setVisibility(View.INVISIBLE);
                    bg01.setVisibility(View.INVISIBLE);
                    bg02.setVisibility(View.VISIBLE);
                    bg03.setVisibility(View.INVISIBLE);
                    bg04.setVisibility(View.INVISIBLE);
                }else if (random_num == 3){
                    bg.setVisibility(View.INVISIBLE);
                    bg01.setVisibility(View.INVISIBLE);
                    bg02.setVisibility(View.INVISIBLE);
                    bg03.setVisibility(View.VISIBLE);
                    bg04.setVisibility(View.INVISIBLE);
                }else if (random_num == 4){
                    bg.setVisibility(View.INVISIBLE);
                    bg01.setVisibility(View.INVISIBLE);
                    bg02.setVisibility(View.INVISIBLE);
                    bg03.setVisibility(View.INVISIBLE);
                    bg04.setVisibility(View.VISIBLE);
                }else {
                    bg.setVisibility(View.VISIBLE);
                    bg01.setVisibility(View.INVISIBLE);
                    bg02.setVisibility(View.INVISIBLE);
                    bg03.setVisibility(View.INVISIBLE);
                    bg04.setVisibility(View.INVISIBLE);
                }
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
                if(random_num == 1){
                    if(39<mCurrAngle && mCurrAngle<55){
                        num = "2";
                    }else if(8<mCurrAngle && mCurrAngle<25){
                        num = "1";
                    }else if(-5>mCurrAngle && mCurrAngle>-23){
                        num = "9";
                    }else if(-36>mCurrAngle && mCurrAngle>-53){
                        num = "4";
                    }else if(-68>mCurrAngle && mCurrAngle>-85){
                        num = "5";
                    }else if(-97>mCurrAngle && mCurrAngle>-113){
                        num = "7";
                    }else if(-128>mCurrAngle && mCurrAngle>-143){
                        num = "8";
                    }else if(-155>mCurrAngle && mCurrAngle>-175){
                        num = "6";
                    }else if(156<mCurrAngle && mCurrAngle<174){
                        num = "0";
                    }else if(129<mCurrAngle && mCurrAngle<143){
                        num = "3";
                    }
                }else if(random_num == 2){
                    if(39<mCurrAngle && mCurrAngle<55){
                        num = "7";
                    }else if(8<mCurrAngle && mCurrAngle<25){
                        num = "2";
                    }else if(-5>mCurrAngle && mCurrAngle>-23){
                        num = "4";
                    }else if(-36>mCurrAngle && mCurrAngle>-53){
                        num = "6";
                    }else if(-68>mCurrAngle && mCurrAngle>-85){
                        num = "0";
                    }else if(-97>mCurrAngle && mCurrAngle>-113){
                        num = "5";
                    }else if(-128>mCurrAngle && mCurrAngle>-143){
                        num = "8";
                    }else if(-155>mCurrAngle && mCurrAngle>-175){
                        num = "9";
                    }else if(156<mCurrAngle && mCurrAngle<174){
                        num = "3";
                    }else if(129<mCurrAngle && mCurrAngle<143){
                        num = "1";
                    }
                }else if(random_num == 3){
                    if(39<mCurrAngle && mCurrAngle<55){
                        num = "8";
                    }else if(8<mCurrAngle && mCurrAngle<25){
                        num = "5";
                    }else if(-5>mCurrAngle && mCurrAngle>-23){
                        num = "0";
                    }else if(-36>mCurrAngle && mCurrAngle>-53){
                        num = "4";
                    }else if(-68>mCurrAngle && mCurrAngle>-85){
                        num = "6";
                    }else if(-97>mCurrAngle && mCurrAngle>-113){
                        num = "1";
                    }else if(-128>mCurrAngle && mCurrAngle>-143){
                        num = "2";
                    }else if(-155>mCurrAngle && mCurrAngle>-175){
                        num = "7";
                    }else if(156<mCurrAngle && mCurrAngle<174){
                        num = "3";
                    }else if(129<mCurrAngle && mCurrAngle<143){
                        num = "9";
                    }
                }else if(random_num == 4){
                    if (39 < mCurrAngle && mCurrAngle < 55) {
                        num = "1";
                    } else if (8 < mCurrAngle && mCurrAngle < 25) {
                        num = "2";
                    } else if (-5 > mCurrAngle && mCurrAngle > -23) {
                        num = "5";
                    } else if (-36 > mCurrAngle && mCurrAngle > -53) {
                        num = "0";
                    } else if (-68 > mCurrAngle && mCurrAngle > -85) {
                        num = "4";
                    } else if (-97 > mCurrAngle && mCurrAngle > -113) {
                        num = "8";
                    } else if (-128 > mCurrAngle && mCurrAngle > -143) {
                        num = "6";
                    } else if (-155 > mCurrAngle && mCurrAngle > -175) {
                        num = "9";
                    } else if (156 < mCurrAngle && mCurrAngle < 174) {
                        num = "3";
                    } else if (129 < mCurrAngle && mCurrAngle < 143) {
                        num = "7";
                    }
                }else {
                    if(39<mCurrAngle && mCurrAngle<55){
                        num = "1";
                    }else if(8<mCurrAngle && mCurrAngle<25){
                        num = "2";
                    }else if(-5>mCurrAngle && mCurrAngle>-23){
                        num = "3";
                    }else if(-36>mCurrAngle && mCurrAngle>-53){
                        num = "4";
                    }else if(-68>mCurrAngle && mCurrAngle>-85){
                        num = "5";
                    }else if(-97>mCurrAngle && mCurrAngle>-113){
                        num = "6";
                    }else if(-128>mCurrAngle && mCurrAngle>-143){
                        num = "7";
                    }else if(-155>mCurrAngle && mCurrAngle>-175){
                        num = "8";
                    }else if(156<mCurrAngle && mCurrAngle<174){
                        num = "9";
                    }else if(129<mCurrAngle && mCurrAngle<143){
                        num = "0";
                    }
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