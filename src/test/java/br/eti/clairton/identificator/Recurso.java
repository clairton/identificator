package br.eti.clairton.identificator;

public class Recurso extends Identificable {
	private @Identificator(field = { "nome" }) Aplicacao aplicacao;

	private @Identificator String nome;

	public Recurso(final Aplicacao aplicacao, final String nome) {
		super();
		this.aplicacao = aplicacao;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Aplicacao getAplicacao() {
		return aplicacao;
	}
}
