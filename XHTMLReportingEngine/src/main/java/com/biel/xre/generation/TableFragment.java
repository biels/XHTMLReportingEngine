package com.biel.xre.generation;

import java.util.ArrayList;

import com.biel.xre.generation.xhtml.LinearLayout;
import com.biel.xre.generation.xhtml.Tag;

public abstract class TableFragment extends XHTMLReportFragment {
	TableHeader header;
	TableBody body;
	
	@Override
	public String getXHTML() {
		return new Tag("table", new LinearLayout(header, body)).getXHTML();
	}
	abstract class TableHeader extends XHTMLReportFragment{
		
	}
	abstract class TableBody extends XHTMLReportFragment{
		ArrayList<TableRow> rows = new ArrayList<TableRow>();
		@Override
		public String getXHTML() {
			return new LinearLayout(rows).getXHTML();
		}
		abstract class TableRow extends XHTMLReportFragment{
			
		}
	}
}
