package com.prestamo.prestamobgp.repository;

import com.prestamo.prestamobgp.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo,Long> {
    List<Prestamo> findAllByIdCliente(long id);
}
