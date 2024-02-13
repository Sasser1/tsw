package testovi;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import zadatak2.AutoGuma;

import org.junit.*;
import org.junit.Assume;

public class AutoGumaTestovi {

	public AutoGuma AG;
	
	@BeforeClass
	public static void ProveriOperativniSistem() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Rule
	public Timeout timeout = Timeout.seconds(5);
	
	@Rule
	public TestName test = new TestName();
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Before
	public void init() {
		AG = new AutoGuma("Michelin",true, 10,180,40);
	}
	
	@Test
	public void testGetZimska() {
		assertEquals(true, AG.getZimska());
	}
	
	@Test
	public void testSetZimska() {
		AG.setZimska(false);
		assertEquals(false, AG.getZimska());
	}
	
	@Test
	public void testGetMarka() {
		assertEquals("Michelin",AG.getMarkaModel());
	}
	
	@Test
	public void testSetMarka() {
		AG.setMarkaModel("Goodyear");
		assertEquals("Goodyear",AG.getMarkaModel());
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetMarkaNull() {
		AG.setMarkaModel(null);
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetMarkaShort() {
		AG.setMarkaModel("BB");
	}
	
	@Test
	public void testGetPrecnik() {
		assertEquals(10,AG.getPrecnik());
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetPrecnikLow() {
		AG.setPrecnik(9);
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetPrecnikHigh() {
		AG.setPrecnik(25);
	}
	
	@Test
	public void testSetPrecnikPass() {
		AG.setPrecnik(18);
	}
	
	@Test
	public void testGetSirina() {
		assertEquals(180, AG.getSirina());
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetSirinaLow() {
		AG.setSirina(110);
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetSirinaHigh() {
		AG.setSirina(400);
	}
	
	@Test
	public void testSetSirinaPass() {
		AG.setSirina(200);
	}

	@Test
	public void getVisina() {
		assertEquals(40, AG.getVisina());
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetVisinaLow() {
		AG.setVisina(20);
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetVisinaHigh() {
		AG.setVisina(100);
	}
	
	@Test
	public void testSetVisinaPass() {
		AG.setVisina(50);
	}
	
	@Test
	public void testIzracunajCenu() {
		double ocekivaniRezultat = 7132.5;
		assertEquals(ocekivaniRezultat,AG.izracunajCenu(),0.001);
	}
	
	@Test
	public void testPovoljnaGumaFalse() {
		assertFalse(AG.povoljnaGuma());
	}
	
	@Test
	public void testPovoljnaGumaTrue() {
		AG.setSirina(135);
		AG.setPrecnik(13);
		AG.setVisina(25);
		assertTrue(AG.povoljnaGuma());
	}
	
	@Test
	public void testToString() {
		String ocekivaniRezultat = "AutoGuma [markaModel=" + AG.getMarkaModel() + ", precnik=" + AG.getPrecnik() + ", sirina=" + AG.getSirina() + ", visina="+ AG.getVisina() + "]";
		assertEquals(ocekivaniRezultat, AG.toString());
	}
	
}
