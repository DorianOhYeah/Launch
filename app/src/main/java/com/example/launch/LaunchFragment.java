package com.example.launch;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class LaunchFragment extends Fragment {
    protected View mView; // claim a view
    protected Context mContext; // claim a context
    private int mPosition; // claim a position number
    private int mImageId; // claim the image id
    private int mCount = 4; // claim the number of the images of the starter

    // get a instance of the fragment
    public static LaunchFragment newInstance(int position, int image_id) {
        LaunchFragment fragment = new LaunchFragment(); // create a fragment
        Bundle bundle = new Bundle(); // create a new Bundle
        bundle.putInt("position", position); // put the position number into the bundle
        bundle.putInt("image_id", image_id); // put the image number into the bundle
        fragment.setArguments(bundle); // put the bundle into the fragment
        return fragment; // return the instance
    }

    // create the fragment view
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity(); // get the activity context
        if (getArguments() != null) { // get the argument from the bundle
            mPosition = getArguments().getInt("position", 0);
            mImageId = getArguments().getInt("image_id", 0);
        }
        // create the view according to the layout xml
        mView = inflater.inflate(R.layout.item_launch, container, false);
        ImageView iv_launch = mView.findViewById(R.id.iv_launch);
        RadioGroup rg_indicate = mView.findViewById(R.id.rg_indicate);
        Button btn_start = mView.findViewById(R.id.btn_start);
        // set the image
        iv_launch.setImageResource(mImageId);
        // set a radio button for each image
        for (int j = 0; j < mCount; j++) {
            RadioButton radio = new RadioButton(mContext);
            radio.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            radio.setButtonDrawable(R.drawable.launch_guide);
            radio.setPadding(10, 10, 10, 10);
            // put the button into the indicator
            rg_indicate.addView(radio);
        }
        // highlight the button in the current positon
        ((RadioButton) rg_indicate.getChildAt(mPosition)).setChecked(true);
        // show the enter button in the last page
        if (mPosition == mCount - 1) {
            btn_start.setVisibility(View.VISIBLE);
            btn_start.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Let's begin", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return mView;
    }
}
