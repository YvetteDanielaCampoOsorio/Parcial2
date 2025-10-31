package co.edu.uniquindio.SOLID.utils.Mappers;

import co.edu.uniquindio.SOLID.Model.Cliente;
import co.edu.uniquindio.SOLID.Model.DTO.ClienteDTO;
import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;
import co.edu.uniquindio.SOLID.Model.Proveedor;

public class ProveedorMapper {
    public static ProveedorDTO toDTO(Proveedor provedor) {
        if (provedor == null) return null;
        return new ProveedorDTO(
                provedor.getNit(),
                provedor.getNombre(),
                provedor.getContacto(),
                provedor.getEmail(),
                provedor.getTelefono(),
                provedor.isActivo()
        );
    }

    public static Proveedor toEntity(ProveedorDTO dto) {
        if (dto == null) return null;
        return new Proveedor(
                dto.getNit(),
                dto.getNombre(),
                dto.getContacto(),
                dto.getEmail(),
                dto.getTelefono()
        );
    }

    public static void updateEntityFromDTO(Proveedor entity, ProveedorDTO dto) {
        if (entity == null || dto == null) return;
        entity.setNit(dto.getNit());
        entity.setNombre(dto.getNombre());
        entity.setContacto(dto.getContacto());
        entity.setEmail(dto.getEmail());
        entity.setTelefono(dto.getTelefono());

        //activo se maneja en provedorService
    }
}
