package fase1;

import java.util.ArrayList;

public class Palabra {
	
	private String palabra;
	private ArrayList<Web> websPalabra;
	
	public Palabra(String palabra) {
		this.palabra = palabra;
		websPalabra = new ArrayList<Web>();
		
	}
		
	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}


	public ArrayList<Web> getWebsPalabra() {
		return websPalabra;
	}


	public void setWebsPalabra(ArrayList<Web> websPalabra) {
		this.websPalabra = websPalabra;
	}



	public void anadirWeb (Web web) {
		websPalabra.add(web);
	}
	
	
	public void imprimirWebs() {
		
		if(websPalabra.isEmpty()) {
			System.out.println(" No se encuentra ninguna web relacionada.");
		}else {
			for(Web w: websPalabra) {
			System.out.println(w.getIndex()+" "+w.getURL());
		}
	}
		}
		

	public boolean esClave() {
		
		if(this.palabra.length() >3 && this.palabra.length()<11) {
			return true;
		}
		return false;
	}

}
