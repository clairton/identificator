package br.eti.clairton.identificator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IdentificableTest {
	final Aplicacao aplicacaoA = new Aplicacao("a");
	final Aplicacao aplicacaoB = new Aplicacao("b");
	final Recurso recursoA = new Recurso(this.aplicacaoA, "a");
	final Recurso recursoB = new Recurso(this.aplicacaoB, "b");

	@Test
	public void testHashCode() {
		assertEquals(aplicacaoA.hashCode(), new Aplicacao("a").hashCode());
		assertNotEquals(aplicacaoA.hashCode(), aplicacaoB.hashCode());
	}

	@Test
	public void testHashCodeField() {
		assertEquals(recursoA.hashCode(), new Recurso(new Aplicacao("a"), "a").hashCode());
		assertNotEquals(recursoA.hashCode(), recursoB.hashCode());
	}

	@Test
	public void testClone() throws CloneNotSupportedException {
		final Aplicacao clone = (Aplicacao) aplicacaoA.clone();
		assertEquals("a", clone.getNome());
	}

	@Test
	public void testCloneField() throws CloneNotSupportedException {
		final Recurso a = new Recurso(this.aplicacaoB, "a");
		final Recurso clone = (Recurso) a.clone();
		assertEquals("a", clone.getNome());
		assertEquals("b", clone.getAplicacao().getNome());
	}

	@Test
	public void testToStringField() {
		assertNotEquals(recursoA.toString(), new Recurso(this.aplicacaoA, "a"));
		assertEquals(recursoA.toString(), recursoA.toString());
		assertNotEquals(recursoA.toString(), recursoB.toString());
		assertTrue(recursoA.toString().endsWith("[aplicacao.nome=a,nome=a]"));
		assertTrue(recursoA.toString().startsWith("br.eti.clairton.identificator.Recurso@"));
	}

	@Test
	public void testToString() {
		assertNotEquals(aplicacaoA.toString(), new Aplicacao("a").toString());
		assertEquals(aplicacaoA.toString(), aplicacaoA.toString());
		assertNotEquals(aplicacaoA.toString(), aplicacaoB.toString());
		assertTrue(aplicacaoA.toString().endsWith("[recursos=[],nome=a]"));
		assertTrue(aplicacaoA.toString().startsWith("br.eti.clairton.identificator.Aplicacao@"));
	}

	@Test
	public void testEqualsObjectField() {
		assertFalse(recursoA.equals(recursoB));
		assertFalse(recursoA.equals(null));
		assertFalse(recursoA.equals("Qualquer outro Objeto"));
		assertTrue(recursoA.equals(new Recurso(this.aplicacaoA, "a")));
		assertTrue(recursoA.equals(recursoA));
	}

	@Test
	public void testEqualsObject() {
		assertFalse(aplicacaoA.equals(aplicacaoB));
		assertFalse(aplicacaoA.equals(null));
		assertFalse(aplicacaoA.equals("Qualquer outro Objeto"));
		assertTrue(aplicacaoA.equals(new Aplicacao("a")));
		assertTrue(aplicacaoA.equals(aplicacaoA));
	}

}
