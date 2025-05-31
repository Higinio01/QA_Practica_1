Higinio Santos 1014-2505

# 🛒 Carrito de Compras con Pruebas Unitarias (JUnit) - QA_Practica_1

Este proyecto implementa una aplicación básica de **carrito de compras** en Java.
Incluye la lógica del carrito, clases orientadas a objetos y pruebas unitarias usando **JUnit 5**.

---

## 📌 Objetivo

Aplicar pruebas unitarias con JUnit para validar el correcto funcionamiento de una aplicación orientada a objetos, con enfoque en la calidad y la prevención de errores en software.

---

## 🧪 Pruebas unitarias

El archivo `CarritoTest.java` valida:

- Agregar productos al carrito
- Sumar cantidades de un mismo producto
- Eliminar productos
- Modificar cantidades
- Calcular el total correctamente
- Verificar comportamiento con carrito vacío

Se utiliza **JUnit 5** con anotaciones como `@Test` y `@BeforeEach`.

---

## 💻 Cómo ejecutar

### Ejecutar la app:
1. Ejecuta `Main.java` para usar el menú de consola.
2. Usa el menú para:
   - Ver productos disponibles
   - Agregar productos con cantidad
   - Ver y modificar el carrito
   - Calcular el total

### Ejecutar las pruebas:
Ejecuta `CarritoTest.java` desde el IDE o consola:

```bash
./gradlew test
