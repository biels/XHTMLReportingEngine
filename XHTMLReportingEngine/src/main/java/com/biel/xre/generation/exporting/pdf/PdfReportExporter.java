package com.biel.xre.generation.exporting.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.biel.xre.generation.XHTMLReport;
import com.biel.xre.generation.exporting.XHTMLReportExporter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PdfReportExporter extends XHTMLReportExporter {

	final Logger l = LoggerFactory.getLogger(XHTMLReportExporter.class);

	public PdfReportExporter(XHTMLReport report) {
		super(report);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean generateFile(File file) {
		Document document = new Document(PageSize.A4);
		PdfWriter pdfWriter = null;
		try {
			file.createNewFile();
		} catch (IOException e1) {
			l.error("Error creating new file  at " + file.getAbsolutePath());
			e1.printStackTrace();
		}
		try {
			FileOutputStream os = new FileOutputStream(file);
			pdfWriter = PdfWriter.getInstance(document, os);
			try {
				generateDocument(pdfWriter, document, xhtml);
				os.close();
				return true;
			} catch (IOException e) {
				l.error("IOException while generating pdf document");
				e.printStackTrace();
			}
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (DocumentException e) {
			l.error("DocumentException while generating pdf document");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;

	}
	protected void generateDocument(PdfWriter pdfWriter,Document document, String xml) throws IOException {
		document.open();
		document.addAuthor("Author");
		document.addCreator("Creator");
		document.addTitle("Title");
		document.addCreationDate();
		document.addSubject("Subject");
		XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
		xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(xml));
		document.close();
		l.debug("Document generated using XHTML");
	}

}
