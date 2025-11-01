package co.edu.uniquindio.SOLID.Service;


import co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO;
import co.edu.uniquindio.SOLID.Model.Empleado;
import co.edu.uniquindio.SOLID.Model.Minimercado;
import co.edu.uniquindio.SOLID.utils.Mappers.EmpleadoMapper;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoService {
    private final Minimercado minimercado;

    public EmpleadoService() {
        this.minimercado = Minimercado.getInstancia();

    }

    public List<EmpleadoDTO> obtenerEmpleados() {
        List<EmpleadoDTO> empleadoDTOS = new ArrayList<EmpleadoDTO>();
        for (Empleado empleado : minimercado.getEmpleados()) {
            empleadoDTOS.add(EmpleadoMapper.toDTO(empleado));
        }
        return empleadoDTOS;
    }

    public EmpleadoDTO buscarEmpleadoPorId(String id) {
        Empleado empleado = buscarEmpleadoEntity(id);
        return empleado != null ? EmpleadoMapper.toDTO(empleado) : null;
    }

    public boolean agregarEmpleado(EmpleadoDTO empleadoDTO) {
        if (buscarEmpleadoEntity(empleadoDTO.getId()) != null) {
            return false;
        }
        Empleado empleado = EmpleadoMapper.toEntity(empleadoDTO);
        minimercado.getEmpleados().add(empleado);
        return true;
    }

    public boolean ActualizarEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado empleado = buscarEmpleadoEntity(empleadoDTO.getId());
        if (empleado ==  null) {
            return false;
        }
        EmpleadoMapper.updateEntityFromDTO(empleado, empleadoDTO);
        return true;
    }

    public boolean eliminarEmpleado(String id) {
        Empleado empleado = buscarEmpleadoEntity(id);
        if (empleado == null) {
            return false;
        }

        minimercado.getEmpleados().remove(empleado);
        return true;
    }

    public boolean existeEmpleado(String id) {
        return buscarEmpleadoEntity(id) != null;
    }

    private Empleado buscarEmpleadoEntity(String id) {
        for (Empleado empleado : minimercado.getEmpleados()) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
            return null;
        }
        return null;
    }
}


