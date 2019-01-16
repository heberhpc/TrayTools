//Class to read CSV files and parse it (Product Objects)

package processes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import domain.Product;

public class ParsingProduct {
	
	//Parse and create a Array of Product
	public static void parseProductFile(File origin, String delimiter, List<Product>listOfProd) {
		
		//
		try {
			//buffer for the file
			BufferedReader br = new BufferedReader(new FileReader(origin));
			
			//read and parse it line
			String line = "";
			int counter = 0;
			while ((line = br.readLine()) != null) {
				counter++;
				
				String [] p = line.split(delimiter);
				
				String ID   = p[0];
				ID = ID.substring(1); // remove the "quote" from start of the line;
				String name = p[1];
				String desc = p[2];
				desc = desc.substring(0, desc.length()-1); // remove quotes from end of the line;
				
				System.out.println("Parsing n:"+counter+" ID "+ID+ " PRODUTO " + name );
				System.out.println(desc);
				
				//Create and store Product Object and Store into arrayList
				Product product = new Product (Integer.parseInt(ID), name,desc);
				listOfProd.add(product);
				
				}
			br.close();
			
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		//Show information 
		System.out.println("Parsing Sucessful");
		System.out.println("Size of the Array " + listOfProd.size());
	}
}
