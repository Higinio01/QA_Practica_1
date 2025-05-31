package org.example;

/**
 * Clase que representa un producto con un identificador, nombre y precio.
 */
public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    /**
     * Constructor para crear un item de carrito con un producto y su cantidad.
     *
     * @param producto Producto asociado al item del carrito.
     * @param cantidad Cantidad del producto en el carrito.
     */
    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ItemCarrito{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}