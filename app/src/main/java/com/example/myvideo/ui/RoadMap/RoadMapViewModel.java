package com.example.myvideo.ui.RoadMap;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myvideo.models.CourseModel;
import com.example.myvideo.utils.SharedModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RoadMapViewModel extends ViewModel {


    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    public MutableLiveData<CourseModel> Course = new MutableLiveData<>();


    public void getCourse(String cat , String name){
        ref.child("Courses").child(cat).child(name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.getValue(CourseModel.class) != null){
                    Course.setValue(snapshot.getValue(CourseModel.class));
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}
