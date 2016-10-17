package com.monti.mascotas.bd;

/**
 * Created by Susana on 16/10/2016.
 */

public final class ConstanteBaseDatos {
    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTA = "mascota";
    public static final String TABLE_MASCOTA_ID = "id";
    public static final String TABLE_MASCOTA_NOMBRE = "nombre";
    public static final String TABLE_MASCOTA_FOTO = "foto";
    public static final String TABLE_MASCOTA_LIKE = "likes";

    public static final String TABLE_LIKE = "like";
    public static final String TABLE_LIKE_ID = "id";
    public static final String TABLE_LIKE_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKE_LIKE = "likes";
}
