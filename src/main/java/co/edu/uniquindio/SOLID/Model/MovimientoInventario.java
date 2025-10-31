package co.edu.uniquindio.SOLID.Model;

import co.edu.uniquindio.SOLID.Model.DTO.ProductoDTO;
import co.edu.uniquindio.SOLID.utils.Mappers.ProductoMapper;

import java.time.LocalDateTime;

public class MovimientoInventario {
    public enum Tipo { ENTRADA }

    private String id;
    private Tipo tipo;
    private LocalDateTime fecha;
    private Producto producto;
    private int cantidad;
    private String referencia;

    public MovimientoInventario(String id, Tipo tipo, ProductoDTO productoDTO, int cantidad, String referencia) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = LocalDateTime.now();
        this.producto = ProductoMapper.toEntity(productoDTO);
        this.cantidad = cantidad;
        this.referencia = referencia;
    }


    public String getId() { return id; }
    public Tipo getTipo() { return tipo; }
    public LocalDateTime getFecha() { return fecha; }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public String getReferencia() { return referencia; }
}


