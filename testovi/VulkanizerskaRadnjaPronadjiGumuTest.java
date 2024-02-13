package testovi;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import zadatak2.AutoGuma;
import zadatak2.VulkanizerskaRadnja;

@RunWith(Parameterized.class)
public class VulkanizerskaRadnjaPronadjiGumuTest {

	private AutoGuma AG;
	private VulkanizerskaRadnja VR;
	
	@BeforeClass
	public static void proveriOS() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Rule
	public Timeout timeout = Timeout.seconds(5);
	
	public VulkanizerskaRadnjaPronadjiGumuTest(AutoGuma AG) {
		this.AG = AG;
	}
	
	@Before
	public void init() {
		VR = new VulkanizerskaRadnja();
	}
	
	@Parameters
	public static Collection<Object[]> gume() {
		return Arrays.asList(new Object[][] {
			{new AutoGuma("Michelin", true, 18, 180, 40)},
			{new AutoGuma("Michelin", true, 18, 185, 45)},
			{new AutoGuma("Michelin", true, 18, 190, 40)},
			{new AutoGuma("Michelin", false, 19,170, 30)}
		});
	}
	
	@Test
	public void testPronadjiGumuNull() {
		assertNull(VR.pronadjiGumu(null));
	}
	
	@Test
	public void testPronadjiGumuPass() {
		assertFalse(VR.gume.contains(AG));
		VR.dodajGumu(AG);
		LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();
		gume.add(AG);
		assertEquals(gume, VR.pronadjiGumu("Michelin"));
	}
	
	@Test
	public void testPronadjiGumuNotExist() {
		assertFalse(VR.gume.contains(AG));
		VR.dodajGumu(AG);
		LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();
		gume.add(AG);
		assertNotEquals(gume, VR.pronadjiGumu("Kazablanka"));
	}
	
	@After
	public void destroy() {
		VR = null;
	}
}
