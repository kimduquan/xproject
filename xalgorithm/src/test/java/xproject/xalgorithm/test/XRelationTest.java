package xproject.xalgorithm.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.*;

import xproject.xalgorithm.XAttribute;
import xproject.xalgorithm.XFunctionalDependency;
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
		
		List<List<XFunctionalDependency>> fds = new ArrayList<List<XFunctionalDependency>>();
		List<Map<String, XAttribute>> result = xrelation.xfindAllKeys(fds);
		
		Assert.assertEquals(result.size(), 2);
		Assert.assertEquals(result.size(), fds.size());
	}
	
	@Test
	public void testFindAllKeys_sourceAttrSetIsEmpty() throws Exception {
		//C->T, HR->C, HT->R, CS->G, HS->R
		/*xrelation.xaddAttributes("C", "T", "H", "R", "S", "G");
		xrelation.xaddFunctionalDependencies(
			new String[] { "C", "->", "T" },
			new String[] { "H", "R", "->", "C" },
			new String[] { "H", "T", "->", "R" },
			new String[] { "C", "S", "->", "G" },
			new String[] { "H", "S", "->", "R" }
		);*/
		xrelation.xaddAttributes("A", "B", "C", "D");
		xrelation.xaddFunctionalDependencies(
			new String[] { "A", "->", "C" },
			new String[] { "B", "->", "D" }
		);
		
		List<List<XFunctionalDependency>> fds = new ArrayList<List<XFunctionalDependency>>();
		List<Map<String, XAttribute>> result = xrelation.xfindAllKeys(fds);
		
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(result.size(), fds.size());
		Assert.assertEquals(fds.get(0).size(), 2);
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
		
		HashSet<String> expected2 = new HashSet<String>();
		expected2.add("B");
		expected2.add("C");
		
		HashSet<String> expected3 = new HashSet<String>();
		expected3.add("A");
		
		HashSet<String> expected4 = new HashSet<String>();
		expected4.add("A");
		expected4.add("B");
		
		Assert.assertTrue(
				result.keySet().equals(expected) 
				|| result.keySet().equals(expected2)
				|| result.keySet().equals(expected3)
				|| result.keySet().equals(expected4)
				);
	}
	
	@Test(enabled = false)
	public void testFindMinimalCover() throws Exception {
		xrelation.xaddAttributes("A", "B", "C", "D", "E", "F", "G", "H");
		xrelation.xaddFunctionalDependencies(
			new String[] { "A", "->", "B", "C" },
			new String[] { "B", "E", "->", "G" },
			new String[] { "E", "->", "D" },
			new String[] { "D", "->", "G" },
			new String[] { "A", "->", "B" },
			new String[] { "A", "G", "->", "B", "C" }
		);
		
		Set<XFunctionalDependency> result = xrelation.xfindMinimalCover();
		
		Assert.assertEquals(result.size(), 4);
	}
	
	@Test(invocationCount = 10)
	public void testFindMinimalCover_2() throws Exception {
		xrelation.xaddAttributes("A", "B", "C", "D");
		xrelation.xaddFunctionalDependencies(
			new String[] { "A", "B", "->", "C" },
			new String[] { "A", "B", "->", "D" },
			new String[] { "B", "->", "C" },
			new String[] { "C", "->", "D" }
		);
		
		Set<XFunctionalDependency> result = xrelation.xfindMinimalCover();
		
		Assert.assertEquals(result.size(), 2);
	}
}
