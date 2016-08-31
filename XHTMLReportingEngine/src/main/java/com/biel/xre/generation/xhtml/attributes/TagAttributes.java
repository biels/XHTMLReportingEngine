package com.biel.xre.generation.xhtml.attributes;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

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
		ArrayList<String> arrayList = new ArrayList<String>();
		for(TagAttribute t : tagAttributes)arrayList.add(t.getAttributeString());
		return StringUtils.join(arrayList, " "); // Java 7 compatible
	}
}
