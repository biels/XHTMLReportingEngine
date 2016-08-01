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
	public void export(File root, String folder, String fileName){
		l.trace("Using export(File root, String folder, String fileName) to export {}", fileName);
		File file = new File(root.getPath() + File.separator + folder + File.separator + fileName);
		export(file);
	}
	public void export(File folder, String fileName){
		l.trace("Using export(File root, String folder, String fileName) to export {}", fileName);
		File file = new File(folder.getPath() + File.separator + fileName);
		export(file);
	}
	public void export(File output){
		File parentFile = output.getParentFile();
		if(!parentFile.exists()){
			l.debug("Creating export directory tree to place file " + parentFile.getAbsolutePath());
			parentFile.mkdirs();
		}
		boolean result = generateFile(output);
		l.info("File " + output.getPath() + " "  + (result ?  "generated correctly" : "could not be generated"));
	}
	protected abstract boolean generateFile(File file);
}
