package com.example.fitwork;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class VentanaPerfil extends AppCompatActivity {

    Button CerrarSesion, SubirFoto;
    TextView nombre, correo;

    //Creamos el objeto Firebase para poder cerrar la sesion
    FirebaseAuth mAuth;
    //Objeto DataBase para recoger datos de la base de datos de FireBase
    DatabaseReference mDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_perfil);

        //inicializamos el objeto
        mAuth = FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference();

        nombre = findViewById(R.id.tv_nombre);
        correo = findViewById(R.id.tv_correo);

        CerrarSesion = findViewById(R.id.bt_CerrarSesion);

        CerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cerramos sesion cuando le damos al boton y volvemos a la pagina de inicio de sesion
                mAuth.signOut();
                startActivity(new Intent(VentanaPerfil.this, MainActivity.class));
                finish();
            }
        });

        //Llamamos al metodo con el que vamos a recoger y poner los datos de los usuarios
        getUserInfo();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setSelectedItemId(R.id.cuenta);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.rutinas:
                        startActivity(new Intent(getApplicationContext(), VentanaForo.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), VentanaInicio.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.cuenta:
                        return true;

                }
                return false;
            }
        });
    }


    //Con este metodo vamos a acceder al nodo hijo Users para obtener el id del usuario con el que hemos iniciado sesion
    private void getUserInfo() {
        //Obtenemos el id
        String id = mAuth.getCurrentUser().getUid();
        mDataBase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Decimos que si ese nodo existe, recogemos los datos
                if (dataSnapshot.exists()) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String email = dataSnapshot.child("email").getValue().toString();

                    //Y ponemos los datos recogidos
                    nombre.setText(name);
                    correo.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
