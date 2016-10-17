package com.monti.mascotas.pojo;

public class Mascota {
    private int id;
    private String nombre;
    private int foto;
    private int likes;

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = 0;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

   /* public int getTantos() {
        return likes;
    }

    public void setTantos() {
        this.likes += 1;
    }
*/
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes){
        this.likes = likes;
    }
    public void setLikes() {
        this.likes += 1;
    }


}
