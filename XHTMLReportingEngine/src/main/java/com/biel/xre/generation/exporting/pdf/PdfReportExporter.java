package com.biel.xre.generation.exporting.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.biel.xre.generation.Report;
import com.biel.xre.generation.exporting.ReportExporter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PdfReportExporter extends ReportExporter {
	
	final Logger l = LoggerFactory.getLogger(ReportExporter.class);
	
	public PdfReportExporter(Report report) {
		super(report);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void export(File output) {
		generatePdf(output);

	}
	
	public File generatePdf(File file) {
        Document document = new Document(PageSize.A4);

        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(file));
            try {
                generateDocument(pdfWriter, document, xhtml);
                return file;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       return null;

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
