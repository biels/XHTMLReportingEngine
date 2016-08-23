package com.biel.xre.generation;

import com.biel.xre.generation.xhtml.LinearLayout;
import com.biel.xre.generation.xhtml.Tag;

/**
 * Represents any XHTML report made out of XHTMLFragments. Provides necessary functionality to generate the actual XHTML string. 
 */
public abstract class XHTMLReport {
	//TODO Check XHTML integrity
	//TODO Add basic XHTML boilerplate code
	//TODO Handle document level CSS
	public String getFullXHTML(){
		Tag title = new Tag("title", getClass().getSimpleName());
		Tag style = new Tag("style", getCSS());
		Tag head = new Tag("head", new LinearLayout(title, style));
		Tag body = new Tag("body", getXHTML());
		return new Tag("html", new LinearLayout(head, body)).getXHTML();
	}
	protected abstract String getXHTML();
	protected abstract String getCSS();
}
