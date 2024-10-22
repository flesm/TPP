package com.example.lab_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhone, editTextName, editTextSurname;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhone = findViewById(R.id.editTextPhone);
        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        buttonRegister = findViewById(R.id.buttonRegister);

        SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String savedPhone = prefs.getString("phone", "");
        String savedName = prefs.getString("name", "");
        String savedSurname = prefs.getString("surname", "");

        if (!savedPhone.isEmpty() && !savedName.isEmpty() && !savedSurname.isEmpty()) {
            buttonRegister.setText("Auth");
        }

        editTextPhone.setText(savedPhone);
        editTextName.setText(savedName);
        editTextSurname.setText(savedSurname);

        buttonRegister.setOnClickListener(v -> {
            String inputPhone = editTextPhone.getText().toString();
            String inputName = editTextName.getText().toString();
            String inputSurname = editTextSurname.getText().toString();

            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("phone", inputPhone);
            editor.putString("name", inputName);
            editor.putString("surname", inputSurname);
            editor.apply();

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("phone", inputPhone);
            intent.putExtra("name", inputName);
            intent.putExtra("surname", inputSurname);
            startActivity(intent);
        });
    }
}
