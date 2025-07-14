package danielrojas.avance2.gui;

import danielrojas.avance2.classes.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class InterfazFactura extends JFrame {
    private JComboBox<String> comboClientes, comboProductos;
    private JTextField txtCantidad;
    private JButton btnAgregar, btnResumen, btnGuardar;
    private JTextArea areaDetalle;

    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private Factura factura;
    private static int contadorFactura = 1;

    public InterfazFactura(ArrayList<Cliente> clientes, ArrayList<Producto> productos) {
        this.clientes = clientes;
        this.productos = productos;

        setTitle("Crear Factura");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelTop = new JPanel(new GridLayout(3, 2));
        comboClientes = new JComboBox<>();
        comboProductos = new JComboBox<>();
        txtCantidad = new JTextField();

        for (Cliente c : clientes) {
            comboClientes.addItem(c.getNombre());
        }

        for (Producto p : productos) {
            comboProductos.addItem(p.getNombre());
        }

        panelTop.add(new JLabel("Cliente:"));
        panelTop.add(comboClientes);
        panelTop.add(new JLabel("Producto:"));
        panelTop.add(comboProductos);
        panelTop.add(new JLabel("Cantidad:"));
        panelTop.add(txtCantidad);

        JPanel panelBotones = new JPanel(new GridLayout(1, 3));
        btnAgregar = new JButton("Agregar a Factura");
        btnResumen = new JButton("Ver Resumen");
        btnGuardar = new JButton("Guardar Factura");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnResumen);
        panelBotones.add(btnGuardar);

        areaDetalle = new JTextArea();
        areaDetalle.setEditable(false);

        add(panelTop, BorderLayout.NORTH);
        add(new JScrollPane(areaDetalle), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        if (!clientes.isEmpty()) {
            Cliente clienteSeleccionado = clientes.get(0);
            factura = new Factura(contadorFactura++, clienteSeleccionado);
        }

        btnAgregar.addActionListener(e -> agregarProducto());
        btnResumen.addActionListener(e -> mostrarResumen());
        btnGuardar.addActionListener(e -> guardarFactura());
    }

    private void agregarProducto() {
        try {
            int indexProducto = comboProductos.getSelectedIndex();
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());

            if (indexProducto < 0 || cantidad <= 0) {
                throw new Exception("Selecciona un producto y cantidad válida.");
            }

            Producto producto = productos.get(indexProducto);
            factura.agregarProducto(producto, cantidad);
            areaDetalle.append(cantidad + " x " + producto.getNombre() + " = ₡" + (producto.getPrecio() * cantidad) + "\n");

            txtCantidad.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void mostrarResumen() {
        StringBuilder resumen = new StringBuilder();
        resumen.append("Factura ID: ").append(factura.getId()).append("\n");
        resumen.append("Cliente: ").append(factura.getCliente().getNombre()).append("\n");
        resumen.append("Total: ₡").append(factura.calcularTotal()).append("\n");

        JOptionPane.showMessageDialog(this, resumen.toString(), "Resumen de Factura", JOptionPane.INFORMATION_MESSAGE);
    }

    private void guardarFactura() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setSelectedFile(new java.io.File("factura_" + factura.getId() + ".txt"));

            int opcion = fileChooser.showSaveDialog(this);
            if (opcion == JFileChooser.APPROVE_OPTION) {
                String ruta = fileChooser.getSelectedFile().getAbsolutePath();
                factura.guardarEnArchivo(ruta);
                JOptionPane.showMessageDialog(this, "Factura guardada exitosamente en:\n" + ruta);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la factura:\n" + ex.getMessage());
        }
    }
}