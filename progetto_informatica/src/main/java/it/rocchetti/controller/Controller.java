package it.rocchetti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.rocchetti.mathematics.Mathematics;
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
	
	@GetMapping("/selectParam0")
	public String selectParam0(@RequestParam(name="country", defaultValue="0") String mCountry) throws Exception {
		
		StringBuilder page = new StringBuilder("Lista degli attributi per: <b>" + mCountry + "</b><br>");
		
		// crea un oggetto di tipo Parser per fare il parsing della tabella
		Parser parser = new Parser();
		parser.parse(ProgettoApplication.PATH);
		
		// lista di oggetti DataModel = tabella completa
		List<DataModel> mList = new ArrayList<DataModel>();
		
		List<String> param0 = new ArrayList<String>();
		
		mList = Parser.parse(ProgettoApplication.PATH);
		
		List<String> allParam = new ArrayList<String>();
		for(int g = 0; g<mList.size(); g++) {
			allParam.add(mList.get(g).getDescription());
		}
		
		boolean canAppend = true;
		
		String[] param = {"","","",""};
		
		for (String item:allParam) {
			canAppend = true;
			param = Parser.parseDescription(item);
			
			try {
			if(param[3].equals(mCountry)) {
				for(String p0:param0) {
					if(p0.equals(param[0])) {
						canAppend = false;
						
					}
				}
					if(canAppend) {
						param0.add(param[0]);
						page.append("<a href=" + "http://localhost:8080/selectParam1?value=" + param[0] + "," + param[3] + ">" + param[0] +"</a> <br>");
						canAppend = false;
					}
			
		}
			}catch(Exception e) {}
		}
		return page.toString();
	}
	
	@GetMapping("/selectParam1")
	public String selectParam1(@RequestParam(name="value", defaultValue="0") String mCountryP0) throws Exception {
		
		StringBuilder page = new StringBuilder("Lista degli attributi per: <b>" + mCountryP0 + "</b><br>");
		
		// crea un oggetto di tipo Parser per fare il parsing della tabella
		Parser parser = new Parser();
		parser.parse(ProgettoApplication.PATH);
		
		// lista di oggetti DataModel = tabella completa
		List<DataModel> mList = new ArrayList<DataModel>();
		
		List<String> param1 = new ArrayList<String>();
		
		mList = Parser.parse(ProgettoApplication.PATH);
		
		List<String> allParam = new ArrayList<String>();
		for(int g = 0; g<mList.size(); g++) {
			allParam.add(mList.get(g).getDescription());
		}
		
		boolean canAppend = true;
		
		String[] param = {"","","",""};
		String[] splittedValue = {"","","",""};
		
		// splitta i valori in ingresso
		splittedValue = Parser.parseDescription(mCountryP0);
		
		for (String item:allParam) {
			canAppend = true;
			param = Parser.parseDescription(item);
			
			try {
			if(param[0].equals(splittedValue[0]) && param[3].equals(splittedValue[1])) {
				for(String p1:param1) {
					if(p1.equals(param[1])) {
						canAppend = false;
						
					}
				}
					if(canAppend) {
						param1.add(param[1]);
						page.append("<a href=" + "http://localhost:8080/selectParam2?value=" + param[0] + "," + param[1] + "," + param[3] + ">" + param[1] +"</a> <br>");
						canAppend = false;
					}
			
		}
			}catch(Exception e) {}
		}
		return page.toString();
	}
	
	@GetMapping("/selectParam2")
	public String selectParam2(@RequestParam(name="value", defaultValue="0") String mCountryP0P1) throws Exception {
		
		StringBuilder page = new StringBuilder("Lista degli attributi per: <b>" + mCountryP0P1 + "</b><br>");
		
		// crea un oggetto di tipo Parser per fare il parsing della tabella
		Parser parser = new Parser();
		parser.parse(ProgettoApplication.PATH);
		
		// lista di oggetti DataModel = tabella completa
		List<DataModel> mList = new ArrayList<DataModel>();
		
		List<String> param2 = new ArrayList<String>();
		
		mList = Parser.parse(ProgettoApplication.PATH);
		
		List<String> allParam = new ArrayList<String>();
		for(int g = 0; g<mList.size(); g++) {
			allParam.add(mList.get(g).getDescription());
		}
		
		boolean canAppend = true;
		
		String[] param = {"","","",""};
		String[] splittedValue = {"","","",""};
		
		// splitta i valori in ingresso
		splittedValue = Parser.parseDescription(mCountryP0P1);
		
		for (String item:allParam) {
			canAppend = true;
			param = Parser.parseDescription(item);
			
			try {
			if(param[0].equals(splittedValue[0]) && param[1].equals(splittedValue[1]) && param[3].equals(splittedValue[2])) {
				for(String p2:param2) {
					if(p2.equals(param[2])) {
						canAppend = false;
						
					}
				}
					if(canAppend) {
						param2.add(param[2]);
						page.append("<a href=" + "http://localhost:8080/selectRow?value=" + param[0] + "," + param[1] + "," + param[2] + "," + param[3] + ">" + param[2] +"</a> <br>");
						canAppend = false;
					}
			
		}
			}catch(Exception e) {}
		}
		return page.toString();
	}
	
	@GetMapping("/selectRow")
	public String selectRowId(@RequestParam(name="value", defaultValue="0") String param) throws Exception {
		int id = 0;
		int value[];
		Parser parser = new Parser();
		List<DataModel> mmV = new ArrayList<DataModel>();
		mmV = Parser.parse(ProgettoApplication.PATH);
		for(int g = 0; g<mmV.size(); g++) {
			if(mmV.get(g).getDescription().equals(param)) {
				id = mmV.get(g).getId();
			}
		}
		return "Row: " + id + "<br>"
		+ "AVG = " + Mathematics.avgByRow(mmV.get(id)) + "<br>"
				+ "MIN = " + Mathematics.minByRow(mmV.get(id)) + "<br>"
						+ "MAX = " + Mathematics.maxByRow(mmV.get(id)) + "<br>"
								+ "DEV = " + Mathematics.devStdByRow(mmV.get(id)) + "<br>"
											+ "CNT = " + Mathematics.count(mmV.get(id)) + "<br>";
	}
}
