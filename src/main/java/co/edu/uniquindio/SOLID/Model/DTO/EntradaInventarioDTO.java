package co.edu.uniquindio.SOLID.Model.DTO;

import co.edu.uniquindio.SOLID.Model.ItemEntrada;

<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> 10ce47d06bbe565536f6725b1623ff19d2421e55
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntradaInventarioDTO {
<<<<<<< HEAD
    private String id;
    private LocalDateTime fecha;
    private String nitProveedor;
    private List<ItemPedidoDTO> items;
=======
    private String Id;
    private Date Fecha;
    private String NitProveedor;
    private List<ItemEntradaDTO> items;
>>>>>>> 10ce47d06bbe565536f6725b1623ff19d2421e55

    public EntradaInventarioDTO() {
    }

<<<<<<< HEAD
    public EntradaInventarioDTO(String id, LocalDateTime fecha, String nitProveedor, List<ItemPedidoDTO> items) {
        this.id = id;
        this.fecha = fecha;
        this.nitProveedor = nitProveedor;
        this.items = items;
=======
    public EntradaInventarioDTO(String id, Date fecha, String nitProveedor, List<ItemEntrada> items) {
        Id = id;
        Fecha = fecha;
        NitProveedor = nitProveedor;
        List<ItemEntradaDTO> itemsEntradas = new ArrayList<ItemEntradaDTO>();
>>>>>>> 10ce47d06bbe565536f6725b1623ff19d2421e55
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

<<<<<<< HEAD
    public List<ItemPedidoDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemPedidoDTO> items) {
=======
    public List<ItemEntradaDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemEntradaDTO> items) {
>>>>>>> 10ce47d06bbe565536f6725b1623ff19d2421e55
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
