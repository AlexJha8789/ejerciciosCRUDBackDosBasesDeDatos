package com.cliente.service;

import com.cliente.dtos.ClienteCreateDTO;
import com.cliente.dtos.ClienteDTO;
import com.cliente.dtos.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> listarClientes();
    ClienteDTO obtenerClientePorID(long id);
    ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO);
    ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO);
    String eliminarCliente(long id);
}
