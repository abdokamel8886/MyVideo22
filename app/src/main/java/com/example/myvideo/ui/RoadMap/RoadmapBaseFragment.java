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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class RoadmapBaseFragment extends Fragment {


    FragmentRoadmapBaseBinding binding;
    RoadMapViewModel viewModel;
    BottomNavigationView nav ;

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
        nav  = requireActivity().findViewById(R.id.nav);
        nav.setVisibility(View.GONE);
        SharedModel.setSelected_course(null);

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


        //basic
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
                        SharedModel.setSelected_course(courseModel);
                        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_frame , new CourseBaseViewerFragment(),"cs50")
                                .addToBackStack("cs50").commit();

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
                        SharedModel.setSelected_course(courseModel);
                        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_frame , new CourseBaseViewerFragment(),"ppy")
                                .addToBackStack("ppy").commit();

                    }
                });
            }
        });

        // core

        binding.core.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.core1.getVisibility() == View.VISIBLE){
                    binding.core1.setVisibility(View.GONE);
                }
                else {
                    binding.core1.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.coreProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.coreProgLayout.getVisibility() == View.VISIBLE){
                    binding.coreProgLayout.setVisibility(View.GONE);
                }
                else {
                    binding.coreProgLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.coreMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.coreMathLayout.getVisibility() == View.VISIBLE){
                    binding.coreMathLayout.setVisibility(View.GONE);
                }
                else {
                    binding.coreMathLayout.setVisibility(View.VISIBLE);
                }
            }
        });


        binding.coreTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.coreToolsLayout.getVisibility() == View.VISIBLE){
                    binding.coreToolsLayout.setVisibility(View.GONE);
                }
                else {
                    binding.coreToolsLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.coreSys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.coreSysLayout.getVisibility() == View.VISIBLE){
                    binding.coreSysLayout.setVisibility(View.GONE);
                }
                else {
                    binding.coreSysLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.coreTheory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.coreTheoryLayout.getVisibility() == View.VISIBLE){
                    binding.coreTheoryLayout.setVisibility(View.GONE);
                }
                else {
                    binding.coreTheoryLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.coreSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.coreSecLayout.getVisibility() == View.VISIBLE){
                    binding.coreSecLayout.setVisibility(View.GONE);
                }
                else {
                    binding.coreSecLayout.setVisibility(View.VISIBLE);
                }
            }
        });


        binding.coreApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.coreAppLayout.getVisibility() == View.VISIBLE){
                    binding.coreAppLayout.setVisibility(View.GONE);
                }
                else {
                    binding.coreAppLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.coreEth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.coreEthLayout.getVisibility() == View.VISIBLE){
                    binding.coreEthLayout.setVisibility(View.GONE);
                }
                else {
                    binding.coreEthLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        //adv

        binding.advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.advanced1.getVisibility() == View.VISIBLE){
                    binding.advanced1.setVisibility(View.GONE);
                }
                else {
                    binding.advanced1.setVisibility(View.VISIBLE);
                }
            }
        });


        binding.advSys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.advSysLayout.getVisibility() == View.VISIBLE){
                    binding.advSysLayout.setVisibility(View.GONE);
                }
                else {
                    binding.advSysLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.advMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.advMathLayout.getVisibility() == View.VISIBLE){
                    binding.advMathLayout.setVisibility(View.GONE);
                }
                else {
                    binding.advMathLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.advProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.advProgLayout.getVisibility() == View.VISIBLE){
                    binding.advProgLayout.setVisibility(View.GONE);
                }
                else {
                    binding.advProgLayout.setVisibility(View.VISIBLE);
                }
            }
        });






    }

}