package com.example.spongebobrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String name = getIntent().getStringExtra("NAME");
        int image = getIntent().getIntExtra("IMAGE",0);
        String description = getIntent().getStringExtra("DESCRIPTION");
        String id = getIntent().getStringExtra("ID");
        String subtext = getIntent().getStringExtra("SUBTEXT");

        TextView titleTextView = findViewById(R.id.Title);
        TextView descriptionTextView = findViewById(R.id.Description);
        ImageView imageView = findViewById(R.id.imageView2);

        titleTextView.setText(name);
        descriptionTextView.setText(description);
        imageView.setImageResource(image);
    }

    public void backToMainActivity(View view){
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);

        startActivity(intent);
    }
}