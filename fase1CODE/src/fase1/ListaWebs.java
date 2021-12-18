package fase1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaWebs {
	
	private ArrayList<Web> ListaWebs;
	
	public ListaWebs() {
		ListaWebs = new ArrayList<Web>();
	}
	
	
	public ArrayList<Web> getListaWebs() {
		return ListaWebs;
	}


	public void setListaWebs(ArrayList<Web> listaWebs) {
		ListaWebs = listaWebs;
	}


	/**
	* Añade una web a la lista
	* @param web: la web a añadir
	* PRE: web no está en la lista
	*/
	public void anadirWeb(Web web){
		ListaWebs.add(web);	
	} 


	/**
	* Añade un enlace a una web de la lista
	* @param idWebOrigen: id de la web de origen (X)
	* @param idWebDestino: id de la web de destino (Y)
	* PRE: las webs con id idWebOrigen e idWebDestino están en la lista
	*/
	
	public void anadirEnlace(int idWebOrigen, int idWebDestino){
		Web e= ListaWebs.get(idWebOrigen);
		e.anadirlink(idWebDestino);	
	} 
	
	
}