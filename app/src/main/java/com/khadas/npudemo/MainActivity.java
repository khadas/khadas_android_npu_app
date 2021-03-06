package com.khadas.npudemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.util.Log;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button_yolov3;
    private Button button_yolov2;
    private Button button_yoloface;
    private Button button_inception;
    public  static  final String Intent_key="modetype";
    private static final String TAG = "MainActivity";
    AlertDialog.Builder alertDialog;
    AlertDialog.Builder alertDialog2;
    AlertDialog.Builder alertDialog3;
    AlertDialog.Builder alertDialog4;

    public enum ModeType {
        DET_YOLOFACE_V2,
        DET_YOLO_V2,
        DET_YOLO_V3,
        DET_INCEPTION
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.title);
        textView.setText("model selection");


        button_yolov3 = (Button) findViewById(R.id.button_yolov3);
        button_yolov2 = (Button) findViewById(R.id.button_yolov2);
        button_yoloface = (Button) findViewById(R.id.button_yoloface);
        button_inception = (Button) findViewById(R.id.button_inception);

        button_yolov3.setOnClickListener(this);
        button_yolov2.setOnClickListener(this);
        button_yoloface.setOnClickListener(this);
        button_inception.setOnClickListener(this);

        alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("prompt");
        alertDialog.setMessage("yolov3 image recognition model will run");
        alertDialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {//添加取消
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e(TAG, "AlertDialog cancel");
                        //onClickNo();
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e(TAG, "AlertDialog ok");
                        onClickYolov3();
                    }
                })
                .create();

        alertDialog2 = new AlertDialog.Builder(MainActivity.this);
        alertDialog2.setTitle("prompt");
        alertDialog2.setMessage("yolov2 image recognition model will run");
        alertDialog2.setNegativeButton("cancel", new DialogInterface.OnClickListener() {//添加取消
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.e(TAG, "AlertDialog cancel");
                //onClickNo();
            }
        })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e(TAG, "AlertDialog ok");
                        onClickYolov2();
                    }
                })
                .create();

        alertDialog3 = new AlertDialog.Builder(MainActivity.this);
        alertDialog3.setTitle("prompt");
        alertDialog3.setMessage("yolovface face recognition model will run");
        alertDialog3.setNegativeButton("cancel", new DialogInterface.OnClickListener() {//添加取消
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.e(TAG, "AlertDialog cancel");
                //onClickNo();
            }
        })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e(TAG, "AlertDialog ok");
                        onClickYoloface();
                    }
                })
                .create();

        alertDialog4 = new AlertDialog.Builder(MainActivity.this);
        alertDialog4.setTitle("prompt");
        alertDialog4.setMessage("inceptionv3 image recognition model will run");
        alertDialog4.setNegativeButton("cancel", new DialogInterface.OnClickListener() {//添加取消
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.e(TAG, "AlertDialog cancel");
                //onClickNo();
            }
        })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e(TAG, "AlertDialog ok");
                        onClickfacenet();
                    }
                })
                .create();



    }

    @Override
    public void onClick(View v) {
        //Log.e(TAG,"OnClickListener");
        switch (v.getId()) {
            case R.id.button_yolov3:
                Log.e(TAG, "button_yolov3");
                //onClickButton1(v);
                alertDialog.setCancelable(false);//点击空白处之后弹出框不会消失
                alertDialog.show();
                buttonSetFocus(v);
                break;
            case R.id.button_yolov2:
                Log.e(TAG, "button_yolov2");
                //onClickButton2(v);
                alertDialog2.setCancelable(false);//点击空白处之后弹出框不会消失
                alertDialog2.show();
                buttonSetFocus(v);
                break;
            case R.id.button_yoloface:
                Log.e(TAG, "button_yoloface");
                //onClickButton2(v);
                alertDialog3.setCancelable(false);//点击空白处之后弹出框不会消失
                alertDialog3.show();
                buttonSetFocus(v);
                break;
            case R.id.button_inception:
                Log.e(TAG, "button_inception");
                //onClickButton2(v);
                alertDialog4.setCancelable(false);//点击空白处之后弹出框不会消失
                alertDialog4.show();
                buttonSetFocus(v);
                break;
            default:
                break;
        }
    }

    private void buttonSetFocus(View v) {
        Button button = (Button)findViewById(v.getId());
        button.setFocusable(true);
        button.setFocusableInTouchMode(true);
        button.requestFocus();
        button.requestFocusFromTouch();

    }


    private void onClickYolov3() {
        //处理逻辑
        Log.e(TAG, "button_yolov3 enter ");
        Intent intent = new Intent(this,ClassifierActivity.class);
        intent.putExtra(Intent_key,ModeType.DET_YOLO_V3.ordinal());
        startActivity(intent);
    }

    private void onClickYolov2() {
        //处理逻辑
        Log.e(TAG, "button_yolov2 enter ");
        Intent intent = new Intent(this,ClassifierActivity.class);
        intent.putExtra(Intent_key,ModeType.DET_YOLO_V2.ordinal());
        startActivity(intent);
    }

    private void onClickYoloface() {
        //处理逻辑
        Log.e(TAG, "button_yoloface enter ");
        Intent intent = new Intent(this,ClassifierActivity.class);
        intent.putExtra(Intent_key,ModeType.DET_YOLOFACE_V2.ordinal());
        startActivity(intent);
    }

    private void onClickfacenet() {
        //处理逻辑
        Log.e(TAG, "button_inception enter ");
        Intent intent = new Intent(this,ClassifierActivity.class);
        intent.putExtra(Intent_key,ModeType.DET_INCEPTION.ordinal() );
        startActivity(intent);
    }
}


