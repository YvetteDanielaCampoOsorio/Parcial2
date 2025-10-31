package co.edu.uniquindio.SOLID.Model;

import co.edu.uniquindio.SOLID.Model.DTO.ProductoDTO;
import co.edu.uniquindio.SOLID.utils.Mappers.ProductoMapper;

import java.time.LocalDateTime;

public class MovimientoInventario {
    public MovimientoInventario(String id, Tipo tipo, LocalDateTime fecha, int stock, int cantidad, String referencia) {
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setId(String id) {
    }

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


