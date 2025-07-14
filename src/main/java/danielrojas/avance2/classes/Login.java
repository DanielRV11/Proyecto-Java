
package danielrojas.avance2.classes;


import danielrojas.avance2.gui.MenuPrincipal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Login extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private ArrayList<Usuario> usuarios;

    public Login(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
        setTitle("Inicio de Sesión");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        add(txtUsuario);

        add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contrasena = new String(txtPassword.getPassword());

                boolean encontrado = false;
                for (Usuario u : usuarios) {
                    if (u.nombre.equals(usuario) && u.password.equals(contrasena)) {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!");
                        encontrado = true;
                        dispose();

                        ArrayList<Cliente> listaClientes = new ArrayList<>();
                        ArrayList<Producto> listaProductos = new ArrayList<>();
                        new MenuPrincipal(listaClientes, listaProductos).setVisible(true);
                        break;
                    }
                }
                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                }
            }
        });
        add(btnLogin);
    }
}