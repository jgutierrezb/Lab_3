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
		elementos = new Object[max];
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
		return tamanoAct;
	}

	public T darElemento(int i) 
	{
		return elementos[i];
	}

	public T buscar(T dato) 
	{
		T buscado = null;
		boolean encontrado = false;

		for ( int  i = 0 ; i < tamanoAct && !encontrado; i ++)
		{
			if(elementos[i].compareTo(dato) == 0)

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

		for(int i = tamanoAct ; i >= 0 ; i--)
		{
			nuevaLista[nuevoTamano] = elementos[i];
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
		T elemento = elementos [tamanoAct];

		return elemento;
	}

	public void aņadirPrimero(T elemento) 
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

	public void aņadirUltimo(T elemento) 
	{
		this.agregar(elemento);
	}

	public void aņadirElemento(T elemento, int pos) 
	{
		T elementoNuevo = elemento;
		
		if(elementos[pos] == null)
		{
			elementos[pos] = elementoNuevo;
		}
	
		else
		{
			T elementoActual = elementos[pos];
			elementos[pos] = elementoNuevo;

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
		T eliminar = elementos[tamanoAct];

		if ( elementos!= null)
		{	
			int nuevoTamano = 0;
			elementos[tamanoAct] = null;
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

	public T removerElemento(int pos) 
	{
		T eliminar = elementos[pos];

		if ( elementos!= null)
		{	
			int nuevoTamano = 0;
			elementos[pos] = null;
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
		T elemento1 = elementos[pos1];
		T elemento2 = elementos[pos2];

		elementos[pos1] = elemento2;
		elementos[pos2] = elemento1;

	}

	public void cambiarElemento(int pos, T nuevoElemento) 
	{
		elementos[pos] = nuevoElemento;
	}

	public int estaPresente(T elemento) 
	{
		int posicion = 0;
		boolean encontrado = false;

		for ( int  i = 0 ; i < tamanoAct && !encontrado; i ++)
		{
			if(elementos[i].compareTo(elemento) == 0)

			{
				posicion = i;
				encontrado = true;
			}
		}

		return posicion;
	}


}
