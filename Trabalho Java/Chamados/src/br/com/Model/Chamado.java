package br.com.Model;


//@author Igor Romão 

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Chamado implements Serializable{

	public int ChamadoId;
	public String Descricao;
	public Date DataAbertura;
	public double Custo;

	public int getChamadoId() {
		return ChamadoId;
	}

	public void setChamadoId(int chamadoId) {
		ChamadoId = chamadoId;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Date getDataAbertura() {
		return DataAbertura;
	}

	public String getDataFormatted() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(this.DataAbertura);

	}

	public void setDataAbertura(Date dataAbertura) {
		DataAbertura = dataAbertura;
	}

	public double getCusto() {
		return Custo;
	}

	public void setCusto(double custo) {
		Custo = custo;
	}

	public List<Lancamento> getLstLancamento() {
		return lstLancamento;
	}

	public void setLstLancamento(List<Lancamento> lstLancamento) {
		this.lstLancamento = lstLancamento;
	}

	public List<Lancamento> lstLancamento;

}
