package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;

public class HTMLFilterSantosAndira {
	
	public static void main (String [] args) {

		String inputFileName = "data/santosandira/guarda-roupas.html";
		File fileIn = new File (inputFileName);
		
		String outputFileName = "data/santosandira/guarda-roupas-out.txt"; 
		
		
		try {
			
			FileInputStream fileInputStream = new FileInputStream (fileIn);
			InputStreamReader reader = new InputStreamReader (fileInputStream, "ISO-8859-1");
			BufferedReader br = new BufferedReader(reader);
			
			FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFileName));
			OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "ISO-8859-1"	);

			String currentLine="";
			String filteredLine ="";
			while ((currentLine = br.readLine()) !=null) {				
				if (currentLine.contains("<h2>")) {
					System.out.println(currentLine);
					filteredLine = Jsoup.parse(currentLine).text();
					writer.append(filteredLine+"\n");
					Boolean f = new File ("data/santosandira/"+filteredLine).mkdir();
				}
			}
			br.close();
			writer.close();

		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Done!!!");
	
	}
}
