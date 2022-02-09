package com.example.OutLookMail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;

@SpringBootApplication
public class OutLookMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutLookMailApplication.class, args);

	}

}
