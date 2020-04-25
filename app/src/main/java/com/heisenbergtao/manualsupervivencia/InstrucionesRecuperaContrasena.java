package com.heisenbergtao.manualsupervivencia;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.google.android.gms.ads.AdView;

public class InstrucionesRecuperaContrasena extends AppCompatActivity {

    ImageView imv;
    AdView mAdView;
    static int[] id = new int[]{R.drawable.ins1, R.drawable.ins2, R.drawable.ins3, R.drawable.ins4, R.drawable.ins5ju, R.drawable.ins6jub, R.drawable.ins7};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruciones_recupera_contrasena);

        SharedPreferences sharedPref;
        sharedPref = getSharedPreferences("instruccionesj", Context.MODE_PRIVATE);
        if (!sharedPref.getBoolean("instruccionesj", false)) {
            final int[] cont = {0};
            final AlertDialog.Builder constructor = new AlertDialog.Builder(this);
            View vista = getLayoutInflater().inflate(R.layout.activity_instruciones_recupera_contrasena, null);
            constructor.setView(vista);
            final AlertDialog dialogo = constructor.create();
            final Button botonext = vista.findViewById(R.id.botonnext);
            final Button botonback = vista.findViewById(R.id.botonback);
            botonback.setVisibility(View.INVISIBLE);
            final CheckBox chbx = vista.findViewById(R.id.chbxdialog);
            final ImageView imageV = vista.findViewById(R.id.imgvw);
            //TextView texto = vista.findViewById(R.id.txt);
            // texto.setText(getString(R.string.mensajeinicio));
            botonback.setOnClickListener(new View.OnClickListener() {
                                             @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                                             @Override
                                             public void onClick(View v) {
                                                 if (cont[0] == 6) {
                                                     botonext.setBackground(getResources().getDrawable(R.drawable.btnflechar));
                                                 }
                                                 if (cont[0] == 1) {
                                                     botonback.setVisibility(View.INVISIBLE);
                                                 }
                                                 cont[0] = instruccionesbotones(imageV, cont[0], false, InstrucionesRecuperaContrasena.this);

                                             }
                                         }
            );
            botonext.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {
                    if (cont[0] == 0) {
                        botonback.setVisibility(View.VISIBLE);
                    }
                    if (cont[0] == 5) {
                        botonext.setBackground(getResources().getDrawable(R.drawable.btnchck));
                    }
                    if (cont[0] == 6) {
                        SharedPreferences sharedPref;
                        sharedPref = getSharedPreferences(
                                "instruccionesj", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putBoolean("instruccionesj", chbx.isChecked());
                        editor.apply();
                        dialogo.cancel();
                    } else {
                        cont[0] = instruccionesbotones(imageV, cont[0], true, InstrucionesRecuperaContrasena.this);
                    }

                }
            });
            dialogo.show();
        }


        imv = findViewById(R.id.imagevi);


    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    static public int instruccionesbotones(ImageView imv, int num, boolean contador, Context context) {
        if (contador) {
            num++;
        } else {
            num--;
        }
        imv.setBackground(context.getResources().getDrawable(id[num]));


        return num;
    }
}
