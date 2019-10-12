package info.androidhive.firebase.list_of_surveys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import info.androidhive.firebase.R;
import info.androidhive.firebase.model_classes.Model;


public class List_it extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseRecyclerAdapter<Model, CategoryViewHolder> recyclerAdapter;
    FirebaseDatabase fdb;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_it);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fdb=FirebaseDatabase.getInstance();
        ref=fdb.getReference("Data");
    }

    @Override
    protected void onStart() {
        super.onStart();
    FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(ref,Model.class)
                        .build();
     recyclerAdapter = new FirebaseRecyclerAdapter<Model, CategoryViewHolder>(options) {

            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder holder, int position, @NonNull Model model) {
                holder.setDetails(getApplicationContext(), model.getTitle(), model.getImage());
            }

            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model,viewGroup,false);
                return new CategoryViewHolder(getApplicationContext(),view);
            }
        };

        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
        recyclerAdapter.startListening();
    }

}

