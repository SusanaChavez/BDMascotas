package com.monti.mascotas;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.monti.mascotas.adapter.MascotaAdaptador;
import com.monti.mascotas.pojo.Mascota;
import com.monti.mascotas.presentador.IRecyclerViewFragmentPresentador;
import com.monti.mascotas.presentador.RecyclerViewFragmentPresentador;
import com.monti.mascotas.vistas.IRecyclerViewFragmentView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.ToIntFunction;

public class Favoritas extends AppCompatActivity implements IRecyclerViewFragmentView {

   // ArrayList<Mascota> misMascotas;
    private RecyclerView listaFavoritas;
    private IRecyclerViewFragmentPresentador presentador;

    private Toolbar toolbar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("5 +Favoritas");
        }

        listaFavoritas = (RecyclerView) findViewById(R.id.rvFavoritas);

        presentador = new RecyclerViewFragmentPresentador(this, this.getBaseContext());


/* ANTERIOR sin BD
        misMascotas = new ArrayList<Mascota>();

        misMascotas.add(new Mascota("Pluto", R.drawable.plutito));
        misMascotas.add(new Mascota("Santa", R.drawable.santito));
        misMascotas.add(new Mascota("Scooby", R.drawable.scoobyto));
        misMascotas.add(new Mascota("Tom", R.drawable.tomito));
        misMascotas.add(new Mascota("Miss", R.drawable.gatito));


    //     Toast.makeText(Favoritas.this, "He creado todas las mascotas ", Toast.LENGTH_SHORT).show();
    //  Snackbar.make(nose, "Estooooy pasando........", Snackbar.LENGTH_SHORT);

  */

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(this,2);

        listaFavoritas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {

     // mascotas.sor
          Collections.sort(mascotas, new Comparator<Mascota>(){
              @Override
              public int compare(Mascota m1, Mascota m2) {
                  return (m1.getLikes() > m2.getLikes()) ? -1: (m1.getLikes() > m2.getLikes()) ? 1:0;
              }
          });

        ArrayList<Mascota> fin = new ArrayList<Mascota>();

        for (int i=0; i< 5; i++){
           fin.add(mascotas.get(i));
        }

        MascotaAdaptador adaptador = new MascotaAdaptador(fin);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaFavoritas.setAdapter(adaptador);
    }
}

