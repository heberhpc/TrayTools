package app;

import java.io.File;
import java.util.ArrayList;

import org.jsoup.Jsoup;

import domain.*;
import processes.ParsingProduct;
import processes.HTMLtoPlainTextFiles;

public class CreatePlainTextFiles {
	
	public static void main (String args[]) {
		//create a array of productos
		ArrayList<Product> listOfProduct = new ArrayList<Product>();
		
		//File csv containing a product per line (ID, NAME, DESCRIPTION)
		File originalDesc = new File ("data/descricao/descricao_produtos.csv");
		String folder = "data/descricao/plaintext";
		String delimiter = "\";\"";
		
		//Parse File Description and populate ArrayList
		ParsingProduct.parseProductFile(originalDesc, delimiter, listOfProduct);
						
		//Create plaitext Files
		HTMLtoPlainTextFiles.PlainTextFiles(listOfProduct, folder);
	}
}
