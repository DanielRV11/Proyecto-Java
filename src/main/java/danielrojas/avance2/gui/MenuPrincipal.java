package danielrojas.avance2.gui;

import danielrojas.avance2.classes.Cliente;
import danielrojas.avance2.classes.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal(ArrayList<Cliente> clientes, ArrayList<Producto> productos) {
        setTitle("Menú Principal");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JButton btnClientes = new JButton("Registrar Cliente");
        JButton btnProductos = new JButton("Registrar Producto");
        JButton btnFacturar = new JButton("Crear Factura");
        JButton btnSalir = new JButton("Salir");

        btnClientes.addActionListener(e -> new RegistroCliente(clientes).setVisible(true));
        btnProductos.addActionListener(e -> new RegistroProducto(productos).setVisible(true));
        btnFacturar.addActionListener(e -> new InterfazFactura(clientes, productos).setVisible(true));
        btnSalir.addActionListener(e -> System.exit(0));

        add(btnClientes);
        add(btnProductos);
        add(btnFacturar);
        add(btnSalir);
    }
}