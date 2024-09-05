package org.konikapp.konikapp.model;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table (name = "publicaciones")
public class Publicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name= "id_publicacion")
	private Long id;
	
	@Column(name = "nombre", length = 60, nullable = false, unique=false)
	private String nombre;
	
	@Column(name = "apellido", length = 60, nullable = false, unique=false)
	private String apellido;
	
	@Column(name = "fotoPerfil", nullable = false, unique = false)
	@Lob 
	private byte[] fotoPerfil;
	
	@Column(name = "contenido", length = 255, nullable = false, unique=false)
	private String contenido;
	
	@Column(name = "adjunto", nullable = false, unique = false)
	@Lob 
	private byte[] adjunto;
	
	@Column(name = "ubicacion", length = 120, nullable = false, unique=false)
	private String ubicacion;
	
	@Column(name = "fechaP", length = 16, nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaP;
	
	
	//Revisar funcionamiento xd
	@Column(name = "categoria", length = 16, nullable = false, unique = false)
	@Enumerated(EnumType.STRING) 
	private CategoriaPublicacion categoria; 
	
	@Column(name = "clienteProveedor", length = 16, nullable = false, unique = false)
	@Enumerated(EnumType.STRING) //Para recibir y enviar Enum a la BD en forma de String
	private ClienteProveedor clienteProveedor;
	
	// Definir las relaciones entre las entidades (N:1)
	@ManyToOne
	@JoinColumn (name="id_usuario", nullable = false) //union entre la columna id de tabla publicacion
	@JsonIgnore
	
	private Usuario usuario;

	
	//Constructor vacio
	
	public Publicacion() {
		super();
	}


	//Constructor

	public Publicacion(Long id, String nombre, String apellido, byte[] fotoPerfil, String contenido, byte[] adjunto,
			String ubicacion, Date fechaP, CategoriaPublicacion categoria, ClienteProveedor clienteProveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fotoPerfil = fotoPerfil;
		this.contenido = contenido;
		this.adjunto = adjunto;
		this.ubicacion = ubicacion;
		this.fechaP = fechaP;
		this.categoria = categoria;
		this.clienteProveedor = clienteProveedor;
	}

	
	//Getters Setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public byte[] getFotoPerfil() {
		return fotoPerfil;
	}


	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public byte[] getAdjunto() {
		return adjunto;
	}


	public void setAdjunto(byte[] adjunto) {
		this.adjunto = adjunto;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public Date getFechaP() {
		return fechaP;
	}


	public void setFechaP(Date fechaP) {
		this.fechaP = fechaP;
	}


	public CategoriaPublicacion getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaPublicacion categoria) {
		this.categoria = categoria;
	}


	public ClienteProveedor getClienteProveedor() {
		return clienteProveedor;
	}


	public void setClienteProveedor(ClienteProveedor clienteProveedor) {
		this.clienteProveedor = clienteProveedor;
	}

	//toString
	@Override
	public String toString() {
		return "Publicacion [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fotoPerfil="
				+ Arrays.toString(fotoPerfil) + ", contenido=" + contenido + ", adjunto=" + Arrays.toString(adjunto)
				+ ", ubicacion=" + ubicacion + ", fechaP=" + fechaP + ", categoria=" + categoria + ", clienteProveedor="
				+ clienteProveedor + "]";
	}

	// hashCode Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(adjunto);
		result = prime * result + Arrays.hashCode(fotoPerfil);
		result = prime * result
				+ Objects.hash(apellido, categoria, clienteProveedor, contenido, fechaP, id, nombre, ubicacion);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacion other = (Publicacion) obj;
		return Arrays.equals(adjunto, other.adjunto) && Objects.equals(apellido, other.apellido)
				&& categoria == other.categoria && clienteProveedor == other.clienteProveedor
				&& Objects.equals(contenido, other.contenido) && Objects.equals(fechaP, other.fechaP)
				&& Arrays.equals(fotoPerfil, other.fotoPerfil) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(ubicacion, other.ubicacion);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
