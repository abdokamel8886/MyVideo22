package com.example.myvideo.ui.RoadMap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myvideo.R;
import com.example.myvideo.databinding.FragmentRoadmapBaseBinding;
import com.example.myvideo.models.CourseModel;
import com.example.myvideo.ui.myHome.MyCourses.Courseviewer.CourseBaseViewerFragment;
import com.example.myvideo.ui.myHome.MyCourses.MyHomeCoursesFragment;
import com.example.myvideo.utils.SharedModel;


public class RoadmapBaseFragment extends Fragment {


    FragmentRoadmapBaseBinding binding;
    RoadMapViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_roadmap_base, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentRoadmapBaseBinding.bind(view);
        viewModel = new ViewModelProvider(this).get(RoadMapViewModel.class);

        onClicks();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void onClicks(){

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().onBackPressed();
            }
        });

        binding.basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.basic1.getVisibility() == View.VISIBLE){
                    binding.basic1.setVisibility(View.GONE);
                }
                else {
                    binding.basic1.setVisibility(View.VISIBLE);
                }

            }
        });

        binding.cs50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.getCourse("Programming","CS50 - ar - abdelrahman gamal");
                viewModel.Course.observe(getViewLifecycleOwner(), new Observer<CourseModel>() {
                    @Override
                    public void onChanged(CourseModel courseModel) {
                        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_frame , new CourseBaseViewerFragment(),"cs50")
                                .addToBackStack("cs50").commit();
                        SharedModel.setSelected_course(courseModel);
                    }
                });
            }
        });

        binding.python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.getCourse("Programming","Python Beginners Tutorial");
                viewModel.Course.observe(getViewLifecycleOwner(), new Observer<CourseModel>() {
                    @Override
                    public void onChanged(CourseModel courseModel) {
                        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_frame , new CourseBaseViewerFragment(),"cs50")
                                .addToBackStack("cs50").commit();
                        SharedModel.setSelected_course(courseModel);
                    }
                });
            }
        });


    }

}