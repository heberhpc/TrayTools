//This static class contains methods to read a Array of Product Objects and create txt files from it description of each Product

package processes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import domain.*;
import org.jsoup.Jsoup;


public class HTMLtoPlainTextFiles {
	
	public static void PlainTextFiles (ArrayList<Product> list) {
		
		for (int i = 0 ; i < list.size() ; i++) {
			
			//get data
			int ID = list.get(i).getID();
			String nameString = list.get(i).getName();
			String description = list.get(i).getProductFullDescrciption();
			
			//file parameters
			String folder = "data/plaintext";
			String fileName = folder+"/"+ID+".txt";
			
			//plaintext formation	
			String plainText="(Cód."+ID+")"+Jsoup.parse(description).text();
			
			//writing files
			try {

				FileWriter fr = new FileWriter(new File(fileName));
				fr.write(plainText);
				fr.close();
				System.out.println("Writing file: "+fileName);
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("writing Files Done!!!");
	}
}
