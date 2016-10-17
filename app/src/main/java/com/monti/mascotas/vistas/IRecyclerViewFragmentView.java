package com.monti.mascotas.vistas;

import android.widget.LinearLayout;

import com.monti.mascotas.adapter.MascotaAdaptador;
import com.monti.mascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Susana on 15/10/2016.
 */

public interface IRecyclerViewFragmentView {

        public void generarLinearLayoutVertical();

        public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

        public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
