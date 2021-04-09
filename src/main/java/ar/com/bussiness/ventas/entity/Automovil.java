package ar.com.bussiness.ventas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "AUTOMOVIL")
public class Automovil {
	@Id
	@SequenceGenerator(name= "AUTOMOVIL_SEQUENCE", sequenceName = "AUTOMOVIL_SEQUENCE_ID", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "AUTOMOVIL_ID", unique = true, nullable = false)
	private Long id;
	
	@OneToOne
    @JoinColumn(name="MODELO_ID",unique = true)
	private Modelo modelo;
		
	@Column(name = "GARANTIA_KMS_DEFAULT", unique = false, nullable = true)
	private Integer garantiaKmsDefault;
	
	@Column(name = "GARANTIA_ANIOS_DEFAULT", unique = false, nullable = true)
	private Integer garantiaAniosDefault;
	
	@Column(name = "UNIDADES_DISPONIBLES", unique = false, nullable = true)
	private Long unidadesDisponibles;
	
	/**
	 * Constructor
	 * @param id
	 * @param modelo
	 * @param garantiaKmsDefault
	 * @param garantiaAniosDefault
	 * @param unidadesDisponibles
	 */
	public Automovil(Long id, Modelo modelo, Integer garantiaKmsDefault, Integer garantiaAniosDefault, Long unidadesDisponibles) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.garantiaKmsDefault = garantiaKmsDefault;
		this.garantiaAniosDefault = garantiaAniosDefault;
	}

	public Automovil() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGarantiaKmsDefault() {
		return garantiaKmsDefault;
	}

	public void setGarantiaKmsDefault(Integer garantiaKmsDefault) {
		this.garantiaKmsDefault = garantiaKmsDefault;
	}

	public Integer getGarantiaAniosDefault() {
		return garantiaAniosDefault;
	}

	public void setGarantiaAniosDefault(Integer garantiaAniosDefault) {
		this.garantiaAniosDefault = garantiaAniosDefault;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Long getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public void setUnidadesDisponibles(Long unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}

	
	

	
}
