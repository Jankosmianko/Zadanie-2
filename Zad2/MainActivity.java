package com.example.myapplication;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText imie;
    private EditText nazwisko;
    private EditText email;
    private EditText tel;
    private EditText haslo;
    private EditText phaslo;
    private Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imie = findViewById(R.id.imie);
        nazwisko = findViewById(R.id.nazwisko);
        email = findViewById(R.id.email);
        tel = findViewById(R.id.tel);
        haslo = findViewById(R.id.haslo);
        phaslo = findViewById(R.id.phaslo);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = imie.getText().toString().trim();
                String surnames = nazwisko.getText().toString().trim();
                String emails = email.getText().toString().trim();
                String tels = tel.getText().toString().trim();
                String haslos = haslo.getText().toString().trim();
                String phaslos = phaslo.getText().toString().trim();

                if (names.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();
                } else if (surnames.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                } else if (emails.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić email", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emails).matches()) {
                    Toast.makeText(MainActivity.this, "Wprowadzono błedny email!", Toast.LENGTH_SHORT).show();
                } else if (tels.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić numer telefonu", Toast.LENGTH_SHORT).show();
                } else if (tels.length() < 9) {
                    Toast.makeText(MainActivity.this, "Wprowadzono błedny numer telefonu", Toast.LENGTH_SHORT).show();
                } else if (haslos.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić hasło", Toast.LENGTH_SHORT).show();
                } else if (phaslos.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić potwierdzenie hasła", Toast.LENGTH_SHORT).show();
                } else if (!haslos.equals(phaslos)) {
                    Toast.makeText(MainActivity.this, "Hasła nie są zgodne", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wysłano formularz", Toast.LENGTH_SHORT).show();
                };


            };

        });
    };
};