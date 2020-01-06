package com.chatapp.threadripper.authenticated.fragments.diary;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chatapp.threadripper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiaryFragment extends Fragment {

    RecyclerView rcvDiary,rcvPicture;
    public DiaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_diary, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvDiary = view.findViewById(R.id.rcv_diary);
    }
}
