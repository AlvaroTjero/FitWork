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

public class VentanaHombros extends AppCompatActivity {

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

                if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Aperturas Boca Abajo") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=zvoOThJ7iHs");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Elevación Frontal") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=PJvMLaKOw0g");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Encogimientos con Barra") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=grQ3s_zU9n4");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Face Pull") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=T5E-qvzBjYc");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Press de Hombro") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=pWoufFUR7E8");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Pájaros") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=hgLpdwMtEEs");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Press Militar") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=YU7wdiXXgb0");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Remo al Cuello") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=HySt7e87zZg");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Remo con Cable") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=Vp4K-fLzjzg");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

                else if (listaEjerciciosZone.get(rvMuscles.getChildAdapterPosition(view)).getNombre() == "Tirón Diagonal") {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=XyLaZvHeVhU");
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
        listaEjerciciosZone.add(new guiaEjerciciosZone("Aperturas Boca Abajo",  R.drawable.aperturas_boca_abajo));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Elevación Frontal",  R.drawable.elevacion_frontal));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Encogimientos con Barra",  R.drawable.encogimiento_hombros_barra));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Face Pull",  R.drawable.face_pull));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Press de Hombro",  R.drawable.press_hombros));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Pájaros", R.drawable.pajaros));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Press Militar",  R.drawable.press_militar));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Remo al Cuello",  R.drawable.remo_cuello));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Remo con Cable",  R.drawable.remo_cable));
        listaEjerciciosZone.add(new guiaEjerciciosZone("Tirón Diagonal", R.drawable.tiron_diagonal));

    }

    private void initViews() {
        //Asignamos al recyclerview un linearLayout y le decimos que su tamaño sea fijo
        rvMuscles = findViewById(R.id.rv_muscles);
        rvMuscles.setLayoutManager(new LinearLayoutManager(this));
        rvMuscles.setHasFixedSize(true);

    }
}

