package com.cliente.dtos;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class ClienteDTO {

    private long id;

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String direccion;

    private Date fechaNacimiento;

    private String telefono;
}
