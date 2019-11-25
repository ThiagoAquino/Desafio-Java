package br.com.desafio.exception;

public class GeneralException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeneralException(String menssagem, Throwable causa) {
		super(menssagem, causa);
	}
	
	public GeneralException(String menssagem) {
		super(menssagem);
	}

}
