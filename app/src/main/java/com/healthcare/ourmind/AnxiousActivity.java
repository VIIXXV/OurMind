package com.healthcare.ourmind;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class AnxiousActivity extends AppCompatActivity {
    public YouTubePlayerView youTubePlayerView;
    public EditText anxiousText, aYear, aMonth, aDay;
    public TextView textView2;
    public Button save_Btn;
    public String _diary;
    public Integer _year, _month, _day;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anxious);

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        anxiousText = findViewById(R.id.anxiousText);
        textView2 = findViewById(R.id.textView2);
        save_Btn = findViewById(R.id.save_Btn);
        aYear = findViewById(R.id.year);
        aMonth = findViewById(R.id.month);
        aDay = findViewById(R.id.day);


        // 안정 호흡법 유튜브 영상
        getLifecycle().addObserver(youTubePlayerView);

        // 저장 버튼 눌렀을 때
        save_Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                _diary = anxiousText.getText().toString();

                save_Btn.setVisibility(View.INVISIBLE);     // 저장 버튼 안 보이게(저장 버튼 누른 후이므로)
                anxiousText.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);
                _year = Integer.parseInt(aYear.getText().toString());
                _month = Integer.parseInt(aMonth.getText().toString());
                _day = Integer.parseInt(aDay.getText().toString());

                Intent home = new Intent(AnxiousActivity.this, MainActivity.class);
                home.putExtra("_diary", _diary);
                home.putExtra("_year", _year);
                home.putExtra("_month", _month);
                home.putExtra("_day", _day);
                startActivity(home);

            }
        });

    }

}
