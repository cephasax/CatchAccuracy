package br.ufrn.imd.master.ia.fileManipulation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileManager {

	String url;
	
	public FileManager() {
		url = new String (".");
	}
	
	public FileManager(String path) {
		url = new String (path);
	}
			
	public File[] selecionarArquivos() {
		
		File[] files;
		
		JFileChooser chooser = null;
		chooser = new JFileChooser(url);
		chooser.addChoosableFileFilter(new FiltraExtensoes());
		chooser.setMultiSelectionEnabled(true);
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			files = chooser.getSelectedFiles();
			return files;
		} else {
			return null;
		}
	}
	
	public File selecionarArquivo() {
		String url = ".";
		File file;

		JFileChooser chooser = null;
		chooser = new JFileChooser(url);
		chooser.addChoosableFileFilter(new FiltraExtensoes());
		chooser.setMultiSelectionEnabled(true);
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			return file;
		} else {
			return null;
		}
	}
	
	public void escreverArquivo(String nomeArquivo, String conteudo) throws IOException{
		//File saida = new File("Trip_kMeans_RCRAI_Si.txt");
		File saida = new File(nomeArquivo);
		
		FileOutputStream fos = new FileOutputStream(saida);    
        fos.write(conteudo.toString().getBytes());  
        fos.close();        
        System.out.println("Arquivo " + nomeArquivo + " salvo!");
	}
}
