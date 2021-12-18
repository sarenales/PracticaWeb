package fase1;

import java.io.IOException;
import java.util.Scanner;

import fase1.Stopwatch;

public class AplicacionWeb {

	
	public AplicacionWeb() {
		
	}

	public static void main(String[] args) throws IOException {

		Internet i= Internet.getInstance();
		Diccionario d= Diccionario.getInstance();
		
		Stopwatch timer = new Stopwatch();	
		
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Indique el fichero a utilizar: 0(small) o 1(big)");
		String fichero=entrada.nextLine();
		
		double tiempo1 =timer.elapsedTime();
		
		if(fichero.equals("0")) {
			i.inicializar("src\\files\\smallindex", "src\\files\\smallpld-arc");
		}else if(fichero.equals("1")) {
			i.inicializar("src\\files\\index", "src\\files\\pld-arc");
		}
		d.inicializar("src\\files\\words.txt");
		
		double tiempo2 =timer.elapsedTime();
		
		//Reloj
		
		double t= tiempo2-tiempo1;
		
		
		System.out.println("Tiempo de carga:"+String.format("%.3f", t)+"s.");	//Imprime el tiempo transcurrido	
		System.out.println("--------------------");
		
		
		
		int opcion = 1;
		Scanner sc = new Scanner(System.in);
		String pal;
		while(opcion!=0) {
			System.out.println("Que deseas hacer?");
			System.out.println("1. Buscar webs por palabra clave");
			System.out.println("0. Salir");
			opcion = Integer.parseInt(sc.nextLine());
			switch(opcion) {
			case 1: 
					i.buscadorWeb(sc.nextLine());

				
				    break;
			default: break;
			}
		}
		sc.close();

	}

}