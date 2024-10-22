package com.example.lab_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private EditText editTextStreet1, editTextHouse1, editTextFlat1;
    private EditText editTextStreet2, editTextHouse2, editTextFlat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        editTextStreet1 = findViewById(R.id.editTextStreet1);
        editTextHouse1 = findViewById(R.id.editTextHouse1);
        editTextFlat1 = findViewById(R.id.editTextFlat1);
        editTextStreet2 = findViewById(R.id.editTextStreet2);
        editTextHouse2 = findViewById(R.id.editTextHouse2);
        editTextFlat2 = findViewById(R.id.editTextFlat2);
        Button buttonOk = findViewById(R.id.Okay_button);

        buttonOk.setOnClickListener(v -> {
            String street1 = editTextStreet1.getText().toString();
            String house1 = editTextHouse1.getText().toString();
            String flat1 = editTextFlat1.getText().toString();
            String street2 = editTextStreet2.getText().toString();
            String house2 = editTextHouse2.getText().toString();
            String flat2 = editTextFlat2.getText().toString();

            String pathDetails = "Point А: " + street1 + ", " + house1 + ", " + flat1 +
                    "\nPoint B: " + street2 + ", " + house2 + ", " + flat2;

            Intent resultIntent = new Intent();
            resultIntent.putExtra("pathDetails", pathDetails);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
