package info.androidhive.firebase.survey_main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import info.androidhive.firebase.R;
import info.androidhive.firebase.start_page.Start_screen;

public class Survey_activity extends AppCompatActivity {
    DatabaseReference databaseReference;
    int oldValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        databaseReference = FirebaseDatabase.getInstance().getReference("Questions");
        ValueEventListener valueEventListener = new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i=0;
                int count= (int) dataSnapshot.getChildrenCount();
                final String[] quest_fin=new String[count];
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    quest_fin[i] = (String)ds.getValue();
                    i++;
                }
                check(quest_fin);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        databaseReference.addListenerForSingleValueEvent(valueEventListener);
    }

    private void check(final String[] quest_fin) {
         RadioButton rb;
         final TextView question=findViewById(R.id.text_question);
         RadioGroup rg = findViewById(R.id.radio_group);
         Button next = findViewById(R.id.apply_button);
        rb=findViewById(rg.getCheckedRadioButtonId());
        final int[] i = {0};
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.print("there is a ghost inside");
               // int random = (int) (Math.random() * quest_fin.length);
               // if (random == oldValue) {
                //    random = (int) (Math.random() * quest_fin.length);
                //}
                i[0]++;
                question.setText(quest_fin[i[0]]);
                if(i[0]==quest_fin.length-1){
                    Intent intent=new Intent(Survey_activity.this,Start_screen.class);
                    startActivity(intent);
                }
            }
    });
}
}