package danielrojas.avance2.classes;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double getPrecio() { return precio; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }

    public void descontar(int cantidadVendida) throws Exception {
        if (cantidadVendida > cantidad) {
            throw new Exception("No hay suficiente stock");
        }
        this.cantidad -= cantidadVendida;
    }
}