package br.com.Controller;


//@author Igor Romão 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.Model.Chamado;
import br.com.Model.Lancamento;
import br.com.Model.Status;

public class LancamentosController {

	public static List<Lancamento> Carregar() throws IOException {

		FileReader fr = new FileReader("C:\\Users\\1676912\\Desktop\\Trabalho Java\\Lançamentos.csv");
		BufferedReader br = new BufferedReader(fr);

		List<Lancamento> lista = new ArrayList<Lancamento>();

		String linha = br.readLine();
		linha = br.readLine();

		while (linha != null) {

			Lancamento st = new Lancamento();

			String pattern = "dd/MM/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);

			String[] dados = linha.split(";");

			Chamado chamado = new Chamado();
			int idStatus = Integer.valueOf(dados[2]);
			chamado.setChamadoId(Integer.valueOf(dados[0]));
			st.setChamado(chamado);
			try {
				st.setDataLancamento(sdf.parse(dados[1]));
			} catch (ParseException e1) {
				e1.printStackTrace();
				System.out.println("Erro Converter Data");
			}
			try {
				List<Status> listaStatus = StatusController.Carregar();
				for (Status status : listaStatus) {
					if (idStatus == status.getStatusID()) {
						st.setStatus(status);
					}
				}

			} catch (Exception e) {
				System.out.println("Erro ao carregar lista");
				e.printStackTrace();
			}

			lista.add(st);

			linha = br.readLine();
		}

		br.close();
		fr.close();

		return lista;

	}

}
