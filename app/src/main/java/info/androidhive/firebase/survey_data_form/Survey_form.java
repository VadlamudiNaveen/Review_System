package info.androidhive.firebase.survey_data_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import info.androidhive.firebase.R;

public class Survey_form extends AppCompatActivity {
 Button like,dislike,neutral;
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveyform);
        like=findViewById(R.id.like);
        dislike=findViewById(R.id.dislike);
        neutral=findViewById(R.id.neutral);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> text=new HashMap<String,String>();
                text.put("name","keshava");
                text.put("vote","like");
                //String text="like";
               db.collection("vote").document("myfirstvote")
                       .set(text)
                       .addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void aVoid) {
                       Toast.makeText(Survey_form.this,"liked",Toast.LENGTH_LONG).show();
                   }
               });
            }
        });
        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> text=new HashMap<String,String>();
                text.put("name","keshava");
                text.put("vote","dislike");
                //String text="like";
                db.collection("vote").document("myfirstvote")
                        .set(text)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Survey_form.this,"disliked",Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> text=new HashMap<String,String>();
                text.put("name","keshava");
                text.put("vote","neutral");
                //String text="like";
                db.collection("vote").document("myfirstvote")
                        .set(text)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Survey_form.this,"neutral",Toast.LENGTH_LONG).show();
                            }
                        });
            }

        });
    }
}
