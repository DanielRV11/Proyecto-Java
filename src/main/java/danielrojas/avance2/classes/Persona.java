
package danielrojas.avance2.classes;

public abstract class Persona {
    protected String nombre;
    protected String correo;

    public Persona(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public abstract void mostrarInformacion();
}