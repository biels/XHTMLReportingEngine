package com.biel.xre.generation.xhtml.attributes;

import java.util.ArrayList;

import com.itextpdf.text.List;

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
		return String.join(" ", arrayList);
		//return String.join(" ", tagAttributes);
	}
}
