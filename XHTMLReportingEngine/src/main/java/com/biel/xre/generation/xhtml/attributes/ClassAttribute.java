package com.biel.xre.generation.xhtml.attributes;

import java.util.Arrays;

public class ClassAttribute extends TagAttribute{
	
	public ClassAttribute(String value) {
		super(value);
	}
	public ClassAttribute(String... values) {
		super(String.join(" ", values));
	}
	@Override
	public String getAttributeName() {
		return "class";
	}
	
}
