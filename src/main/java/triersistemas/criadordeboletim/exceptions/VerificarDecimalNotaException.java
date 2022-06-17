package br.com.triersistemas.criadordeboletim.exceptions;

public class VerificarDecimalNotaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VerificarDecimalNotaException(String mensagem) {
		super(mensagem);
	}

}