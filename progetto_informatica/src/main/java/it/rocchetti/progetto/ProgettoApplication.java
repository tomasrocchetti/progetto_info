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
		
		

			
		
	}

}
