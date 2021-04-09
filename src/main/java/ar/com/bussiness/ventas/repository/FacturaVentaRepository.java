package ar.com.bussiness.ventas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.bussiness.ventas.entity.Automovil;
import ar.com.bussiness.ventas.entity.FacturaVenta;

@Repository
public interface FacturaVentaRepository extends JpaRepository<FacturaVenta, Long> {

	public Optional<List<FacturaVenta>> findByAutomovil(Automovil automovil);
	
}
