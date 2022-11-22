package model;

public class Edificio extends Propiedad{
        int numeropisos;

        public Edificio(String dirrecion, double valor, float area, Propietario propietario, int numeropisos, Disponibilidad disponibilidad) {
                super(dirrecion, valor, area, propietario, disponibilidad);
                this.numeropisos = numeropisos;
        }
}
