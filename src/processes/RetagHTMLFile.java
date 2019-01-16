//Class to read txt files and add hmlt tags

package processes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RetagHTMLFile {
	
	public static void RetagHTML(String originFolder, String destFolder) {
		
		//origin foldes
		File folder = new File (originFolder);
		
		//read all files inside de origin folder
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0 ; i < listOfFiles.length ; i++ ) {
			
			try {
				
				String fileNameOrigin = originFolder+listOfFiles[i].getName();
				String fileNameDest = destFolder+listOfFiles[i].getName();
				
				File fileOrigin = new File(fileNameOrigin);
				FileReader fr = new FileReader(fileOrigin);
				
				File fileDest = new File(fileNameDest);
				FileWriter wr = new FileWriter(fileDest);
				
				BufferedReader br = new BufferedReader (fr);
				
				String currentLine;
				String modLine="";
				
				while ((currentLine = br.readLine()) !=null) {
					String temp;
					if(currentLine.equals("") ) {
						temp = "<br>"+currentLine;
					}else {
						temp = "<p>"+currentLine+"</p>";
					}
					modLine=modLine+temp;
					//System.out.println(modLine);
					
				}
				
				modLine=modLine+"<br>";
				modLine=modLine+"<p>*MONTAGEM POR CONTA DO COMPRADOR</p>";
				modLine=modLine+"<p>**IMAGENS MERAMENTE ILUSTRATIVAS</p>";
				
				wr.write(modLine);
				
				wr.close();
				br.close();

			}catch (IOException e) {
				System.out.println(e.getMessage());
			}		
		}
	}
}
