package com.example.launch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int[] lanuchImageArray = {R.drawable.startimage,
            R.drawable.startimage2, R.drawable.startimage3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        // find the view pager
        ViewPager vp_launch = findViewById(R.id.vp_launch);
        // set the adapter
        LaunchImproveAdapter adapter = new LaunchImproveAdapter(getSupportFragmentManager(), lanuchImageArray);
        // put the adapter into launch page
        vp_launch.setAdapter(adapter);
        // the first page default shown
        vp_launch.setCurrentItem(0);
    }

}
