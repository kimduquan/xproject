package xproject.xalgorithm.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.*;

import xproject.xalgorithm.XAttribute;
import xproject.xalgorithm.XRelation;

@Test
public class XRelationTest {

	protected XRelation xrelation = null;
	
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
		/*xrelation.xaddAttributes("C", "T", "H", "R", "S", "G");
		xrelation.xaddFunctionalDependencies(
			new String[] { "C", "->", "T" },
			new String[] { "H", "R", "->", "C" },
			new String[] { "H", "T", "->", "R" },
			new String[] { "C", "S", "->", "G" },
			new String[] { "H", "S", "->", "R" }
		);*/
		xrelation.xaddAttributes("A", "B", "C");
		xrelation.xaddFunctionalDependencies(
			new String[] { "A", "B", "->", "C" },
			new String[] { "C", "->", "A" }
		);
		
		List<Map<String, XAttribute>> result = xrelation.xfindAllKeys();
		
		Assert.assertEquals(result.size(), 2);
	}
	
	@Test
	public void testCalculateClosure() throws Exception {
		xrelation.xaddAttributes("A", "B", "C", "D", "F", "G", "H");
		xrelation.xaddFunctionalDependencies(
			new String[] { "B", "->", "A" },
			new String[] { "D", "A", "->", "C", "E" },
			new String[] { "D", "->", "H" },
			new String[] { "G", "H", "->", "C" },
			new String[] { "A", "C", "->", "D" }
		);
		
		Map<String, XAttribute> result = xrelation.xcalculateClosure("A", "C");
		
		HashSet<String> expected = new HashSet<String>();
		expected.add("A");
		expected.add("C");
		expected.add("D");
		expected.add("E");
		expected.add("H");
		Assert.assertEquals(result.keySet(), expected);
	}
	
	@Test
	public void testFindAnyKey() throws Exception {
		xrelation.xaddAttributes("A", "B", "C");
		xrelation.xaddFunctionalDependencies(
			new String[] { "A", "->", "B" },
			new String[] { "A", "->", "C" },
			new String[] { "B", "->", "A" }
		);
		
		Map<String, XAttribute> result = xrelation.xfindAnyKey();
		
		HashSet<String> expected = new HashSet<String>();
		expected.add("B");
		Assert.assertEquals(result.keySet(), expected);
	}
}
