package com.example.helloworld.ui.notifications;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.helloworld.R;
import com.example.helloworld.databinding.FragmentNotificationsBinding;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.Timer;

public class NotificationsFragment extends Fragment {

    private MaterialButtonToggleGroup materialButtonToggleGroup;
    private NumberPicker picker1;
    private String[] pickerVals;

    private TextView textTime;

    private FragmentNotificationsBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textNotifications;
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        materialButtonToggleGroup = root.findViewById(R.id.toggleButton);

        picker1 = root.findViewById(R.id.numberPicker);
        picker1.setMaxValue(60);
        picker1.setMinValue(0);
        pickerVals = new String[] {"0s", "1s", "2s", "3s", "4s", "5s", "6s", "7s", "8s", "9s", "10s",
                "11s", "12s", "13s", "14s", "15s", "16s", "17s", "18s", "19s", "20s",
                "21s", "22s", "23s", "24s", "25s", "26s", "27s", "28s", "29s", "30s",
                "31s", "32s", "33s", "34s", "35s", "36s", "37s", "38s", "39s", "40s",
                "41s", "42s", "43s", "44s", "45s", "46s", "47s", "48s", "49s", "50s",
                "51s", "52s", "53s", "54s", "55s", "56s", "57s", "58s", "59s", "60s"};
        picker1.setDisplayedValues(pickerVals);

        picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                int valuePicker1 = picker1.getValue();
                Log.d("picker value", String.valueOf(valuePicker1));
            }

        });



        materialButtonToggleGroup.addOnButtonCheckedListener(
                new MaterialButtonToggleGroup.OnButtonCheckedListener() {

                    @Override
                    public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {

                        if (isChecked) {
                            if (checkedId == R.id.button_start) {
                                // start timing here
                                new CountDownTimer( picker1.getValue(),1000){
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        textTime = root.findViewById(R.id.textViewTimer);
                                        textTime.setText("seconds remaining: " + millisUntilFinished / 1000);
                                    }

                                    @Override
                                    public void onFinish() {
                                        textTime = root.findViewById(R.id.textViewTimer);
                                        textTime.setText("done!");
                                    }
                                }.start();


                            } else if (checkedId == R.id.button_pause) {
                                // pause timing here


                            } else if (checkedId == R.id.button_stop) {
                                //stop timing here


                            }
                        }
                    }
                });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}