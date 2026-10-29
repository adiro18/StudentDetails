package com.example.studentdetails;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_display);

        // Keep content below the status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the details sent from MainActivity
        String name = getIntent().getStringExtra("name");
        String registerNumber = getIntent().getStringExtra("registerNumber");
        String department = getIntent().getStringExtra("department");
        String year = getIntent().getStringExtra("year");
        String email = getIntent().getStringExtra("email");
        String phoneNumber = getIntent().getStringExtra("phoneNumber");

        // Show each detail on its own line
        TextView tvName = findViewById(R.id.tvName);
        TextView tvRegisterNumber = findViewById(R.id.tvRegisterNumber);
        TextView tvDepartment = findViewById(R.id.tvDepartment);
        TextView tvYear = findViewById(R.id.tvYear);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvPhoneNumber = findViewById(R.id.tvPhoneNumber);

        tvName.setText("Name: " + name);
        tvRegisterNumber.setText("Register Number: " + registerNumber);
        tvDepartment.setText("Department: " + department);
        tvYear.setText("Year: " + year);
        tvEmail.setText("Email: " + email);
        tvPhoneNumber.setText("Phone Number: " + phoneNumber);

        // Back button simply closes this screen
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
