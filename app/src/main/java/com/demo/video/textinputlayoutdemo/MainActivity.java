package com.demo.video.textinputlayoutdemo;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    LinearLayout lay_main;
    TextInputLayout tv_inout_lay;
    EditText editTest;

    CheckBox checkBox_hint, checkBox_Animation, checkBox_Error, checkBox_counter, checkBox_pws, checkBox_counter_max,
            checkbox_hint_style, checkbox_error_style, checkbox_over_style;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        lay_main = (LinearLayout) findViewById(R.id.lay_main);
        lay_main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editTest.clearFocus();
                tv_inout_lay.clearFocus();
                return false;
            }
        });

        tv_inout_lay = (TextInputLayout) findViewById(R.id.tv_input_lay);
        editTest = (EditText) findViewById(R.id.edit_test);

        checkBox_hint = (CheckBox) findViewById(R.id.checkbox_hint);
        checkBox_Animation = (CheckBox) findViewById(R.id.checkbox_animation);
        checkBox_Error = (CheckBox) findViewById(R.id.checkbox_error);
        checkBox_counter = (CheckBox) findViewById(R.id.checkbox_counter);
        checkBox_pws = (CheckBox) findViewById(R.id.checkbox_pws);
        checkBox_counter_max = (CheckBox) findViewById(R.id.checkbox_counter_max);
        checkbox_hint_style = (CheckBox) findViewById(R.id.checkbox_hint_style);
        checkbox_error_style = (CheckBox) findViewById(R.id.checkbox_error_style);
        checkbox_over_style = (CheckBox) findViewById(R.id.checkbox_over_style);

        checkBox_hint.setOnCheckedChangeListener(this);
        checkBox_Animation.setOnCheckedChangeListener(this);
        checkBox_Error.setOnCheckedChangeListener(this);
        checkBox_counter.setOnCheckedChangeListener(this);
        checkBox_counter_max.setOnCheckedChangeListener(this);
        checkBox_pws.setOnCheckedChangeListener(this);
        checkbox_hint_style.setOnCheckedChangeListener(this);
        checkbox_error_style.setOnCheckedChangeListener(this);
        checkbox_over_style.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        switch (compoundButton.getId()){
            case R.id.checkbox_hint:
                tv_inout_lay.setHintEnabled(checked);
                if(checked){
                    tv_inout_lay.setHint("设置提示文字");
                }
                break;
            case R.id.checkbox_animation:
                tv_inout_lay.setHintAnimationEnabled(checked);
                break;
            case R.id.checkbox_error:
                tv_inout_lay.setErrorEnabled(checked);
                if(checked){
                    tv_inout_lay.setError("错误提示");
                }
                break;
            case R.id.checkbox_counter:
                tv_inout_lay.setCounterEnabled(checked);
                if(checked){
                    tv_inout_lay.setCounterMaxLength(0);
                }
                break;
            case R.id.checkbox_counter_max:
                tv_inout_lay.setCounterEnabled(checked);
                if(checked){
                    tv_inout_lay.setCounterMaxLength(10);
                }else {
                    tv_inout_lay.setCounterMaxLength(0);
                }
                break;
            case R.id.checkbox_pws:
                if(checked){
                    editTest.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }else {
                    editTest.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                tv_inout_lay.setPasswordVisibilityToggleEnabled(true);//设置密码图标(EditText必须位password类型才起作用)
                break;
            case R.id.checkbox_hint_style:
                if(checked){
                    tv_inout_lay.setHintTextAppearance(R.style.hintAppearance);//自定义浮标样式
                    tv_inout_lay.setHint("字漂亮，颜色亮");
                }else {
                    tv_inout_lay.setHintTextAppearance(0);
                }
                break;
            case R.id.checkbox_error_style:
                if(checked){
                    tv_inout_lay.setErrorTextAppearance(R.style.errorAppearance);
                }else {
                    tv_inout_lay.setErrorTextAppearance(0);
                }
                break;
            case R.id.checkbox_over_style:
                if(checked){ //自定义图标样式
                    tv_inout_lay.setPasswordVisibilityToggleDrawable(R.drawable.select_pwd_icon);
                }else {
                    tv_inout_lay.setPasswordVisibilityToggleDrawable(android.support.design.R.drawable.design_password_eye);
                }
                Resources res = getResources();
                ColorStateList csl = res.getColorStateList(R.color.select_pwd_icon_color);
                tv_inout_lay.setPasswordVisibilityToggleTintList(csl);
                break;
        }
    }
}
