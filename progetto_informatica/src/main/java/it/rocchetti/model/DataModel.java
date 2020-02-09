package it.rocchetti.model;

public class DataModel {
	private int id;
	private String description;
	private int[] value = new int[200];
	
	
	/** crea il modello per i dati:
	 * <p>
	 * - id per determinare il numero della riga (id = 0 -> intestazione)
	 * <p>
	 * - description, attributi in una sola string (parsing separato)
	 * <p>
	 * - value, insieme dei valori, max su 200 anni
	**/
	
 	public DataModel(int id, String dataType, int[] value) {
 		this.id = id;
		this.description = dataType;
		this.value = value;
	}
 	
 	/**
 	 * Ritorna l'ID della riga
 	 * @return id della riga
 	 */
 	public int getId() {
		return id;
	}
 	/**
 	 * Setta l'ID della riga
 	 * @param mId
 	 * 
 	 * 
 	 */
 	public void setId(int mId) {
		this.id = mId;
	}
 	/**
 	 * Ritorna la descrizione
 	 * @return description
 	 * 
 	 * 
 	 */
	public String getDescription() {
		return description;
	}
 	/**
 	 * Setta la descrizione
 	 * @param dataType
 	 * 
 	 * 
 	 */
	public void setDescription(String dataType) {
		this.description = dataType;
	}
 	/**
 	 * Ritorna l'array di valori 
 	 * @return value[id]
 	 * 
 	 * 
 	 */
	public int getValue(int id) {
		return value[id];
	}
 	/**
 	 * Setta il valore dell'array dato l'indice
 	 * @param value1, index
 	 * 
 	 * 
 	 */
	public void setValue(int value1, int index) {
		this.value[index] = value1;
	}
 	/**
 	 * Ritorna la lunghezza dell'array
 	 * @return value.lenght
 	 * 
 	 * 
 	 */
	public int getSize() {
		return value.length;
	}
}
