package com.example.fitwork.recyclerview;

import android.content.Intent;
import android.graphics.CornerPathEffect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.fitwork.R;
import com.example.fitwork.VentanaPectoral;
import com.example.fitwork.model.guiaEjerciciosZone;
import com.google.android.material.internal.CircularBorderDrawable;

import java.util.List;

//Creamos el recycleview con el adaptador creado previamente y le implementamos el metodo OnClick para poder seleccionar los items del recyclerview
public class ZoneAdapter extends RecyclerView.Adapter<ZoneAdapter.zoneviewholder> implements View.OnClickListener {


    //Creamos la lista
    List<guiaEjerciciosZone> listaEjerciciosZone;

    //Creamos el escuchador
    private  View.OnClickListener listener;

    public ZoneAdapter(List<guiaEjerciciosZone> listaEjerciciosZone) {
        this.listaEjerciciosZone = listaEjerciciosZone;

    }


    @NonNull
    @Override
    public zoneviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //creamos la vista y le añadimos el xml creado anteriormente como plantilla
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_muscle_zone, null, false);

        //Poder hacer el proceso de seleccion
        view.setOnClickListener(this);

        return new zoneviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull zoneviewholder holder, int position) {

        //con holder cogemos las variables creadas en nuestro objeto guiaEjercicios
        holder.nombre.setText(listaEjerciciosZone.get(position).getNombre());

        //glide sirve para coger y poner las fotos de cada zona del cuerpo, con un recorte y centradas, finalmente la insertamos en en el ImageView de ItemMuscle
        Glide.with(holder.itemView.getContext())
                .load(listaEjerciciosZone.get(position).getFoto())    //cogemos la url de la imagen del musculo
                .transforms(new RoundedCorners(16))
                .into(holder.imgMuscle);
                //
    }

    //Decimos cual es el tamaño de la lista
    @Override
    public int getItemCount() {

        return listaEjerciciosZone.size();

    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;

    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }

    }

    //Creamos los elementos que va a llevar dentro el recyclerview, que son los objeto creados en guiaEjercicios
    public class zoneviewholder extends RecyclerView.ViewHolder {

        ImageView imgMuscle;
        TextView nombre;
        ConstraintLayout muscleLaoyut;

        public zoneviewholder(@NonNull View itemView) {
            super(itemView);

            imgMuscle = itemView.findViewById(R.id.item_foto);
            nombre = itemView.findViewById(R.id.item_nombre);
            muscleLaoyut = itemView.findViewById(R.id.muscleLayout);

        }
    }
}
