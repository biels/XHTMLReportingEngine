package com.biel.xre.generation.xhtml;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Environment;

import com.biel.xre.generation.TableFragment;

public class TableFragmentTest {
	TableFragment t1;
	@Before
	public void setUp() throws Exception {
		t1 = new TableFragment();
		t1.addRow(new Literal("Product"), new Literal("Units"));
		t1.addRow(new Literal("Sample1"), new Literal("30"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetXHTML() {
		String s = "<table>\r\n" + 
				"  <tr>\r\n" + 
				"    <th>Product</th>\r\n" + 
				"    <th>Units</th>\r\n" + 
				"  </tr>\r\n" + 
				"  <tr>\r\n" + 
				"    <td>Sample1</td>\r\n" + 
				"    <td>30</td>\r\n" + 
				"  </tr>\r\n" + 
				"</table>";
		String r = t1.getXHTML();
		String r1 = r.replaceAll("\r\n", "").replaceAll("	", "").replaceAll(" ", "");
		String r2 = s.replaceAll("\r\n", "").replaceAll("	", "").replaceAll(" ", "").replaceAll(" ", "");
		//assertEquals(r1, r2);
	}

}
