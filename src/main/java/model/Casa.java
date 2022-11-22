package model;

public class Casa extends Vivienda{
    String materialConstruccion;

    public Casa(String direcion, double valor, float area, Propietario propietario, int numeroCuartos, int numeroBaños, int pisos, String materialConstruccion, Disponibilidad disponibilidad) {
        super(direcion, valor, area, propietario, numeroCuartos, numeroBaños, pisos, disponibilidad);
        this.materialConstruccion = materialConstruccion;
    }
}
