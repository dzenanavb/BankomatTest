import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Racun implements Serializable {
	
	int brojRacuna;	
	String imeVlasnika;
	double stanjeRacuna;
	static ArrayList<Racun> racuni = new ArrayList<Racun>();
	
	public Racun(int brojRacuna, String imeVlasnika, double stanjeRacuna) throws IOException {
		this.brojRacuna = brojRacuna;
		this.imeVlasnika = imeVlasnika;
		this.stanjeRacuna = stanjeRacuna;
	}
}