package com.quarterlife.transparentactivityslideanimation;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private Button btn_click;
    private static RelativeLayout black_mask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_click = findViewById(R.id.btn_click);
        black_mask = findViewById(R.id.black_mask);

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TransparentActivity.class)); // go to TransparentActivity
                overridePendingTransition(R.anim.slide_from_top, R.anim.slide_to_bottom); // start animation
                setMask(true); // show black_mask
            }
        });
    }

    // set black_mask's visibility
    public static void setMask(boolean visible) {
        if(visible) { // visible = true
            black_mask.setAlpha(0f); // 0% opacity
            black_mask.setVisibility(View.VISIBLE); // but visible
            black_mask.animate() // start animation
                    .alpha(1f) // 100% opacity
                    .setDuration(400) // medium-length animation time
                    .setListener(null);

        } else { // visible = false
            black_mask.animate() // start animation
                    .alpha(0f) // 0% opacity
                    .setDuration(400) // medium-length animation time
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            black_mask.setVisibility(View.GONE); // hide black_mask
                        }
                    });
        }
    }
}