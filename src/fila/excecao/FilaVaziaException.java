package fila.excecao;

/**
 *
 * @author Hugo Marcel Larsen e Murilo Bartel
 */

public class FilaVaziaException extends RuntimeException {

	public FilaVaziaException(String m) {
		super(m);
	}
}