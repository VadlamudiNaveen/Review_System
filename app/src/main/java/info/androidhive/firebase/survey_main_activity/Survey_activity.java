package info.androidhive.firebase.survey_main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import info.androidhive.firebase.R;
import info.androidhive.firebase.global.Global;
import info.androidhive.firebase.start_page.Start_screen;

public class Survey_activity extends AppCompatActivity {
    DatabaseReference databaseReference;
    FirebaseFirestore db=FirebaseFirestore.getInstance();
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
        final RadioButton[] rb = new RadioButton[1];
         final TextView question=findViewById(R.id.text_question);
         final RadioGroup rg = findViewById(R.id.radio_group);
         Button next = findViewById(R.id.apply_button);
        final Global globalVariable = (Global) getApplicationContext();
        final String email = globalVariable.getEmail();
        final Map<String, ArrayList<String>>map=new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        //System.out.println(""+email);
        final List<String> questions_firebase = Arrays.asList(quest_fin);
        final ArrayList<String> questions=new ArrayList<String>(questions_firebase);
        final int[] i = {0};
        final ArrayList<String> answers=new ArrayList<>();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radio_id=rg.getCheckedRadioButtonId();
                rb[0] =findViewById(radio_id);
                i[0]++;
                String test= (String)rb[0].getText();
                System.out.println(""+rb[0].getText());
                answers.add(test);
                System.out.println(""+answers);
                question.setText(quest_fin[i[0]]);
                if(i[0]==quest_fin.length-1){
                    map.put("questions",questions);
                    map.put("answers",answers);
                    db.collection("vote").document(email)
                            .set(map)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Survey_activity.this,"Completed your Survey", Toast.LENGTH_LONG).show();
                                }});
                    Intent intent=new Intent(Survey_activity.this,Start_screen.class);
                    startActivity(intent);
                }
            }
    });
}
}