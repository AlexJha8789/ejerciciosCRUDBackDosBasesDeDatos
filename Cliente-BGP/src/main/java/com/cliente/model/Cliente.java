package com.cliente.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_cliente")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private long id;

    @Column(name="nombre" , length = 50, nullable = false)
    private String nombre;

    @Column(name="ape_pat", length = 100, nullable = false)
    private String apellidoPaterno;

    @Column(name="ape_mat", length = 100, nullable = false)
    private String apellidoMaterno;

    @Column(name="direccion", length = 300, nullable = false)
    private String direccion;

    @Column(name="fecha_nacimiento", nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @Column(length = 255,nullable = false)
    private String telefono;

}
