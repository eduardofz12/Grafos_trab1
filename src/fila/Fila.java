package fila;

/**
 *
 * @author Hugo Marcel Larsen e Murilo Bartel
 */
public interface Fila<T> {

    public void inserir(T valor);

    public boolean estaVazia();

    public T peek();

    public T retirar();

    public void liberar();
}