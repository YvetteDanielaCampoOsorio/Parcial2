package co.edu.uniquindio.SOLID.Model.DTO;

import co.edu.uniquindio.SOLID.Model.ItemEntrada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntradaInventarioDTO {
    private String Id;
    private Date Fecha;
    private String NitProveedor;
    private List<ItemEntradaDTO> items;

    public EntradaInventarioDTO() {
    }

    public EntradaInventarioDTO(String id, Date fecha, String nitProveedor, List<ItemEntrada> items) {
        Id = id;
        Fecha = fecha;
        NitProveedor = nitProveedor;
        List<ItemEntradaDTO> itemsEntradas = new ArrayList<ItemEntradaDTO>();
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

    public List<ItemEntradaDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemEntradaDTO> items) {
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
