package com.biel.xre.generation.xhtml;

import com.biel.xre.generation.XHTMLFragment;

public class Literal implements XHTMLFragment {
	String value;
	
	public Literal(String value) {
		super();
		this.value = value;
	}
	
	public Literal(XHTMLFragment value) {
		super();
		this.value = value.getXHTML();
	}

	@Override
	public String getXHTML() {
		return value;
	}

}
