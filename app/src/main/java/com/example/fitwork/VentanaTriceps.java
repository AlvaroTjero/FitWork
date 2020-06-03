package com.example.fitwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fitwork.model.guiaEjerciciosZone;
import com.example.fitwork.recyclerview.ZoneAdapter;

import java.util.ArrayList;
import java.util.List;

public class VentanaTriceps extends AppCompatActivity {

    private RecyclerView rvMuscles;
    private ZoneAdapter adapter;
    private List<guiaEjerciciosZone> listaEjerciciosZone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_pectoral);

        //metodos para crear el recyclerview
        initViews();
        llenarDatosMusculos();
        setupMuscleAdapter();

    }

    //lo usamos para inicializar y crear el adapter para meterlo dentro del recyclerview
    private void setupMuscleAdapter() {

        adapter = new ZoneAdapter(listaEjerciciosZone);
        rvMuscles.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Extensión en Banco") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=PYapgguXgT8");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Extensión con Mancuerna") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=zo_o_sj2T0k");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Extensión con Disco") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=xvhH5_PzEL4");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Extensión en Polea") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=dRkTreltpnc");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Extensión con TRX") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=d983vnbjxjo");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Extensión con Cable") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=8XPp4vOdznY");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Extensión con Cable de Pie") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=kCTGL83gFu8");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Fondos en Paralela") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=NF_wvA7CHGQ");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Flexiones Brazos Pegados") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=szc48Qhec8Q");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Press Frances de Pie") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=YQyE3JnWfNs");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });
    }


    //Rellenamos el recyclerview con los parametros pasados en el metodo guiaholder de la clase GuiaAdapter
    private void llenarDatosMusculos() {

        //creamos la lista y la llenamos
        listaEjerciciosZone = new ArrayList<>();
        listaEjerciciosZone.add(new guiaEjerciciosZone("Extensión en Banco",  R.drawable.extension_banco));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Extensión con Mancuerna", R.drawable.extension_banco_mancuerna));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Extensión con Disco",  R.drawable.extension_disco));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Extensión en Polea",  R.drawable.extension_polea));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Extensión con TRX",  R.drawable.extension_trx));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Extensión con Cable",  R.drawable.extension_cable));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Extensión con Cable de Pie",  R.drawable.extension_cable_depie));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Fondos en Paralela",  R.drawable.fondos_paralelas));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Flexiones Brazos Pegados",  R.drawable.flexiones));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Press Frances de Pie", R.drawable.press_frances));

    }

    private void initViews() {
        //Asignamos al recyclerview un linearLayout y le decimos que su tamaño sea fijo
        rvMuscles = findViewById(R.id.rv_muscles);
        rvMuscles.setLayoutManager(new LinearLayoutManager(this));
        rvMuscles.setHasFixedSize(true);

    }
}
