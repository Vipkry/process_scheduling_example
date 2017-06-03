/**package com.system;

import java.util.ArrayList;

import com.rowHandler.Row;

public class FeedbackScheduler2 extends Scheduler implements Runnable {
	
	private ArrayList <Row> userQueue = new ArrayList<Row>(3);
	private Processor processor;
	private Process process = null;
	private CPU freeCPU = null;
	private boolean firstQuantum = true;
	private boolean stopFlag = false;
	
	public FeedbackScheduler2 (Processor processor) {
		super();
		userQueue.add(new Row());
		userQueue.add(new Row());
		userQueue.add(new Row());
		this.processor = processor;
	}
	
	public Processor getProcessor (){
		return this.processor;
	}
	
	public Row getUserQueue (int id){
		return userQueue.get(id - 1);
	}
	
	private Process request(){
		Process process = null;

		for (int i= 0; i < userQueue.size(); i++ ){

			process = userQueue.get(i).getList().pop();
			
			// troca de fila
			if (i + 1 >= userQueue.size()) userQueue.get(0).submit(process); // caso seja a ultima fila
			else userQueue.get(i + 1).submit(process); // caso seja a primeira ou a segunda ou alguma no meio
				
			if (process != null) return process;
		}
		return null;
	}
	
	public boolean submit (Process process, int processId){
		if (process != null){
			// TODO: CHECK MEMORY SPACE
			process.setId(processId);
			getUserQueue(1).submit(process);
			return true;
		}
		return false;
	}
	
	public boolean withdraw (Process process){
		for (int i = 0; i < userQueue.size(); i ++){
			if (userQueue.get(i).remove(process)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void run (){

		if (firstQuantum){
			// ----------- First Quantum ------------
			freeCPU = this.processor.getFreeCPU();
			
			// checa se tem cpu livre
			if (freeCPU != null){
				// pega novo processo da fila
				process = this.request();
				// seta o executando do CPU como esse novo processo
				freeCPU.setExecuting(process);
			}
			
			firstQuantum = false;
		}/**else {
			
			// ----------- Second Quantum ------------
			// se n tiver interrup��o, checa se o processo j� acabou, pega outro processo caso contr�rio
			if (freeCPU != null){
				// TODO checa interrup��o do fcfs
				if (process != null){
					if (process.getTimeLeft() <= 0){
						this.withdraw(process);
						process = this.request();
						freeCPU.setExecuting(process);
					}	
					
				}
			}
			
			firstQuantum = true;
		}
		
		
		// -------- Every Quantum ---------
		
		// tenta pular o clock (� protegido pelo processor para que esteja sincronizado)
		this.processor.feedbackDone = true;
		this.processor.incrementClock();
		
		if (process != null){
			if(process.getTimeLeft() <= 0){
				this.withdraw(process);
			}
		}
		
		try {
			Thread.sleep(90);
			if (this.processor != null){
				if (this.processor.getSubmissionRow() != null){
					// checks if submission row is empty
					// checks if all queues are empty
					// TODO break execution
					if (this.processor.getSubmissionRow().size() <= 0){
						if (this.userQueue.get(0).size() <= 0 && this.userQueue.get(1).size() <= 0 && this.userQueue.get(2).size() <= 0){
								stopFlag = true;
						}
					}
				}
			}
			
			// recursive call
			if (!stopFlag)
				run ();
			else 
				System.out.println("User requests ended");
				
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}**/