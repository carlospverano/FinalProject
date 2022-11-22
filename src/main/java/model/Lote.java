package model;

public class Lote extends Propiedad{
    @Override
	public String toString() {
		return "Lote [zona=" + zona + ", getDirecion()=" + getDireccion() + ", getValor()=" + getValor() + ", getArea()="
				+ getArea() + ", getPropietario()=" + getPropietario() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	String zona;

    public Lote(String direccion, double valor, double area, Propietario propietario, String zona, Disponibilidad disponibilidad) {
        super(direccion, valor, area, propietario, disponibilidad);
        this.zona = zona;
    }
}
