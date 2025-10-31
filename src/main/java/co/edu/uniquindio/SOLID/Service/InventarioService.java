package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.*;
import co.edu.uniquindio.SOLID.Model.DTO.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventarioService {

    private List<MovimientoInventario> movimientos = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<Proveedor> proveedores = new ArrayList<>();
    private ProveedorService proveedorService;
    private ProductoService productoService;

    // Constructor
    public InventarioService(ProveedorService proveedorService, ProductoService productoService) {
        this.proveedorService = proveedorService;
        this.productoService = productoService;
    }

    // Aumentar stock
    private void aumentarStock(Producto producto, int cantidad) {
        if (cantidad > 0) {
            int nuevoStock = producto.getStock() + cantidad;
            producto.setStock(nuevoStock);
        } else {
            System.out.println("⚠️ Cantidad inválida para aumentar stock");
        }
    }

    // Disminuir stock
    private void disminuirStock(Producto producto, int cantidad) {
        if (cantidad > 0 && producto.getStock() - cantidad >= 0) {
            producto.setStock(producto.getStock() - cantidad);
        } else {
            System.out.println("⚠️ No hay suficiente stock para descontar " + cantidad);
        }
    }

    // Verificar stock suficiente
    private boolean tieneStockSuficiente(Producto producto, int cantidadRequerida) {
        return cantidadRequerida >= 0 && producto.getStock() >= cantidadRequerida;
    }

    private String generarIdMovimiento() {
        // Usa la cantidad actual de movimientos para crear un ID secuencial
        return "MOV-" + (movimientos.size() + 1);
    }

    public void registrarEntrada(EntradaInventarioDTO entradaDTO) {

        // Validar proveedor existente
        Proveedor proveedor = ProveedorService.buscarPorNit(entradaDTO.getNitProveedor());

        if (proveedor == null) {
            System.out.println("❌ Error: El proveedor con NIT " + entradaDTO.getNitProveedor() + " no existe.");
            return;
        }

        // Validar lista de items
        if (entradaDTO.getItems() == null || entradaDTO.getItems().isEmpty()) {
            System.out.println("❌ Error: La entrada no tiene productos asociados.");
            return;
        }

        // Procesar cada ítem de entrada
        for (ItemEntradaDTO item : entradaDTO.getItems()) {

            // Convertir cantidad a número entero
            int cantidad;
            try {
                cantidad = Integer.parseInt(item.getCantidad());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ La cantidad del producto " + item.getSku() + " no es un número válido.");
                continue;
            }

            // Validar cantidad
            if (cantidad <= 0) {
                System.out.println("⚠️ Cantidad inválida para producto " + item.getSku());
                continue;
            }

            // Buscar producto
            ProductoDTO producto = productoService.buscarProductoPorSku(item.getSku());

            if (producto == null) {
                System.out.println("⚠️ Producto con SKU " + item.getSku() + " no encontrado.");
                continue;
            }

            // ✅ Aumentar stock usando la nueva función del InventarioService
            productoService.actualizarStock(item.getSku(), cantidad);

            // Crear movimiento de inventario
            MovimientoInventario movimiento = new MovimientoInventario(
                    generarIdMovimiento(),
                    MovimientoInventario.Tipo.ENTRADA,
                    producto, // objeto Producto, no SKU
                    cantidad,
                    "Entrada desde proveedor: " + proveedor.getNombre()
            );


            movimientos.add(movimiento);
        }

        System.out.println("✅ Entrada de inventario registrada correctamente para proveedor " + proveedor.getNombre());
    }

    public List<MovimientoInventarioDTO> listarMovimientos() {
        List<MovimientoInventarioDTO> lista = new ArrayList<>();

        for (MovimientoInventario mov : movimientos) {
            // Convertir LocalDateTime a Date (porque tu DTO usa java.util.Date)
            Date fechaConvertida = Date.from(mov.getFecha().atZone(ZoneId.systemDefault()).toInstant());

            MovimientoInventarioDTO dto = new MovimientoInventarioDTO(
                    mov.getId(),
                    mov.getTipo(),         // Tipo (enum) directamente
                    fechaConvertida,       // Fecha convertida
                    mov.getProducto(),     // Producto completo
                    mov.getCantidad(),
                    mov.getReferencia()
            );

            lista.add(dto);
        }

        return lista;
    }


}
