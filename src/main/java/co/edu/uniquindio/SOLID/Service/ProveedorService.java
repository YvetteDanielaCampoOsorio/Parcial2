package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorService {

    private List<Proveedor> proveedores = new ArrayList<>();

    private Proveedor buscarPorNit(String nit) {
        return proveedores.stream()
                .filter(p -> p.getNit().equals(nit))
                .findFirst()
                .orElse(null);
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

    public void actualizarContacto(String contacto, String email, String telefono) {
        this.contacto = contacto;
        this.email = email;
        this.telefono = telefono;
    }

    public boolean validarEmail() {
        return email != null && email.contains("@");
    }



}
