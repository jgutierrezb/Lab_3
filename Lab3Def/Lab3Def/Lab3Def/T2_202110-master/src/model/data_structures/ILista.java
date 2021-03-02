package model.data_structures;

public interface ILista <T>
{
	public T darPrimero();

	public T darUltimo();

	public int size();

	public void a�adirPrimero(T elemento);

	public void a�adirUltimo(T elemento);

	public void a�adirElemento( T elemento , int pos);

	public T removerPrimero();

	public T removerUltimo();

	public T removerElemento(int pos);

	public void intercambiarElementos(int pos1 , int pos2);
	
	public void cambiarElemento(int pos, T nuevoElemento);

	public T darElemento(int pos);

	public int estaPresente ( T elemento);	
	
	//TODO parte 6.1
	public ILista<T> sublista(int pos ,int subElementos);

}