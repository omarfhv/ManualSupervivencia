package com.heisenbergtao.manualsupervivencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Vacasiones extends AppCompatActivity implements View.OnClickListener{

    LinearLayout botonanouno,botonanodos,botonanotres, botonanocuatro, botonanocinco,
            botonanomascinco;

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //botonatras
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        setContentView(R.layout.activity_vacasiones);

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        botonanouno = findViewById(R.id.botonanouno);
        botonanouno.setOnClickListener(this);


        botonanodos = findViewById(R.id.botonanodos);
        botonanodos.setOnClickListener(this);


        botonanotres = findViewById(R.id.botonanotres);
        botonanotres.setOnClickListener(this);


        botonanocuatro = findViewById(R.id.botonanocuatro);
        botonanocuatro.setOnClickListener(this);


        botonanocinco = findViewById(R.id.botonanocinco);
        botonanocinco.setOnClickListener(this);


        botonanomascinco = findViewById(R.id.botonanomas);
        botonanomascinco.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.botonanouno:

                Intent intent11 = new Intent(this, AnoUno.class);
                startActivity(intent11);
                finish();
                break;

            case R.id.botonanodos:

                Intent intent111 = new Intent(this, Anodos.class);
                startActivity(intent111);
                finish();
                break;

            case R.id.botonanotres:

                Intent intent112 = new Intent(this, Anotres.class);
                startActivity(intent112);
                finish();
                break;

            case R.id.botonanocuatro:

                Intent intent113 = new Intent(this, AnoCuatro.class);
                startActivity(intent113);
                finish();
                break;

            case R.id.botonanocinco:

                Intent intent115 = new Intent(this, AnoCinco.class);
                startActivity(intent115);
                finish();
                break;

            case R.id.botonanomas:

                Intent intent116 = new Intent(this, AnoMas.class);
                startActivity(intent116);
                finish();
                break;


        }

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            startActivity(new Intent(getBaseContext(), MenuPrincipal.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.action_bar_roles, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(getBaseContext(), MenuPrincipal.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();
        }


        Intent intentmenu = new Intent();
        switch (item.getItemId()) {
            case R.id.diagnostico:
                Intent intent121 = new Intent(this, Roluno.class);
                startActivity(intent121);
                finish();
                break;



        }



        return super.onOptionsItemSelected(item);



    }



}
