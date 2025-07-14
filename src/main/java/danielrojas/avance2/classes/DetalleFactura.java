package danielrojas.avance2.classes;

public class DetalleFactura {
    private Producto producto;
    private int cantidad;

    public DetalleFactura(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    public String getLinea() {
        return cantidad + " x " + producto.getNombre();
    }
}