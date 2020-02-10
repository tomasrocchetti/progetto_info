package it.rocchetti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.rocchetti.model.DataModel;
import it.rocchetti.parser.Parser;
import it.rocchetti.progetto.ProgettoApplication;

@RestController
public class Controller {
	@GetMapping("/country")
	public String country() throws Exception {
		StringBuilder page = new StringBuilder("Di seguito viene riportata la lista delle nazioni presenti nella tabella, sceglierne una: <br>");
		
		
		
		// crea un oggetto di tipo Parser per fare il parsing della tabella
		Parser parser = new Parser();
		parser.parse(ProgettoApplication.PATH);
		
		// lista di oggetti DataModel = tabella completa
		List<DataModel> mList = new ArrayList<DataModel>();
		
		// lista delle nazioni che verranno mostrate
		List<String> country = new ArrayList<String>();
		
		// lista di tutti i parametri non parsati
		List<String> allParam = new ArrayList<String>();
		
		mList = Parser.parse(ProgettoApplication.PATH);
		
		String[] param = {"","","",""};
		
		boolean canAppend = true;
		
		// per ogni elemento della lista prende i parametri e li mette in una lista dedicata
		// inizia da 1 per nascondere l'intestazione della tabella
		for(int g = 1; g<mList.size(); g++) {
			allParam.add(mList.get(g).getDescription());
		}
		
		// per ogni elemento dei allParam fa il parsing
		for (String item:allParam) {
			
			// parsing della descrizione, i parametri sono separati da virgole
			param = Parser.parseDescription(item);
			
			canAppend = true;

			
			try {
				// controlla se l'item è stato precedentemente aggiunto alla lista
				for(String itemCountry:country) {
					if(itemCountry.equals(param[3])) {
						canAppend = false;
					}
				}
				if(canAppend) {
					country.add(param[3]);
					page.append("<a href=" + "http://localhost:8080/selectParam0?country=" + param[3] + ">" + param[3] +"</a> <br>");
					canAppend = false;
				}
			} catch(Exception e) {}
		
		}
		return page.toString();
	}
}
