package app;

import processes.RetagHTMLFile;

public class CreateTagedFiles {
	
	public static void main(String [] args) {
		
		//Origin and Destination Folder
		String folderOrigin = "data/test/lote1/";
		String folderDest = "data/test/retag1/";
		
		//Retag process
		RetagHTMLFile.RetagHTML(folderOrigin, folderDest);
	}
}
