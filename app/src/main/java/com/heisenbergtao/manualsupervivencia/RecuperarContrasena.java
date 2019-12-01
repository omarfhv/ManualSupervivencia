package com.heisenbergtao.manualsupervivencia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class RecuperarContrasena extends AppCompatActivity implements View.OnClickListener {


    private static final int SOLICITUD_PERMISO_CALL_PHONE = 1;
    private Intent intentllamada;
    LinearLayout botonrecujubilados, botonrecuactivos, botonsoportetecnico;
    ColorDrawable dialogColor;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //botonatras
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setContentView(R.layout.activity_recuperar_contrasena);
        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



// SI NOS CONCEDE EL PERMISO Y LANZA LA LLAMADA


        botonrecujubilados = findViewById(R.id.botonrecujubilados);
        botonrecujubilados.setOnClickListener(this);

        botonrecuactivos = findViewById(R.id.botonrecuactivos);
        botonrecuactivos.setOnClickListener(this);

        botonsoportetecnico = findViewById(R.id.botonsoporte);
        botonsoportetecnico.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.botonrecujubilados:

                Intent intent1122 = new Intent(this, RecuJubilados.class);
                startActivity(intent1122);
                finish();
                break;

            case R.id.botonrecuactivos:

                Intent intent112 = new Intent(this, RecuActivos.class);
                startActivity(intent112);
                finish();
                break;

            case R.id.botonsoporte:

                intentllamada  = new Intent(Intent.ACTION_CALL, Uri.parse("tel"+"5555555"));
                if (ActivityCompat.checkSelfPermission(RecuperarContrasena.this, Manifest.permission.CALL_PHONE) ==
                        PackageManager.PERMISSION_GRANTED) {
                    startActivity(intentllamada);
                }
            else{
                    explicarUsoPermiso();
                    solicitarPermiso();

        }

        break;
        }


    }

    private void explicarUsoPermiso(){
        if (ActivityCompat.checkSelfPermission(RecuperarContrasena.this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED){
            alertDialogoBasico();
            Toast.makeText(this, "PERMISO concedido", Toast.LENGTH_SHORT).show();

        }
    }

    private void solicitarPermiso(){

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},SOLICITUD_PERMISO_CALL_PHONE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == SOLICITUD_PERMISO_CALL_PHONE){
            startActivity(intentllamada);
        }

        else {
            Toast.makeText(this, "PERMISO DENEGADO", Toast.LENGTH_SHORT).show();
        }
    }

    public  void alertDialogoBasico(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("SIN EL PERMISO LA LLAMADA NO PUEDE SER REALIZADA");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
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
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(getBaseContext(), MenuPrincipal.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}