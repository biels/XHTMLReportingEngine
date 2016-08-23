package com.biel.xre.generation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.biel.xre.generation.xhtml.LinearLayout;
import com.biel.xre.generation.xhtml.Tag;

public class TableFragment extends XHTMLReportFragment {
	List<TableRow> rows = new ArrayList<>();
	@Override
	public String getXHTML() {
		return new Tag("table", new LinearLayout(rows)).getXHTML();
	}
	public class TableRow extends XHTMLReportFragment{
		List<XHTMLFragment> columns = new ArrayList<>();

		public TableRow(List<XHTMLFragment> columns) {
			super();
			this.columns = columns;
		}
		public TableRow(XHTMLFragment... columns) {
			super();
			this.columns = Arrays.asList(columns);
		}
		@Override
		public String getXHTML() {
			return new Tag("tr", new LinearLayout(columns)).getXHTML();
		}
	}
	public class TableColumn extends XHTMLReportFragment{
		XHTMLFragment content;
		
		public TableColumn(XHTMLFragment content) {
			super();
			this.content = content;
		}

		@Override
		public String getXHTML() {
			// TODO Auto-generated method stub
			return new Tag("td", content).getXHTML();
		}
		
	}
	public class TableHeaderColumn extends TableColumn{
		//TODO Add support for styles, saved here
		public TableHeaderColumn(XHTMLFragment content) {
			super(content);
			// TODO Auto-generated constructor stub
		}
		@Override
		public String getXHTML() {
			// TODO Auto-generated method stub
			return new Tag("th", content).getXHTML();
		}
	}
	public boolean addRow(List<XHTMLFragment> columns) {
		TableRow row = new TableRow(columns);
		return addRow(row);
	}
	public boolean addRow(XHTMLFragment... columns) {
		TableRow row = new TableRow(columns);
		return addRow(row);
	}
	protected boolean addRow(TableRow arg0) {
		return rows.add(arg0);
	}
	protected List<TableRow> getRows() {
		return rows;
	}
	
}
