//Parsing the description output from TRAY other tools

package processes;

import java.io.*;
import java.util.*;

import domain.Product;

public class Utils {

	public static void findWord(List<Product> listOfProd, String key) {
		int count=0;
		for (int i = 0; i < listOfProd.size() ; i++) {
			
			Product p = listOfProd.get(i);
			String curr = p.getProductFullDescrciption();
			
			if (curr.contains(key)) {
				System.out.println("Find a match on product ID: "+p.getID());
				count++;
			}
		}
		System.out.println("Occorrences :"+ count);	
	}

	public static void parseTextToRemoveFile(File file, List<String> listOfbad ) {
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(file)) ;	
			String line = "";
			while ((line = br.readLine())!=null){
				listOfbad.add(line);
				System.out.println("Line Added :" + line);
			}
			br.close();
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	//Remove text
	public static void replaceText(List<Product>list, List<String> badTexts) {
		
		//look for each product
		System.out.println("Size of the List: "+ list.size());
		for (int i = 0 ; i < list.size() ; i ++) {
			
			Product curr = list.get(i);
			System.out.println("Current Product: " +curr.getID());
			
			String description = curr.getProductFullDescrciption();
			
			//look for eack text x produc
			System.out.println("SIZE OF BAD "+badTexts.size());
			for (int j = 0; j < badTexts.size() ; j++) {
				
				String currText = badTexts.get(j);
				System.out.println(" i :"+i+" --- j: "+j+"--->"+ currText );
				description = description.replaceAll(currText, "");
				
			}
			curr.setProductFullDescrciption(description);
		}
	}
	
	//Rewrite the file from Array of Product Objects
	public static void rewriteFile(List<Product> list, File destination, String delimiter) {
		try {
			FileWriter fr = new FileWriter (destination);
			for (int i = 0 ; i < list.size() ; i++) {

				int ID = ((Product)list.get(i)).getID();
				String name = ((Product)list.get(i)).getName();
				String desc = ((Product)list.get(i)).getProductFullDescrciption();
			
				fr.write("\""+ID+delimiter+name+delimiter+desc+"\""+"\n");	
			}
			fr.close();
		}catch (IOException e) {
					System.out.println(e.getMessage());
		}
		System.out.println("Rewrite the file: Sucessfull" );
	}
	public static void createHTMLFiles(List<Product> ls, String folder) {
		for (int i = 0 ;  i < ls.size() ;  i++) {
			
			String desc = ls.get(i).getProductFullDescrciption();
			int ID = ls.get(i).getID();
			
			String filename= folder+"/"+ID+".html";
			try {
				FileWriter fr = new FileWriter(new File(filename));
				
				fr.write(desc);
				
				fr.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
