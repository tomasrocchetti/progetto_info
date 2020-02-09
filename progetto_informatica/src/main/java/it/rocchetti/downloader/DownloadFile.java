package it.rocchetti.downloader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URI;


public class DownloadFile implements Runnable{
	
	private String link;
	private File out;
	
	// Costruttore
	public DownloadFile(String link, File out) {
		this.link = link;
		this.out = out;
	}

	
	@Override
	public synchronized void run() {
		
		try {
			
			// Connette ad url scelta e crea uno stream
			URL mUrl = new URL(link);
			HttpURLConnection httpURLCon = (HttpURLConnection) mUrl.openConnection();
			BufferedInputStream inStream = new BufferedInputStream(httpURLCon.getInputStream());
			
			// Calcola dimensione file da scaricare
			double fileSize = (double)httpURLCon.getContentLengthLong();
			
			// Buffer per salvare file
			BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(this.out), 1024);
			byte[] buffer = new byte[1024];
			
			// Lettura del file e scrittura in memoria
			int read = 0;
			while((read = inStream.read(buffer, 0, 1024)) >= 0) {
				buffOut.write(buffer, 0, read);
			}
			if(fileSize != -1) {
				System.out.println("Download terminato, sono stati scaricati  " + fileSize + " Byte");
			}
			else System.out.println("Download terminato");
			
			// chiusura stream
			inStream.close();
			buffOut.close();
			
		}
		catch(IOException e) {
			System.err.println("Errore Download");
			e.printStackTrace();
		}
	}
}
	
	//