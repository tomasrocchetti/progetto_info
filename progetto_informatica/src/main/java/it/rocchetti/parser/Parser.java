package it.rocchetti.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import it.rocchetti.model.DataModel;

public class Parser {
	
	public static Vector<DataModel> parse(String path) throws Exception {
		
		// oggetto di tipo DataModel, ogni riga della tabella è un oggetto
		DataModel dataObj;
		// lista delle righe = tabella
		Vector <DataModel> mList = new Vector<DataModel>(20000);
		// array che contiene i valori di ogni riga (max 200)
		int[] valueArray;
		// conta tutte le righe, servirà per associare un id alla riga
		int k = 0;
		
        StringTokenizer st ;
        BufferedReader TSVFile = new BufferedReader(new FileReader(path));
        String dataRow = TSVFile.readLine(); // Read first line.
        
        // scorre il file riga per riga finchè non ne trova una nulla
        while (dataRow != null){
        	valueArray = new int[200];
        	
            st = new StringTokenizer(dataRow);
            List<String>dataArray = new ArrayList<String>() ;
            
            // splitta i record di ogni riga
            while(st.hasMoreElements()){
                dataArray.add(st.nextElement().toString());
            }
            
            // crea un oggetto di tipo DataModel che verrà poi aggiunto alla lista mList
            dataObj = new DataModel(0, null, new int[200]);
            int n = 0;
          
            for (String item:dataArray) {
            
            	// rimuove da ogni item i caratteri che potrebbero creare problemi 
            	// in modo da uniformare la tabella
            	item = item.replaceAll("\\s", "");
            	item = item.replaceAll("\t", "");
            	item = item.replaceAll("\n", "");
            	item = item.replaceAll("u", "NOT_DEFINED");	
            	item = item.replaceAll(":", "NOT_DEFINED");
            	
            	//inserisce gli item nell'oggetto di tipo DataModel separando Indice e Valore
                if (n == 0) {
                	// quando n == 0 significa che il valore contiene la descrizione degli attributi
                	dataObj.setDescription(item);
               
                } else {
                	// quando n != 0 il valore contiene i dati
                	try {
                		valueArray[n-1] = Integer.parseInt(item);
                		dataObj.setValue(valueArray[n-1], n-1);
					} catch (Exception e) {
						dataObj.setValue(1, n-1);
					}
                }
                n++;       
            }
            
            dataObj.setId(k);
            mList.add(k, dataObj);
            k++;
            // legge la prossima riga
            dataRow = TSVFile.readLine();
        }
        // chiude il file terminata la scrittura
        TSVFile.close();
		return mList;
    }
	
	public static String[] parseDescription(String item) throws Exception{		
		// variabile che conterrà i parametri parsati
		String[] param = {"","","",""};
		
		param = item.split(",");
		return param;
	}


}