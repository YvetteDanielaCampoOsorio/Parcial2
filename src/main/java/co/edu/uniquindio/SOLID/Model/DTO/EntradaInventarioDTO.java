package co.edu.uniquindio.SOLID.Model.DTO;

import co.edu.uniquindio.SOLID.Model.ItemEntrada;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntradaInventarioDTO {
    private String id;
    private LocalDateTime fecha;
    private String nitProveedor;
    private List<ItemPedidoDTO> items;

    public EntradaInventarioDTO() {
    }

    public EntradaInventarioDTO(String id, LocalDateTime fecha, String nitProveedor, List<ItemPedidoDTO> items) {
        this.id = id;
        this.fecha = fecha;
        this.nitProveedor = nitProveedor;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public List<ItemPedidoDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemPedidoDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "EntradaInventarioDTO{" +
                "Id='" + id + '\'' +
                ", Fecha=" + fecha +
                ", NitProveedor='" + nitProveedor + '\'' +
                ", items=" + items +
                '}';
    }
}
