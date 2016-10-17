package com.monti.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.monti.mascotas.adapter.PageAdapter;
import com.monti.mascotas.vistas.PerfilFragment;
import com.monti.mascotas.vistas.RecyclerViewFragment;

import java.util.ArrayList;


public class ListaMascotas extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_mascotas);

 //       getSupportFragmentManager().beginTransaction().add(R.id.)

//***********
//        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
//        setSupportActionBar(miActionBar);

//        ActionBar actionBar = getSupportActionBar();
      //  actionBar.setDisplayUseLogoEnabled(true);

//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setTitle("");
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayShowTitleEnabled(true);
//        actionBar.setLogo(R.drawable.huellaback);
       // actionBar.setHomeAsUpIndicator(R.drawable.back);



        //Add the following code to make the up arrow white:
        //final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        //upArrow.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        //getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //Estoy probando
       // actionBar.setIcon(android.R.color.transparent);
       // actionBar.setDisplayUseLogoEnabled(false);

        /* para cambiar la barra
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);


        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
getSupportActionBar().setTitle("My new title"); // set the top title
String title = actionBar.getTitle().toString(); // get the title
actionBar.hide();
         */
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        if (toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Mascotas");
        }

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewpager();
    }

    private void setUpViewpager(){
    viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.house);
        tabLayout.getTabAt(1).setIcon(R.drawable.face);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    public void irFavoritas(){
        Intent intent = new Intent(this, Favoritas.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     //   getMenuInflater().inflate(R.menu.menu, menu);
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        // or call onBackPressed()
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
     //   Toast.makeText(ListaMascotas.this, Integer.toString(item.getItemId()), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.vStart:
                irFavoritas();
                break;
            case R.id.mpContacto:
                intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.mpAcerca:
                intent = new Intent(this, Acerca.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
