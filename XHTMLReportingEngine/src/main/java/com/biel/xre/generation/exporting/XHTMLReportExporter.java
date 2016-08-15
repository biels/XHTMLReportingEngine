package com.biel.xre.generation.exporting;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.biel.xre.generation.XHTMLReport;

public abstract class XHTMLReportExporter {
	final Logger l = LoggerFactory.getLogger(XHTMLReportExporter.class);
	protected XHTMLReport report;
	protected String xhtml;

	public XHTMLReportExporter(XHTMLReport report) {
		super();
		if(report == null){l.error("Tried to create a ReportExporter with a null report"); return;};
		this.report = report;
		l.debug("Populating xhtml string...");
		this.xhtml = report.getFullXHTML();
		l.debug("ReportExporter for report {} is ready", report.getClass().getName());
	}
	public File export(File root, String folder, String fileName){
		l.trace("Using export(File root, String folder, String fileName) to export {}", fileName);
		File file = new File(root.getPath() + File.separator + folder + File.separator + fileName);
		export(file);
		return file;
	}
	public File export(File folder, String fileName){
		l.trace("Using export(File root, String folder, String fileName) to export {}", fileName);
		File file = new File(folder.getPath() + File.separator + fileName);
		export(file);
		return file;
	}
	public File export(File output){
		File parentFile = output.getParentFile();
		if(!parentFile.exists()){
			l.debug("Creating export directory tree to place file " + parentFile.getAbsolutePath());
			parentFile.mkdirs();
		}
		boolean result = generateFile(output);
		l.info("File " + output.getPath() + " "  + (result ?  "generated correctly" : "could not be generated"));
		return output;
	}
	protected abstract boolean generateFile(File file);
}
