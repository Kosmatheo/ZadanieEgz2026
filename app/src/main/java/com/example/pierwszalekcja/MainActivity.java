 package com.example.pierwszalekcja;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.jspecify.annotations.NullMarked;

 public class MainActivity extends AppCompatActivity {
    private Button zatwierdz , wlacz;
    private EditText editText;
    private TextView NumerPrania , infOOdku;
    private int licznik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        zatwierdz = findViewById(R.id.zatwiedz);
        wlacz = findViewById(R.id.wlacz);
        editText = findViewById(R.id.edit);
        NumerPrania = findViewById(R.id.nrPrania);
        infOOdku = findViewById(R.id.inf);

        zatwierdz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int wartoscPola = Integer.parseInt( editText.getText().toString());
                        if( wartoscPola >= 1 && wartoscPola <= 12){
                            NumerPrania.setText("Numer prania: "+wartoscPola);
                        }
                    }
                }
        );
        wlacz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(licznik % 2 == 0) {
                            wlacz.setText("Wyłącz");
                            infOOdku.setText("Odkurzacz włączony");
                        }
                        else{
                            wlacz.setText("Włącz");
                            infOOdku.setText("Odkurzacz wyłączony");
                        }
                        licznik++;
                    }
                }
        );

    }
}