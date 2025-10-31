package co.edu.uniquindio.SOLID.utils.Mappers;

import co.edu.uniquindio.SOLID.Model.DTO.MovimientoInventarioDTO;
import co.edu.uniquindio.SOLID.Model.MovimientoInventario;

public class MovimientoInventarioMapper {
    public static MovimientoInventarioDTO toDTO(MovimientoInventario MovimientoInventario){
        if(MovimientoInventario==null)return null;
        return new MovimientoInventarioDTO();

    }
    public static MovimientoInventario toEntity(MovimientoInventarioDTO MovimientoInventarioDTO, boolean dto){
        if(dto == null)return null;
        return new MovimientoInventario(
                dto.getId(),
                dto.getTipo(),
                dto.getFecha(),
                dto.getProducto(),
                dto.getCantidad(),
                dto.getReferencia()
        );
    }
    public static void updateEntityFromDTO(MovimientoInventario entity, MovimientoInventarioDTO dto) {
        if (entity == null || dto == null) return;
        entity.setTipo(dto.getTipo());
        entity.setFecha(dto.getFecha());
        entity.setProducto(dto.getProducto());
        entity.setCantidad(dto.getCantidad());
        entity.setReferencia(dto.getReferencia());
    }
}
