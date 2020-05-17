import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BankomatTest {

	
	@Test
	void shouldReturnString() {
		String str1 = Main.izbor1("Unesite 1 ako zelite da kreirate novi racun: ");
		assertEquals("Unesite 1 ako zelite da kreirate novi racun: ", str1);
		String str2 = Main.izbor2("Unesite 2 ako zelite da izvrsite transfer novca: ");
		assertEquals("Unesite 2 ako zelite da izvrsite transfer novca: ", str2);
		String str3 = Main.izbor3("Unesite 3 ako zelite ispis detalja postojecih racuna: ");
		assertEquals("Unesite 3 ako zelite ispis detalja postojecih racuna: ", str3);
		String str4 = Main.izbor4("Unesite 4 ako zelite da izadete iz aplikacije: ");
		assertEquals("Unesite 4 ako zelite da izadete iz aplikacije: ", str4);
	}
	
	@Test
	public void unosSourceBrojaRacunaUnijeti1(){
		assertEquals(1,Main.sourceRacun());}
	
	@Test
	public void unosTargetBrojaRacunaUnijeti2(){
		assertEquals(2,Main.targetRacun());}
	

	@Test
	public void unosIznosaTransfera(){
		assertEquals(22.00, Main.iznosTransfera());}
	
	@Test
	public void unosBrojaRacunaUnijeti1(){
		assertEquals(1,Main.brojRacuna());}
	
	
	
	@Test
	public void unosImenaVlasnikaUnijetiAmina() {
		assertEquals("Amina", Main.imeVlasnikaRacuna());}
	
	@Test
	public void unosIznosaRacuna() {
		double iznos = 20.12;
		assertEquals(iznos, Main.iznosRacuna());}
	
	@Test
	public void provjeraNegativnogBrojaRacuna() {
		assertFalse(Main.provjeraNegativnogBroja(-7));}
	
	@Test
	public void provjeraNegativnogIznosaRacuna() {
		assertFalse(Main.provjeraNegativnogIznosa(-1.00));}
	
	@Test
	public void provjeraKreiranjaRacuna() {
		boolean test = false;
		if(Main.provjeraIstogBroja(2) && Main.provjeraNegativnogBroja(2) && Main.provjeraNegativnogIznosa(20.12))
			test = true;
		assertTrue(test);}
	
	@Test
	public void provjeraTransferaNovca() throws IOException {
		Main.kreirajRacun(1, "Amina", 20.00);
		Main.kreirajRacun(2, "Amina", 20.00);
		String str = "Transfer je izvrsen!";
		assertEquals(Main.transferNovca(1, 2, 5.00), str);
	}
	
	@Test
	public void provjeraTransferaNovcaFalse() throws IOException {
		Main.kreirajRacun(1, "Amina", 20.00);
		Main.kreirajRacun(2, "Amina", 20.00);
		String str = "Transfer nije izvrsen!";
		assertEquals(Main.transferNovca(1, 2, 35.00), str);
	}
	
	@Test
	public void provjeraTRansferaTest() throws IOException {
		Main.kreirajRacun(1, "Amina", 20.00);
		Main.kreirajRacun(2, "Amina", 20.00);
		assertTrue(Main.provjeraTransfera(1, 2, 10.00));
	}
	
	@Test
	public void daLiJeRacunKreiran() throws IOException {
		String str = "Racun je uspjesno kreiran!";
		assertEquals(Main.kreirajRacun(1, "Amina", 20.12), str);}
	
	
	@Test
	public void provjeraPostojecegRacuna() throws IOException {
		boolean test = true;
		ArrayList<Racun> racuni = new ArrayList<Racun>(); 
		racuni.add(new Racun(1, "Amina", 20.12));
		if(Main.provjeraIstogBroja(2))
			test = true;
		
		else test = false;
		assertTrue(test);}
	
	@Test
	public void provjeraPostojecegRacunaFalse() throws IOException {
		boolean test = true;
		ArrayList<Racun> racuni = new ArrayList<Racun>(); 
		racuni.add(new Racun(1, "Amina", 20.12));
		if(Main.provjeraIstogBroja(1))
			test = true;
		
		else test = false;
		assertFalse(test);}
	
}
