package it.consorzioinnovo.webapp.services;

import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImplementation implements MainServiceInterface{
	public static List<String> todos = new ArrayList<>(List.of("Stefano","Davide","Gabriele"));
	
	private Logger logger = LoggerFactory.getLogger(MainServiceImplementation.class);
	
	
	/*public String firstService(double[] array) {
		Double mul= 1d;
		for (int i=0; i<array.length; i++) {
			mul = mul* array[i];
		}
		return "Il risultato è: " + Math.round(mul);
	}*/



	@Override
	public String inserimento(String todo) {
		// TODO Auto-generated method stub
		//Scanner input = new Scanner(System.in);
		//System.out.println("Inserisci il tuo nome: ");
		//String name = input.nextLine();
		String todoUpd = format(todo);
		String resp = "";
		if( todos.contains(todoUpd) ) {
			resp += "Elemento non aggiunto, già presente.<br/>";
		}else {
			todos.add(todoUpd);		
		}
		resp += "Elementi aggiunti: " + todos;
		logger.info(todos.toString());
		
		return resp;
		//input.close();
	}



	@Override
	public List<String> lettura() {
		// TODO Auto-generated method stub
		return todos;
	}



	@Override
	public String modifica(int pos, String todo) {
		// TODO Auto-generated method stub
		String txt = "";
		//controllo prima lettera maiuscola del valore inserito
		String todoUpd = format(todo);
		try {
			todos.set(pos, todoUpd);
			txt += "Elemento modificato correttamente: " + todos;
			
		}/*catch(UnsupportedOperationException e) {
			txt += e.getMessage();
		}catch(ClassCastException e) {
			txt += e.getMessage();
		}catch(NullPointerException e) {
			txt += e.getMessage();
		}catch(IllegalArgumentException e) {
			txt += e.getMessage();
		}catch(IndexOutOfBoundsException e) {
			txt += e.getMessage();
		}*/catch(Exception e) {
			
			txt += e.getMessage();
			txt += "<br/>"+todos;
		}finally {
			txt+="<br/>Finally eseguito";
		}
		return txt;
	}



	@Override
	public void eliminazione(int pos) {
		// TODO Auto-generated method stub
		 todos.remove(pos);
		    System.out.println("Eliminazione effettuata:");
		    System.out.println(todos);
	}
	
	@Override
	public String eliminazionePerTodo(String todo) {
		String testo = "";
		String todoUpd = format(todo);
		
		if(todos.remove(todoUpd)) {
			testo += "Elemento eliminato!<br/>" + todos;
		}else {
			return "Elemento non trovato: " + todos;
		}
		logger.info(todos.toString());
		return testo;
	}
	
	private String format(String todo) {
		return todo.substring(0,1).toUpperCase() + todo.substring(1,todo.length()).toLowerCase();
	}
}
