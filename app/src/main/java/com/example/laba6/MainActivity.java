package com.example.laba6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    ImageView tweenImage, frameImage, roundRectImage, pathImage, arcImage;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tweenImage = findViewById(R.id.tweenAnimation);
        frameImage = findViewById(R.id.frameAnimation);
        roundRectImage = findViewById(R.id.roundRect);
        pathImage = findViewById(R.id.path);
        arcImage = findViewById(R.id.arc);

        SetTweenAnimation();
        SetFrameAnimation();
        SetRoundRectShape();
        SetPathShape();
        SetArcShape();
    }

    private void SetTweenAnimation()
    {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.total);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation)
            {
                tweenImage.startAnimation(animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        tweenImage.startAnimation(animation);
    }

    private void SetFrameAnimation()
    {
        frameImage.setImageResource(R.drawable.animation);

        AnimationDrawable frameAnimation = (AnimationDrawable) frameImage.getDrawable();
        frameAnimation.start();
    }

    private void SetRoundRectShape()
    {
        float[] outR = new float[] { 5, 10, 50, 70, 20, 20, 20, 20 };
        RectF rectF = new RectF(10, 10, 10, 10);
        float[] inR = new float[] { 40, 40, 20, 20, 40, 40, 20, 20 };

        ShapeDrawable roundRect = new ShapeDrawable(
                new RoundRectShape(outR, rectF, inR));
        roundRect.setIntrinsicHeight(500);
        roundRect.setIntrinsicWidth(500);
        roundRect.getPaint().setColor(Color.BLUE);

        roundRectImage.setImageDrawable(roundRect);
    }

    private void SetPathShape()
    {
        Path p = new Path();
        p.moveTo(50, 0);
        p.lineTo(25,50);
        p.lineTo(100,100);
        p.lineTo(0,50);
        p.lineTo(75,100);
        p.lineTo(50,0);

        ShapeDrawable path = new ShapeDrawable(new PathShape(p, 100, 100));
        path.setIntrinsicHeight(200);
        path.setIntrinsicWidth(200);
        path.getPaint().setColor(Color.BLACK);
        path.getPaint().setStyle(Paint.Style.STROKE);

        pathImage.setImageDrawable(path);
    }

    private void SetArcShape()
    {
        ShapeDrawable arc = new ShapeDrawable(new ArcShape(0, 365));
        arc.setIntrinsicHeight(300);
        arc.setIntrinsicWidth(300);
        arc.getPaint().setColor(Color.BLUE);
        arc.setAlpha(50);

        arcImage.setImageDrawable(arc);
    }
}