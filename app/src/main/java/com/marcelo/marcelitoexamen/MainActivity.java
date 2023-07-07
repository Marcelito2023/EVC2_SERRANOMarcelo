package com.marcelo.marcelitoexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import java.util.Random;
import com.google.android.material.snackbar.Snackbar;
import com.marcelo.marcelitoexamen.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {
    private static final int delay = 3000; // 3 segundos

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, delay);

        binding.vector1.setOnClickListener(v -> {
            String[] messages = {
                    "Hello",
                    "UGU",
                    "klsdsds",
                    "Csdsdsiao",
                    "Holaotravez",

            };

            Random random = new Random();
            int index = random.nextInt(messages.length);
            String message = messages[index];

            Snackbar.make(binding.getRoot(), message, Snackbar.LENGTH_SHORT).show();
        });
    }


}