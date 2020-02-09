package it.rocchetti.model;

public class DataModel {
	private int id;
	private String description;
	private int[] value = new int[200];
	
	
	/** crea il modello per i dati:
	 * - id per determinare il numero della riga (id = 0 -> intestazione)
	 * - description, attributi in una sola string (parsing separato)
	 * - value, insieme dei valori, max su 200 anni
	**/
	
 	public DataModel(int id, String dataType, int[] value) {
 		this.id = id;
		this.description = dataType;
		this.value = value;
	}
 	public int getId() {
		return id;
	}
 	public void setId(int mId) {
		this.id = mId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String dataType) {
		this.description = dataType;
	}
	public int getValue(int id) {
		return value[id];
	}
	public void setValue(int value1, int index) {
		this.value[index] = value1;
	}
	public int getSize() {
		return value.length;
	}
}
