package ar.com.bussiness.ventas.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
@Table(name = "FACTURA_VENTA")
public class FacturaVenta {
	
	@Id
	@SequenceGenerator(name= "FACTURA_VENTA_SEQUENCE", sequenceName = "FACTURA_VENTA_SEQUENCE_ID", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "FACTURA_VENTA_ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "NOMBRE_COMPRADOR", unique = false, nullable = false)
	private String nombreComprador;
	
	@Column(name = "APELLIDO_COMPRADOR", unique = false, nullable = false)
	private String apellidoComprador;
	
	@ManyToOne
    @JoinColumn(name="AUTOMOVIL_ID", nullable = false)
	private Automovil automovil;
	
	@Column(name = "FECHA_ALTA", unique = false, nullable = false)
	private Timestamp fecha;
	
	@Column(name = "FECHA_MODIFICACION", unique = false, nullable = true)
	private Timestamp fechaModificacion;
	
	@Column(name = "PRECIO_FINAL", unique = false, nullable = false)
	private BigDecimal precioFinal;
	
	@Column(name = "GARANTIA_DESCRIPCION", unique = false, nullable = false)
	private String garantiaDescripcion;
	
	@Column(name = "GARANTIA_KMS", unique = false, nullable = false)
	private Integer garantiaKms;
	
	@Column(name = "GARANTIA_ANIOS", unique = false, nullable = false)
	private Integer garantiaAnios;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	public String getApellidoComprador() {
		return apellidoComprador;
	}

	public void setApellidoComprador(String apellidoComprador) {
		this.apellidoComprador = apellidoComprador;
	}

	
	public BigDecimal getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(BigDecimal precioFinal) {
		this.precioFinal = precioFinal;
	}

	public String getGarantiaDescripcion() {
		return garantiaDescripcion;
	}

	public void setGarantiaDescripcion(String garantiaDescripcion) {
		this.garantiaDescripcion = garantiaDescripcion;
	}

	public Integer getGarantiaKms() {
		return garantiaKms;
	}

	public void setGarantiaKms(Integer garantiaKms) {
		this.garantiaKms = garantiaKms;
	}

	public Integer getGarantiaAnios() {
		return garantiaAnios;
	}

	public void setGarantiaAnios(Integer garantiaAnios) {
		this.garantiaAnios = garantiaAnios;
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}
