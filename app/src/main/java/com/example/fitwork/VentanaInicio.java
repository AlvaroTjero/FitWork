package com.example.fitwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VentanaInicio extends AppCompatActivity {

    ImageButton guia, dietas, retos, rutinas, informacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_inicio);

        //Declaramos e inicializamos el menu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        //Decimos el objeto que esta seleccionando
        bottomNavigationView.setSelectedItemId(R.id.home);

        //La acción que pasa depende del boton que seleccionemos
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.rutinas:
                        //startActivity(new Intent(getApplicationContext(), VentanaForo.class));
                        Intent recuperarUsuario = getIntent();

                        String string_usuario_recibido2 = recuperarUsuario.getStringExtra("string_usuario");

                        Intent intentNombreForo = new Intent(getApplicationContext(), VentanaForo.class);

                        intentNombreForo.putExtra("string_usuario", string_usuario_recibido2);

                        startActivity(intentNombreForo);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        return true;

                    case R.id.cuenta:
                        startActivity(new Intent(getApplicationContext(), VentanaPerfil.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });


        guia = findViewById(R.id.bt_guiaEjercicios);
        dietas = findViewById(R.id.bt_dietas);
        retos = findViewById(R.id.bt_retos);
        rutinas = findViewById(R.id.bt_rutinas);
        informacion = findViewById(R.id.bt_informacion);

        guia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGuia = new Intent(VentanaInicio.this, VentanaGuia.class);
                startActivity(intentGuia);
            }
        });

        dietas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDietas = new Intent(VentanaInicio.this, VentanaDietas.class);
                startActivity(intentDietas);
            }
        });

        retos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRetos = new Intent(VentanaInicio.this, VentanaRetos.class);
                startActivity(intentRetos);
            }
        });

        rutinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRutinas = new Intent(VentanaInicio.this, VentanaRutinas.class);
                startActivity(intentRutinas);
            }
        });

        informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInformacion = new Intent(VentanaInicio.this, VentanaInformacion.class);
                startActivity(intentInformacion);
            }
        });
    }
}
