package com.fzq.mybutterknifedemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindAnim;
import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindBool;
import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindInt;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnFocusChange;
import butterknife.OnLongClick;
import butterknife.OnTouch;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity.java";
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第一步： 绑定XML文件。
        //ButterKnife.bind()方法返回一个Unbinder对象，在Activity，Fragment等的声明周期中，销毁时通过它来解除绑定
        //一般在Activity中可以不用Unbinder， 在Fragment建议使用。
        //unbinder = ButterKnife.bind(this);

        //在Activity中，直接可以写为：
        ButterKnife.bind(this);


        //第二步： 通过注解声明控件或者实现控件的监听事件 ---- 使用的形式都是各种用注解修饰的成员变量或成员方法。


        //第三步： 销毁时解除绑定 --- 在Activity中可以不用管

    }


    //下面开始是ButterKnife的使用。注意：控件或者方法都不能用private 或者 static修饰，所以控件都是默认
    // 修饰符(不加修饰符)，方法一般用public修饰
    @BindView(R.id.MainAct_imageView)
    ImageView imageView;
    @BindView(R.id.MainAct_btn_test)
    Button button;   //因为要用到这个控件，所以要声明，如果只用到方法则不用声明控件。

    /**
     * Button的点击事件
     */
    @OnClick(R.id.MainAct_btn_test)
    public void testClick() {
        System.out.println("点击了Button");

//        testAnim();
//        testBindArray();
//        testBindBitmap();
//        testBindBool();
//        testBindColor();
//        testBindDimen();
//        testBindDrawable();
//        testBindInt();
//        testBindString();
//        testBindViews();
    }


    @BindAnim(R.anim.anim)
    Animation anim;

    /**
     * 测试BindAnim
     */
    private void testAnim() {
        imageView.startAnimation(anim);
    }


    @BindArray(R.array.test_array)
    String[] names;    //这里也可以在xml声明相应的int型或其他类型。

    /**
     * 测试BindArray
     */
    private void testBindArray() {
        for (String s : names) {
            System.out.println(s);
        }
    }

    // 传入一个drawable resource ID将之绑定到一个Bitmap
    @BindBitmap(R.drawable.aa4)
    Bitmap bitmap;

    /**
     * 测试BindBitmap
     */
    private void testBindBitmap() {
        imageView.setImageBitmap(bitmap);
    }

    @BindBool(R.bool.test_bool)
    boolean testBool;

    /**
     * 测试BindBool
     */
    private void testBindBool() {
        System.out.println("testBool: " + testBool);
    }

    //Bind a field to the specified color resource ID
    @BindColor(R.color.colorAccent)
    int colorId;

    /**
     * 测试BindColor
     */
    private void testBindColor() {
        button.setBackgroundColor(colorId);
    }

    @BindDimen(R.dimen.test_dimen)
    int testDimen;

    /**
     * 测试BindDimen
     */
    private void testBindDimen() {
        button.setTextSize(testDimen);
    }

    @BindDrawable(R.drawable.aa4)
    Drawable drawable;

    /**
     * 测试BindDrawable， 效果的话和BindBitmap一样 。
     */
    private void testBindDrawable() {
        imageView.setImageDrawable(drawable);
    }

    @BindInt(R.integer.test_int)
    int testInt;

    /**
     * 测试BindInt
     */
    private void testBindInt() {
        System.out.println("testInt: " + testInt);
    }

    @BindString(R.string.app_name)
    String appName;

    /**
     * 测试BindString
     */
    private void testBindString() {
        System.out.println("appName: " + appName);
    }

    @BindViews({R.id.MainAct_text_hello_1, R.id.MainAct_text_hello_2, R.id.MainAct_text_hello_3})
    List<TextView> textViews;

    /**
     * 测试BindViews
     */
    private void testBindViews() {
        textViews.get(0).setText("text - 111111");
        textViews.get(1).setText("text - 222222");
        textViews.get(2).setText("text - 333333");

    }

    /**
     * 对CheckBox的状态监听
     */
    @OnCheckedChanged(R.id.MainAct_text_checkBox)
    public void testOnCheckedChanged(boolean isChecked) {
        if (isChecked) {
            Toast.makeText(this, "state: true", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "state: false", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * 多个按钮的点击事件
     */
    @OnClick({R.id.MainAct_btn_1, R.id.MainAct_btn_2, R.id.MainAct_btn_3})
    public void testMultiOnclick(View view) {
        switch (view.getId()) {
            case R.id.MainAct_btn_1:
                System.out.println("点击了Button-1");
                break;
            case R.id.MainAct_btn_2:
                System.out.println("点击了Button-2");
                break;
            case R.id.MainAct_btn_3:
                System.out.println("点击了Button-3");
                break;
            default:
                break;
        }
    }

    /**
     * 多个按钮的长按事件， 注意这里是要返回boolean类型的，不然编译会报错
     */
    @OnLongClick({R.id.MainAct_btn_1, R.id.MainAct_btn_2, R.id.MainAct_btn_3})
    public boolean testMultiOnLongClick(View view) {
        switch (view.getId()) {
            case R.id.MainAct_btn_1:
                System.out.println("Button-1 长按事件");
                break;
            case R.id.MainAct_btn_2:
                System.out.println("Button-2 长按事件");
                break;
            case R.id.MainAct_btn_3:
                System.out.println("Button-3 长按事件");
                break;
            default:
                break;
        }

        return true;
    }

    //需要注意的是 setOnEditorActionListener这个方法，并不是在我们点击EditText的时候触发，
    // 也不是在我们对EditText进行编辑时触发，而是在我们编辑完之后点击软键盘上的回车键才会触发。
    @OnEditorAction(R.id.MainAct_edit1)
    public boolean testOnEditorAction() {  //注意：需要返回boolean值
        Toast.makeText(this, "input finished", Toast.LENGTH_SHORT).show();
        return true;
    }

    /**
     * 当前点击的控件和已经获取焦点的控件不是同一个时会执行
     */
    @OnFocusChange({R.id.MainAct_edit1, R.id.MainAct_edit2})
    public void testOnFocusChange(View view) {
        if (view.getId() == R.id.MainAct_edit1) {
            Toast.makeText(this, "账号输入框获得焦点", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.MainAct_edit2) {
            Toast.makeText(this, "密码输入框获得焦点", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * OnTouch是对于控件来说的，如果控件返回false，则表示其父控件会接收到touch事件。
     * 如果返回true，则表示此次的touch被控件自身消耗了。
     */
    @OnTouch(R.id.MainAct_text_hello_1)
    public boolean testOnTouch(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            System.out.println("touch TextView down...");
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            System.out.println("touch TextView up...");
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {
            System.out.println("touch screen up...");
        }else if (event.getAction() == MotionEvent.ACTION_DOWN) {
            System.out.println("touch screen down...");
        }
        return true;
    }


    @OnClick(R.id.MainAct_btn_4)
    public void toSeondAct(){
        startActivity(new Intent(this, SecondActivity.class));
    }
}
