package danielrojas.avance2.classes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Factura {
    private int id;
    private Cliente cliente;
    private Date fecha;
    private List<DetalleFactura> detalles;

    public Factura(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = new Date();
        this.detalles = new ArrayList<>();
    }

    public void agregarProducto(Producto p, int cantidad) throws Exception {
        p.descontar(cantidad);
        detalles.add(new DetalleFactura(p, cantidad));
    }

    public double calcularTotal() {
        return detalles.stream().mapToDouble(DetalleFactura::calcularSubtotal).sum();
    }

    public void guardarEnArchivo(String ruta) throws IOException {
        FileWriter writer = new FileWriter(ruta);
        writer.write("Factura ID: " + id + "\\n");
        writer.write("Cliente: " + cliente.getNombre() + "\\n");
        writer.write("Fecha: " + fecha + "\\n\\n");
        for (DetalleFactura d : detalles) {
            writer.write(d.getLinea() + " - ₡" + d.calcularSubtotal() + "\\n");
        }
        writer.write("\\nTotal: ₡" + calcularTotal() + "\\n");
        writer.close();
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }
}