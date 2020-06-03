package com.example.fitwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    EditText correo;
    Button reestablecer;
    String email = " ";

    FirebaseAuth mAuth;

    //objeto de un loader para mostrar el envio del correo electronico
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);

        correo = findViewById(R.id.et_correoContraseña);
        reestablecer = findViewById(R.id.bt_reestablecerPassword);

        reestablecer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obtenemos el email
                email = correo.getText().toString();

                //antes de ejecutar el metodo vamos a validar si el correo esta puesto
                if (!email.isEmpty()) {
                    //mostraremos un mensaje para el usuario
                    mDialog.setMessage("Espere unos segundos...");
                    //Asi el usuario no podra quitar el mensaje hasta que se termine
                    mDialog.setCanceledOnTouchOutside(false);
                    //se muestra
                    mDialog.show();
                    resetPassword();
                }
                else {
                    Toast.makeText(ResetPassword.this, "Debe ingresar el email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void resetPassword() {
        //vamos a establecer el idioma en el que queremos que llegue el correo de reestablecer contraseña
        mAuth.setLanguageCode("es");

        //enviamos el correo de resetear contraseña
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ResetPassword.this, "Se ha enviado el correo para reestablecer tu contraseña", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ResetPassword.this, "No se pudo enviar el correo de reestablecer contraseña", Toast.LENGTH_SHORT).show();
                }

                //cuando acaba se oculta
                mDialog.dismiss();
            }
        });
    }

    public static class VentanaCafeina extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ventana_proteinas);
        }
    }
}
