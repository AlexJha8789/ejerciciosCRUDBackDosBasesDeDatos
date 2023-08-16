package com.prestamo.prestamobgp.dtos;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class PrestamoDTO {

    private long id;

    private BigDecimal monto;

    private Long plazo;

    private BigDecimal tea;

    private Date fechaDesembolso;

    private String seguro;

    private long idCliente;

}
