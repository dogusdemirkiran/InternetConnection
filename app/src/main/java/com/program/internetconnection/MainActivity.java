package com.program.internetconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.mesaj);
        button = findViewById(R.id.sendButton);
    }

    public void sendData(View view){
        Toast.makeText(getApplicationContext(), "Veri Gönderimi Başarılı", Toast.LENGTH_SHORT).show();
    }
}