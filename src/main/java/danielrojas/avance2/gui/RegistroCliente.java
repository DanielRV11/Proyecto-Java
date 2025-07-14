package danielrojas.avance2.gui;

import danielrojas.avance2.classes.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RegistroCliente extends JFrame {
    private JTextField txtNombre, txtCorreo, txtCedula;
    private JButton btnGuardar;
    private JTextArea areaClientes;
    private ArrayList<Cliente> clientes;

    public RegistroCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;

        setTitle("Registro de Clientes");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelCampos = new JPanel(new GridLayout(4, 2));
        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        panelCampos.add(txtCorreo);

        panelCampos.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        panelCampos.add(txtCedula);

        btnGuardar = new JButton("Guardar");
        panelCampos.add(new JLabel());
        panelCampos.add(btnGuardar);

        areaClientes = new JTextArea();
        areaClientes.setEditable(false);

        add(panelCampos, BorderLayout.NORTH);
        add(new JScrollPane(areaClientes), BorderLayout.CENTER);

        btnGuardar.addActionListener(e -> guardarCliente());
    }

    private void guardarCliente() {
        String nombre = txtNombre.getText().trim();
        String correo = txtCorreo.getText().trim();
        String cedula = txtCedula.getText().trim();

        if (!nombre.isEmpty() && !correo.isEmpty() && !cedula.isEmpty()) {
            clientes.add(new Cliente(nombre, correo, cedula));
            mostrarClientes();
            txtNombre.setText("");
            txtCorreo.setText("");
            txtCedula.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
        }
    }

    private void mostrarClientes() {
        areaClientes.setText("");
        for (Cliente c : clientes) {
            areaClientes.append("Nombre: " + c.getNombre() + "\n");
        }
    }
}