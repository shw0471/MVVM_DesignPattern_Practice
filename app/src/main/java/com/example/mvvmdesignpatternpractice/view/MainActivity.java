package com.example.mvvmdesignpatternpractice.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mvvmdesignpatternpractice.R;
import com.example.mvvmdesignpatternpractice.databinding.ActivityMainBinding;
import com.example.mvvmdesignpatternpractice.viewModel.GithubUserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        GithubUserViewModel githubUserViewModel = new GithubUserViewModel();
        binding.setViewModel(githubUserViewModel);

        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.etSearch.getText().length() > 0)
                    githubUserViewModel.getUserInfo(binding.etSearch.getText().toString());
            }
        });
    }
}