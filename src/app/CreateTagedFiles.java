package app;


import processes.RetagHTMLFile;

public class CreateTagedFiles {
	
	public static void main(String [] args) {
		
		String folderOrigin = "data/test/lote1/";
		String folderDest = "data/test/retag1/";
		
		RetagHTMLFile.RetagHTML(folderOrigin, folderDest);
		
		
	}

}
