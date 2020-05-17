import java.util.*;
import java.io.*;

public class Main {
	static Scanner unos = new Scanner (System.in);
	static ArrayList<Racun> racuni = new ArrayList<Racun>();
	static boolean ide = true;
	
	public static void main(String[] args) throws IOException {
		String izbor ="";
		int izborInt = 0;
			do {
			System.out.println(izbor1(izbor));
			System.out.println(izbor2(izbor));
			System.out.println(izbor3(izbor));
			System.out.println(izbor4(izbor));
			izborInt = unos.nextInt();
			menu(izborInt);}
			while(ide);

		}
		
	
	public static String izbor1 (String izbor) {
		return "Unesite 1 ako zelite da kreirate novi racun: ";}
	
	public static String izbor2 (String izbor) {
		return "Unesite 2 ako zelite da izvrsite transfer novca: ";}
	
	public static String izbor3 (String izbor) {
		return "Unesite 3 ako zelite ispis detalja postojecih racuna: ";}

	public static String izbor4 (String izbor) {
		return "Unesite 4 ako zelite da izadete iz aplikacije: ";}
	
	public static void menu(int izbor) throws IOException {
		
		switch(izbor) {
		case 1: 
			int brojRacuna = brojRacuna();
			String imeVlasnika = imeVlasnikaRacuna();
			double iznosRacuna = iznosRacuna();
			kreirajRacun(brojRacuna, imeVlasnika, iznosRacuna); break;
		
		case 2: 
			int source = sourceRacun();
			int target = targetRacun();
			double iznos = iznosTransfera();
			transferNovca(source, target, iznos); break;
			
		case 3: 
		ispisRacuna();
		break;
		
		case 4:  ide = false; ;break;
		
		default: System.out.println("Unesite broj izmedu 1 i 4!");}}
		
	
	
	public static String transferNovca(int source , int target, double transfer) throws IOException {
		
	
		if(provjeraTransfera (source, target, transfer)) {
			for (int i = 0; i < racuni.size(); i++) {
				if (racuni.get(i).brojRacuna == source)
					racuni.get(i).stanjeRacuna -= transfer;

				if (racuni.get(i).brojRacuna == target)
					racuni.get(i).stanjeRacuna += transfer;
				}
			return "Transfer je izvrsen!";}
		
		else
		{return "Transfer nije izvrsen!";}
	
	}

	public static void ispisRacuna() throws IOException {
		for(int i = 0; i <racuni.size(); i++) {
			System.out.println("Ime korisnika racuna: "+racuni.get(i).imeVlasnika);
			System.out.println("Broj racuna: "+racuni.get(i).brojRacuna);
			System.out.println("Stanje racuna je: "+racuni.get(i).stanjeRacuna);
		}}
	
	public static String kreirajRacun(int brojRacuna, String imeVlasnika, double iznosRacuna) throws IOException {
		
		provjeraIstogBroja(brojRacuna);
		provjeraNegativnogBroja(brojRacuna);
		provjeraNegativnogIznosa(iznosRacuna);
		
		if(provjeraIstogBroja(brojRacuna) && provjeraNegativnogBroja(brojRacuna) && provjeraNegativnogIznosa(iznosRacuna)) 
			{racuni.add(new Racun(brojRacuna, imeVlasnika, iznosRacuna));
			return "Racun je uspjesno kreiran!";}
		
		else return "Racun nije kreiran!";
	}
	
	
	
	public static boolean provjeraIstogBroja(int brojRacuna) {
		for (int i = 0; i < racuni.size(); i++)
			if (racuni.get(i).brojRacuna == brojRacuna) {
				return false;}
		return true;}

	public static boolean provjeraNegativnogBroja(int brojRacuna) {
		if (brojRacuna < 0)
			return false;
		else return true;}

	public static boolean provjeraNegativnogIznosa(double iznosRacuna) {
		if (iznosRacuna < 0)
			return false;
		else return true;}

	public static int sourceRacun() {
		System.out.println("Unesite broj source racuna: ");
		int source = unos.nextInt();
		return source;}
	
	public static int targetRacun() {
		System.out.println("Unesite broj target racuna: ");
		int target = unos.nextInt();
		return target;}
	
	public static double iznosTransfera() {
		System.out.println("Unesite iznos transfera: ");
		double transfer = unos.nextDouble();
		return transfer;}
	
	public static int brojRacuna() {
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = unos.nextInt();
		return brojRacuna;}
	
	public static String imeVlasnikaRacuna() {
		System.out.println("Unesite ime korisnika: ");
		String imeKorisnika = unos.nextLine();
		unos.nextLine();
		return imeKorisnika;}
	
	public static double iznosRacuna() {
		System.out.println("Unesite stanje na racunu: ");
		double stanjeRacuna = unos.nextDouble();
		return stanjeRacuna;}
	
	public static boolean provjeraTransfera(int sourceRacun, int targetRacun, double iznos) throws IOException {
		boolean sourcePostoji = false;
		boolean targetPostoji = false;
		boolean novac = false;

		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).brojRacuna == sourceRacun) 
				sourcePostoji = true;

			if ((racuni.get(i).stanjeRacuna - iznos) >= 0)
					novac = true;

			if (racuni.get(i).brojRacuna == targetRacun)
				targetPostoji = true;

		}
		if (sourcePostoji && targetPostoji && novac)
			return true;
		else return false;}
}