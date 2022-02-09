package com.example.ReadDataFromPDF;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.lang.reflect.Array;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Entity.PDFEntity;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;

import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.RectangularTextContainer;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.Entity;

public class ReadData {

	public static void main(String[] args) throws Exception {

//			File file = new File("C:\\Users\\ramu\\Desktop\\PDF\\TableData.pdf");
//			FileInputStream fileInputStream = new FileInputStream(file);
//		
//			PDDocument document = PDDocument.load(fileInputStream);
//			System.out.println(document.getPages().getCount());
//		
//			PDFTextStripper pdfTextStripper = new PDFTextStripper();
//			String data = pdfTextStripper.getText(document);
//			System.out.println(data);
//			
//			String[] sliptData = data.split("1");
//			for (String stringData : sliptData) {
//				System.out.println(stringData);
//				
//			}
//			
//			
//			
//			document.close();
//			fileInputStream.close();

//		        //Load a sample PDF document
//		        PdfDocument pdf = new PdfDocument("C:\\Users\\ramu\\Desktop\\PDF\\TableData.pdf");
//
//		        //Create a PdfTableExtractor instance
//		        PdfTableExtractor extractor = new PdfTableExtractor(pdf);
//
//		        //Extract tables from the first page
//		        PdfTable[] pdfTables = extractor.extractTable(0);
//
//		        //Get the first table
//		        PdfTable table = pdfTables[0];
//
//		        //Create a StringBuilder instance
//		        StringBuilder builder = new StringBuilder();
//
//		        //Loop through the rows in the current table
//		        for (int i = 0; i < table.getRowCount(); i++) {
//
//		            //Loop through the columns in the current table
//		            for (int j = 0; j < table.getColumnCount(); j++) {
//
//		                //Extract data from the current table cell
//		                String text = table.getText(i, j);
//
//		                //Append the text to the string builder
//		                builder.append(text + " ");
//		            }
//		            builder.append("\r\n");
//		        }
//
//		        //Write data into a .txt document
//		        FileWriter fw = new FileWriter("C:\\Users\\ramu\\Desktop\\PDF\\10mb.txt");
//		        fw.write(builder.toString());
//		        fw.flush();
//		        fw.close();
//		    }
//		
//		//Load a sample PDF document
//        PdfDocument pdf = new PdfDocument("C:\\Users\\ramu\\Desktop\\PDF\\TableData.pdf");
//
//        //Create a StringBuilder instance
//        StringBuilder builder = new StringBuilder();
//        //Create a PdfTableExtractor instance
//        PdfTableExtractor extractor = new PdfTableExtractor(pdf);
//        System.out.println("helo");
//
//        //Loop through the pages in the PDF
//        for (int pageIndex = 0; pageIndex < pdf.getPages().getCount(); pageIndex++) {
//            //Extract tables from the current page into a PdfTable array
//            PdfTable[] tableLists = extractor.extractTable(pageIndex);
//            
//            //If any tables are found
//            if (tableLists != null && tableLists.length > 0) {
//                //Loop through the tables in the array
//                for (PdfTable table : tableLists) {
//                	
//                	
//                    //Loop through the rows in the current table
//                    for (int i = 0; i < table.getRowCount(); i++) {
//                        //Loop through the columns in the current table
//                        for (int j = 0; j < table.getColumnCount(); j++) {
//                            //Extract data from the current table cell and append to the StringBuilder 
//                            String text = table.getText(i, j);
//                            builder.append(text + " | ");
//                        }
//                        builder.append("\r\n");
////                        System.out.println(builder);
//                        System.out.println("lala");
//                    }
//                }
//            }
//        }
//
//        //Write data into a .txt document
//        FileWriter fw = new FileWriter("ExtractTable.txt");
//        System.err.println(builder);
//        
//        fw.write(builder.toString());
//        fw.flush();
//        fw.close();
//    }

		String FILENAME = "C:\\Users\\ramu\\Desktop\\PDF\\TableDataWithRows.pdf";
		PDDocument pd = PDDocument.load(new File(FILENAME));

		ObjectExtractor oe = new ObjectExtractor(pd);

		SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm(); // Tabula algo.

		Page page = oe.extract(1); // extract only the first page
		List<Table> table = sea.extract(page);

//		System.out.println("table found "+table);
		PDFEntity entity = new PDFEntity();
		for (Table tables : table) {
//			System.out.println("table data "+ tables);
			List<List<RectangularTextContainer>> rows = tables.getRows();
			Map<String, String> map = new HashMap<String, String>();
			List<String> list = new ArrayList<String>();
			List<PDFEntity> entityList = new ArrayList<PDFEntity>();

			Map<Integer, PDFEntity> map1 = new HashMap<Integer, PDFEntity>();
			int index = 0;

			for (int i = 0; i < rows.size(); i++) {

				List<RectangularTextContainer> cells = rows.get(i);
//				System.out.print(cells.size());

//				System.out.println("Row list "+cells);
//				System.out.println(cells);
//				System.out.println(cells.get(0).getText());
//				String currency =  cells.get(0).getText();

				for (int j = 0; j < cells.size(); j++) {
					if (cells.get(j).getText().startsWith("Recommended Grid(USD)")
							|| (cells.get(j).getText().startsWith("Recommended Grid(EUR)"))) {

						for (int z = 1; z < cells.size(); z++) {
							j++;
						}

						break;
					}
//					System.out.print(cells.get(0).getText() + "|");
					list.add(cells.get(j).getText());

				}

				System.out.println();

			}

			System.out.println(list.toString());
			System.out.println(list.size());

//			entityPDF.setCurrencyGrid(list.get(0));
//			entityPDF.setFristWeek(list.get(1));
//			entityPDF.setFirstMonth(list.get(2));
//			entityPDF.setSecondMonth(list.get(3));
//			entityPDF.setThirdMonth(list.get(4));
//			entityPDF.setSixthmonth(list.get(5));
//			entityPDF.setNinthMonth(list.get(6));
//			entityPDF.setOneYear(list.get(7));
//			for(String data : list ) {
//				System.out.println(data);
//				PDFEntity entityFor = new PDFEntity();
//				entityPDF.setCurrencyGrid(data);
//				entityPDF.setFristWeek(data);
//				entityPDF.setFirstMonth(data);
//				entityPDF.setSecondMonth(data);
//				entityPDF.setThirdMonth(data);
//				entityPDF.setSixthmonth(data);
//				entityPDF.setNinthMonth(data);
//				entityPDF.setOneYear(data);
//				entityPDF.setFromRange(data);
//				
//				map1.put(index,entityFor );
//				index++;
//			}

			Iterator<String> iterator = list.iterator();
			if (iterator.hasNext()) {

				PDFEntity entityPDF = new PDFEntity();
				entityPDF.setCurrencyGrid(iterator.next());
				entityPDF.setFristWeek(iterator.next());
				entityPDF.setFirstMonth(iterator.next());
				entityPDF.setSecondMonth(iterator.next());
				entityPDF.setThirdMonth(iterator.next());
				entityPDF.setSixthmonth(iterator.next());
				entityPDF.setNinthMonth(iterator.next());
				entityPDF.setOneYear(iterator.next());
				entityPDF.setFromRange(iterator.next());

//				map1.put(index,entityPDF);
//				index++;
				entityList.add(index, entityPDF);
				index++;

			}

			System.out.println("map " + map1);
			System.out.println("list " + entityList);
//			System.out.println("pdfEntity" + entityPDF);
		}

	}

}
