package com.example.hewlettpackard.penilaianmahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HitungActivity extends AppCompatActivity {

    String uts, uas, nilaiHarian;
    Double total, mUts, mUas, mNilaiHarian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung);
        TextView tvData1= (TextView) findViewById(R.id.tv_nama);
        TextView tvData2= (TextView) findViewById(R.id.tv_npm);
        TextView tvData3= (TextView) findViewById(R.id.tv_kelas);
        TextView tvData4= (TextView) findViewById(R.id.tv_nilairata2);
        TextView tvData5= (TextView) findViewById(R.id.tv_nilaihuruf);

        tvData1.setText("Nama = " + getIntent().getStringExtra("nama"));
        tvData2.setText("NPM = " +getIntent().getStringExtra("npm"));
        tvData3.setText("Kelas = " + getIntent().getStringExtra("kelas"));

        nilaiHarian = getIntent().getStringExtra("nilaiharian");
        uts = getIntent().getStringExtra("nilaiuts");
        uas = getIntent().getStringExtra("nilaiuas");

        mUts = Double.valueOf(uts);
        mUas = Double.valueOf(uas);
        mNilaiHarian = Double.valueOf(nilaiHarian);

        total = ((mUts*50/100) + (mUas*30/100) + (mNilaiHarian*20/100));
        tvData4.setText("Nilai = " + total.toString());

        if (total > 80) {
            tvData5.setText("Grade = A");
        }else if (total > 70 && total <= 80){
            tvData5.setText("Grade = B");
        }else if (total > 60 && total <= 70){
            tvData5.setText("Grade = C");
        }else if (total > 50 && total <= 60){
            tvData5.setText("Grade = D");
        }else
            tvData5.setText("Grade = E");
    }

    public void btnclear(View view) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);

    }
}
