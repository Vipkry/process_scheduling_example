package com.system;

import java.util.ArrayList;

public class Process {
	private int size = 0; // Mbytes
	private int time = 0;
	private int arrivalTime = 0;
	private int priority = 2;
	private ArrayList<Resource> resources; //<# printers >, <# scanners>, <# modems>, <# CDs>
	public int id = 0; 
		
	public Process(){
		resources = new ArrayList<Resource>();	
	}
	
	public int getPriority (){
		return this.priority;
	}
	
	public boolean setId(int id){
		if(this.id == 0){
			this.id = id;
			return true;
		}
		return false;
	}
	
	public int getId(){
		return this.id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public ArrayList<Resource> getResources() {
		return resources;
	}

	public void setResources(Resource resource) {
		if (resource.getName().equals("Printer")){
			
		}else if(resource.getName().equals("Scanner")){
			
		}else if(resource.getName().equals("Modem")){
			
		}else{
			// else is a CD driver
		}
	}

	public void setPriority(int priority) {
		this.priority = priority;
		
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
