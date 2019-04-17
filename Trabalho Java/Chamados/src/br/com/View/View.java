package br.com.View;
//@author Igor Romão 

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.Controller.ChamadoController;
import br.com.Controller.LancamentosController;
import br.com.Controller.PegaId;
import br.com.Controller.Serializar;
import br.com.Controller.StatusController;
import br.com.Model.Chamado;
import br.com.Model.Lancamento;
import br.com.Model.Status;

public class View {

	public static void main(String args[]) throws ParseException {

		Serializar zeri = new Serializar(); // criando objeto da classe Serializar
		PegaId pegaid = new PegaId();
		
		
		
		
		JOptionPane.showMessageDialog(null,"Bem vindo ao Sistema de Consulta de Chamado ");
		JOptionPane.showMessageDialog(null,"Digite: 1 para consulta/ 2 salvar arquivo/ 3 carregar arquivo/ 4 sair ");
		

		boolean check = true; // criacao tipo false ou true para sair do laco ou voltar (do)
		do {
			Scanner in = new Scanner(System.in); // criando o scanner
			System.out.println("Opcao:"); // pedindo para digitar a opca do switch
			int opc = in.nextInt(); // lendo a opcao digitada
			String id = "";
			
			
			switch (opc) {
			case 1:
				id = pegaid.getId(); // chamando o metodo id
				pegaid.consultar(id); // chamando o metodo consultar

				break;
			case 2:
				id = pegaid.getId();
				zeri.Serializar(id);

				break;

			case 3:
				zeri.DeSerializar();
				break;

			case 4:
				JOptionPane.showMessageDialog(null, "Encerrado");
				check = false;
				break;

			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção valida");
				break;
			}
		} while (check == true); //

	}

}
