package br.com.Model;


//@author Igor Romão 

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lancamento implements Serializable{

	public Chamado chamado;
	public Date DataLancamento;
	public Status status;
	
	
	
	public Chamado getChamado() {
		return chamado;
	}
	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}
	public Date getDataLancamento() {
		return DataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		DataLancamento = dataLancamento;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getDataFormatted() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(this.DataLancamento);

	}	
	
}
