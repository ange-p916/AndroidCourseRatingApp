package com.example.courseapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.courseapp.FirstFragment.radioGroup;

public class CourseActivity extends FragmentActivity{

    static TextView tv;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GestureDetector mDetector = new GestureDetector(CourseActivity.this, new MyGestureListener());

        setContentView(R.layout.course_layout);


        ViewPager pager = (ViewPager) findViewById(R.id.container);
        Button android_button = (Button)findViewById(R.id.button_android);
        Button back_button = (Button)findViewById(R.id.course_back);
        Button course_submit = (Button)findViewById(R.id.course_submit);
        LinearLayout course_buttons = (LinearLayout)findViewById(R.id.course_buttons_layout);
        tv = (TextView)findViewById(R.id.question_box);

        Intent intent = getIntent();

        android_button.setOnClickListener((view -> {
            course_buttons.setVisibility(View.INVISIBLE);
            tv.setText("");
            pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        }));

        back_button.setOnClickListener((view -> {
            course_buttons.setVisibility(View.VISIBLE);
            pager.setAdapter(null);
            tv.setText("Select a course to rate");
        }));

        course_submit.setOnClickListener((view -> {

            for (QuestionnaireInfo qr : QuestionnaireInfo.QRs)
            {
                Log.d("output", qr.questionnareRating +  " box: " + qr.questionnare_text_box_question);
            }

            String fromEmail = "mymailhehe11@gmail.com";
            String frompassword = "113355aa";
            String toemail = "ajphlp90@gmail.com";

            String emailsubject = "teacher rating";

            String emailbody = "";
            for (QuestionnaireInfo qr : QuestionnaireInfo.QRs)
            {
                emailsubject +=
                        "\nfor teacher: " +  qr.teacher_names[0] +
                        "\n, question: " + qr.questionnare_text_box_question +
                        "\n, score: " + qr.questionnareRating;
            }


            new SendMailTask(CourseActivity.this).execute(fromEmail,frompassword,toemail,emailsubject,emailbody);

        }));

        pager.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(final View v, final MotionEvent event){

                return mDetector.onTouchEvent(event);
            }

        });
    }
}
