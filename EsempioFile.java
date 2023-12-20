package it.edu.iisgubbio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class EsempioFile {
	
	public static void main(String[] args) {
		
		File documento = new File("/Users/classe4I/Desktop/prova.html");
		
		try {
			FileOutputStream flussoBytes = new FileOutputStream(documento);
			OutputStreamWriter flussoCaratteri1 = new OutputStreamWriter(flussoBytes,"UTF-8");
			flussoCaratteri1.write("ciao");
			flussoCaratteri1.close();
			flussoBytes.close();
			//flussoBytes.write(45);
			//flussoBytes.close();
		}catch (FileNotFoundException x){
			System.out.println("ACCIDENTI: "+x.getLocalizedMessage());
		}catch(IOException y) {
			System.out.println("non puoi scrivere");
		}
		
		System.out.println(documento.isDirectory());
		
	}
	
}