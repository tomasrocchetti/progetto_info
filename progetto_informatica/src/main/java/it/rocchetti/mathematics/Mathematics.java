package it.rocchetti.mathematics;

import java.util.ArrayList;
import java.util.List;

import it.rocchetti.model.DataModel;
import it.rocchetti.parser.Parser;
import it.rocchetti.progetto.ProgettoApplication;

public class Mathematics {
	public static Double avgByRow(DataModel row){
		double sum = 0;
		int lenght = getValueLenght();
		int i = 0;
		int k = 0;
		while (i < lenght) {
			if(row.getValue(i) != 0) {
				sum = sum + row.getValue(i);
				k++;
			}
			i++;
		}
		
		return sum/k;
	}
	
	public static int maxByRow(DataModel row){
		int max = 0;
		int lenght = getValueLenght();
		int i = 0;
		while (i < lenght) {
			if(row.getValue(i) != 0) {
				if(row.getValue(i) > max) {
					max = row.getValue(i);
				}
			}
			i++;
		}
		
		return max;
	}
	

	
	public static int count(DataModel row){
		int lenght = getValueLenght();
		int i = 0;
		int k = 0;
		while (i < lenght) {
			if(row.getValue(i) != 0) {
				k++;
			}
			i++;
		}
		
		return k;
	}
	
	
	public static int minByRow(DataModel row){
		int min = 999;
		int lenght = getValueLenght();
		int i = 0;
		while (i < lenght) {
			if(row.getValue(i) != 0) {
				if(row.getValue(i) < min) {
					min = row.getValue(i);
				}
			}
			i++;
		}
		
		return min;
	}
	
	public static Double devStdByRow(DataModel row){
		double sum = 0.0, std = 0.0;
		int k = 0;
		int i = 0;
		int lenght = getValueLenght();
		double avg = avgByRow(row);
		while (i < lenght) {
			if(row.getValue(i) != 0) {
				std += Math.pow((row.getValue(i) - avg), 2);
				k++;
			}
			i++;
		}
		return Math.sqrt(std/k);
	}
	
	public static int getValueLenght(){
		Parser parser = new Parser();
		List<DataModel> mmV = new ArrayList<DataModel>();
		int i = 1;
		try {
			mmV = Parser.parse(ProgettoApplication.PATH);
			
			while(mmV.get(0).getValue(i) != 0) {
				i++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
}

