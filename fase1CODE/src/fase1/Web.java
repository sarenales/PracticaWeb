package fase1;

import java.util.ArrayList;

public class Web {

	private String URL;
	private int index;
	private ArrayList<Integer> websenlazadas;
	
	
	public Web(String URL, int index){
		websenlazadas = new ArrayList<Integer>();
		this.URL = "www."+ URL;
		this.index = index;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<Integer> getWebsenlazadas() {
		return websenlazadas;
	}

	public void setWebsenlazadas(ArrayList<Integer> websenlazadas) {
		this.websenlazadas = websenlazadas;
	}
	
	
	public void anadirlink(int link) {
		websenlazadas.add(link);
	}
	
}
