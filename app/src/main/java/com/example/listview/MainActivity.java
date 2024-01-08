package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inpNama = (EditText) findViewById(R.id.inpNama);

        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        ArrayList<String> arrayListNama = new ArrayList<>();
        Intent intentPindahListView = new Intent(MainActivity.this, ListActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringNama = inpNama.getText().toString();

                if(stringNama.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Data tidak boleh kosong", Toast.LENGTH_LONG).show();
                }else {
                    arrayListNama.add(stringNama);
                    inpNama.setText("");
                    Toast.makeText(getApplicationContext(), "Data berhasil disimpan", Toast.LENGTH_LONG).show();
                    intentPindahListView.putStringArrayListExtra("daftarNama", arrayListNama);
                    startActivity(intentPindahListView);
                }
            }
        });

        Button btnLihat = (Button) findViewById(R.id.btnLihat);
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentPindahListView.putStringArrayListExtra("daftarNama", arrayListNama);
                startActivity(intentPindahListView);
            }
        });
    }
}