package com.monti.mascotas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.monti.mascotas.R;
import com.monti.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Susana on 06/10/2016.
 */
public class MascotaPerfil extends RecyclerView.Adapter<MascotaPerfil.MascotaViewHolder>   {

    ArrayList<Mascota> mascotas;
    public MascotaPerfil(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @Override
    public MascotaPerfil.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        int height = parent.getMeasuredHeight() / 8;
        v.setMinimumHeight(height);

        return new MascotaViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(MascotaPerfil.MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvTantosCV.setText(String.valueOf(mascota.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvTantosCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvTantosCV = (TextView) itemView.findViewById(R.id.tvTantoCV);
        }
    }
}
