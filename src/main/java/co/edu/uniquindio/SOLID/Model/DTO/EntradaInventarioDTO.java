package co.edu.uniquindio.SOLID.Model.DTO;

import co.edu.uniquindio.SOLID.Model.ItemEntrada;

import java.util.Date;
import java.util.List;

public class EntradaInventarioDTO {
    private String Id;
    private Date Fecha;
    private String NitProveedor;
    private List<ItemEntrada> items;

    public EntradaInventarioDTO() {
    }

    public EntradaInventarioDTO(String id, Date fecha, String nitProveedor, List<ItemEntrada> items) {
        Id = id;
        Fecha = fecha;
        NitProveedor = nitProveedor;
        this.items = items;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public String getNitProveedor() {
        return NitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        NitProveedor = nitProveedor;
    }

    public List<ItemEntrada> getItems() {
        return items;
    }

    public void setItems(List<ItemEntrada> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "EntradaInventarioDTO{" +
                "Id='" + Id + '\'' +
                ", Fecha=" + Fecha +
                ", NitProveedor='" + NitProveedor + '\'' +
                ", items=" + items +
                '}';
    }
}
