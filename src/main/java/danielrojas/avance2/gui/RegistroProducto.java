package danielrojas.avance2.gui;

import danielrojas.avance2.classes.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RegistroProducto extends JFrame {
    private JTextField txtNombre, txtPrecio, txtCantidad;
    private JButton btnAgregar;
    private JTextArea areaLista;
    private ArrayList<Producto> productos;
    private int contadorId = 1;

    public RegistroProducto(ArrayList<Producto> productos) {
        this.productos = productos;

        setTitle("Registro de Productos");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelCampos = new JPanel(new GridLayout(4, 2));
        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelCampos.add(txtPrecio);

        panelCampos.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        panelCampos.add(txtCantidad);

        btnAgregar = new JButton("Agregar");
        panelCampos.add(new JLabel());
        panelCampos.add(btnAgregar);

        areaLista = new JTextArea();
        areaLista.setEditable(false);

        add(panelCampos, BorderLayout.NORTH);
        add(new JScrollPane(areaLista), BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> agregarProducto());
        mostrarProductos();
    }

    private void agregarProducto() {
        try {
            String nombre = txtNombre.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
                return;
            }

            Producto nuevo = new Producto(contadorId++, nombre, precio, cantidad);
            productos.add(nuevo);
            mostrarProductos();
            txtNombre.setText("");
            txtPrecio.setText("");
            txtCantidad.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precio y cantidad deben ser números.");
        }
    }

    private void mostrarProductos() {
        areaLista.setText("");
        for (Producto p : productos) {
            areaLista.append(p.getNombre() + " - ₡" + p.getPrecio() + " (" + p.getCantidad() + " unidades)\n");
        }
    }
}