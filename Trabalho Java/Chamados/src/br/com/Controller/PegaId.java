package br.com.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.Model.Chamado;
import br.com.Model.Lancamento;
import br.com.Model.Status;

public class PegaId {
	
	
	

		public String getId() {

			System.out.println("Informe O ID : ");
			Scanner sc = new Scanner(System.in);
			String id = sc.next();
			return id;

		}


	
	
	public ArrayList<Lancamento> consultar(String id) {
		ArrayList<Lancamento> listaStream = new ArrayList<Lancamento>();
		ChamadoController ch = new ChamadoController(); // criando objeto da chamadaController
		LancamentosController lancamentoController = new LancamentosController(); // criando objeto de lancamentos
		StatusController statusController = new StatusController(); // criando objeto da status

		try { // adicionando um try para tratamento de exceções
			List<Chamado> lista = ch.Carregar();
			List<Lancamento> listaLancamento = lancamentoController.Carregar(); // uma lista de lancamentos e chamando o
																				// carregar
			List<Status> listaStatus = statusController.Carregar();
			for (Chamado c : lista) { // percorrendo a lista com o chamado
				if (c.getChamadoId() == Integer.valueOf(id)) { // se o chamado id for igual o solicitado chamar
																// id,descricao da lista e etc
					System.out.println("ID:" + c.getChamadoId());
					System.out.println("Lista DESC:" + c.getDescricao());
					System.out.println("Data: " + c.getDataFormatted());
					System.out.println("Custo: " + c.getCusto());

					for (Lancamento l : listaLancamento) {

						if (l.getChamado().getChamadoId() == c.getChamadoId()) {
							l.setChamado(c);
							System.out.println("----Lancamento----");
							System.out.println("Data: " + l.getDataFormatted());

							System.out.println("Size ListaStream: " + listaStream.size());

							for (Status s : listaStatus) {

								if (l.getStatus().getStatusID() == s.getStatusID()) {
									l.setStatus(s);
									System.out.println("Status: " + s.getDescricao());
									System.out.println("-------------");
								}
							}
							listaStream.add(l);
						}

					}

				}
			}
		} catch (Exception e) {

			System.out.println("Informe Um ID Válido2");
			
			e.printStackTrace();
		}
		return listaStream;
	}

	
	
	
}
