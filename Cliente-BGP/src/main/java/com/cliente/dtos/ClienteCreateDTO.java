package com.cliente.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ClienteCreateDTO {
    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String direccion;

    private Date fechaNacimiento;

    private String telefono;

    private List<PrestamoDTO> prestamo;
}
