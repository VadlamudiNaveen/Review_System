package info.androidhive.firebase.list_of_surveys;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import info.androidhive.firebase.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView title_t;
    public ImageView image_t;
View v;
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        v=itemView;
    }
    public void setDetails(Context ctx,String title,String image){
     title_t=v.findViewById(R.id.title);
     image_t=v.findViewById(R.id.image);
     title_t.setText(title);
     Picasso.get().load(image).into(image_t);
    }

    @Override
    public void onClick(View view) {

    }
}
