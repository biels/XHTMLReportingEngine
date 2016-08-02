package com.biel.xre.generation.xhtml;

import java.util.ArrayList;
import java.util.Arrays;

import com.biel.xre.generation.XHTMLFragment;

public class LinearLayout implements XHTMLFragment {
	ArrayList<? extends XHTMLFragment> fragments;
	
	
	public LinearLayout(XHTMLFragment... fragments) {
		super();
		this.fragments = new ArrayList<XHTMLFragment>(Arrays.asList(fragments));
	}
	public LinearLayout(ArrayList<? extends XHTMLFragment> fragments) {
		super();
		this.fragments = fragments;
	}

	@Override
	public String getXHTML() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fragments.size(); i++) 
			sb.append(fragments.get(i).getXHTML());
		return sb.toString();
	}

}
