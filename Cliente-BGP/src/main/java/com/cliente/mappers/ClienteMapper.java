package com.cliente.mappers;


import com.cliente.dtos.ClienteCreateDTO;
import com.cliente.dtos.ClienteDTO;
import com.cliente.dtos.ClienteUpdateDTO;
import com.cliente.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {
    ClienteMapper instancia= Mappers.getMapper(ClienteMapper.class);

    ClienteDTO clienteAClienteDTO(Cliente cliente);
    Cliente clienteDTOACliente(ClienteDTO clienteDTO);
    Cliente clienteCreateDTOACliente(ClienteCreateDTO clienteCreateDTO);
    Cliente clienteUpdateDTOACliente(ClienteUpdateDTO clienteUpdateDTO);
    List<ClienteDTO> listaClienteAListaClienteDTO (List<Cliente> listaCliente);

}
