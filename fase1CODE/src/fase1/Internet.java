package fase1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/*
 * Esta clase representa Internet.
 */
public class Internet {

	private static Internet instance;
	private ListaWebs listawebs;
	
	private Internet() {
		listawebs= new ListaWebs();

	}
	public static Internet getInstance() {

		if(instance==null) instance = new Internet(); 
		return instance;

	}
	
	public ListaWebs getListawebs() {
		return listawebs;
	}
	public void setListawebs(ListaWebs listawebs) {
		this.listawebs = listawebs;
	}

	/**
	 * Carga las webs contenidas en el fichero indicado
	 * @param nomFich: nombre del fichero que contiene las webs
	 */
	private void cargarWebs(String nomFich) {

		try {
			int cont = 0;
			Scanner myReader = new Scanner(new FileReader(nomFich));
			while (myReader.hasNext()) {
				String[] arrayi = myReader.nextLine().split("\\s+");
				listawebs.anadirWeb(new Web(arrayi[0],cont));
				cont++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error.");
			e.printStackTrace();
		}
	} 



	/**
	 * Carga los enlaces contenidos en el fichero indicado
	 * @param nomFich: nombre del fichero que contiene los enlaces
	 */
	private void cargarEnlaces(String nomFich) {
		try {
			Scanner myReader = new Scanner(new FileReader(nomFich));
			while (myReader.hasNext()) {
				String index = myReader.nextLine();
				String[] arrayi = index.split("\\s+");
				listawebs.anadirEnlace(Integer.parseInt(arrayi[0]),Integer.parseInt(arrayi[1]));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha habido un error.");
			e.printStackTrace();
		}

	} 

	/**
	 * Inicializa la clase cargando las webs y los enlaces
	 * @param nomFichWebs: nombre del fichero que contiene las webs
	 * @param nomFichEnlaces: nombre del fichero que contiene los enlaces
	 */
	public void inicializar(String nomFichWebs, String nomFichEnlaces){

		cargarWebs(nomFichWebs);
		System.out.println("Webs cargadas.");
		cargarEnlaces(nomFichEnlaces);
		System.out.println("Enlaces cargados.");
	} 

	/**
	 * Dado un string que contiene una palabra, imprime por pantalla las webs
	 * que tienen dicha palabra clave
	 * @param sPalabra: string con la palabra
	 */
	ListaPalabras lp;

	public void buscadorWeb(String sPalabra){

		Palabra p= new Palabra(sPalabra);
		Diccionario diccionario = Diccionario.getInstance();

		if(p.esClave()){
			p=diccionario.buscarPalabra(sPalabra);
			
			if(p!=null) {
				
				System.out.println(" Webs de la palabra "+ p.getPalabra()+":");
				p.imprimirWebs();
				
			}else
				System.out.println("La palabra "+sPalabra+" no se encuentra en el diccionario.");
			
		} 
		else{
			System.out.print(sPalabra+" no es una palabra clave.");
		}
	}




}
