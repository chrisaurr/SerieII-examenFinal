package com.example.firebaseexamen.model;

public class Gasolinera {
    private String uid;
    private String nombre;
    private String precioDiesel;
    private String precioRegular;
    private String precioSuper;

    public Gasolinera() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecioDiesel() {
        return precioDiesel;
    }

    public void setPrecioDiesel(String precioDiesel) {
        this.precioDiesel = precioDiesel;
    }

    public String getPrecioRegular() {
        return precioRegular;
    }

    public void setPrecioRegular(String precioRegular) {
        this.precioRegular = precioRegular;
    }

    public String getPrecioSuper() {
        return precioSuper;
    }

    public void setPrecioSuper(String precioSuper) {
        this.precioSuper = precioSuper;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
