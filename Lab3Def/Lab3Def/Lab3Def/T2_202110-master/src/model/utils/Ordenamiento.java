package model.utils;

import java.util.Comparator;

import model.data_structures.ILista;

public final class Ordenamiento <T extends Comparable<T>>
{
	public void ordenarInserccion(ILista<T> lista, Comparator<T> criterio , boolean ascendente)
	{
		for ( int i = 2 ; i <= lista.size() ; i++)
		{
			boolean posicion = false;

			for ( int j = i; j > 1 && !posicion; j--)
			{

				int comparacion = (ascendente?1:-1) * criterio.compare(lista.darElemento(j), lista.darElemento(j-1));
				if (comparacion  < 0)
				{
					lista.intercambiarElementos(j, j-1);
				}
				else
				{
					posicion = true;
				}
			}
		}
	}

	public void ordenarSeleccion(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	{ 	
		for ( int i = 1 ; i <= lista.size(); i++)
		{
			int posMayor = i;

			for (int j = i+1 ; j <= lista.size() ; j++)
			{
				int comparacion = (ascendente?1: -1) *  criterio.compare(lista.darElemento(posMayor) , lista.darElemento(j) );

				if (comparacion > 0)
				{
					posMayor = j;
				}
			}

			lista.intercambiarElementos(posMayor, i);
		}
	}

	public void ordenarShell(ILista<T> lista, Comparator<T> criterio , boolean ascendente)
	{
		int n = lista.size();
		int h = 1;

		while ( h < n/3)
		{
			h = 3 * h +1;
		}

		while( h >= 1)
		{
			for(int i = h+1 ; i < n ; i++)
			{
				boolean posicion = false;
				for ( int j = i ; j > h &&  !posicion ; j -= h)
				{
					int comparacion = (ascendente?1:-1) * criterio.compare(lista.darElemento(j), lista.darElemento(j-h));

					if( comparacion <= 0)
					{
						lista.intercambiarElementos(j, j-h);
					}
					else
					{
						posicion = true;
					}
				}
			}
			h /= 3;
		}

	}

	public void ordenarMergeSort(ILista<T> lista, Comparator<T> criterio , boolean ascendente)
	{
		int medida = lista.size();

		if(medida > 1)
		{
			int mid = (int) (medida/2);

			ILista<T> leftlist = lista.sublista(1, mid);
			ILista<T> rightlist = lista.sublista(mid+1, medida - mid);

			this.ordenarMergeSort(leftlist, criterio, ascendente);
			this.ordenarMergeSort(rightlist, criterio, ascendente);

			int i, j, k;
			i=j=k= 1;

			int leftelements = leftlist.size();
			int rightelements = rightlist.size();

			while ( i <= leftelements && j <= rightelements)
			{
				T elemi = leftlist.darElemento(i);
				T elemj = rightlist.darElemento(j);

				int comparacion = (ascendente?1:-1) * criterio.compare(elemi, elemj);

				if( comparacion <= 0)
				{
					lista.cambiarElemento(k, elemi);
					i++;
				}

				else
				{
					lista.cambiarElemento(k, elemj);
					j++;
				}
				k++;
			}

			while( i <= leftelements)
			{
				lista.cambiarElemento( k , leftlist.darElemento(i));
				i++;
				k++;
			}

			while( j <= rightelements)
			{
				lista.cambiarElemento(k , rightlist.darElemento(j));
				j++;
				k++;
			}
		}
	}

	public void ordenarQuickSort(ILista<T> lista, Comparator<T> criterio , boolean ascendente)
	{
		sort(lista, criterio, ascendente, 1 , lista.size());
	}

	public void sort(ILista<T> lista, Comparator<T> criterio , boolean ascendente , int lo , int hi)
	{
		if ( lo > hi)
		{
			return;
		}

		int pivot = particion(lista, criterio, ascendente, lo, hi);	
		sort(lista, criterio, ascendente, lo, pivot -1);
		sort(lista, criterio, ascendente, pivot +1, hi);
	}

	public int particion(ILista<T> lista, Comparator<T> criterio , boolean ascendente , int lo , int hi)
	{
		int seguidor, lider;
		seguidor = lider = lo ;

		while (lider < hi)
		{
			int comparacion = (ascendente?1:-1) * criterio.compare(lista.darElemento(lider), lista.darElemento(hi));
			if ( comparacion <  0)
			{
				lista.intercambiarElementos(seguidor, lider);
				seguidor++;
			}
			lider++;
		}

		lista.intercambiarElementos(seguidor, hi);
		return seguidor;
	}

}
