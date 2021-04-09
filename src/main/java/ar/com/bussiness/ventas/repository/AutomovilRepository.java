package ar.com.bussiness.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.bussiness.ventas.entity.Automovil;

@Repository
public interface AutomovilRepository extends JpaRepository<Automovil, Long> {
	
}
