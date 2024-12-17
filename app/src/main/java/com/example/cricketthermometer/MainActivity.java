package com.example.cricketthermometer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btnCalculate;
    TextView tvResult;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etChirps = findViewById(R.id.etChirps);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.0");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etChirps.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields! ",Toast.LENGTH_SHORT).show();

                }
                else{
                    int chirps = Integer.parseInt(etChirps.getText().toString().trim());
                    double temp = (chirps/3.0)+4;
                    String results = "The approximate temperature outside is: "+formatter.format(temp)+" degree Celsius.";
                    tvResult.setText(results);
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}