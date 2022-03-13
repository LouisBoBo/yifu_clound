package com.yssj.myapplication.ui.cangraborder.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import com.yssj.myapplication.R;

public class CangraborderSuccessDialog extends Dialog implements View.OnClickListener{
    private Context context;
    private int requestCode;

    public CangraborderSuccessDialog(Context context) {
        super(context, R.style.my_invate_dialog);
        this.context=context;
        setContentView(R.layout.cangraborder_success_dialog);
        this.getWindow().setWindowAnimations(R.style.my_dialog_anim_style);

        findViewById(R.id.dialog_confirm).setOnClickListener(this::onClick);
    }


    public void setRequestCode(int code){
        this.requestCode=code;
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
