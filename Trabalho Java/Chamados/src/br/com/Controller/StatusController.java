package br.com.Controller;

//@author Igor Romão 


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.Model.Status;

public class StatusController {
	
	
public static List<Status> Carregar() throws IOException {
		
		FileReader fr = new FileReader("C:\\Users\\1676912\\Desktop\\Trabalho Java\\Status.csv");
		BufferedReader br = new BufferedReader(fr);
		
		List<Status> lista = new ArrayList<Status>();
		
		String linha = br.readLine();
		linha = br.readLine();
		
		while (linha != null) {
						
			Status st = new Status();
			
			String[] dados = linha.split(";");
			
			st.StatusID = Integer.parseInt(dados[0]);
			st.Descricao = dados[1];
			
			lista.add(st);
			
			linha = br.readLine();
		}
		
		br.close();
		fr.close();
		
		return lista;
		
		
	}

}
