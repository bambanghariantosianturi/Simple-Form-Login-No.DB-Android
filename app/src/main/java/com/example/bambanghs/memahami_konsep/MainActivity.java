package com.example.bambanghs.memahami_konsep;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etpanjang, etlebar;
    private Button etbutton, btnExit, button_test;
    private TextView textView_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Menghitung Luas");


        etpanjang = (EditText) findViewById(R.id.et_panjang);
        etlebar = (EditText) findViewById(R.id.et_lebar);
        etbutton = (Button) findViewById(R.id.et_button);
        textView_3 = (TextView) findViewById(R.id.textView3);
        textView_3.setTypeface(null, Typeface.BOLD);

        etbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String panjang = etpanjang.getText().toString().trim();
                String lebar = etlebar.getText().toString().trim();

                if ( panjang.isEmpty() || lebar.isEmpty()) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Anda Belum Memasukkan Nilai Panjang Atau Lebar!").setNegativeButton("Isikan", null).create().show();



                } else {
                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);
                    double luas = p * l;
                    textView_3.setText("Luas : " + luas);


                }


            }

        });

        btnExit = (Button) findViewById(R.id.buttonExit);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setMessage("Apakah Kamu Yakin Untuk Keluar")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.this.finish();
                            }
                        })
                            .setNegativeButton("No", null)
                        .show();
            }


        });

        button_test = (Button) findViewById(R.id.button_test);

        button_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Test Builder !!!").setNegativeButton("Coba Lagi", null).create().show();
            }
        });


    }


}
