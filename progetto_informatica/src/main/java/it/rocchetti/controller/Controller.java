package it.rocchetti.controller;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.rocchetti.deleter.Deleter;
import it.rocchetti.mathematics.Mathematics;
import it.rocchetti.model.DataModel;
import it.rocchetti.parser.Parser;
import it.rocchetti.progetto.ProgettoApplication;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@RestController
public class Controller {
	/**
	* Restituisce la lista delle nazioni, al click su una di esse viene fatto scegliere
	* un parametro relativo a qulla nazione
	* @return nazione
	*/
	@GetMapping("/country")
	public String country() throws Exception {
		StringBuilder page = new StringBuilder("Di seguito viene riportata la lista delle nazioni presenti nella tabella, sceglierne una: <br>");// crea un oggetto di tipo Parser per fare il parsing della tabella
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
			} catch(Exception e) {
				System.err.println("impossibile verificare un item");
			}
		}
		return page.toString();
	}
	
	/**
	* Restituisce la lista dei parametri 0 di una nazione, al click su una di esse viene fatto scegliere
	* il parametro 1
	* @param nazione
	* @return nazione, parametro0
	*/
	@GetMapping("/selectParam0")
	public String selectParam0(@RequestParam(name="country", defaultValue="0") String mCountry) throws Exception {
		
		StringBuilder page = new StringBuilder("Lista degli attributi per: <b>" + mCountry + "</b><br>");
	
		
		// lista di oggetti DataModel = tabella completa
		List<DataModel> mList = new ArrayList<DataModel>();
		// lista dei parametri 0
		List<String> param0 = new ArrayList<String>();
		
		// parsing del file e copia dei dati in mList
		mList = Parser.parse(ProgettoApplication.PATH);
		
		// lista di tutti i parametri non parsati
		List<String> allParam = new ArrayList<String>();
		
		// per ogni elemento della lista prende i parametri e li mette in una lista dedicata
		for(int g = 0; g<mList.size(); g++) {
			allParam.add(mList.get(g).getDescription());
		}
		
		boolean canAppend = true;
		
		String[] param = {"","","",""};
		
		// scorre tutta la lista che contiene i parametri e fa il parsing
		for (String item:allParam) {
			canAppend = true;
			param = Parser.parseDescription(item);
			
			try {
			// se il parametro corrisponde al parametro precedente desiderato lo aggiungo alla lista
			// evitando di scrivere doppioni
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
			}catch(Exception e) {
				System.err.println("impossibile verificare un item");
			}
		}
		return page.toString();
	}
	
	/**
	* Restituisce la lista dei parametri 1 di una nazione, al click su una di esse viene fatto scegliere
	* il parametro 1
	* @param nazione, parametro0
	* @return nazione, parametro0, parametro1
	*/
	@GetMapping("/selectParam1")
	public String selectParam1(@RequestParam(name="value", defaultValue="0") String mCountryP0) throws Exception {
		
		StringBuilder page = new StringBuilder("Lista degli attributi per: <b>" + mCountryP0 + "</b><br>");
		
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
			}catch(Exception e) {
				System.err.println("impossibile verificare un item");
			}
		}
		return page.toString();
	}
	/**
	* Restituisce la lista dei parametri 2 di una nazione, al click su una di esse viene fatto scegliere
	* il parametro 1
	* @param nazione, parametro0, parametro1
	* @return nazione, parametro0, parametro1, parametro2
	*/
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
			}catch(Exception e) {
				System.err.println("impossibile verificare un item");
			}
		}
		return page.toString();
	}
	/**
	* Dati tutti i parametri trova il record con essi e restituisce i vari calcoli fatti sui valori
	* inoltre restituisce una stringa in json contenente i parametri da incollare in postman
	* per testare le richieste POST
	* @param nazione, parametro0, parametro1, parametro2
	* @return calcoli e json con tutti i parametri
	*/
	@GetMapping("/selectRow")
	public String selectRowId(@RequestParam(name="value", defaultValue="0") String mParam) throws Exception {
		// id per contare le righe
		int id = 0;
		// array in cui finiranno i parametri ricevuti splittati
		String[] param = {"","","",""};
		// splitta i parametri CSV e li mette in param
		param = Parser.parseDescription(mParam);
		// lista contenente tutti i record della tabella
		List<DataModel> mmV = new ArrayList<DataModel>();
		// fa il parsing del file e lo mette nella lista
		mmV = Parser.parse(ProgettoApplication.PATH);
		// controlla quale record corrisponde ai parametri ricevuti e ne salva l'id
		for(int g = 0; g<mmV.size(); g++) {
			if(mmV.get(g).getDescription().equals(mParam)) {
				id = mmV.get(g).getId();
			}
		}
		
		// crea un oggetto Json con tutti i parametri
		JSONObject j = new JSONObject();
		j.put("Country",param[3]);
		j.put("Parametro_0",param[0]);
		j.put("Parametro_1",param[1]);
		j.put("Parametro_2",param[2]);
		StringWriter out = new StringWriter();
	    j.writeJSONString(out);
	    // converte il json in String
	    String jsonText = out.toString();
	    
	    // String builder per generare l'interfaccia Web
	    StringBuilder sBuild = new StringBuilder();
	    sBuild.append("In questa pagina vengono eseguiti i vari calcoli sulla riga della tabella seleizionata e viene creata una comda stringa JSON da copiare e incollare in PostMan <br>");
	    sBuild.append("<br>");
	    sBuild.append("Parametro_0:		<b>" + param[0] + "</b><br>");
	    sBuild.append("Parametro_1:		<b>" + param[1] + "</b><br>");
	    sBuild.append("Parametro_2:		<b>" + param[2] + "</b><br>");
	    sBuild.append("Country:		<b>" + param[3] + "</b><br>");
	    sBuild.append("<br>");
	    sBuild.append("ROW:		<b>" + id + "</b><br>");
	    sBuild.append("MIN:		<b>" + Mathematics.minByRow(mmV.get(id)) + "</b><br>");
	    sBuild.append("MAX:		<b>" + Mathematics.maxByRow(mmV.get(id)) + "</b><br>");
	    sBuild.append("AVG:		<b>" + Mathematics.avgByRow(mmV.get(id)) + "</b><br>");
	    sBuild.append("DEV:		<b>" + Mathematics.devStdByRow(mmV.get(id)) + "</b><br>");
	    sBuild.append("CNT:		<b>" + Mathematics.count(mmV.get(id)) + "</b><br>");
	    sBuild.append("<br>");
	    sBuild.append("Copia in PostMan: <br>");
	    sBuild.append(jsonText);
	    
		return sBuild.toString();
	}
	/**
	* Dato un json con tutti i parametri in ingresso cerca il record corretto e restituisce tutti i calcoli in json
	* @param json(nazione, parametro0, parametro1, parametro2)
	* @return json(ROW, MIN, MAX, AVG, DEV, CNT)
	*/
	@PostMapping("/selectRowByParameters")
	public String selectRowByParameters(@RequestBody String body) throws Exception {
		
		
		// fa il parsing della stringa body e la mette nell'oggetto Json
		JSONParser jParser = new JSONParser();
		JSONObject json = new JSONObject();
		boolean parsingError = false;
		String jsonText = "";
		try {
			json = (JSONObject) jParser.parse(body);
			
	
			// String builder per ottenere i dati del json
			StringBuilder createDescription = new StringBuilder();
			createDescription.append(json.get("Parametro_0").toString());
			createDescription.append(",");
			createDescription.append(json.get("Parametro_1").toString());
			createDescription.append(",");
			createDescription.append(json.get("Parametro_2").toString());
			createDescription.append(",");
			createDescription.append(json.get("Country").toString());
			// id della riga
			int id = 0;
			
			// converte lo string builder in string
			String stringDescription = createDescription.toString(); 
			List<DataModel> mmV = new ArrayList<DataModel>();
			try {
				mmV = Parser.parse(ProgettoApplication.PATH);
			} catch (Exception e) {
				System.err.println("Impossibile effettuare il parsing, stringa inserita in formato non corretto");
				parsingError = true;
			}
			// controlla quale record ha le caratteristiche richieste e memorizza l'id
			for(int g = 0; g<mmV.size(); g++) {
				if(mmV.get(g).getDescription().equals(stringDescription)) {
					id = mmV.get(g).getId();
				}
			}
			JSONObject j = new JSONObject();
			if(id == 0) {
				j.put("ROW", "ND");
				j.put("MIN", "ND"); 
				j.put("MAX", "ND");
				j.put("AVG", "ND");
				j.put("DEV", "ND");
				j.put("CNT", "ND");
			}
			else {
				j.put("ROW", id);
				j.put("MIN",Mathematics.minByRow(mmV.get(id))); 
				j.put("MAX",Mathematics.maxByRow(mmV.get(id)));
				j.put("AVG",Mathematics.avgByRow(mmV.get(id)));
				j.put("DEV",Mathematics.devStdByRow(mmV.get(id)));
				j.put("CNT",Mathematics.count(mmV.get(id)));
			}
			// restituisce i vari calcoli in formato Json
			// utilizzando la libreria simple json

			jsonText = j.toString();
		}
		catch(Exception e){
			parsingError = true;
		}
		// controlla se ci sono stati errori nel parsin della string ainserita e modifica l'output 
		if (parsingError) {
			jsonText = "Stringa inserita in formato errato";
		}
		return jsonText;
	}
	/**
	* Dato uno o piu parametri elimina tutte le righe con quei parametri
	* @param parametro da eliminare
	*/
	@DeleteMapping("/deleteRow")
	public String deleteRow(@RequestParam(name="value", defaultValue="") String paramToDelete) throws Exception {
		// nuovo oggetto della classe delete
		Deleter deleter = new Deleter();
		// stringa per informare dell'avvenuta eliminazione
		String result = "Valore inserito non valido";
		// elimina la lista con i parametri scelti
		if (deleter.delete(paramToDelete)) {
			result = "Tutti gli elementi che contengono " + paramToDelete + " sono stati eliminati";
		}
		return result;
	}
}
