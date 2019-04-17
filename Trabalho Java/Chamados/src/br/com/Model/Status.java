package br.com.Model;


//@author Igor Romão 

import java.io.Serializable;

public class Status implements Serializable{

	public int StatusID;
	public String Descricao;

	public int getStatusID() {
		return StatusID;
	}

	public void setStatusID(int statusID) {
		StatusID = statusID;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	

}
