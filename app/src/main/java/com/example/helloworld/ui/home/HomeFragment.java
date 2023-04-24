package com.example.helloworld.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.helloworld.Game;
import com.example.helloworld.R;
import com.example.helloworld.databinding.FragmentHomeBinding;

import YTJ.DataActivity;

public class HomeFragment extends Fragment {
    private Button startButton;
    private TextView helloText;
    private Button gameButton;

    private Button ytjButton;

    private EditText ytjSearchTxt;
    public static final String TAG ="MainActivity";

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        startButton = root.findViewById(R.id.start_button);
        helloText = root.findViewById(R.id.hello_text);
        gameButton = root.findViewById(R.id.game_button);
        ytjButton = root.findViewById(R.id.searchYtjBtn);
        ytjSearchTxt = root.findViewById(R.id.searchYtjTxt);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (helloText.getVisibility() == View.VISIBLE){
                    helloText.setVisibility(View.INVISIBLE);
                }
                else{
                    helloText.setVisibility(View.VISIBLE);
                }

            }
        });

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Game.class);
                startActivity(i);
            }
        });

        ytjButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DataActivity.class);
                Log.i(TAG,ytjSearchTxt.getText().toString());
                i.putExtra("ytjSearchTxt",ytjSearchTxt.getText().toString());
                startActivity(i);
            }
        });


        Log.i(TAG, "Game button clicked");

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}