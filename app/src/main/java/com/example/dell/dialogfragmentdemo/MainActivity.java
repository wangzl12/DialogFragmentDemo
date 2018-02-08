package com.example.dell.dialogfragmentdemo;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dell.dialogfragmentdemo.view.CustomeDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button textView = findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomeDialogFragment dialogFragment = CustomeDialogFragment.getInstance();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                dialogFragment.show(ft, "dialogFragment");
            }
        });


    }
}
