package com.example.tyr.testtoolbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button button;

    boolean isPlay = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(button,"rotation",0f,360f);
                ObjectAnimator moveIN = ObjectAnimator.ofFloat(button,"translationX",0f,500f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(button,"scaleX",1f,2f,1f,2f,1f);
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(button,"scaleY",1f,0.5f,1f,0.5f,1f);
                ObjectAnimator fadeIN = ObjectAnimator.ofFloat(button,"alpha",1f,0f,1f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setInterpolator(new LinearInterpolator());
                animatorSet.play(objectAnimator).with(fadeIN).with(scaleY).with(scaleX).after(moveIN);
                animatorSet.setDuration(10000);
                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        isPlay = true;
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        isPlay = false;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        isPlay = false;
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animatorSet.start();
            }
        });


    }
}
