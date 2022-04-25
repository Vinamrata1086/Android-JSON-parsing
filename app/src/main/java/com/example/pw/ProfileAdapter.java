// Adapter class will help us to populate the recyclerview.
package com.example.pw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileHolder>{

    private Context context;
    private List<Profile> profileList;


    public ProfileAdapter(Context context, List<Profile> profile) {
        this.context = context;
        profileList = profile;
    }
    @NonNull
    @Override
    public ProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item , parent , false);
        return new ProfileHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileHolder holder, int position) {

        Profile profile = profileList.get(position);
        holder.subject.setText(profile.getSubject());
        holder.name.setText(profile.getName());
        holder.qualification.setText(profile.getQualification());
//        Compiler will use Glide library here.
        Glide.with(context).load(profile.getImage()).into(holder.image);
//Compiler will write the name, Subject and qualification from the objects of the profilelist.
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("name" , profile.getName());
                bundle.putString("qualification" , profile.getQualification());
                bundle.putString("image" , profile.getImage());
                bundle.putString("subject" , profile.getSubject());

                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }

    public class ProfileHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name , qualification , subject;
        ConstraintLayout constraintLayout;

        public ProfileHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            qualification = itemView.findViewById(R.id.qualification);
            subject = itemView.findViewById(R.id.subject);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
