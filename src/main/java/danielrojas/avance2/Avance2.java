package danielrojas.avance2;

import danielrojas.avance2.classes.Usuario;
import danielrojas.avance2.classes.Login;

import java.util.ArrayList;

public class Avance2 {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin", "admin@gmail.com", "1234"));

        javax.swing.SwingUtilities.invokeLater(() -> {
            new Login(usuarios).setVisible(true);
        });
    }
}
