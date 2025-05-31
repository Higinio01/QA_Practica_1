package org.example;

import java.util.*;

public class Main {

    /**
     * Método principal que ejecuta el programa de gestión de carrito de compras.
     * Permite al usuario agregar, eliminar, modificar productos y ver el total a pagar.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de productos disponibles
        List<Producto> productosDisponibles = Arrays.asList(
                new Producto(1, "Laptop", 1200.00),
                new Producto(2, "Mouse", 25.00),
                new Producto(3, "Teclado", 45.50),
                new Producto(4, "Monitor", 300.00)
        );

        Carrito carrito = new Carrito();

        int opcion;
        // Bucle para mostrar el menú y procesar las opciones del usuario
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Ver carrito");
            System.out.println("3. Modificar cantidad");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Ver total a pagar");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            // Procesar la opción seleccionada
            switch (opcion) {
                // Mostrar productos disponibles y permitir agregar al carrito
                case 1:
                    System.out.println("\n--- Productos disponibles ---");
                    for (Producto p : productosDisponibles) {
                        System.out.println(p.getId() + ". " + p.getNombre() + " - $" + p.getPrecio());
                    }
                    System.out.println("\n--- Agregar producto al carrito ---");
                    System.out.print("\nIngrese el ID del producto a agregar: ");
                    int idAgregar = scanner.nextInt();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidadAgregar = scanner.nextInt();

                    Producto productoAgregar = buscarProductoPorId(productosDisponibles, idAgregar);
                    if (productoAgregar != null) {
                        carrito.agregarProducto(productoAgregar, cantidadAgregar);
                        System.out.println("Producto agregado al carrito.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                // Mostrar el contenido del carrito
                case 2:
                    System.out.println("\n--- Carrito ---");
                    System.out.println(carrito);
                    break;

                // Modificar la cantidad de un producto en el carrito
                case 3:
                    System.out.print("Ingrese el nombre del producto a modificar: ");
                    String nombreMod = scanner.nextLine();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = scanner.nextInt();
                    carrito.modificarCantidad(nombreMod, nuevaCantidad);
                    System.out.println("Cantidad modificada.");
                    break;

                // Eliminar un producto del carrito
                case 4:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    carrito.eliminarProducto(nombreEliminar);
                    System.out.println("Producto eliminado.");
                    break;

                // Calcular y mostrar el total a pagar
                case 5:
                    System.out.println("Total a pagar: $" + carrito.calcularTotal());
                    break;

                // Salir del programa
                case 6:
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    /**
     * Busca un producto por su ID en una lista de productos.
     *
     * @param productos Lista de productos donde buscar.
     * @param id ID del producto a buscar.
     * @return El producto encontrado o null si no se encuentra.
     */
    private static Producto buscarProductoPorId(List<Producto> productos, int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
