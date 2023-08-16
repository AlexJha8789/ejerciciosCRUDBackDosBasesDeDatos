package com.prestamo.prestamobgp.mappers;

import com.prestamo.prestamobgp.dtos.PrestamoCreateDTO;
import com.prestamo.prestamobgp.dtos.PrestamoDTO;
import com.prestamo.prestamobgp.dtos.PrestamoUpdateDTO;
import com.prestamo.prestamobgp.model.Prestamo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PrestamoMapper {
    PrestamoMapper instancia= Mappers.getMapper(PrestamoMapper.class);

    List<PrestamoDTO> listaPrestamoAListaPrestamoDTO(List<Prestamo> lista);

    PrestamoDTO prestamoAPrestamoDTO(Prestamo prestamo);

    Prestamo prestamoCreateDTOAPrestamo(PrestamoCreateDTO prestamoCreateDTO);

    Prestamo prestamoUpdateDTOAPrestamo(PrestamoUpdateDTO prestamoUpdateDTO);
}
