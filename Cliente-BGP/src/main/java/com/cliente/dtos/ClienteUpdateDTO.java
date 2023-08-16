package com.cliente.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteUpdateDTO {
    private long id;

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String direccion;

    private Date fechaNacimiento;

    private String telefono;
}
