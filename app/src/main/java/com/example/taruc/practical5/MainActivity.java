package com.example.taruc.practical5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    private RadioGroup radioGroupGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = findViewById(R.id.smokerCheckBox);
        textViewPremium = findViewById(R.id.textViewPremium);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.age_group, android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Item selected" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view) {
        int position;
        int premium = 0;
        position = spinnerAge.getSelectedItemPosition();
        if(position == 0) {
            premium = 50;
        }else if (position == 1) {
            premium = 55;
        }else if (position == 2) {
            premium = 60;
        }else if (position == 3) {
            premium = 70;
        }else if (position == 4) {
            premium = 120;
        }else if (position == 5) {
            premium = 160;
        }else if (position == 6) {
            premium = 200;
        }else if (position == 7){
            premium = 250;
        }
        int gender;
        gender = radioGroupGender.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale && (position == 0 || position == 1 || position == 6 || position == 7)) {
            premium = premium + 0;
        }
        else if(gender == R.id.radioButtonMale && position == 2) {
            premium = premium + 50;
        }
        else if(gender == R.id.radioButtonMale && position == 3) {
            premium = premium + 100;
        }
        else if(gender == R.id.radioButtonMale && position == 4) {
            premium = premium + 100;
        }
        else if(gender == R.id.radioButtonMale && position == 5) {
            premium = premium + 50;
        } else {
            premium = premium + 0;
        }

        if(checkBoxSmoker.isChecked() && (position == 0 || position == 1 || position == 2)) {
            premium = premium + 0;
        }
        else if(checkBoxSmoker.isChecked() && position == 3) {
            premium = premium + 100;
        }
        else if(checkBoxSmoker.isChecked() && position == 4) {
            premium = premium + 150;
        }
        else if(checkBoxSmoker.isChecked() && position == 5) {
            premium = premium + 150;
        }
        else if(checkBoxSmoker.isChecked() && position == 6) {
            premium = premium + 250;
        }
        else if(checkBoxSmoker.isChecked() && position == 7) {
            premium = premium + 250;
        } else {
            premium = premium + 0;
        }

        textViewPremium.setText(getString(R.string.premium) + " : " + premium);
    }

    public void reset(View view) {
        spinnerAge.setSelection(0);
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText("Premium");
        radioButtonMale.setChecked(false);
        radioButtonFemale.setChecked(false);
    }
}
