package com.exc.myapplication.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.exc.myapplication.R;
import com.exc.myapplication.base.BaseActivity;

public class AccountBalanceActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_balance);

        initView();
    }

    public void initView() {
        ImageView backimg = findViewById(R.id.headview_back_img);
        backimg.setOnClickListener(this::onClick);

        TextView mywork = findViewById(R.id.mywork);
        mywork.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.headview_back_img) {
            finish();
        } else if (view.getId() == R.id.mywork) {
            startActivity(AccountDetailsActivity.class);
        }
    }
}
