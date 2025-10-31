package co.edu.uniquindio.SOLID.Model.DTO;

import co.edu.uniquindio.SOLID.Model.MovimientoInventario;
import co.edu.uniquindio.SOLID.Model.Producto;

import java.util.Date;

public class MovimientoInventarioDTO {
    private String id;
    private MovimientoInventario.Tipo tipo;
    private Date fecha;
    private Producto producto;
    private int cantidad;
    private String referencia;

    public MovimientoInventarioDTO() {
    }

    public MovimientoInventarioDTO(String id, MovimientoInventario.Tipo tipo, Date fecha, Producto producto, int cantidad, String referencia) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.referencia = referencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MovimientoInventario.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(MovimientoInventario.Tipo tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        return "MovimientoInventarioDTO{" +
                "id='" + id + '\'' +
                ", tipo=" + tipo +
                ", fecha=" + fecha +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", referencia='" + referencia + '\'' +
                '}';
    }
}
