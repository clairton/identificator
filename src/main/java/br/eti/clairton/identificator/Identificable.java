package br.eti.clairton.identificator;

import java.lang.reflect.Field;
import java.util.Arrays;

import net.vidageek.mirror.dsl.Mirror;
import net.vidageek.mirror.list.dsl.Matcher;
import net.vidageek.mirror.list.dsl.MirrorList;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.eti.clairton.identificator.Identificator.Type;

public class Identificable implements Cloneable {
	private final static Mirror mirror = new Mirror();
	private final static ToStringStyle STYLE = new ToStringStyle() {
		private static final long serialVersionUID = 1L;

		@Override
		protected boolean isUseClassName() {
			return Boolean.FALSE;
		}

		@Override
		protected boolean isUseShortClassName() {
			return Boolean.TRUE;
		}
	};

	/**
	 * Clona o objeto. {@inheritDoc}.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final HashCodeBuilder builder = new HashCodeBuilder();
		for (final Field field : retrieveFields(Type.HASHCODE)) {
			final Object value = mirror.on(this).get().field(field);
			builder.append(value);
		}
		return builder.toHashCode();
	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this, STYLE);
		for (final Field field : retrieveFields(Type.TO_STRING)) {
			final Object value = mirror.on(this).get().field(field);
			final String name = field.getName();
			builder.append(name, value);
		}
		return builder.toString();
	}

	@Override
	public boolean equals(final Object obj) {
		if (getClass().isInstance(obj)) {
			final EqualsBuilder builder = new EqualsBuilder();
			for (final Field field : retrieveFields(Type.EQUALS)) {
				final Object lhs = mirror.on(this).get().field(field);
				final Object rhs = mirror.on(obj).get().field(field);
				builder.append(lhs, rhs);
			}
			return builder.isEquals();
		}
		return Boolean.FALSE;
	}

	private MirrorList<Field> retrieveFields(final Type type) {
		return mirror.on(getClass()).reflectAll().fields()
				.matching(new MatcherField(type));
	}

	private static class MatcherField implements Matcher<Field> {
		private final Type type;

		public MatcherField(Type type) {
			super();
			this.type = type;
		}

		@Override
		public boolean accepts(final Field element) {
			if (!element.isAnnotationPresent(Identificator.class)) {
				return false;
			} else {
				Identificator identificator = element
						.getAnnotation(Identificator.class);
				return Arrays.asList(identificator.value()).contains(type);
			}
		}

	}

}
