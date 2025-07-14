
package danielrojas.avance2.classes;

public class Cliente extends Persona {
    private String cedula;

    public Cliente(String nombre, String correo, String cedula) {
        super(nombre, correo);
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + ", Cédula: " + cedula);
    }
}