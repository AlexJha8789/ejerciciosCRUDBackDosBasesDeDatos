package com.prestamo.prestamobgp.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tb_prestamo")
@Getter
@Setter
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_prestamo")
    private long id;

    @Column(nullable = false)
    private BigDecimal monto;

    @Column(nullable = false)
    private Long plazo;

    @Column(nullable = false)
    private BigDecimal tea;


    @Column(name = "fechaDesembolso",nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaDesembolso;

    @Column(length = 255,nullable = false)
    private String seguro;

    @Column(name = "id_cliente")
    private long idCliente;


}
