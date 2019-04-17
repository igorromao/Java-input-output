package br.com.Controller;


//@author Igor Romão 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.Model.Chamado;
import br.com.Model.Lancamento;

public class ChamadoController {

	public List<Chamado> Carregar() throws IOException {

		FileReader fr = new FileReader("C:\\Users\\1676912\\Desktop\\Trabalho Java\\Chamados.csv");
		BufferedReader br = new BufferedReader(fr);

		List<Chamado> lista = new ArrayList<Chamado>();
		List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		lancamentos = LancamentosController.Carregar();
		List<Lancamento> lancamentosChamado = new ArrayList<>();

		String linha = br.readLine();
		linha = br.readLine();

		while (linha != null) {

			Chamado st = new Chamado();

			String[] dados = linha.split(";");

			st.ChamadoId = Integer.parseInt(dados[0]);
			st.Descricao = dados[1];
			String data = dados[2];
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = sdf.parse(dados[2]);
				st.DataAbertura = date;
			} catch (ParseException e1) {
				System.out.println("Erro Converter DAta");
				e1.printStackTrace();
			}
			st.Custo = Double.parseDouble(dados[3]);

			lista.add(st);

			linha = br.readLine();
		}

		br.close();
		fr.close();

		return lista;

	}

}
