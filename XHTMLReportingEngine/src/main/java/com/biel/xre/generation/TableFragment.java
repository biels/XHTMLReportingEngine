package com.biel.xre.generation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.biel.xre.generation.xhtml.LinearLayout;
import com.biel.xre.generation.xhtml.Tag;

import java8.util.J8Arrays;
import java8.util.function.Consumer;
import java8.util.function.Function;
import java8.util.stream.Collectors;
import java8.util.stream.RefStreams;
import java8.util.stream.StreamSupport;

public class TableFragment extends XHTMLReportFragment {
	List<TableRow> rows = new ArrayList<>();
	boolean hasHeader = false;
	@Override
	public String getXHTML() {
		return new Tag("table", new LinearLayout(rows)).getXHTML();
	}
	public class TableRow extends XHTMLReportFragment{
		List<TableColumn> columns = new ArrayList<>();

		public TableRow(List<XHTMLFragment> columns) {
			super();
			StreamSupport.stream(columns).map(new Function<XHTMLFragment, TableColumn>() {
				@Override
				public TableColumn apply(XHTMLFragment t) {
					// TODO Auto-generated method stub
					return hasHeader ? new TableColumn(t) : new TableHeaderColumn(t);
				}
			}).forEach(new Consumer<TableColumn>() {
				@Override
				public void accept(TableColumn t) {
					TableRow.this.columns.add(t);
				}
			});			
			hasHeader = true;
		}
		public TableRow(XHTMLFragment... columns) {
			this(Arrays.asList(columns));
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
