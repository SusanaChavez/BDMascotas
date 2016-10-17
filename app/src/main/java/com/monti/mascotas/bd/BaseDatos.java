package com.monti.mascotas.bd;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.monti.mascotas.pojo.Mascota;

import java.util.ArrayList;
import java.util.concurrent.CompletionService;

/**
 * Created by Susana on 16/10/2016.
 */

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstanteBaseDatos.DATABASE_NAME, null, ConstanteBaseDatos.DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " +ConstanteBaseDatos.TABLE_MASCOTA +"(" +
                ConstanteBaseDatos.TABLE_MASCOTA_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT," +
                ConstanteBaseDatos.TABLE_MASCOTA_FOTO   + " TEXT, " +
                 ")";

        String queryCrearTablaLike = "CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKE +"(" +
                ConstanteBaseDatos.TABLE_LIKE_ID            + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstanteBaseDatos.TABLE_LIKE_ID_MASCOTA    + " INTEGER," +
                ConstanteBaseDatos.TABLE_LIKE_LIKE          + " INTEGER, " +
                "FOREIGN KEY (" +  ConstanteBaseDatos.TABLE_LIKE_ID_MASCOTA + ")" +
                " REFERENCES " + ConstanteBaseDatos.TABLE_MASCOTA + "(" +ConstanteBaseDatos.TABLE_MASCOTA_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLike);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST " + ConstanteBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstanteBaseDatos.TABLE_LIKE);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota unaMascota = new Mascota();
            unaMascota.setId(registros.getInt(0));
            unaMascota.setNombre(registros.getString(1));
            unaMascota.setFoto(registros.getInt(2));
            unaMascota.setLikes(registros.getInt(3));

            String queryLike = "SELECT COUNT(" + ConstanteBaseDatos.TABLE_LIKE_LIKE + ") as likes" +
                                " FROM " + ConstanteBaseDatos.TABLE_LIKE +
                                " WHERE " + ConstanteBaseDatos.TABLE_LIKE_ID_MASCOTA + " = " + unaMascota.getId();

            Cursor reg = db.rawQuery(queryLike, null);
            if (reg.moveToNext()){
                unaMascota.setLikes(reg.getInt(0));
            }else {
                unaMascota.setLikes(0);
            }

            mascotas.add(unaMascota);
        }

        db.close();

        return mascotas;
    }

    public void intertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLike(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_LIKE, null, contentValues);
        db.close();

    }

    public int obtenerLike(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT(" + ConstanteBaseDatos.TABLE_LIKE_LIKE +
                ") FROM " + ConstanteBaseDatos.TABLE_LIKE + " WHERE " +
                ConstanteBaseDatos.TABLE_LIKE_ID_MASCOTA + " = " +
                mascota.getId();
        SQLiteDatabase bd = this.getWritableDatabase();
        Cursor registros = bd.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        bd.close();

        return likes;
    }
}
