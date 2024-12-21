package com.ktck124.lop124LTDD04.nhom13;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThanhvienDetailActivity extends AppCompatActivity {
    private TextView tvName, tvEmail, tvPhone, tvID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanhvien_detail);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvID = findViewById(R.id.tvID);

        Member member = (Member) getIntent().getSerializableExtra("member");

        if (member != null) {
            tvName.setText(member.getName());
            tvEmail.setText(member.getEmail());
            tvPhone.setText(member.getPhone());
            tvID.setText(String.valueOf(member.getId()));
        }
    }
}
