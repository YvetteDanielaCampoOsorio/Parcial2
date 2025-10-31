package co.edu.uniquindio.SOLID.Service.Fachadas;

import co.edu.uniquindio.SOLID.Model.DTO.EntradaInventarioDTO;
import co.edu.uniquindio.SOLID.Model.DTO.MovimientoInventarioDTO;
import co.edu.uniquindio.SOLID.Model.DTO.ProductoDTO;
import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;
import co.edu.uniquindio.SOLID.Service.InventarioService;
import co.edu.uniquindio.SOLID.Service.ProductoService;
import co.edu.uniquindio.SOLID.Service.ProveedorService;

import java.util.List;

public class InventarioFacade {

    private final ProveedorService proveedorService;
    private final ProductoService productoService;
    private final InventarioService inventarioService;

    // 🔧 Constructor
    public InventarioFacade() {
        this.proveedorService = new ProveedorService();
        this.productoService = new ProductoService();
        this.inventarioService = new InventarioService(proveedorService, productoService);
    }

    // ------------------- MÉTODOS DE PROVEEDORES -------------------

    public List<ProveedorDTO> listarProveedores() {
        return proveedorService.listarProveedores();
    }

    public String crearProveedor(ProveedorDTO dto) {
        return proveedorService.crearProveedor(dto);
    }

    public String actualizarProveedor(ProveedorDTO dto) {
        return proveedorService.actualizarProveedor(dto);
    }

    public String eliminarProveedor(String nit) {
        return proveedorService.eliminarProveedor(nit);
    }

    public String activarProveedor(String nit) {
        return proveedorService.activarProveedor(nit);
    }

    public String inactivarProveedor(String nit) {
        return proveedorService.inactivarProveedor(nit);
    }

    // ------------------- MÉTODOS DE PRODUCTOS -------------------

    public List<ProductoDTO> listarProductos() {
        return productoService.listarProductos();
    }

    // ------------------- MÉTODOS DE INVENTARIO -------------------

    public void registrarEntrada(EntradaInventarioDTO entradaDTO) {
        inventarioService.registrarEntrada(entradaDTO);
    }

    public List<MovimientoInventarioDTO> listarMovimientos() {
        return inventarioService.listarMovimientos();
    }
}
