package com.monti.mascotas.vistas;


import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.monti.mascotas.R;
import com.monti.mascotas.adapter.MascotaAdaptador;
import com.monti.mascotas.pojo.Mascota;
import com.monti.mascotas.presentador.IRecyclerViewFragmentPresentador;
import com.monti.mascotas.presentador.RecyclerViewFragmentPresentador;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
 //   ArrayList<Mascota> misMascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresentador presentador;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

/*
        misMascotas = new ArrayList<Mascota>();
        misMascotas.add(new Mascota("Garfield", R.drawable.gardfielito));
        misMascotas.add(new Mascota("Miss", R.drawable.gatito));
        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Santa", R.drawable.santito));
        misMascotas.add(new Mascota("Scooby", R.drawable.scoobyto));
        misMascotas.add(new Mascota("Tom", R.drawable.tomito));
*/
        //     Toast.makeText(ListaMascotas.this, "He creado todas las mascotas ", Toast.LENGTH_SHORT).show();
        //  Snackbar.make(nose, "Estooooy pasando........", Snackbar.LENGTH_SHORT);

        presentador = new RecyclerViewFragmentPresentador(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);

        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

    }
}
