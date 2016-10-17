package com.monti.mascotas.vistas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.monti.mascotas.R;
import com.monti.mascotas.adapter.MascotaPerfil;
import com.monti.mascotas.pojo.Mascota;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> misMascotas;
    private RecyclerView listaFotos;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaFotos = (RecyclerView) v.findViewById(R.id.rvPerfil);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        listaFotos.setLayoutManager(glm);

        misMascotas = new ArrayList<Mascota>();

        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        /*
        misMascotas.add(new Mascota("Santa", R.drawable.santito));
        misMascotas.add(new Mascota("Scooby", R.drawable.scoobyto));
        misMascotas.add(new Mascota("Tom", R.drawable.tomito));
        misMascotas.add(new Mascota("Miss", R.drawable.gatito));
        */
        darLike();

        //     Toast.makeText(Favoritas.this, "He creado todas las mascotas ", Toast.LENGTH_SHORT).show();
        //  Snackbar.make(nose, "Estooooy pasando........", Snackbar.LENGTH_SHORT);

        inicializaAdaptador();
        return v;
    }

    private void inicializaAdaptador() {
        MascotaPerfil adaptador = new MascotaPerfil(misMascotas);
        listaFotos.setAdapter(adaptador);
    }

    private void darLike() {
        for (Mascota m:misMascotas) {
            m.setLikes();m.setLikes();m.setLikes();m.setLikes();m.setLikes();
        }
    }
}
