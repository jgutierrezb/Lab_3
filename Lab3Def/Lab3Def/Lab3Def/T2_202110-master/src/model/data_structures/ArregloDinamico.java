package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements ILista<T>
{
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T[] elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Object[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [] copia = elementos;
			elementos = (T[]) new Object[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}

		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() 
	{
		return tamanoMax;
	}

	public int size() 
	{
		return tamanoAct-1;
	}

	public T darElemento(int i) 
	{
		return elementos[i-1];
	}

	public T[] darElementos()
	{
		return elementos;
	}

	public T buscar(T dato) 
	{
		T buscado = null;
		boolean encontrado = false;

		for ( int  i = 0 ; i < tamanoAct && !encontrado; i ++)
		{
			if(elementos[i].equals(dato) )
			{
				buscado = elementos[i];
				encontrado = true;
			}
		}

		return buscado;
	}

	public T eliminar(T dato) 
	{
		T eliminar = null;

		if ( this.buscar(dato) != null)
		{	
			int nuevoTamano = 0 ;

			T[] nuevaLista = (T[])new Object[tamanoAct-1];

			for ( int  i = 0 ; i < tamanoAct; i ++)
			{
				if(elementos[i].equals(dato) )
				{
					eliminar = elementos[i];
					elementos[i] = null;
				}

				else
				{
					nuevaLista[nuevoTamano] = elementos[i];	
					nuevoTamano++;
				}
			}

			elementos = nuevaLista;
			tamanoAct = nuevoTamano;
		}

		return eliminar;
	}

	/**
	 * Invierte el orden del arreglo dinamico
	 */	
	public void invertir()
	{
		int nuevoTamano = 0;

		T[] nuevaLista = (T[]) new Object[tamanoAct];

		for(int i = tamanoAct ; i > 0 ; i--)
		{
			nuevaLista[nuevoTamano] = elementos[i-1];
			nuevoTamano++;
		}

		elementos = nuevaLista;
		tamanoAct = nuevoTamano;
	}

	public T darPrimero() 
	{
		T elemento = elementos[0];

		return elemento;
	}

	public T darUltimo() 
	{
		T elemento = elementos [tamanoAct-1];

		return elemento;
	}

	public void añadirPrimero(T elemento) 
	{
		T[] nuevaLista = (T[]) new Object [tamanoAct+1];

		nuevaLista[0] = elemento;
		int j = 1;

		for (int i = 0 ; i < tamanoAct ; i ++)
		{ 
			nuevaLista[j] = elementos[i];
			j++;

		}

		elementos = nuevaLista;
		tamanoAct = tamanoAct+1;
	}

	public void añadirUltimo(T elemento) 
	{
		this.agregar(elemento);
	}

	//TODO revisar
	public void añadirElemento(T elemento, int pos) 
	{
		T elementoNuevo = elemento;

		if(elementos[pos-1] == null)
		{
			elementos[pos-1] = elementoNuevo;
		}

		else
		{
			T elementoActual = elementos[pos-1];
			
			elementos[pos-1] = elementoNuevo;

			this.agregar(elementoActual);
		}
	}

	public T removerPrimero() 
	{
		T eliminar = elementos[0];

		if ( elementos!= null)
		{	
			int nuevoTamano = 0;
			elementos[0] = null;
			T[] nuevaLista = (T[])new Object[tamanoAct-1];

			for ( int  i = 0 ; i < tamanoAct; i ++)
			{
				if(elementos[i]!=null )
				{
					nuevaLista[nuevoTamano] = elementos[i];	
					nuevoTamano++;
				}
			}

			elementos = nuevaLista;
			tamanoAct = nuevoTamano;
		}

		return eliminar;
	}

	public T removerUltimo() 
	{
		T eliminar = elementos[tamanoAct-1];

		if ( elementos!= null)
		{	
			int nuevoTamano = 0;
			elementos[tamanoAct-1] = null;
			T[] nuevaLista = (T[])new Object[tamanoAct-1];

			for ( int  i = 0 ; i < tamanoAct-1; i ++)
			{
				if(elementos[i]!=null )
				{
					nuevaLista[nuevoTamano] = elementos[i];	
					nuevoTamano++;
				}
			}

			elementos = nuevaLista;
			tamanoAct = nuevoTamano;
		}
		return eliminar;
	}

	public T removerElemento(int pos) 
	{
		T eliminar = elementos[pos-1];

		if ( elementos!= null)
		{	
			int nuevoTamano = 0;
			elementos[pos-1] = null;
			T[] nuevaLista = (T[])new Object[tamanoAct-1];

			for ( int  i = 0 ; i < tamanoAct; i ++)
			{
				if(elementos[i]!=null )
				{
					nuevaLista[nuevoTamano] = elementos[i];	
					nuevoTamano++;
				}
			}

			elementos = nuevaLista;
			tamanoAct = nuevoTamano;
		}
		return eliminar;

	}

	public void intercambiarElementos(int pos1, int pos2) 
	{ 
		T elemento1 = elementos[pos1-1];
		T elemento2 = elementos[pos2-1];

		elementos[pos1-1] = elemento2;
		elementos[pos2-1] = elemento1;

	}

	public void cambiarElemento(int pos, T nuevoElemento) 
	{
		elementos[pos-1] = nuevoElemento;
	}

	public int estaPresente(T elemento) 
	{
		int posicion = 0;
		boolean encontrado = false;

		for ( int  i = 0 ; i < tamanoAct && !encontrado; i ++)
		{
			if(elementos[i].equals(elemento) )
			{
				posicion = i;
				encontrado = true;
			}
		}

		return posicion;
	}

	//TODO punto 6.2
	public ILista<T> sublista(int pos, int subElementos) 
	{
		ILista<T> copia = new ArregloDinamico(subElementos);
		
		int posicion = pos;
		
		for(int i = 0 ; i <= subElementos ; i++)
		{
			T elemento = this.darElemento(posicion);	
			copia.añadirUltimo(elemento);
			posicion++;
		}

		return copia;
	}

}
