package model;

import model.Propiedad;

public class Vivienda  extends Propiedad {
    int numeroCuartos;
    int numeroBaños;
    int pisos;

    public Vivienda(String direccion, double valor, double area,
                    Propietario propietario, int numeroCuartos, int numeroBaños, int pisos, Disponibilidad disponibilidad) {
        super(direccion,valor, area, propietario,disponibilidad);
        this.numeroCuartos = numeroCuartos;
        this.numeroBaños = numeroBaños;
        this.pisos = pisos;
    }
}
