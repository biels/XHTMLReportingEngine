package com.biel.xre.generation.xhtml;

import java.text.MessageFormat;
import java.util.ArrayList;

import com.biel.xre.generation.XHTMLFragment;
import com.biel.xre.generation.xhtml.attributes.IdAttribute;
import com.biel.xre.generation.xhtml.attributes.StyleAttribute;
import com.biel.xre.generation.xhtml.attributes.TagAttributes;

/**
 * Represents an XHTML tag of the form <tagname> </tagname>
 */
public class Tag implements XHTMLFragment {
	String name;
	XHTMLFragment content;
	TagAttributes attributes;
	//Attributes
	//new Tag("h2", new InlineStyle("
	
	public Tag(String name, XHTMLFragment content) {
		super();
		this.name = name;
		this.content = content;
	}

	public Tag(String name, XHTMLFragment content, TagAttributes attributes) {
		super();
		this.name = name;
		this.content = content;
		this.attributes = attributes;
	}
	public Tag(String name, XHTMLFragment content, StyleAttribute style) {
		super();
		this.name = name;
		this.content = content;
		this.attributes = new TagAttributes(style);
	}
	public Tag(String name, XHTMLFragment content, IdAttribute id) {
		super();
		this.name = name;
		this.content = content;
		this.attributes = new TagAttributes(id);
	}
	public Tag(String name, String content) {
		super();
		this.name = name;
		this.content = new Literal(content);
	}
	@Override
	public String getXHTML() {
		String s = (attributes == null ? "" : " " + attributes.getAttributeString());
		return MessageFormat.format("<{0}{1}>{2}</{0}>", name, s, content.getXHTML());
	}

}
