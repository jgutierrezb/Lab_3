package controller;

import java.sql.Time;
import java.util.Comparator;
import java.util.Scanner;

import model.data_structures.ArregloDinamico;
import model.data_structures.YoutubeVideo;
import model.logic.Modelo;
import model.utils.Ordenamiento;
import view.View;

public class Controller<T> {


	private View view;
	private Modelo modelo;
	public Controller()
	{
		view= new View();
		modelo=new Modelo(0);		
	}
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		Scanner lector2 = new Scanner(System.in);
		Scanner lector3 = new Scanner(System.in);
		boolean fin = false;
		while(!fin)
		{
			view.printMenu();
			int option = lector.nextInt();
			System.out.println("\n--------------------------------------------------\n");
			switch(option){
			case 1:

				Time time2= new Time(option);
				ArregloDinamico<YoutubeVideo> p= modelo.cargarArregloDinamico();

				view.printMessage("Como quiere cargar los datos (Arreglo Dinamico o Lista Dinamica");
				String tipo = lector2.nextLine();
				ArregloDinamico<YoutubeVideo> arregloVideos = modelo.cargarVideosArreglo(tipo);

				view.printMessage("La Lista de peliculas es: \n");
				for(int j=1; j<=arregloVideos.size();j++)
				{
					int vCount =0;
					if(arregloVideos.darElemento(j) != null) {
						vCount++;


					}

					view.printMessage("La cantidad de videos es:" + vCount);
				}

				view.printMessage("Como desea organizar ordenar los videos (InsertionSort , Shellsort, MergeSort o QuickSort");
				String ordenar = lector3.nextLine();
				Ordenamiento<YoutubeVideo> ord = new Ordenamiento<YoutubeVideo>();
			
				view.printMessage("como quieres ordenar la lista (ascendente o descendente):");
				String comparacion= lector2.nextLine();
				
				
				
				int tiempo = 0;
				
				if( ordenar == "InsertionSort" )
				{
					long start_time = System.currentTimeMillis();
					ord.ordenarInserccion(arregloVideos, comparacion , true);
					long stop_time = System.currentTimeMillis();
					long elapsed_time = stop_time - start_time;
					tiempo = (int) elapsed_time;		
				}
				
				if( ordenar == "ShellSort" )
				{
					long start_time = System.currentTimeMillis();
					ord.ordenarShell(arregloVideos, comparacion , true);
					long stop_time = System.currentTimeMillis();
					long elapsed_time = stop_time - start_time;
					tiempo = (int) elapsed_time;
					
				}
				if( ordenar == "MergeSort" )
				{
					long start_time = System.currentTimeMillis();
					ord.ordenarMergeSort(arregloVideos, comparacion , true);
					long stop_time = System.currentTimeMillis();
					long elapsed_time = stop_time - start_time;
					tiempo = (int) elapsed_time;
					
				}
				if( ordenar == "QuickSort" )
				{
					long start_time = System.currentTimeMillis();
					ord.ordenarQuickSort(arregloVideos, comparacion , true);
					long stop_time = System.currentTimeMillis();
					long elapsed_time = stop_time - start_time;
					tiempo = (int) elapsed_time;
					
				}
				
				view.printMessage("El ordenamiento se tardó:" + tiempo);
				
				break;


			case 2:




			}}}}
