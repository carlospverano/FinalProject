package model;

public class Bodega extends Propiedad{
    String zona;
    String nombre;
    public Bodega(String dirrecion, double valor, float area, Propietario propietario, String zona, Disponibilidad disponibilidad) {
        super(dirrecion, valor, area, propietario, disponibilidad);
        this.zona = zona;
    }
}
