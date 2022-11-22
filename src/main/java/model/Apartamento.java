package model;

public class Apartamento extends Vivienda {
    Boolean balcon;
    Boolean ascensor;
    double valorAdministracion;
    int numeroParqueadero;

    public Apartamento(String dirrecion, double valor, float area, Propietario propietario, int numeroCuartos, int numeroBaños, int pisos, Boolean balcon,
                       Boolean ascensor, double valorAdministracion, int numeroParqueadero, Disponibilidad disponibilidad) {
        super(dirrecion, valor, area, propietario, numeroCuartos, numeroBaños, pisos, disponibilidad);
        this.balcon = balcon;
        this.ascensor = ascensor;
        this.valorAdministracion = valorAdministracion;
        this.numeroParqueadero = numeroParqueadero;
    }
}
