package com.washcar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainLayoutActivity extends AppCompatActivity {

    @BindView(R.id.llOne)
    LinearLayout llOne;
    @BindView(R.id.llTwo)
    LinearLayout llTwo;
    @BindView(R.id.llThree)
    LinearLayout llThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.llOne)
    public void setLlOne(){
        Toast.makeText(this,"去购买单次卡",Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.llTwo)
    public void setLlTwo(){
        Toast.makeText(this,"去购买半年卡",Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.llThree)
    public void setLlThree(){
        Toast.makeText(this,"去购买年卡",Toast.LENGTH_SHORT).show();
    }

}
