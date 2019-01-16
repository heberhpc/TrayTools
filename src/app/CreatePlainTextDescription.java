package app;

import java.io.File;
import java.util.ArrayList;

import org.jsoup.Jsoup;

import domain.*;
import processes.ParsingProduct;
import processes.PlainTextDescriptionFiles;

public class CreatePlainTextDescription {
	
	public static void main (String args[]) {
		//create a array of productos
		ArrayList<Product> listOfProduct = new ArrayList<Product>();
		
		//File csv containing a product per line (ID, NAME, DESCRIPTION)
		File originalDesc = new File ("data/descricao_produtos - V0.csv");
		String delimiter = "\";\"";
		
		//Parse File Description and populate ArrayList
		ParsingProduct.parseProductFile(originalDesc, delimiter, listOfProduct);
		
		//TEST
		int idTest = 1719;
		System.out.println(listOfProduct.get(idTest).getID());
		System.out.println(listOfProduct.get(idTest).getName());
		System.out.println(listOfProduct.get(idTest).getProductFullDescrciption());
		
		String html = listOfProduct.get(idTest).getProductFullDescrciption();
		String plain = Jsoup.parse(html).text();
		System.out.println(plain);
		
		
		//Create plaitext Files
		PlainTextDescriptionFiles.PlainTextFiles(listOfProduct);
		
		
		
		//
		
	}

}
