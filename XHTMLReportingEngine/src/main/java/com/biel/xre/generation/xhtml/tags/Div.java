package com.biel.xre.generation.xhtml.tags;

import com.biel.xre.generation.XHTMLFragment;
import com.biel.xre.generation.xhtml.Tag;
import com.biel.xre.generation.xhtml.attributes.IdAttribute;
import com.biel.xre.generation.xhtml.attributes.StyleAttribute;
import com.biel.xre.generation.xhtml.attributes.TagAttributes;

public class Div extends Tag {

	public Div(String content) {
		super("div", content);
		// TODO Auto-generated constructor stub
	}

	public Div(XHTMLFragment content, TagAttributes attributes) {
		super("div", content, attributes);
		// TODO Auto-generated constructor stub
	}
	
	public Div(XHTMLFragment content, IdAttribute id) {
		super("div", content, id);
		// TODO Auto-generated constructor stub
	}

	public Div(XHTMLFragment content, StyleAttribute style) {
		super("div", content, style);
		// TODO Auto-generated constructor stub
	}

	public Div(XHTMLFragment content) {
		super("div", content);
		// TODO Auto-generated constructor stub
	}

	

}
