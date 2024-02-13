package testovi;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

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
public class VulkanizerskaRadnjaDodajGumuTest {

	private AutoGuma AG;
	private VulkanizerskaRadnja VR;
	
	@BeforeClass
	public static void proveriOS() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Rule
	public Timeout timeout = Timeout.seconds(5);
	
	public VulkanizerskaRadnjaDodajGumuTest(AutoGuma AG) {
		this.AG = AG;
	}
	
	@Before
	public void init(){
		VR = new VulkanizerskaRadnja();
	}
	
	@Parameters
	public static Collection<Object[]> gume(){
		return Arrays.asList(new Object[][] {
			{new AutoGuma("Michelin",true,10,20,30)},
			{new AutoGuma("Goodyear",false,50,60,70)},
			{new AutoGuma("Toyo",false,50,30,50)},
			{new AutoGuma("Yokohama",true,50,50,50)}
		});
	
	}
	
	@Test(expected = RuntimeException.class)
	public void testDodajGumuNull() {
		VR.dodajGumu(null);
	}
	
	@Test(expected = RuntimeException.class)
	public void testDodajGumuExists() {
		VR.dodajGumu(AG);
		VR.dodajGumu(AG);
	}
	
	@Test
	public void testDodajGumuPass() {
		VR.dodajGumu(AG);
	}
	
	@After
	public void destroy() {
		VR = null;
	}
	
}
