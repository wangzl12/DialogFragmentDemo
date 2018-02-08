package com.example.dell.dialogfragmentdemo.view;


import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dell.dialogfragmentdemo.R;

/**
 * Created by dell on 2018/2/8.
 */

public class CustomeDialogFragment extends DialogFragment implements View.OnClickListener {
    private View view = null;
    private ImageView mCloseImg;
    private Button mConfirmBtn;

    /**
     * 静态方法产生实例
     * @return
     */
    public static CustomeDialogFragment getInstance(){
        CustomeDialogFragment customeDialogFragment = new CustomeDialogFragment();
        return customeDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                    dismiss();
                    return true; // pretend we've processed it
                } else
                    return false; // pass on to be processed as normal
            }
        });
        view = inflater.inflate(R.layout.dialog_submit_product_t0,container,false);
        mCloseImg = view.findViewById(R.id.dialog_close);
        mCloseImg.setOnClickListener(this);
        mConfirmBtn = view.findViewById(R.id.dialog_product_confirm_btn);
        mConfirmBtn.setOnClickListener(this);

        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);//无法直接点击外部取消dialog
        //setStyle(DialogFragment.STYLE_NORMAL,0);//NO_FRAME就是dialog无边框，0指的是默认系统Theme
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_MinWidth);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.9), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.dialog_close:
                dismiss();

                break;

            case R.id.dialog_product_confirm_btn:
                Toast.makeText(getActivity(),"点击确定",Toast.LENGTH_SHORT).show();
                dismiss();

                break;
        }

    }
}
