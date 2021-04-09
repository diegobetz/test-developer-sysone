package ar.com.bussiness.ventas.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.bussiness.ventas.entity.PrecioAutomovil;

@Repository
public interface PreciosRepository extends JpaRepository<PrecioAutomovil, Long> {

	@Query(value="SELECT c FROM PrecioAutomovil c WHERE (?1 is null or c.automovil.id = ?1) and (?2 is null"
			  + " or ?2 BETWEEN c.fechaMin AND c.fechaMax)")
	public Optional<List<PrecioAutomovil>> getPrecioAtomovilByAutomovilAndDate(Long idAutomovil, Date fecha);
	
	@Query(value="SELECT c FROM PrecioAutomovil c WHERE c.automovil.id = ?1 and "
			  + "(?2 BETWEEN c.fechaMin AND c.fechaMax or ?3 BETWEEN c.fechaMin AND c.fechaMax )")
	public  Optional<List<PrecioAutomovil>> getPrecioAtomovilIfExistsDateRange(Long idAutomovil, Date fechaMin, Date fechaMax);
	

	@Query(value="SELECT c FROM PrecioAutomovil c WHERE c.automovil.id = ?2 and "
			  + "(?2 BETWEEN c.fechaMin AND c.fechaMax and ?3 BETWEEN c.precioMin AND c.precioMax )")
	public  Optional<List<PrecioAutomovil>> getPrecioAtomoviIntoTheRange(Long idAutomovil, Date fecha, BigDecimal monto);

	@Query(value="SELECT c FROM PrecioAutomovil c WHERE "
			  + "(?2 BETWEEN c.fechaMin AND c.fechaMax and ?1 BETWEEN c.precioMin AND c.precioMax )")
	public  Optional<PrecioAutomovil> getPrecioAtomovilIfExistsDateRange(BigDecimal precioFinal, Date date);

	
}
