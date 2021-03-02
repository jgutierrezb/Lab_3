package model.data_structures;

import java.util.ArrayList;

public class ListaEncadenada <T extends Comparable<T>> implements ILista<T>
{
	private NodoLista<T> primero;

	private NodoLista<T> ultimo;


	int size;

	public ListaEncadenada(NodoLista<T> first)
	{	
		primero = first;
		ultimo = null;
	}	

	public T darPrimero()
	{
		return primero.darElemento();
	}

	public T darUltimo()
	{
		return ultimo.darElemento();
	}

	public NodoLista<T> primerNodo()
	{
		return primero;
	}

	public NodoLista<T> ultimoNodo()
	{
		return ultimo;
	}

	public int size()
	{
		int tamaño = 0 ;
		NodoLista<T> actual = primero;

		while(actual!= null)
		{
			tamaño++;		
			actual = actual.darSiguiente();
		}

		return tamaño;
	}

	//WELL
	public void añadirPrimero(T elemento)
	{
		NodoLista<T> nodo = new NodoLista<T>(elemento);
		NodoLista<T> actual = primero;

		if(this.esVacio() == true)
		{
			primero = nodo;
		}

		else
		{
			nodo.cambiarSiguiente(primero);
			primero = nodo;

			while(actual!= null)
			{
				actual = actual.darSiguiente();
			}

			ultimo = actual;
		}
	}

	//WELL
	public void añadirUltimo(T elemento)
	{
		NodoLista<T> nodo = new NodoLista<T>(elemento);
		NodoLista<T> actual = primero;

		if(this.esVacio() == true )
		{
			primero = nodo;
		}

		else
		{
			while(actual.darSiguiente()!=null)
			{
				actual = actual.darSiguiente();
			}
		}

		actual.cambiarSiguiente(nodo);

		ultimo = nodo;
	}

	//WELL
	public void añadirElemento( T elemento , int pos)
	{
		NodoLista<T> nuevo= new NodoLista<T>(elemento);
		NodoLista<T> actual = primero;
		int posT = 1;

		if(primero == null)
		{
			primero = nuevo;
		}

		else
		{
			while(pos-1!= posT)
			{
				actual = actual.darSiguiente();
				posT++;
			}

			if(actual.darSiguiente() == null)
			{
				actual.cambiarSiguiente(nuevo);	
			}
			else
			{
				nuevo.cambiarSiguiente(actual.darSiguiente());
				actual.cambiarSiguiente(nuevo);	
			}
		}


	}

	//WELL
	public T removerPrimero()
	{
		T elemento = null;


		if(this.esVacio() == true)
		{
			return elemento;
		}

		else
		{
			elemento = primero.darElemento();

			NodoLista<T> nuevoPrimero = primero.darSiguiente();
			primero = nuevoPrimero;

			NodoLista<T> actual = primero;
			while(actual.darSiguiente()!=null)
			{
				actual = actual.darSiguiente();
			}

			ultimo = actual;
		}

		return elemento;
	}

	//WELL
	public T removerUltimo()
	{
		T elemento = null;

		if(this.esVacio() == true)
		{
			return elemento;
		}

		else
		{
			elemento = ultimo.darElemento();

			NodoLista<T> actual = primero;

			while(actual.darSiguiente() != ultimo)
			{
				actual = actual.darSiguiente();
			}

			actual.cambiarSiguiente(null);			
			ultimo = actual;	
		}

		return elemento;
	}

	//WELL
	public T removerElemento(int pos)
	{
		T elemento = null;
		int posT = 1;

		if(this.esVacio() == true)
		{
			return elemento;
		}

		else
		{
			NodoLista<T> actual = primero;

			while(pos-1!=posT)
			{
				actual = actual.darSiguiente();
				posT++;
			}

			elemento = actual.darSiguiente().darElemento();
			actual.cambiarSiguiente(actual.darSiguiente().darSiguiente());
		}

		return elemento;		
	}

	//WELL
	public void intercambiarElementos(int pos1 , int pos2) 
	{
		T elemento1 = this.darElemento(pos1);
		T elemento2 = this.darElemento(pos2);

		NodoLista<T> actual = primero;

		for(int i  = 1 ; i <= pos1-1 ; i++)
		{
			actual = actual.darSiguiente();
		}

		actual.cambiarElemento(elemento2);

		actual = primero;

		for(int i  = 1 ; i <= pos2-1 ; i++)
		{
			actual = actual.darSiguiente();
		}

		actual.cambiarElemento(elemento1);

	}

	//well	
	public void cambiarElemento(int pos, T nuevoElemento)
	{
		int acum=1;

		NodoLista<T> actual= primero;

		while(actual!=null)
		{
			if(acum!=pos)
			{
				actual=actual.darSiguiente();
				++acum;
			}
			else
			{
				break;
			}
		}

		actual.cambiarElemento(nuevoElemento);
	}

	//well
	public T darElemento(int pos)
	{
		T elemento = null;
		int posT = 1;
		NodoLista<T> actual = primero;

		if(this.esVacio() == true)
		{
			return elemento;
		}

		else
		{
			while(pos!=posT)
			{
				actual = actual.darSiguiente();
				posT++;
			}
			elemento = actual.darElemento();
		}

		return elemento;
	}

	public boolean esVacio()
	{
		boolean vacio = false;

		if( primero == null)
		{
			vacio = true;
		}

		else
		{
			vacio = false;
		}

		return vacio;
	}

	public int estaPresente ( T elemento)
	{
		int posicion = 1;

		if(this.esVacio() == true)
		{
			posicion = -1;
		}

		else
		{
			NodoLista<T> actual = primero;

			while(actual!=null)
			{
				if(actual.darElemento().compareTo(elemento) == 0)
				{
					return posicion;
				}

				else
				{
					posicion++;
					actual = actual.darSiguiente();
				}
			}
		}

		return posicion;
	}

	public NodoLista<T> darNodo( int pos)
	{
		int acum=1;

		NodoLista<T> actual= primero;

		while(actual!=null)
		{
			if(acum!=pos)
			{
				actual=actual.darSiguiente();
				++acum;
			}
			else
			{
				break;
			}
		}
		return actual;
	}

	public ILista<T> sublista(int pos, int subElementos)
	{
		T elementoF = this.darElemento(pos);
		
		NodoLista<T> first = new NodoLista<T>(elementoF);		

		ILista<T> copia = new ListaEncadenada(first);

		int posicion = pos;
		
		for(int i = 2 ; i <= subElementos ; i++)
		{
			T elemento = this.darElemento(posicion+1);
			copia.añadirUltimo(elemento);
			posicion++;		
		}

		return copia;
	}


}
