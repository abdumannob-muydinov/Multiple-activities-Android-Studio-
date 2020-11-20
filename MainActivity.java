package com.ctis487.homework1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etName1, etName2, etBudget,etDays;
    TextView tvResult;
    Intent aug;
    Intent ist;
    Intent sam;
    RadioButton aug1,ist1,sam1;
    RadioGroup rdbgroup;
    Button g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        etName1 = findViewById(R.id.editSTR1);
        etName2 = findViewById(R.id.editSTR2);
        etBudget = findViewById(R.id.editBudget);
        etDays = findViewById(R.id.editDays);
        tvResult = findViewById(R.id.tvResult);


        aug = new Intent(this, SecondActivity.class);
        ist = new Intent(this, ThirdActivity.class);
        sam = new Intent(this, FourthActivity.class);


        aug1 = findViewById(R.id.augRbtn);
        ist1 = findViewById(R.id.istRbtn);
        sam1 = findViewById(R.id.samRbtn);
        rdbgroup = findViewById(R.id.rdg);
        g = findViewById(R.id.button);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Bundle b = new Bundle();
                b.putString("str1", "10");
                b.putString("str2", "20");
                b.putInt("num1", 10);
                b.putInt("num2", 20);

                if (rdbgroup.getCheckedRadioButtonId() == R.id.augRbtn){
                    aug.putExtras(b);
                    startActivityForResult(aug,1);}
                else if (rdbgroup.getCheckedRadioButtonId() == R.id.istRbtn)
                {
                    ist.putExtras(b);
                    startActivityForResult(ist,2);}
                else if (rdbgroup.getCheckedRadioButtonId() == R.id.samRbtn){
                    sam.putExtras(b);
                    startActivityForResult(sam,3);

            }}
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            assert data != null;
            Bundle b = data.getExtras();
            assert b != null;
            String resultTakenFromActivities = b.getString("res");
            tvResult.setText(resultTakenFromActivities);

            if (rdbgroup.getCheckedRadioButtonId()==R.id.augRbtn) {
                tvResult.setBackgroundColor(Color.BLUE);
                Toast.makeText(this, resultTakenFromActivities, Toast.LENGTH_LONG).show();
            } else {
                tvResult.setBackgroundColor(Color.GREEN);
                Toast.makeText(this, resultTakenFromActivities, Toast.LENGTH_LONG).show();
            }
        }

    }

}
