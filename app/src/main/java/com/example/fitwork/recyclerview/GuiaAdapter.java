package com.example.fitwork.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.fitwork.R;
import com.example.fitwork.model.guiaEjercicios;

import java.util.List;

//Creamos el recycleview con el adaptador creado previamente y le implementamos el metodo OnClick para poder seleccionar los items del recyclerview
public class GuiaAdapter extends RecyclerView.Adapter<GuiaAdapter.guiaviewholder> implements View.OnClickListener {


    //Creamos la lista
    List<guiaEjercicios> listaMsuculos;

    //Creamos el escuchador
    private View.OnClickListener listener;

    public GuiaAdapter(List<guiaEjercicios> listaMsuculos) {

        this.listaMsuculos = listaMsuculos;
    }


    @NonNull
    @Override
    public guiaviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //creamos la vista y le añadimos el xml creado anteriormente como plantilla
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_muscle, null, false);

        //Poder hacer el proceso de seleccion
        view.setOnClickListener(this);

        return new guiaviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull guiaviewholder holder, int position) {

        //con holder cogemos las variables creadas en nuestro objeto guiaEjercicios
        holder.nombre.setText(listaMsuculos.get(position).getNombre());
        holder.info.setText(listaMsuculos.get(position).getInfo());
        //glide sirve para coger y poner las fotos de cada zona del cuerpo, con un recorte y centradas, finalmente la insertamos en en el ImageView de ItemMuscle
        Glide.with(holder.itemView.getContext())
                .load(listaMsuculos.get(position).getFoto())    //cogemos la url de la imagen del musculo
                .transforms(new RoundedCorners(16))
                .into(holder.imgMuscle);

    }

    //Decimos cual es el tamaño de la lista
    @Override
    public int getItemCount() {
        return listaMsuculos.size();
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
    public class guiaviewholder extends RecyclerView.ViewHolder {

        ImageView imgMuscle;
        TextView nombre, info;

        public guiaviewholder(@NonNull View itemView) {
            super(itemView);

            imgMuscle = itemView.findViewById(R.id.item_foto);
            nombre = itemView.findViewById(R.id.item_nombre);
            info = itemView.findViewById(R.id.tv_info);

        }
    }
}
