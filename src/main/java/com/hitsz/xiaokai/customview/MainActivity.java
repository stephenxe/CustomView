package com.hitsz.xiaokai.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hitsz.xiaokai.customview.com.hitsz.xiaokai.Util.MyUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    /**
     * 菜单按钮及其他按钮
     */
    private ImageView icon_menu;
    private ImageView icon_home;

    private ImageView channel1;
    private ImageView channel2;
    private ImageView channel3;
    private ImageView channel4;
    private ImageView channel5;
    private ImageView channel6;
    private ImageView channel7;

    private ImageView search;
    private ImageView information;



    /**
     * 布局
     */
    private RelativeLayout level1;
    private RelativeLayout level2;
    private RelativeLayout level3;


    /**
     * 判断菜单是否显示
     */
    private boolean isLevel3Show=true;
    private boolean isLevel2Show=true;
    private boolean isLevel1Show =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        icon_home= (ImageView) findViewById(R.id.icon_home);
        icon_menu= (ImageView) findViewById(R.id.icon_menu);

        search= (ImageView) findViewById(R.id.icon_search);
        information= (ImageView) findViewById(R.id.icon_myyouku);

        channel1= (ImageView) findViewById(R.id.channel1);
        channel2= (ImageView) findViewById(R.id.channel2);
        channel3= (ImageView) findViewById(R.id.channel3);
        channel4= (ImageView) findViewById(R.id.channel4);
        channel5= (ImageView) findViewById(R.id.channel5);
        channel6= (ImageView) findViewById(R.id.channel6);
        channel7= (ImageView) findViewById(R.id.channel7);

        level1= (RelativeLayout) findViewById(R.id.level1);
        level2= (RelativeLayout) findViewById(R.id.level2);
        level3= (RelativeLayout) findViewById(R.id.level3);

        icon_home.setOnClickListener(this);
        search.setOnClickListener(this);
        icon_menu.setOnClickListener(this);
        information.setOnClickListener(this);
        channel1.setOnClickListener(this);
        channel2.setOnClickListener(this);
        channel3.setOnClickListener(this);
        channel4.setOnClickListener(this);
        channel5.setOnClickListener(this);
        channel6.setOnClickListener(this);
        channel7.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icon_menu:	//处理 menu 图标的点击事件
                // 如果第3级菜单是显示状态，那么将其隐藏
                if(isLevel3Show){
                    //隐藏 第3级菜单
                    MyUtils.startAnimOut(level3);
                }else{
                    // 如果第3级菜单是隐藏状态，那么将其显示
                    MyUtils.startAnimIn(level3);
                }

                isLevel3Show = !isLevel3Show;

                break;
            case R.id.icon_home:	//处理 home 图标 的点击事件
                // 如果第2级菜单是显示状态，那么就隐藏，2，3级菜单
                if(isLevel2Show ){
                    MyUtils.startAnimOut(level2);
                    isLevel2Show = false;

                    if(isLevel3Show){ // 如果此时，第3级菜单也显示，那也将其隐藏
                        MyUtils.startAnimOut(level3,200);
                        isLevel3Show = false;
                    }

                }else{
                    // 如果第2级菜单是隐藏状态，那么就显示2级菜单
                    MyUtils.startAnimIn(level2);
                    isLevel2Show = true;
                }

                break;
            case R.id.icon_search:
                Toast.makeText(MainActivity.this,"搜索",Toast.LENGTH_SHORT).show();
                break;
            case R.id.icon_myyouku:
                Toast.makeText(MainActivity.this,"说明",Toast.LENGTH_SHORT).show();
                break;
            case R.id.channel1:
                Toast.makeText(MainActivity.this,"频道1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.channel2:
                Toast.makeText(MainActivity.this,"频道2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.channel3:
                Toast.makeText(MainActivity.this,"频道3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.channel4:
                Toast.makeText(MainActivity.this,"频道4",Toast.LENGTH_SHORT).show();
                break;
            case R.id.channel5:
                Toast.makeText(MainActivity.this,"频道5",Toast.LENGTH_SHORT).show();
                break;
            case R.id.channel6:
                Toast.makeText(MainActivity.this,"频道6",Toast.LENGTH_SHORT).show();
                break;
            case R.id.channel7:
                Toast.makeText(MainActivity.this,"频道7",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    /**
     * 改变第1级菜单的状态
     */
    private void changeLevel1State() {
        //如果第1级菜单是显示状态，那么就隐藏 1，2，3级菜单
        if(isLevel1Show){
            MyUtils.startAnimOut(level1);
            isLevel1Show = false;

            if(isLevel2Show){ // 判断2级菜单是否显示
                MyUtils.startAnimOut(level2,100);
                isLevel2Show = false;
                if(isLevel3Show){ // 判断3级菜单是否显示
                    MyUtils.startAnimOut(level3,200);
                    isLevel3Show = false;
                }
            }

        }else{
            //如果第1级菜单是隐藏状态，那么就显示 1，2级菜单
            MyUtils.startAnimIn(level1);
            isLevel1Show = true;

            MyUtils.startAnimIn(level2,200);
            isLevel2Show = true;

        }

    }



    @Override
    /**
     * 响应按键的动作
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_MENU){ // 监听 menu 按键
            changeLevel1State();
        }
        return super.onKeyDown(keyCode, event);
    }
}
