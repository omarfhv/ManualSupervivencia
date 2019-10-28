package com.heisenbergtao.manualsupervivencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {

    LinearLayout botoncontrato,botonpase,botontxt, botonlicencias, botonvacaciones,
    botontestamento, botonfaltas, botoncaja, botonseguro, botonincapacidad, botonfestivos,
    botonreintegros, botoncontratos, botonjubilacion,botoncursos,botontabulador;

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);


        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        botoncontrato = findViewById(R.id.botoncontrato);
        botoncontrato.setOnClickListener(this);

        botontabulador = findViewById(R.id.botontabulador);
        botontabulador.setOnClickListener(this);

        botonpase = findViewById(R.id.botonpases);
        botonpase.setOnClickListener(this);

        botontxt = findViewById(R.id.botontxt);
        botontxt.setOnClickListener(this);

        botoncursos = findViewById(R.id.botoncursos);
        botoncursos.setOnClickListener(this);

        botonvacaciones = findViewById(R.id.botonvacaciones);
        botonvacaciones.setOnClickListener(this);

        botontestamento = findViewById(R.id.botonpliego);
        botontestamento.setOnClickListener(this);

        botonfaltas = findViewById(R.id.botonfaltas);
        botonfaltas.setOnClickListener(this);

        botonseguro = findViewById(R.id.botonseguro);
        botonseguro.setOnClickListener(this);

        botonincapacidad = findViewById(R.id.botonincapacidad);
        botonincapacidad.setOnClickListener(this);

        botonfestivos = findViewById(R.id.botondias);
        botonfestivos.setOnClickListener(this);

        botonreintegros = findViewById(R.id.botonreintegros);
        botonreintegros.setOnClickListener(this);

        botonjubilacion = findViewById(R.id.botonjubilacion);
        botonjubilacion.setOnClickListener(this);

        botoncontratos = findViewById(R.id.botoncontratos);
        botoncontratos.setOnClickListener(this);




    }




    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botoncontrato:

                Intent intent11 = new Intent(this, ContratoColectivo.class);
                startActivity(intent11);
                finish();
                break;


            case R.id.botonpases:

                Intent intent1 = new Intent(this, Pases.class);
                startActivity(intent1);
                finish();
                break;

            case R.id.botonvacaciones:

                Intent intent1131 = new Intent(this, Vacasiones.class);
                startActivity(intent1131);
                finish();
                break;

            case R.id.botonincapacidad:

                Intent intent1112 = new Intent(this, Incapacidades.class);
                startActivity(intent1112);
                finish();
                break;

            case R.id.botondias:

                Intent intent111 = new Intent(this, Festivos.class);
                startActivity(intent111);
                finish();
                break;

            case R.id.botonpliego:

                Intent intent112 = new Intent(this, PliegoTestamentario.class);
                startActivity(intent112);
                finish();
                break;
            case R.id.botonseguro:

                Intent intent11z = new Intent(this, SeguroFacultativo.class);
                startActivity(intent11z);
                finish();
                break;

            case R.id.botonfaltas:

                Intent intent11z3 = new Intent(this, Faltas.class);
                startActivity(intent11z3);
                finish();
                break;

            case R.id.botoncontratos:

                Intent intent11zq = new Intent(this, Contratoss.class);
                startActivity(intent11zq);
                finish();
                break;

            case R.id.botoncursos:

                Intent intent11zq1 = new Intent(this, Cursos.class);
                startActivity(intent11zq1);
                finish();
                break;


            case R.id.botontabulador:

                Intent intent11zq1a = new Intent(this, Tabulador.class);
                startActivity(intent11zq1a);
                finish();
                break;

            case R.id.botonjubilacion:

                Intent intent11zq1aq = new Intent(this, TramiteJubilacion.class);
                startActivity(intent11zq1aq);
                finish();
                break;


            case R.id.botontxt:

                Intent intentd = new Intent(this, TxtSustis.class);
                startActivity(intentd);
                finish();
                break;

        }

    }
}
