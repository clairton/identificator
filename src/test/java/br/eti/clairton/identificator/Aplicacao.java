package br.eti.clairton.identificator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

public class Aplicacao extends Identificable{
	
	private @Identificator Collection<String> recursos = new HashSet<String>();

	private @Identificator String nome;

	private final Long transientField = new Date().getTime();

	@Deprecated
	protected Aplicacao() {
	}

	public Aplicacao(final String nome, final Collection<String> recursos) {
		super();
		this.nome = nome;
		this.recursos = recursos;
	}

	public Aplicacao(final String nome, final String recurso) {
		this(nome, Arrays.asList(recurso));
	}

	public Aplicacao(final String nome) {
		this(nome, Collections.<String> emptyList());
	}

	public String getNome() {
		return nome;
	}
	
	public Long getTransientField() {
		return transientField;
	}
}
