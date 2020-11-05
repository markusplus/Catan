package com.oal.catan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import static com.oal.catan.ResourceManager.*;
import static com.oal.catan.ConstructionManager.*;

public class MainActivity extends AppCompatActivity {
    LinearLayout tronco_necesario_carretera;
    LinearLayout ladrillo_necesario_carretera;
    LinearLayout fila3;
    LinearLayout fila4;
    ImageView uno;
    ImageView dos;
    ImageView carretera_img;
    boolean longClickCarretera = false;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        uno = (ImageView) findViewById(R.id.dado_1);
        dos = (ImageView) findViewById(R.id.dado_2);
        //Construir-----------------------------
        iniConstructionManager(CARRETERA, (LinearLayout) findViewById(R.id.carretera_necesario), (ImageView) findViewById(R.id.carretera_icon), (TextView) findViewById(R.id.carretera_cantidad),
                findViewById(R.id.carretera_icon), MainActivity.this);
        iniConstructionManager(POBLADO, (LinearLayout) findViewById(R.id.poblado_necesario), (ImageView) findViewById(R.id.pueblo_icon), (TextView) findViewById(R.id.pueblo_cantidad),
                findViewById(R.id.pueblo_icon), MainActivity.this);
        iniConstructionManager(CIUDAD, (LinearLayout) findViewById(R.id.ciudad_necesario), (ImageView) findViewById(R.id.ciudad_icon), (TextView) findViewById(R.id.ciudad_cantidad),
                findViewById(R.id.ciudad_icon), MainActivity.this);
        iniConstructionManager(MAGIA, (LinearLayout) findViewById(R.id.magia_necesario), (ImageView) findViewById(R.id.magia_icon), (TextView) findViewById(R.id.magia_cantidad),
                findViewById(R.id.magia_icon), MainActivity.this);

        fila3 = findViewById(R.id.fila3);
        fila4 = findViewById(R.id.fila4);
        carretera_img = findViewById(R.id.carretera_icon);
        /*
        carretera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(tronco.getText().toString()) > 0 && Integer.parseInt(tronco.getText().toString()) > 0) {
                    AlertDialog.Builder myBuild = new AlertDialog.Builder(MainActivity.this);
                    myBuild.setMessage("Se construirá una carretera");
                    myBuild.setTitle(Html.fromHtml("<font color='#a32d47'>Construcción</font>"));
                    myBuild.setPositiveButton(Html.fromHtml("<font color='#a32d47'>Construir</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int carretera = Integer.parseInt(carretera_cantidad.getText().toString());
                            int tronco_cantidad = Integer.parseInt(tronco.getText().toString());
                            int ladrillo_cantidad = Integer.parseInt(ladrillo.getText().toString());
                            carretera_cantidad.setText(String.valueOf(++carretera));
                            tronco.setText(String.valueOf(--tronco_cantidad));
                            ladrillo.setText(String.valueOf(--ladrillo_cantidad));
                        }
                    });
                    myBuild.setNegativeButton(Html.fromHtml("<font color='#a32d47'>Cancelar</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = myBuild.create();
                    dialog.show();
                }
            }
        });
         */
//        carretera.setOnLongClickListener(carreteraHoldListener);
//        carretera.setOnTouchListener(carreteraTouchListener);

        //Recursos------------------------------
        iniResourceManager(TRONCO,
                (TextView) findViewById(R.id.tronco),
                findViewById(R.id.tronco_container_fila4),
                findViewById(R.id.menos_tronco));
        iniResourceManager(LADRILLO,
                (TextView) findViewById(R.id.ladrillo),
                findViewById(R.id.ladrillo_container_fila4),
                findViewById(R.id.menos_ladrillo));
        iniResourceManager(OVEJA,
                (TextView) findViewById(R.id.oveja),
                findViewById(R.id.oveja_container_fila4),
                findViewById(R.id.menos_oveja));
        iniResourceManager(TRIGO,
                (TextView) findViewById(R.id.trigo),
                findViewById(R.id.trigo_container_fiila4),
                findViewById(R.id.menos_trigo));
        iniResourceManager(ROCA,
                (TextView) findViewById(R.id.roca),
                findViewById(R.id.roca_container_fila4),
                findViewById(R.id.menos_roca));
        //Comerciar----------------------------------------------------------
    }

    private View.OnLongClickListener carreteraHoldListener = new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View pView) {
            // Do something when your hold starts here.
            ladrillo_necesario_carretera.setVisibility(View.VISIBLE);
            tronco_necesario_carretera.setVisibility(View.VISIBLE);
            longClickCarretera = true;
            return true;
        }
    };

    private View.OnTouchListener carreteraTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View pView, MotionEvent pEvent) {
            pView.onTouchEvent(pEvent);
            // We're only interested in when the button is released.
            if (pEvent.getAction() == MotionEvent.ACTION_UP) {
                // We're only interested in anything if our speak button is currently pressed.
                if (longClickCarretera) {
                    ladrillo_necesario_carretera.setVisibility(View.GONE);
                    tronco_necesario_carretera.setVisibility(View.GONE);
                    // Do something when the button is released.
                    longClickCarretera = false;
                }
            }
            return false;
        }
    };

    public void TirarDado(View v) {
        int numero1 = (int) Math.floor(Math.random() * 6) + 1;
        int numero2 = (int) Math.floor(Math.random() * 6) + 1;
        switch (numero1) {
            case 1:
                uno.setImageResource(R.drawable.dado1);
                break;
            case 2:
                uno.setImageResource(R.drawable.dado2);
                break;
            case 3:
                uno.setImageResource(R.drawable.dado3);
                break;
            case 4:
                uno.setImageResource(R.drawable.dado4);
                break;
            case 5:
                uno.setImageResource(R.drawable.dado5);
                break;
            case 6:
                uno.setImageResource(R.drawable.dado6);
        }
        switch (numero2) {
            case 1:
                dos.setImageResource(R.drawable.dado1);
                break;
            case 2:
                dos.setImageResource(R.drawable.dado2);
                break;
            case 3:
                dos.setImageResource(R.drawable.dado3);
                break;
            case 4:
                dos.setImageResource(R.drawable.dado4);
                break;
            case 5:
                dos.setImageResource(R.drawable.dado5);
                break;
            case 6:
                dos.setImageResource(R.drawable.dado6);
                break;
        }
    }
    public void DadoVisible(View v) {
        uno.setVisibility(View.INVISIBLE);
        dos.setVisibility(View.INVISIBLE);
    }
    public void CambiarAlfa(View v) {
        carretera_img.setAlpha((float) 255/255);
    }
}
