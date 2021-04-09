package ar.com.bussiness.ventas.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRECIO_AUTOMOVIL")
public class PrecioAutomovil {
	@Id
	@SequenceGenerator(name= "PRECIO_AUTOMOVIL_SEQUENCE", sequenceName = "PRECIO_AUTOMOVIL_SEQUENCE_ID", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PRECIO_AUTOMOVIL_ID", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="AUTOMOVIL_ID")
	private Automovil automovil;
		
	@Column(name = "PRECIO_MAX", unique = false, nullable = true)
	private BigDecimal precioMax;
	
	@Column(name = "PRECIO_MIN", unique = false, nullable = true)
	private BigDecimal precioMin;

	@Column(name = "FECHA_MAX", unique = false, nullable = true)
	private Date fechaMax;
	
	@Column(name = "FECHA_MIN", unique = false, nullable = true)
	private Date fechaMin;
	
	
	

	public PrecioAutomovil(Long id, Automovil automovil, BigDecimal precioMax, BigDecimal precioMin, Date fechaMax,
			Date fechaMin) {
		super();
		this.id = id;
		this.automovil = automovil;
		this.precioMax = precioMax;
		this.precioMin = precioMin;
		this.fechaMax = fechaMax;
		this.fechaMin = fechaMin;
	}

	public PrecioAutomovil() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	public BigDecimal getPrecioMax() {
		return precioMax;
	}

	public void setPrecioMax(BigDecimal precioMax) {
		this.precioMax = precioMax;
	}

	public BigDecimal getPrecioMin() {
		return precioMin;
	}

	public void setPrecioMin(BigDecimal precioMin) {
		this.precioMin = precioMin;
	}

	public Date getFechaMax() {
		return fechaMax;
	}

	public void setFechaMax(Date fechaMax) {
		this.fechaMax = fechaMax;
	}

	public Date getFechaMin() {
		return fechaMin;
	}

	public void setFechaMin(Date fechaMin) {
		this.fechaMin = fechaMin;
	}


}
