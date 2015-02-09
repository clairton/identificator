package br.eti.clairton.identificator;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlAnyAttribute;

/**
 * Representa uma Aplicação.
 * 
 * @author Clairton Rodrigo Heinzen<clairton.rodrigo@gmail.com>
 */
public class Aplicacao extends Identificable implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Identificator Collection<String> recursos = new HashSet<String>();

	private @Identificator String nome;

	/*
	 * Atributo que server somente para testar os metodos equals, hashCode e
	 * toString
	 */
	@XmlAnyAttribute
	private final Long transientField = new Date().getTime();

	/**
	 * Construtor padrão.
	 */
	@Deprecated
	protected Aplicacao() {
	}

	/**
	 * Construtor com argumentos.
	 * 
	 * @param nome
	 *            nome da aplicação
	 * @param recursos
	 *            recursos da aplicação
	 */
	public Aplicacao(final String nome, final Collection<String> recursos) {
		super();
		this.nome = nome;
		adicionar(recursos);
	}

	/**
	 * Construtor com argumentos.
	 * 
	 * @param nome
	 *            nome da aplicação
	 * @param recurso
	 *            recurso da aplicação
	 */
	public Aplicacao(final String nome, final String recurso) {
		this(nome, Arrays.asList(recurso));
	}

	/**
	 * Construtor com parametros.
	 * 
	 * @param nome
	 *            da aplicação
	 */
	public Aplicacao(final String nome) {
		this(nome, Collections.<String> emptyList());
	}

	public void adicionar(String recurso) {
		recursos.add(recurso);
	}

	public void adicionar(Collection<String> recursos) {
		this.recursos.addAll(recursos);
	}

	public void remover(String recurso) {
		recursos.remove(recurso);
	}

	public Collection<String> getRecursos() {
		return Collections.unmodifiableCollection(recursos);
	}

	public String getNome() {
		return nome;
	}
}
