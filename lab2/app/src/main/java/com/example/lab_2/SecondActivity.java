package com.example.lab_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SET_PATH = 1;
    private TextView textViewInfo, textViewRoute;
    private Button buttonSetPath, buttonCallTaxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewInfo = findViewById(R.id.textViewInfo);
        textViewRoute = findViewById(R.id.textViewRoute);
        buttonSetPath = findViewById(R.id.SetPathButton);
        buttonCallTaxi = findViewById(R.id.buttonCallTaxi);

        Intent intent = getIntent();
        String phone = intent.getStringExtra("phone");
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("surname");

        textViewInfo.setText(name + " " + surname + "\n" + phone);

        buttonCallTaxi.setEnabled(false);

        buttonSetPath.setOnClickListener(v -> {
            Intent pathIntent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivityForResult(pathIntent, REQUEST_CODE_SET_PATH);
        });

        buttonCallTaxi.setOnClickListener(v -> {
            Toast.makeText(SecondActivity.this, "Wait 4 taxi. Good luck!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SET_PATH && resultCode == RESULT_OK) {
            String pathDetails = data.getStringExtra("pathDetails");

            textViewRoute.setText("Taxi will arive at :\n " + pathDetails);
            buttonCallTaxi.setEnabled(true);
        }
    }
}
