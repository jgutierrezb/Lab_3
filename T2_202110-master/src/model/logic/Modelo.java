package model.logic;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ID;
import model.data_structures.ListaEncadenada;
import model.data_structures.YoutubeVideo;


/**
 * Definicion del modelo del mundo
 *
 */
@SuppressWarnings({ "unchecked", "unchecked" })
public class Modelo 
{
	private final static String RUTAID ="data/category-id.csv";
	private final static String RUTAVIDEOS ="data/videos-small.csv";
	
	FileReader archivoCSV = null;
	CSVReader lector = null;
	
	private YoutubeVideo video;
	private ID id;
	
	
	private ArregloDinamico<YoutubeVideo> datos;
	private ListaEncadenada<YoutubeVideo> datos2;
	
	
	
	
	

	
	public Modelo()
	{
		
		datos = new ArregloDinamico<YoutubeVideo>(7);
		datos2= new ListaEncadenada<YoutubeVideo>(null);
	}
	
	public void CargarPeliculasLista()
	{
		ListaEncadenada<ID> listacast= cargarIDLista();
		try
 		{
 		archivoCSV = new FileReader(RUTAVIDEOS);
 		CSVParser PuntoComa = new CSVParserBuilder().withSeparator(';').build();
 		lector =new CSVReaderBuilder(archivoCSV).withCSVParser(PuntoComa).build();
 		int i=1;
 		lector.readNext();
 		String []  fila;
 		while((fila=(String[]) lector.readNext()) !=null)
 		{
 			Date date;
 			try
 			{
 				date= new SimpleDateFormat("dd/mm/yyyy").parse(fila[10]);
 			}
 			catch(Exception e)
 			{
 				String s= fila[10].replace("-", "/");
 				date= new SimpleDateFormat("dd/mm/yyyy").parse(s);
 				
 			}
 			video = new YoutubeVideo();
 			datos2.insertElement(video, i);
 			
 			i++;
 		}
 		}catch (Exception e)
 		{
 			System.out.print(e);
 		}
 		finally
 		{
 			
 			try {
				archivoCSV.close();
				lector.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		
 		}
 		
	}
	
	public ArregloDinamico<YoutubeVideo> cargarVideos()
	{
		ArregloDinamico<YoutubeVideo> castLista=cargarVideos();
		try
 		{
 		archivoCSV = new FileReader(RUTAVIDEOS);
 		CSVParser Coma = new CSVParserBuilder().withSeparator(',').build();
 		lector =new CSVReaderBuilder(archivoCSV).withCSVParser(Coma).build();
 		int i=1;  
 		lector.readNext();
 		String []  fila;
 		
 		while((fila=(String[]) lector.readNext()) !=null)
 		{
 			Date date;
 			try
 			{
 				date= new SimpleDateFormat("dd/mm/yyyy").parse(fila[10]);
 			}
 			catch(Exception e)
 			{
 				String s= fila[10].replace("-", "/");
 				date= new SimpleDateFormat("dd/mm/yyyy").parse(s);
 				
 			}
 			video = new YoutubeVideo(Integer.parseInt(fila[0]), fila[2], date,fila[16],Float.parseFloat(fila[17]),Integer.parseInt(fila[18]));
 			 datos.agregar(video, i);
 			i++;
 		}
 		
 		}catch (Exception e)
 		{
 			System.out.print(e);
 		}
 		finally
 		{
 			try {
				archivoCSV.close();
				lector.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		
 		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ListaEncadenada cargarIDLista()
	{
		ListaEncadenada<ID> lista= new ListaEncadenada<ID>(null);
		try
 		{
 		archivoCSV = new FileReader(RUTAID);
 		CSVParser y = new CSVParserBuilder().withSeparator('&').build();
 		lector =new CSVReaderBuilder(archivoCSV).withCSVParser(y).build();
 		String []  fila;
 		lector.readNext();
 		int i=1;
 		while((fila=(String[]) lector.readNext()) !=null)
 		{
 			ID id = new ID(Integer.parseInt(fila[0]), fila[1]);
 			 lista.insertElement(id, i);
 			
 			i++;
 			
 		}
 		}catch (Exception e)
 		{
 			System.out.print(e);
 		}
 		finally
 		{
 			try {
				archivoCSV.close();
				lector.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		
 		}
		return lista;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int darTamano()
	{
		return datos.darTamano();
	}

	
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}
	
	
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}
	

	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}
	
	public void invertir()
	{
		datos.invertir();
	}
	
	
}
