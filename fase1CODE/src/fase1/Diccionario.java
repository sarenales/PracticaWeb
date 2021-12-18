package fase1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Diccionario  {

	private static Diccionario instance;
	private ListaPalabras lp;

	private Diccionario() {
		lp= new ListaPalabras();
	}

	public static Diccionario getInstance() {

		if(instance==null) instance = new Diccionario(); 
		return instance;

	}
	public ListaPalabras getLp() {
		return lp;
	}

	public void setLp(ListaPalabras lp) {
		this.lp = lp;
	}



	/**
	 * Carga el diccionario desde el fichero indicado
	 * @param nomFich: nombre del fichero que contiene el diccionario
	 */

	private void cargarPalabras(String nomFich){

		try {
			FileReader myObj = new FileReader(nomFich);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String pal = myReader.nextLine();
				lp.anadirPalabra(new Palabra(pal));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error.");
			e.printStackTrace();
		}
	}



	/**
	 * Asigna a cada palabra del diccionario las webs a las que hace
	 * referencia
	 * Pre: Internet y el diccionario ya están cargados
	 */

	private void computarWebsDePalabras(){ 	

		ListaWebs lw= Internet.getInstance().getListawebs();

		for(Web w: lw.getListaWebs()) {

			String[] arrayi = w.getURL().split("\\.");
			
			if(arrayi[1].length()>3) {
				//descomponemos el string del URL en substring y lo metemeos en una lista
				for(int a=3;a<10;a++)	{

					for(int i=0 ; a <= arrayi[1].length() - i && a < 10;i++) {

						Palabra p = lp.buscarPalabra(arrayi[1].substring(i, a+i));

						if(p!=null) {
							p.anadirWeb(w);	
						}
					}
				}
			}
		}
	}


	/**
	 * Carga el diccionario desde el fichero indicado y asigna a cada palabra
	 * del diccionario las webs a las que hace referencia
	 * Pre: Internet ya está cargado
	 * @param nomFich: nombre del fichero que contiene el diccionario
	 */
	public void inicializar(String nomFich){

		cargarPalabras(nomFich);
		System.out.println("Loading...");

		computarWebsDePalabras();
		System.out.println("Cargado.");

	} 

	/**
	 * Busca una palabra en el diccionario y la devuelve
	 * @param sPalabra: texto de la palabra a buscar
	 * @return la Palabra (si está en el diccionario), null en caso contrario
	 */
	public Palabra buscarPalabra(String sPalabra){

		return this.lp.buscarPalabra(sPalabra);

	}	

}
