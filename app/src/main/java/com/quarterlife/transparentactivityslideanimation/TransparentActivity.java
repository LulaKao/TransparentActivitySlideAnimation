package com.quarterlife.transparentactivityslideanimation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class TransparentActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_back;
    private RelativeLayout mask_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);

        btn_back = findViewById(R.id.btn_back);
        mask_area = findViewById(R.id.mask_area);

        btn_back.setOnClickListener(this);
        mask_area.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish(); // finish this page
        finishSetting(); // set animation
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishSetting(); // set animation
    }

    @Override
    public void finish() {
        super.finish();
        finishSetting(); // set animation
    }

    private void finishSetting() {
        overridePendingTransition(R.anim.slide_from_bottom, R.anim.slide_to_top); // start animation
        MainActivity.setMask(false); // hide black_mask
    }
}