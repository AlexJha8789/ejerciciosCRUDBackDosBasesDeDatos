package com.cliente.feingClient;


import com.cliente.config.FeignClientConfig;
import com.cliente.dtos.PrestamoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="prestamo-api", url="http://localhost:8080/api/prestamos", configuration = FeignClientConfig.class)
public interface PrestamoFeingClient {

    @GetMapping("/empleados/{empladoId}")
    List<PrestamoDTO> obtenerPrestamoPorIdCliente(@PathVariable("clienteId") Long clienteId);

    @PostMapping()
    PrestamoDTO registrarPrestamo(PrestamoDTO prestamoDTO);
}
