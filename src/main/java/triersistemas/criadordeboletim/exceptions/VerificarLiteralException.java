package br.com.triersistemas.criadordeboletim.exceptions;

public class VerificarLiteralException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public VerificarLiteralException(String mensagem) {
		super(mensagem);
	}

}