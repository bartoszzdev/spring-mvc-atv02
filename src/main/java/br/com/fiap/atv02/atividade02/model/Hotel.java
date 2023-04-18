package br.com.fiap.atv02.atividade02.model;

public class Hotel {

	private String nome;
	private String endereco;
	private double valorDiaria;
	private int classificacao;
	
    public Hotel(String nome, String endereco, double valorDiaria, int classificacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.valorDiaria = valorDiaria;
        this.classificacao = classificacao;
    }

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getValorDiaria() {
		return this.valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public int getClassificacao() {
		return this.classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

}
