package info.androidhive.firebase.start_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import info.androidhive.firebase.R;
import info.androidhive.firebase.Survey_activity;

public class Start_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        Button button=findViewById(R.id.start_quiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startquiz();
            }

            private void startquiz() {
                Intent intent=new Intent(Start_screen.this, Survey_activity.class);
                startActivity(intent);
            }
        });
    }
}
