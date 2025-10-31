package co.edu.uniquindio.SOLID.utils.Mappers;

import co.edu.uniquindio.SOLID.Model.DTO.EntradaInventarioDTO;
import co.edu.uniquindio.SOLID.Model.DTO.ItemPedidoDTO;
import co.edu.uniquindio.SOLID.Model.EntradaInventario;
import co.edu.uniquindio.SOLID.Model.ItemPedido;

import java.util.ArrayList;
import java.util.List;

public class EntradaInventarioMapper {

        public static EntradaInventarioDTO toDTO(EntradaInventario entradaInventario) {
            if (entradaInventario == null) return null;

            List<ItemPedidoDTO> itemsDTO = new ArrayList<>();
            if (entradaInventario.getItems() != null) {
                for (ItemPedido item : entradaInventario.getItems()) {
                    itemsDTO.add(new ItemPedidoDTO(
                    item.getProducto().getSku(),
                    item.getCantidad()
                    ));
                }
            }

            return new EntradaInventarioDTO(
                    entradaInventario.getId(),
                    entradaInventario.getFecha(),
                    entradaInventario.getProveedor().getNit(),itemsDTO
            );
        }

        public static EntradaInventario toEntity(EntradaInventarioDTO dto) {
            if (dto == null) return null;
            List<ItemPedido>items = new ArrayList<>();
            if (dto.getItems() != null) {
                for (ItemPedidoDTO item : dto.getItems()) {
                    items.add(new ItemPedido(
                            itemDTO.getSkuProducto(),
                            itemDTO.getCantidad()
                    ));
                }

            return new EntradaInventario(
                    dto.getId(),
                    dto.getFecha(),
                    null,
                    items

            );
        }

        public static void updateEntityFromDTO(EntradaInventario entity, EntradaInventarioDTO dto) {
            if (entity == null || dto == null) return;
            entity.setId(dto.getId());
            entity.setFecha(dto.getFecha());
            entiny.setNitProveedor(dto.getNitProveedor());

        }
    }

}
