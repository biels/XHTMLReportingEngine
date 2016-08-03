package com.biel.xre.generation;

import com.biel.xre.generation.xhtml.Tag;

/**
 * Represents any XHTML report made out of XHTMLFragments. Provides necessary functionality to generate the actual XHTML string. 
 */
public abstract class Report {
	//TODO Check XHTML integrity
	//TODO Add basic XHTML boilerplate code
	//TODO Handle document level CSS
	public String getFullXHTML(){
		return new Tag("html", getXHTML()).getXHTML();
	}
	protected abstract String getXHTML();
}
