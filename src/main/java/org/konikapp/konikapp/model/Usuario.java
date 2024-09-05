package org.konikapp.konikapp.model;

import java.util.List;
import java.util.Objects;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "nombre", length = 60, nullable = false, unique=false)
	private String nombre;
	
	@Column(name = "apellido", length = 60, nullable = false, unique=false)
	private String apellido;
	
	@Column(name = "email", length = 120, nullable = false, unique=true)
	private String email;
	
	@Column(name = "contraseña", length = 24, nullable = false, unique=false)
	private String contraseña;
	
	@Column(name = "telefono", length =10, nullable = false, unique = false)
	private String telefono;
	
	@Column(name = "fechaNacimiento", length =10, nullable = false, unique = false)
	private String fechaNacimiento;

	@Column (name = "cp", length = 5, nullable = false, unique = false)
	private String cp;
	
	@Column(name = "estado", length = 60, nullable = false, unique=false)
	private String estado;
	
	@Column(name = "ciudad", length = 60, nullable = false, unique=false)
	private String  ciudad;
	
	@Column(name = "direccion", length = 120, nullable = false, unique=false)
	private String direccion;
	
	
	//Definir las relaciones (1:N) OneToMany. Un usuario puede tener varias publicaciones
	/*@OneToMany(mappedBy= "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	
	private List <Publicacion> publicaciones;*/
	
	
	
	// Constructor vacio 
	
	public Usuario() {
		
	}

	// Constructor 

	public Usuario(Long id, String nombre, String apellido, String email, String contraseña, String telefono,
			String fechaNacimiento, String cp, String estado, String ciudad, String direccion,
			List<Publicacion> publicaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contraseña = contraseña;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.cp = cp;
		this.estado = estado;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}
	
	
	// Getters y Setters

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String  telefono) {
		this.telefono = telefono;
	}

	public String  getCp() {
		return cp;
	}

	public void setCp(String  cp) {
		this.cp = cp;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	//toString
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", contraseña=" + contraseña + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento
				+ ", cp=" + cp + ", estado=" + estado + ", ciudad=" + ciudad + ", direccion=" + direccion + "]";
	}

	//hashCode 

	@Override
	public int hashCode() {
		return Objects.hash(apellido, ciudad, contraseña, cp, direccion, email, estado, fechaNacimiento, id, nombre,
				telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(contraseña, other.contraseña) && Objects.equals(cp, other.cp)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(email, other.email)
				&& Objects.equals(estado, other.estado) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}


	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
