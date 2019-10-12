package info.androidhive.firebase.list_of_surveys;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import com.squareup.picasso.Picasso;
import  info.androidhive.firebase.item_click.ItemClickListener;
import info.androidhive.firebase.R;
import info.androidhive.firebase.start_page.Start_screen;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView title_t;
    public ImageView image_t;
    Context ct;
    public CategoryViewHolder(Context ct,@NonNull View itemView) {
        super(itemView);
        this.ct=ct;
        itemView.setOnClickListener(this);
    }

    public void setDetails(Context ctx,String title,String image){
        title_t=itemView.findViewById(R.id.title);
        image_t=itemView.findViewById(R.id.image);
        title_t.setText(title);
        //System.out.println("  "+image);
        Picasso.get().load(image).into(image_t);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(ct,Start_screen.class);
        ct.startActivity(intent);
    }
}
