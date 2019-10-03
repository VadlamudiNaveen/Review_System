package info.androidhive.firebase.list_of_surveys;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import info.androidhive.firebase.R;

public class Adapter_list extends RecyclerView.ViewHolder {
    View v;
    public Adapter_list(@NonNull View itemView) {
        super(itemView);
        v=itemView;
    }
    public void setDetails(Context ctx,String title,String image){
        TextView mtitle=v.findViewById(R.id.title);
        ImageView imageView=v.findViewById(R.id.image);
        mtitle.setText(title);
        Picasso.get().load(image).into(imageView);
    }

}
