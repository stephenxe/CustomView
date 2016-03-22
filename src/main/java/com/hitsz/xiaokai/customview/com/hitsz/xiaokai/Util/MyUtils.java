package com.hitsz.xiaokai.customview.com.hitsz.xiaokai.Util;

import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/3/22.
 */
public class MyUtils {
    public static void startAnimOut(RelativeLayout view){
        startAnimOut(view, 0);
    }
    public static void startAnimOut(RelativeLayout view,long offset){
        RotateAnimation animation = new RotateAnimation(0,180,view.getWidth()/2,view.getHeight());
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setStartOffset(offset);

        view.startAnimation(animation);
    }

    public static void startAnimIn(RelativeLayout view){
        startAnimIn(view, 0);
    }

    public static void startAnimIn(RelativeLayout view,long offset){
        RotateAnimation animation = new RotateAnimation(180,360,view.getWidth()/2,view.getHeight());
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setStartOffset(offset);

        view.startAnimation(animation);
    }
    public static void startAnimIn(RelativeLayout view, int offset){
        RotateAnimation animation = new RotateAnimation(180,360,view.getWidth()/2,view.getHeight());
        animation.setDuration(200);
        animation.setFillAfter(true);
        animation.setStartOffset(200);
        view.startAnimation(animation);
    }
}
