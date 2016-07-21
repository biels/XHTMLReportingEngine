package com.biel.xre.generation.xhtml.attributes;

import java.text.MessageFormat;

public abstract class TagAttribute {
	protected String value;
	public TagAttribute(String value) {
		super();
		this.value = value;
	}
	public abstract String getAttributeName();
	public String getAttributeString(){
		if(value.isEmpty())return "";
		return MessageFormat.format("id=\"{0}\"", value);
	}
}
