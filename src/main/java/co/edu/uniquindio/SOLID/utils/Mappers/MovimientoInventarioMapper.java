package co.edu.uniquindio.SOLID.utils.Mappers;

import co.edu.uniquindio.SOLID.Model.DTO.MovimientoInventarioDTO;
import co.edu.uniquindio.SOLID.Model.MovimientoInventario;

public class MovimientoInventarioMapper {

        public static MovimientoInventarioDTO toDTO(MovimientoInventario movimientoInventario) {
            if (movimientoInventario == null) return null;
            return new MovimientoInventarioDTO(
                    movimientoInventario.getId(),
                    movimientoInventario.getTipo(),
                    movimientoInventario.getFecha(),
                    movimientoInventario.getProducto(),
                    movimientoInventario.getCantidad(),
                    movimientoInventario.getReferencia()


            );
        }

        public static MovimientoInventario toEntity(MovimientoInventarioDTO dto) {
            if (dto == null) return null;
            return new MovimientoInventario(
                    dto.getId(),
                    dto.getTipo(),
                    dto.getFecha(),
                    dto.getProducto().getStock(),
                    dto.getCantidad(),
                    dto.getReferencia()

            );
        }

        public static void updateEntityFromDTO(MovimientoInventario entity, MovimientoInventarioDTO dto) {
            if (entity == null || dto == null) return;
            entity.setId(dto.getId());
            entity.setTipo(dto.getTipo());
            entity.setFecha(dto.getFecha());
            entity.setProducto(dto.getProducto());
            entity.setCantidad(dto.getCantidad());
            entity.setReferencia(dto.getReferencia());
        }
    }
