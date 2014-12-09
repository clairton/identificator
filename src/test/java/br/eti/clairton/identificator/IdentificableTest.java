package br.eti.clairton.identificator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IdentificableTest {
	final Aplicacao a = new Aplicacao("a");
	final Aplicacao b = new Aplicacao("b");

	@Test
	public void testHashCode() {
		assertEquals(a.hashCode(), new Aplicacao("a").hashCode());
		assertNotEquals(a.hashCode(), b.hashCode());
	}

	@Test
	public void testClone() throws CloneNotSupportedException {
		final Aplicacao clone = (Aplicacao) a.clone();
		assertEquals("a", clone.getNome());
	}

	@Test
	public void testToString() {
		assertNotEquals(a.toString(), new Aplicacao("a").toString());
		assertEquals(a.toString(), a.toString());
		assertNotEquals(a.toString(), b.toString());
		assertTrue(a.toString().endsWith("[recursos=[],nome=a]"));
		assertTrue(a.toString().startsWith(
				"br.eti.clairton.identificator.Aplicacao@"));
	}

	@Test
	public void testEqualsObject() {
		assertFalse(a.equals(b));
		assertFalse(a.equals(null));
		assertFalse(a.equals("Qualquer outro Objeto"));
		assertTrue(a.equals(new Aplicacao("a")));
		assertTrue(a.equals(a));
	}

}
