package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un carrito de compras que contiene una lista de items.
 * Permite agregar, eliminar y modificar productos, así como calcular el total.
 */
public class Carrito {
    private List<ItemCarrito> items;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    /**
     * Agrega un producto al carrito. Si el producto ya existe, se suma la cantidad.
     *
     * @param producto Producto a agregar.
     * @param cantidad Cantidad del producto a agregar.
     */
    public void agregarProducto(Producto producto, int cantidad) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getNombre().equals(producto.getNombre())) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        items.add(new ItemCarrito(producto, cantidad));
    }

    /**
     * Elimina un producto del carrito por su nombre.
     *
     * @param nombreProducto Nombre del producto a eliminar.
     */
    public void eliminarProducto(String nombreProducto) {
        items.removeIf(item -> item.getProducto().getNombre().equals(nombreProducto));
    }

    /**
     * Modifica la cantidad de un producto en el carrito.
     *
     * @param nombreProducto Nombre del producto a modificar.
     * @param nuevaCantidad Nueva cantidad del producto.
     */
    public void modificarCantidad(String nombreProducto, int nuevaCantidad) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getNombre().equals(nombreProducto)) {
                item.setCantidad(nuevaCantidad);
                return;
            }
        }
    }

    /**
     * Calcula el total del carrito sumando el precio de cada producto por su cantidad.
     *
     * @return Total del carrito.
     */
    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrito item : items) {
            total += item.getProducto().getPrecio() * item.getCantidad();
        }
        return total;
    }

    /**
     * Obtiene la lista de items en el carrito.
     *
     * @return Lista de items del carrito.
     */
    public List<ItemCarrito> getItems() {
        return items;
    }

    /**
     * Representación en cadena del carrito, mostrando los productos y el total.
     *
     * @return Cadena que representa el carrito.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Carrito:\n");
        for (ItemCarrito item : items) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total: ").append(calcularTotal());
        return sb.toString();
    }
}
