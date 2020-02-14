package it.rocchetti.deleter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import it.rocchetti.progetto.ProgettoApplication;;

public class Deleter {
	
	public void delete(String description) throws IOException {
		File inputFile = new File(ProgettoApplication.PATH);
		File tempFile = new File("tmp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;
		if(!description.equals("")) {
			while((currentLine = reader.readLine()) != null) {
			    // trim newline when comparing with lineToRemove
			    String trimmedLine = currentLine.trim();
			    if(!trimmedLine.contains(description))
			    { 
			      writer.write(currentLine);
			      writer.newLine();
			    }
			}		writer.close(); 
			reader.close(); 
			tempFile.renameTo(inputFile);
		}
	}

}
