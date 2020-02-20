package it.rocchetti.deleter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import it.rocchetti.progetto.ProgettoApplication;;

public class Deleter {
	/**
	* Data una descrizione in ingresso elimina la riga che la contiene
	* @param descrizione della riga
	*/
	public boolean delete(String description) throws IOException {
		boolean success = false;
		File inputFile = new File(ProgettoApplication.PATH);
		File tempFile = new File("tmp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;
		// viene riscritto un nuovo file con tutte le righe che non contengono description
		if(!description.isBlank()) {
			while((currentLine = reader.readLine()) != null) {
			    String trimmedLine = currentLine.trim();
			    if(!trimmedLine.contains(description))
			    { 
			      writer.write(currentLine);
			      writer.newLine();
			    }
			}		writer.close(); 
			reader.close(); 
			//viene rinominato il nuovo file con il nome di quello vecchio per sovrascriverlo
			tempFile.renameTo(inputFile);
			success = true;
		}
		return success;
	}

}
