package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;
import co.edu.uniquindio.SOLID.Model.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorService {

    private static List<Proveedor> proveedores = new ArrayList<>();

    public String crearProveedor(ProveedorDTO dto) {
        if (validarEmail(dto.getEmail())) {
            Proveedor proveedor = new Proveedor(
                    dto.getNit(),
                    dto.getNombre(),
                    dto.getContacto(),
                    dto.getEmail(),
                    dto.getTelefono()
            );
            proveedores.add(proveedor);
        } else {
            System.out.println("Email inválido");
        }
        return null;
    }

    public String actualizarProveedor(ProveedorDTO dto) {
        Proveedor proveedor = buscarPorNit(dto.getNit());
        if (proveedor != null) {
            if (validarEmail(dto.getEmail())) {
                actualizarContacto(proveedor, dto.getContacto(), dto.getEmail(), dto.getTelefono());
                proveedor.setNombre(dto.getNombre());
            }
        }
        return null;
    }

    public String activarProveedor(String nit) {
        Proveedor p = buscarPorNit(nit);
        if (p != null) {
            p.activar();
        }
        return nit;
    }

    public String inactivarProveedor(String nit) {
        Proveedor p = buscarPorNit(nit);
        if (p != null) {
            p.inactivar();
        }
        return nit;
    }

    private void actualizarContacto(Proveedor proveedor, String contacto, String email, String telefono) {
        proveedor.setContacto(contacto);
        proveedor.setEmail(email);
        proveedor.setTelefono(telefono);
    }


    private boolean validarEmail(String email) {
        return email != null && email.contains("@");
    }

    public static Proveedor buscarPorNit(String nit) {
        return proveedores.stream()
                .filter(p -> p.getNit().equals(nit))
                .findFirst()
                .orElse(null);
    }

    public List<ProveedorDTO> listarProveedores() {
        List<ProveedorDTO> lista = new ArrayList<>();

        for (Proveedor proveedor : proveedores) {
            ProveedorDTO dto = new ProveedorDTO(
                    proveedor.getNit(),
                    proveedor.getNombre(),
                    proveedor.getContacto(),
                    proveedor.getEmail(),
                    proveedor.getTelefono(),
                    proveedor.isActivo()
            );
            lista.add(dto);
        }

        return lista;
    }

    public String eliminarProveedor(String nit) {
        Proveedor proveedor = buscarPorNit(nit); // si tienes un método que devuelve la entidad real
        if (proveedor != null) {
            proveedores.remove(proveedor);
            return "✅ Proveedor eliminado correctamente.";
        } else {
            return "⚠️ Proveedor con NIT " + nit + " no encontrado.";
        }
    }

}
