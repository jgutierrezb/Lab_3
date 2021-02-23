package model.data_structures;

public class NodoLista <T extends Comparable <T>>
{
	private T elemento;
	
	private NodoLista<T> next;
	
	public NodoLista (T element)
	{
		elemento = element;
		next = null;
	}
	
	public T darElemento()
	{
		return elemento;
	}
	
	public NodoLista<T> darSiguiente()
	{
		return next;
	}
	
	public void cambiarSiguiente(NodoLista<T> nuevoNext)
	{
		next = nuevoNext;
	}
	
	public void eliminarSiguiente(NodoLista<T> nodo)
	{
		NodoLista<T> eliminar = nodo.darSiguiente();
		
		NodoLista<T> nuevo = eliminar.darSiguiente();

		nodo.cambiarSiguiente(nuevo);
	}
	
	public void cambiarElemento(T nuevoElemento)
	{
		elemento = nuevoElemento;
	}

}
