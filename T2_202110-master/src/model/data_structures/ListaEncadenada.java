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
			while(primero.darSiguiente()!=null)
			{
				actual = primero.darSiguiente();
			}

			actual.cambiarSiguiente(nodo);

			ultimo = nodo;
		}
	}

	public void añadirElemento( T elemento , int pos)
	{
		NodoLista<T> nodo = new NodoLista<T>(elemento);
		NodoLista<T> actual = primero;

		if(this.esVacio() == true)
		{
			primero = nodo;
		}

		else
		{
			if ( pos > this.size())
			{
				for(int i  = 1 ; i <= pos-1 ; i++)
				{
					actual = actual.darSiguiente();
				}

				nodo.cambiarSiguiente(actual.darSiguiente());
				actual.cambiarSiguiente(nodo);
			}
		}
	}

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

	public T removerElemento(int pos)
	{
		T elemento = null;

		if(this.esVacio() == true)
		{
			return elemento;
		}

		else
		{
			
			NodoLista<T> actual = primero;

			for(int i  = 1 ; i <= pos-1 ; i++)
			{
				actual = actual.darSiguiente();
			}
			
			elemento = actual.darSiguiente().darElemento();
			actual.cambiarSiguiente(actual.darSiguiente().darSiguiente());
		}

		return elemento;		
	}
	
	public void intercambiarElementos(int pos1 , int pos2) 
	{
		T elemento1 = this.darElemento(pos1);
		T elemento2 = this.darElemento(pos2);
		
		NodoLista<T> actual = primero;
		
		for(int i  = 1 ; i <= pos1 ; i++)
		{
			actual = actual.darSiguiente();
		}
		
		actual.cambiarElemento(elemento2);
		
		actual = primero;
		
		for(int i  = 1 ; i <= pos2 ; i++)
		{
			actual = actual.darSiguiente();
		}
		
		actual.cambiarElemento(elemento1);
		
	}
	
	public void cambiarElemento(int pos, T nuevoElemento)
	{
		
	}

	public T darElemento(int pos)
	{
		T elemento = null;
		NodoLista<T> actual = primero;

		if(this.esVacio() == true)
		{
			return elemento;
		}

		else
		{
			for(int i  = 1 ; i <= pos ; i++)
			{
				actual = actual.darSiguiente();
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

	public void insertElement(T element, int pos) {
		// TODO Auto-generated method stub
		NodoLista<T> nuevo= new NodoLista<T>((T) element);
		if(size()>=2)
		{
			if(pos!=1)
			{
				NodoLista<T> anterior=getNode(pos-1);
				nuevo.cambiarSiguiente(anterior.darSiguiente());
				anterior.cambiarSiguiente(nuevo);
				size++;
			}
			else
			{
				añadirPrimero((T) element);
			}
		}
		else if(size==1)
		{
			primero.cambiarSiguiente(new NodoLista<T>(element));
			size++;
		}
		else
		{
			añadirPrimero((T) element);
		}
		
	}
	public NodoLista<T> getNode( int pos)
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
	

}
