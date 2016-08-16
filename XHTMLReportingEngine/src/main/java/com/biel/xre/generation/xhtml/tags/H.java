package com.biel.xre.generation.xhtml.tags;

import com.biel.xre.generation.XHTMLFragment;
import com.biel.xre.generation.xhtml.Tag;
import com.biel.xre.generation.xhtml.attributes.TagAttributes;

public class H extends Tag {

	public H(int n, XHTMLFragment content) {
		super("h" + n, content);
		// TODO Auto-generated constructor stub
	}

	public H(int n, XHTMLFragment content, TagAttributes attributes) {
		super("h" + n, content, attributes);
		// TODO Auto-generated constructor stub
	}

	public H(int n, String content) {
		super("h" + n, content);
		// TODO Auto-generated constructor stub
	}

}
