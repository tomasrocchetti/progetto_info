package it.rocchetti.progetto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import it.rocchetti.downloader.DownloadFile;


@SpringBootApplication
@ComponentScan(basePackages={"it.rocchetti"})
public class ProgettoApplication {
	// Main app
	public final static String LINK = new String("https://ec.europa.eu/eurostat/estat-navtree-portlet-prod/BulkDownloadListing?file=data/isoc_ec_eseln2.tsv.gz&unzip=true");
	public final static String PATH = new String("j.tsv");

	public static void main(String[] args) throws Exception {

		SpringApplication.run(ProgettoApplication.class, args);
		
		// crea il file e avvia il download
		File fileOut = new File(PATH);
		if(!fileOut.exists()) {
			DownloadFile download = new DownloadFile(LINK, fileOut);
			Thread threadDown = new Thread (download);
			threadDown.start();
			System.out.println(PATH);
			//Attesa della chiusura del thread di download 
			try {
				threadDown.join(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
		
	}

}
