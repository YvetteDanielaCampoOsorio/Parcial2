package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;
import co.edu.uniquindio.SOLID.Model.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorService {

    private List<Proveedor> proveedores = new ArrayList<>();

    public void crearProveedor(ProveedorDTO dto) {
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
    }

    public void actualizarProveedor(ProveedorDTO dto) {
        Proveedor proveedor = buscarPorNit(dto.getNit());
        if (proveedor != null) {
            if (validarEmail(dto.getEmail())) {
                actualizarContacto(proveedor, dto.getContacto(), dto.getEmail(), dto.getTelefono());
                proveedor.setNombre(dto.getNombre());
            }
        }
    }

    public void activarProveedor(String nit) {
        Proveedor p = buscarPorNit(nit);
        if (p != null) {
            p.activar();
        }
    }

    public void inactivarProveedor(String nit) {
        Proveedor p = buscarPorNit(nit);
        if (p != null) {
            p.inactivar();
        }
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
}
