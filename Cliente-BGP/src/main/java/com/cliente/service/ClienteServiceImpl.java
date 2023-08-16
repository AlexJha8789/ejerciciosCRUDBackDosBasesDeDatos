package com.cliente.service;


import com.cliente.dtos.ClienteCreateDTO;
import com.cliente.dtos.ClienteDTO;
import com.cliente.dtos.ClienteUpdateDTO;
import com.cliente.dtos.PrestamoDTO;
import com.cliente.feingClient.PrestamoFeingClient;
import com.cliente.mappers.ClienteMapper;
import com.cliente.model.Cliente;
import com.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PrestamoFeingClient prestamoFeingClient;

    @Override
    public List<ClienteDTO> listarClientes() {
        return ClienteMapper.instancia.listaClienteAListaClienteDTO( clienteRepository.findAll());
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        ClienteDTO clienteDTO = null;
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            clienteDTO = ClienteMapper.instancia.clienteAClienteDTO(cliente);
        }
        return clienteDTO;
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente=ClienteMapper.instancia.clienteCreateDTOACliente(clienteCreateDTO);
        Cliente respuestaEntity=clienteRepository.save(cliente);

        //Registrar el prestamo
        List<PrestamoDTO> listaPrest = clienteCreateDTO.getPrestamo();
        for ( PrestamoDTO itemPrest: listaPrest) {
            itemPrest.setIdCliente( respuestaEntity.getId() );
            prestamoFeingClient.registrarPrestamo(itemPrest);
        }

        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {
        Cliente cliente=ClienteMapper.instancia.clienteUpdateDTOACliente(clienteUpdateDTO);
        Cliente respuestaEntity=clienteRepository.save(cliente);
        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarCliente(long id) {
        boolean clienteExistente = clienteRepository.existsById(id);
        String resultado = "";
        if (clienteExistente) {
            clienteRepository.deleteById(id);
            resultado = "Registro Eliminado";
        } else {
            resultado = "No se pudo realizar la eliminación";
        }
        return resultado;
    }
}
