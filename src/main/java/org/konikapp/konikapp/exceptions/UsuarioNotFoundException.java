package org.konikapp.konikapp.exceptions;

public class UsuarioNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//Método contructor va a recibir un parametro para poder evaluar y lanzar la Exception
	public UsuarioNotFoundException(Long id) {
		super("El usario con el Id: " + id + "no existe");
		
}
}