package com.biel.xre.generation.xhtml;

import java.util.ArrayList;

import com.biel.xre.generation.XHTMLFragment;

public class LinearLayout implements XHTMLFragment {
	XHTMLFragment[] fragments;
	
	
	public LinearLayout(XHTMLFragment... fragments) {
		super();
		this.fragments = fragments;
	}


	@Override
	public String getXHTML() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fragments.length; i++) 
			sb.append(fragments[i].getXHTML());
		return sb.toString();
	}

}
