package com.example.courseapp;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.choose_a_teacher);

       // Button submit_button = (Button)findViewById(R.id.submit_button);


        Button button_faisal = (Button) findViewById(R.id.button_faisal);
        Button button_oskar = (Button) findViewById(R.id.button_oskar);
        Button button_david= (Button) findViewById(R.id.button_david);


        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        button_faisal.setOnClickListener((view -> {
            ViewPager pager = (ViewPager) findViewById(R.id.container);
            pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        }));

        button_oskar.setOnClickListener((view -> {
            ViewPager pager = (ViewPager) findViewById(R.id.container);
            pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        }));

        button_david.setOnClickListener((view -> {
            ViewPager pager = (ViewPager) findViewById(R.id.container);
            pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        }));
        System.out.println(radioGroup.getFocusedChild());

        // submit_button.setOnClickListener((view -> {
        //
        //      System.out.println(radioGroup.getFocusedChild());

        // }));

    }


}
