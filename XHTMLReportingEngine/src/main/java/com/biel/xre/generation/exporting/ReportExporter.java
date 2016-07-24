package com.biel.xre.generation.exporting;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.biel.xre.generation.Report;

public abstract class ReportExporter {
	final Logger l = LoggerFactory.getLogger(ReportExporter.class);
	protected Report report;
	protected String xhtml;

	public ReportExporter(Report report) {
		super();
		if(report == null)l.error("Tried to create a ReportExporter with a null report");
		this.report = report;
		l.debug("Populating xhtml string...");
		this.xhtml = report.getXHTML();
		l.debug("ReportExporter for report {} is ready", report.getClass().getName());
	}
	public void export(File dir, String fileName){
		if(!dir.exists())dir.mkdir();
		File file = new File(dir.getPath() + File.separator + fileName);
		export(file);
	}
	public abstract void export(File output);
}
