package danielrojas.avance2.classes;

public class Usuario extends Persona {
    protected String password;

    public Usuario(String nombre, String correo, String contrasena) {
        super(nombre, correo);
        this.password = contrasena;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Usuario: " + nombre + " - " + correo);
    }
}