package com.example.fitwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.load.model.GlideUrl;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    EditText correo, contraseña;
    Button iniciarSesion, registrarUsuario, reestablecerContraseña;
    String email = " ";
    String password = " ";

    //Creamos el objeto Firebase para poder iniciar sesion
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos mAuth
        mAuth = FirebaseAuth.getInstance();

        correo = findViewById(R.id.et_correo);
        contraseña = findViewById(R.id.et_contrasena);
        iniciarSesion = findViewById(R.id.bt_iniciarSesion);
        registrarUsuario = findViewById(R.id.bt_crear_cuenta);
        reestablecerContraseña = findViewById(R.id.bt_contraseña);

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = correo.getText().toString();
                password = contraseña.getText().toString();

                //Si no esta vacio hacemos el login
                if(!email.isEmpty() && !password.isEmpty()) {
                    loginUser();
                    
                }
                //Si no salta un mensaje de error
                else{
                    Toast.makeText(MainActivity.this, "Por favor completa los campos para iniciar sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void loginUser() {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //si la tarea fue exitosa se inicia sesion
                if (task.isSuccessful()) {
                    //startActivity(new Intent(MainActivity.this, VentanaInicio.class));
                    Intent intent = new Intent(getApplicationContext(), VentanaInicio.class);

                    intent.putExtra("string_usuario", email);

                    startActivity(intent);
                    //finish es para que no pueda volver a la pantalla anterior
                    finish();
                }
                //Si no
                else {
                    Toast.makeText(MainActivity.this, "No se pudo iniciar la sesión, compruebe los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void Registrarse(View view){
        Intent intent = new Intent(MainActivity.this, VentanaRegistro.class);
        startActivity(intent);
    }

    public void Contraseña(View view) {
        Intent intent2 = new Intent(MainActivity.this, ResetPassword.class);
        startActivity(intent2);
    }

    //Con este metodo lo que haremos es que reconozca si un usuario ha iniciado sesion y en vez de enviarlo a la pantalla para volver a iniciar sesion
    //Aparecerá directamente en la ventana de incio
    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() !=null) {
            startActivity(new Intent(MainActivity.this, VentanaInicio.class));
            finish();
        }
    }
}
