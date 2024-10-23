package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
//    private static final String KEY_COUNT = "count";
//    private static final String STATE_CHECKBOX = "check";
//    private static final String STATE_SWITCH = "tryb";
//    private static final String STATE_INPUT = "tekst";
//    private TextView textViewCount;
//    private EditText CustomText;
//    private Button buttonIncrement;
//    private CheckBox checkBox;
//    private TextView textView;
//    private Switch switch1;
//
//
//    private int count = 0;
//    private String tekst = "";
//    private boolean check = false;
//    private boolean tryb = false;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        textViewCount = findViewById(R.id.textViewCount);
//        buttonIncrement = findViewById(R.id.buttonIncrement);
//        CustomText = findViewById(R.id.CustomText);
//        checkBox = findViewById(R.id.checkBox);
//        textView = findViewById(R.id.textView);
//        switch1 = findViewById(R.id.switch1);
//
//
//        if (savedInstanceState != null) {
//            count = savedInstanceState.getInt(KEY_COUNT);
//            tekst = savedInstanceState.getString(STATE_INPUT);
//            check = savedInstanceState.getBoolean(STATE_CHECKBOX);
//            tryb = savedInstanceState.getBoolean(STATE_SWITCH);
//        }
//        updateCountText();
//        updateCustomText();
//        updateCheckBox();
//        updateSwitch();
//
//
//
//        buttonIncrement.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count++;
//                updateCountText();
//
//            }
//
//        });
//        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                } else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                }
//            }
//        });
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b) {
//                    textView.setVisibility(textView.VISIBLE);
//                } else{
//                    textView.setVisibility(textView.GONE);
//                }
//            }
//        });
//
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(KEY_COUNT, count);
//
//        outState.putString(STATE_INPUT, tekst);
//
//        outState.putBoolean(STATE_CHECKBOX, check);
//
//        outState.putBoolean(STATE_SWITCH, tryb);
//    }
//
//    private void updateCountText() {
//        textViewCount.setText("Licznik: " + count);
//    }
//
//
//    private void updateCustomText() {
//        CustomText.setText(tekst);
//    }
//
//    private void updateCheckBox() {
//        checkBox.setChecked(check);
//    }
//
//    private void updateSwitch() {
//        switch1.setChecked(tryb);
//
//    }


    private TextView textViewCount;
    private EditText CustomText;
    private Button buttonIncrement;
    private CheckBox checkBox;
    private TextView textView;
    private Switch switch1;


    private StateViewModel stateViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        buttonIncrement = findViewById(R.id.buttonIncrement);
        CustomText = findViewById(R.id.CustomText);
        checkBox = findViewById(R.id.checkBox);
        textView = findViewById(R.id.textView);
        switch1 = findViewById(R.id.switch1);


        stateViewModel = new ViewModelProvider(this).get(StateViewModel.class);
        updateCountText();
        updateCustomText();


        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateViewModel.incrementCount();
                updateCountText();
            }
        });
        CustomText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                stateViewModel.Settekst(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                stateViewModel.setTryb(isChecked);
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                updateswitch1();
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                stateViewModel.SetChecked(b);
                if (b) {
                    textView.setVisibility(textView.VISIBLE);
                } else {
                    textView.setVisibility(textView.GONE);
                }
                updatecheckBox();
            }

        });
    }

    private void updateCountText() {
        textViewCount.setText("Licznik: " + stateViewModel.getCount());

    }

    private void updateCustomText() {
        CustomText.setText(stateViewModel.gettekst());
    }

    private void updatecheckBox() { checkBox.setChecked(stateViewModel.isChecked()); }

    private void updateswitch1() {
        switch1.setChecked(stateViewModel.isTryb());
    }
}
