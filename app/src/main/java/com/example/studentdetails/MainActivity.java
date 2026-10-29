package com.example.studentdetails;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // EditTexts for each student detail
    private EditText etFullName, etRegisterNumber, etDepartment, etYear, etEmail, etPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);

        // Keep content below the status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Link EditTexts to layout
        etFullName = findViewById(R.id.etFullName);
        etRegisterNumber = findViewById(R.id.etRegisterNumber);
        etDepartment = findViewById(R.id.etDepartment);
        etYear = findViewById(R.id.etYear);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    // Validate the fields and move to DisplayActivity
    private void submitForm() {
        String name = etFullName.getText().toString().trim();
        String registerNumber = etRegisterNumber.getText().toString().trim();
        String department = etDepartment.getText().toString().trim();
        String year = etYear.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();

        // Check if any field is empty
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(registerNumber)
                || TextUtils.isEmpty(department) || TextUtils.isEmpty(year)
                || TextUtils.isEmpty(email) || TextUtils.isEmpty(phoneNumber)) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // All fields are filled, send details to DisplayActivity
        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("registerNumber", registerNumber);
        intent.putExtra("department", department);
        intent.putExtra("year", year);
        intent.putExtra("email", email);
        intent.putExtra("phoneNumber", phoneNumber);
        startActivity(intent);
    }
}
