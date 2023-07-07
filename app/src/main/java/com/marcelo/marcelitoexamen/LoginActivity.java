package com.marcelo.marcelitoexamen;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.marcelo.marcelitoexamen.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tilemail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               boolean isOK= credenciales(s.toString(),binding.password.getEditText().getText().toString());
                binding.btnLogin.setEnabled(isOK);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean isOK= credenciales(binding.tilemail.getEditText().getText().toString(),binding.password.getEditText().getText().toString());
                binding.btnLogin.setEnabled(isOK);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    private boolean credenciales(String email, String password){

        boolean isEmailOk = (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) && email.equals("ejemplo@idat.com.pe");
        boolean isPasswordOk = (password.length() >= 8 ) && password.equals("Idat1234");
        return isEmailOk && isPasswordOk;
    }

}