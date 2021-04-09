package ar.com.bussiness.ventas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.bussiness.ventas.entity.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

	public Optional<Modelo> getModeloByDescripcionAndVariante(String modeloDescripcion,String variante);

	public List<Optional<Modelo>> getModeloByDescripcion(String modeloDescripcion);
	
	@Transactional
	@Modifying
    @Query("update Modelo c set c.descripcion = :descripcionNueva WHERE c.descripcion = :descripcionAnterior")
	public void setDescripcion(@Param("descripcionAnterior") String modeloDescripcionAnterior,@Param("descripcionNueva")  String modeloDescripcionNueva);
	

}

