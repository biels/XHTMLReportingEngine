package com.biel.xre.generation.xhtml;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.biel.xre.generation.XHTMLFragment;

public class LinearLayoutTest {
	XHTMLFragment f1, f2, f3;
	String s1, s2, s3;
	String result;
	@Before
	public void setUp() throws Exception {
		s1 = "Fragment 1";
		f1 = new Literal(s1);
		s2 = "Fragment 2";
		f2 = new Literal(s2);
		s3 = "Fragment 3";
		f3 = new Literal(s3);
		result = s1 + s2 + s3;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLinearLayoutXHTMLFragmentArray() {
		LinearLayout l1 = new LinearLayout(f1, f2, f3);
		assertEquals(l1.getXHTML(), result);
		LinearLayout l2 = new LinearLayout(f1, f3, f2);
		assertNotEquals(l2.getXHTML(), result);
	}

	@Test
	public void testGetXHTML() {
		LinearLayout l1 = new LinearLayout(f1, f2, f3);
		assertEquals(l1.getXHTML(), result);
	}

}
