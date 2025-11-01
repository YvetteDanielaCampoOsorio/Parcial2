package co.edu.uniquindio.SOLID.Service.Fachadas;

import co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO;
import co.edu.uniquindio.SOLID.Service.EmpleadoService;

import java.util.List;

public class EmpresaAdminFacade {
    private final EmpleadoService empleadoService;

    public EmpresaAdminFacade() {
        this.empleadoService = new EmpleadoService();
    }

    public List<EmpleadoDTO> obtenerEmpleados() {
        return empleadoService.obtenerEmpleados();
    }
    public EmpleadoDTO buscarEmpleadoPorId() {
        return empleadoService.buscarEmpleadoPorId(id);
    }
    public boolean agregarEmpleado(EmpleadoDTO empleadoDTO) {
        return empleadoService.agregarEmpleado(empleadoDTO);
    }
    public boolean ActualizarEmpleado(EmpleadoDTO empleadoDTO) {
        return empleadoService.ActualizarEmpleado(empleadoDTO);
    }
    public boolean eliminarEmpleado(String id) {
        return empleadoService.eliminarEmpleado(id);
    }
}
