package com.cwzk.environmentmonitor.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cwzk.environmentmonitor.MainActivity;
import com.cwzk.environmentmonitor.R;
import com.cwzk.environmentmonitor.entity.UserInfo;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private EditText mAccountView;
    private EditText mPasswordView;
    private TextView mBtnLogin;
//    private Button mBtnLogin;
    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
//        setContentView(R.layout.activity_login_layout);
        setContentView(R.layout.activity_user_login);
        mAccountView = findViewById(R.id.etAccount);
        mPasswordView = findViewById(R.id.etPassword);
        mBtnLogin = findViewById(R.id.btnLogin);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initEvent() {
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.etAccount:
                break;
            case R.id.etPassword:
                break;
            case R.id.btnLogin:
                String account = mAccountView.getText().toString();
                String password = mPasswordView.getText().toString();
                if(account.isEmpty()||account.length()==0) {
                    Toast.makeText(getApplicationContext(), "请输入账号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.isEmpty()||password.length()==0) {
                    Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                showLoading();
                UserInfo userInfo = new UserInfo();
                userInfo.account=account;
                userInfo.password = password;
                userInfo.role = 1;
                if(checkUser(userInfo)){
                    hideLoading();
                    Intent intent = new Intent();
                    if(userInfo.role==1){
//                        intent.setClass(LoginActivity.this, MainActivity.class);
                        intent.setClass(LoginActivity.this, SchoolInfoActivity.class);
                    }else{
//                        intent.setClass(LoginActivity.this, ExpansionPanelSampleActivityRecycler.class);
                        intent.setClass(LoginActivity.this, AdminSelectActivity.class);
                    }
                    startActivity(intent);
                }else{
                    hideLoading();
                    Toast.makeText(getApplicationContext(),"账号或密码有误",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private boolean checkUser(UserInfo userInfo){
        if((userInfo.account.equals("cdcwzk"))&&(userInfo.password.equals("123456"))){
            return true;
        }else if((userInfo.account.equals("admin"))&&(userInfo.password.equals("123456"))){
            userInfo.role =2;
            return true;
        }
        else{
            return false;
        }
    }
}
