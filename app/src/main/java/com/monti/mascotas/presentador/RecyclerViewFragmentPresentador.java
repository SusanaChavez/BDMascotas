package com.monti.mascotas.presentador;

import android.content.Context;

import com.monti.mascotas.bd.ConstructorMascotas;
import com.monti.mascotas.pojo.Mascota;
import com.monti.mascotas.vistas.IRecyclerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by Susana on 15/10/2016.
 */

public class RecyclerViewFragmentPresentador implements IRecyclerViewFragmentPresentador {
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructor;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresentador(IRecyclerViewFragmentView view, Context context) {
        this.iRecyclerViewFragmentView = view;
        this.context = context;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        constructor = new ConstructorMascotas(context);
        mascotas = constructor.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }
}
