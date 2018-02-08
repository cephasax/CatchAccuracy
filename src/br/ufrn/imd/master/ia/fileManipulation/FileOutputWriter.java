package br.ufrn.imd.master.ia.fileManipulation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import br.ufrn.imd.master.ia.domain.ResultFromMethod;

public class FileOutputWriter {

	private StringBuilder toText;
	
	public FileOutputWriter() {
		toText = new StringBuilder();
	}
		
	public void writeFile(String text) throws IOException {
		toText.append(text);
		putContentOnTxt(toText.toString());
		
	}
	
	public void writeFile(ArrayList<ResultFromMethod> results) throws IOException {
		for(ResultFromMethod r: results) {
			toText.append(r.toString() + "\n");

		}
		putContentOnTxt(toText.toString());
	}
	
	private void putContentOnTxt(String text) throws IOException {
		//File saida = new File("Trip_kMeans_RCRAI_Si.txt");
		long date;
		date = System.currentTimeMillis();
		
		File saida = new File("Results - " + String.valueOf(date) + ".txt");
		
		FileOutputStream fos = new FileOutputStream(saida);    
	    fos.write(text.toString().getBytes());  
	    fos.close();        
	    System.out.println("Arquivo " + saida + " salvo!");
	}
}
