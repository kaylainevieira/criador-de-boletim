package br.com.kaylaine.criadordeboletim.exceptions;

public class VerificarInteiroException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VerificarInteiroException(String mensagem) {
		super(mensagem);
	}
}