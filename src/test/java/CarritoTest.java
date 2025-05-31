import org.example.Carrito;
import org.example.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para verificar el correcto funcionamiento
 * de la clase Carrito.
 */
public class CarritoTest {

    private Carrito carrito;
    private Producto laptop;
    private Producto mouse;

    /**
     * Inicializa los objetos necesarios antes de cada prueba.
     * Se crea un carrito vacío y dos productos de prueba.
     */
    @BeforeEach
    public void setUp() {
        carrito = new Carrito();
        laptop = new Producto(1, "Laptop", 1000.0);
        mouse = new Producto(2, "Mouse", 50.0);
    }

    /**
     * Verifica que se puede agregar un producto al carrito correctamente.
     * Se espera que el tamaño del carrito aumente y que los valores coincidan.
     */
    @Test
    public void testAgregarProducto() {
        carrito.agregarProducto(laptop, 1);
        assertEquals(1, carrito.getItems().size());
        assertEquals("Laptop", carrito.getItems().getFirst().getProducto().getNombre());
        assertEquals(1, carrito.getItems().getFirst().getCantidad());
    }

    /**
     * Verifica que si se agrega el mismo producto más de una vez,
     * las cantidades se acumulen correctamente.
     */
    @Test
    public void testAgregarProductoExistenteSumaCantidad() {
        carrito.agregarProducto(mouse, 1);
        carrito.agregarProducto(mouse, 2); // debe sumar
        assertEquals(1, carrito.getItems().size());
        assertEquals(3, carrito.getItems().getFirst().getCantidad());
    }

    /**
     * Verifica que se puede eliminar un producto del carrito.
     * Luego de eliminarlo, el carrito debe estar vacío.
     */
    @Test
    public void testEliminarProducto() {
        carrito.agregarProducto(laptop, 1);
        carrito.eliminarProducto("Laptop");
        assertEquals(0, carrito.getItems().size());
    }

    /**
     * Verifica que se puede modificar la cantidad de un producto existente en el carrito.
     */
    @Test
    public void testModificarCantidad() {
        carrito.agregarProducto(mouse, 2);
        carrito.modificarCantidad("Mouse", 5);
        assertEquals(5, carrito.getItems().getFirst().getCantidad());
    }

    /**
     * Verifica que el método calcularTotal devuelva el total correcto
     * basado en los productos y sus cantidades.
     */
    @Test
    public void testCalcularTotal() {
        carrito.agregarProducto(laptop, 1);  // 1000
        carrito.agregarProducto(mouse, 2);   // 50 * 2 = 100
        assertEquals(1100.0, carrito.calcularTotal());
    }

    /**
     * Verifica que el total de un carrito vacío sea 0.
     */
    @Test
    public void testCalcularTotalConCarritoVacio() {
        assertEquals(0.0, carrito.calcularTotal());
    }
}
