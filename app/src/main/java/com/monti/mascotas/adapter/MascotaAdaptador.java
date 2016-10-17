package com.monti.mascotas.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.monti.mascotas.bd.ConstructorMascotas;
import com.monti.mascotas.pojo.Mascota;
import com.monti.mascotas.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>  {

    ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }
    @Override
    public MascotaAdaptador.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(final MascotaAdaptador.MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombreCV.setText(mascota.getNombre());
        holder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(v.getContext(), "Te gustaaaa  "+mascota.getNombre(), Toast.LENGTH_SHORT).show();

               ConstructorMascotas constructorMascotas = new ConstructorMascotas(v.getContext());
               constructorMascotas.darLike(mascota);

               holder.tvLikesCV.setText(String.valueOf(constructorMascotas.obtenerLikes(mascota)));
               holder.tvLikesCV.invalidate();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnLike;
        private TextView tvLikesCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.like);
            tvLikesCV = (TextView) itemView.findViewById(R.id.tvTantoCV);
        }
    }
}