package com.biel.xre.generation.xhtml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.biel.xre.generation.XHTMLFragment;

public class LinearLayout implements XHTMLFragment {
	ArrayList<XHTMLFragment> fragments;
	
	
	public LinearLayout(XHTMLFragment... fragments) {
		super();
		this.fragments = new ArrayList<XHTMLFragment>(Arrays.asList(fragments));
	}
	@SuppressWarnings("unchecked")
	public LinearLayout(List<? extends XHTMLFragment> fragments) {
		super();
		this.fragments = (ArrayList<XHTMLFragment>) fragments;
	}
	public void add(XHTMLFragment... fragments) {
		this.fragments.addAll(Arrays.asList(fragments));
	}
	public void add(List<? extends XHTMLFragment> fragments) {
		this.fragments.addAll(fragments);
	}
	@Override
	public String getXHTML() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fragments.size(); i++) 
			sb.append(fragments.get(i).getXHTML());
		return sb.toString();
	}

}
