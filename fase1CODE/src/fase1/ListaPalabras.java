package fase1;

import java.util.ArrayList;

public class ListaPalabras {
	
	
	private ArrayList<Palabra> ListaPalabras;
	private ArrayList<Palabra> ListaPalabrasClave; //creo otra lista con SOLO palabras clave
												   //asi las veces que queramos acceder a ella no ciclara tanto.
	
	public ListaPalabras() {
		ListaPalabras = new ArrayList<Palabra>();
		ListaPalabrasClave = new ArrayList<Palabra>();
	}
	
	public ArrayList<Palabra> getListaPalabras() {
		return ListaPalabras;
	}

	public void setListaPalabras(ArrayList<Palabra> listaPalabras) {
		ListaPalabras = listaPalabras;
	}

	public ArrayList<Palabra> getListaPalabrasClave() {
		return ListaPalabrasClave;
	}

	public void setListaPalabrasClave(ArrayList<Palabra> listaPalabrasClave) {
		ListaPalabrasClave = listaPalabrasClave;
	}	
	
	/**
	* Añade una palabra a la lista
	* @param palabra: palabra a añadir
	*/
	public void anadirPalabra(Palabra palabra){
		
		if(palabra.esClave()) 
			ListaPalabrasClave.add(palabra);
					
		ListaPalabras.add(palabra);		
	} 
	

	/**
	* Busca una palabra en la lista y la devuelve
	* @param sPalabra: texto de la palabra a buscar
	* @return la Palabra (si está en la lista), null en caso contrario
	*/
	
	public Palabra buscarPalabra(String sPalabra){
		
		int min = 0;
		int max = this.ListaPalabrasClave.size()-1;
		int medio;
		Palabra p;
		
		while(min<=max) {
			medio= ((max-min)/2) + min;
			
			p=this.ListaPalabrasClave.get(medio);
			int resultado=p.getPalabra().compareTo(sPalabra);
			
			if(resultado==0) {
				return p;
			}
			if(resultado < 0) {
				min = medio + 1;
			}else {
				max = medio -1;
			}
		}
		return null;
		
	}
	
	
}
