package ar.com.bussiness.ventas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "MODELO",uniqueConstraints={
	    @UniqueConstraint(columnNames = {"descripcion", "variante"})})
public class Modelo {
	@Id
	@SequenceGenerator(name= "MODELO_SEQUENCE", sequenceName = "MODELO_SEQUENCE_ID", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MODELO_ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "DESCRIPCION", unique = false, nullable = true)
	private String descripcion;
	
	@Column(name = "VARIANTE", unique = false, nullable = true)
	private String variante;


	public Modelo(Long id, String descripcion, String variante) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.variante = variante;
	}
	
	public Modelo( String descripcion, String variante) {
		super();
		this.descripcion = descripcion;
		this.variante = variante;
	}

	public Modelo() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getVariante() {
		return variante;
	}

	public void setVariante(String variante) {
		this.variante = variante;
	}

	
			

	

	
}
