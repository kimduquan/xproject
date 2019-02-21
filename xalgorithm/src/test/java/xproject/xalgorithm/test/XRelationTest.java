package xproject.xalgorithm.test;

import org.testng.annotations.*;

import xproject.xalgorithm.XRelation;

@Test
public class XRelationTest {

	private XRelation xrelation = null;
	
	@BeforeMethod
	public void beforeMethod() {
		xrelation = new XRelation();
	}
	
	@AfterMethod
	public void afterMethod() throws Throwable {
		xrelation.xfinalize();
	}
	
	@BeforeClass
	public static void beforeClass() {
		
	}
	
	@AfterClass
	public static void afterClass() {
		
	}
	
	@Test
	public void testFindAllKeys() throws Exception {
		//C->T, HR->C, HT->R, CS->G, HS->R
		xrelation.xaddAttributes("C", "T", "H", "R", "S", "G");
		xrelation.xaddFunctionalDependencies(
			new String[] { "C", "->", "T" },
			new String[] { "H", "R", "->", "C" },
			new String[] { "H", "T", "->", "R" },
			new String[] { "C", "S", "->", "G" },
			new String[] { "H", "S", "->", "R" }
		);
	}
}
