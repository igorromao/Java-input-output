package br.com.Controller;

//@author Igor Romão 

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.Model.Chamado;
import br.com.Model.Lancamento;
import br.com.Model.Status;

public class Serializar implements Serializable {
	
	PegaId consultar = new PegaId();

	


	public void Serializar(String id) {

		try {

			System.out.println("Por favor, informe o nome do arquivo a ser salvo");
			Scanner sc = new Scanner(System.in);
			String fileName = sc.next();

			FileOutputStream file = new FileOutputStream(
					"C:\\Users\\1676912\\Desktop\\Trabalho Java\\saves\\" + fileName + ".txt");

			ArrayList<Lancamento> lista = consultar.consultar(id);
			System.out.println("Tamanho Lista: " + lista.size());

			ObjectOutputStream os = new ObjectOutputStream(file);
			os.writeObject(lista);
			os.close();
			file.close();

			

		}

		catch (IOException e) {
			System.out.println("Erro informe um ID valido");
			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")//anotação que serve para impedir o compilador de emitir algumas advertências
	public void DeSerializar() {
		ArrayList<Lancamento> lista = new ArrayList<Lancamento>();
		try {
			System.out.println(" Por favor, informe o nome do arquivo a ser Carregado");
			Scanner sc = new Scanner(System.in);
			String file = sc.next();

			FileInputStream fileDir = new FileInputStream(
					"C:\\Users\\1676912\\Desktop\\Trabalho Java\\saves\\" + file + ".txt");

			ObjectInputStream is = new ObjectInputStream(fileDir);
			try {
				lista = (ArrayList) is.readObject();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Erro AO Ler Arquivo");
			}

			is.close();
			System.out.println("Arquivo Lido");

			

		} catch (IOException e) {
			System.out.println("Erro informe um ID valido");
			e.printStackTrace();

		}
		System.out.println("Leitura");
		System.out.println(lista.size());

		System.out.println("ChamadoID: " + lista.get(0).getChamado().getChamadoId());
		System.out.println("Lista DESC:" + lista.get(0).getChamado().getDescricao());
		System.out.println("Data: " + lista.get(0).getChamado().getDataFormatted());
		System.out.println("Custo: " + lista.get(0).getChamado().getCusto());
		for (Lancamento l : lista) {

			System.out.println("----Lancamento----");
			System.out.println("Data: " + l.getDataFormatted());
			System.out.println("Status: " + l.getStatus().getDescricao());
			System.out.println("-------------");

		}
	}

}
