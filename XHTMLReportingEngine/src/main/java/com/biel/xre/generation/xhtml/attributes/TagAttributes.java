package com.biel.xre.generation.xhtml.attributes;

public class TagAttributes {
	final TagAttribute[] tagAttributes;

	public TagAttributes(TagAttribute... tagAttributes) {
		super();
		this.tagAttributes = tagAttributes;
	}

	public TagAttribute[] getTagAttributes() {
		return tagAttributes;
	}
	
	public String getAttributeString(){
		//TODO Implement
		return "-attributes-";
		//return String.join(" ", tagAttributes);
	}
}
