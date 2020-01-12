package com.chatapp.threadripper.authenticated.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chatapp.threadripper.R;
import com.chatapp.threadripper.models.Diary;
import com.chatapp.threadripper.utils.ImageLoader;
import com.chatapp.threadripper.utils.Preferences;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalAdapter extends RecyclerView.Adapter<PersonalAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Diary> diaryArrayList;

    public PersonalAdapter(Context mContext, ArrayList<Diary> diaryArrayList) {
        this.mContext = mContext;
        this.diaryArrayList = diaryArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_diary, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Diary diary = diaryArrayList.get(position);
        ImageLoader.loadUserAvatar(holder.cvAvatar, Preferences.getCurrentUser().getPhotoUrl());
        holder.tvStatus.setText(diary.getStatus());
        holder.time.setText(diary.getTime());
        holder.tvDisplayName.setText(Preferences.getCurrentUser().getDisplayName());
        holder.imgDiary.setImageResource(diary.getImgDiary());

    }

    @Override
    public int getItemCount() {
        return diaryArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDisplayName, time,tvStatus;
        public CircleImageView cvAvatar;
        ImageView imgDiary;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDisplayName = itemView.findViewById(R.id.tv_display_name);
            tvStatus =itemView.findViewById(R.id.tv_status);
            cvAvatar = itemView.findViewById(R.id.cv_avatar);
            imgDiary = itemView.findViewById(R.id.img_diary);
            time = itemView.findViewById(R.id.tv_time);
        }
    }
}
