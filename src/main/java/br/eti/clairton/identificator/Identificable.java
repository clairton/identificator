package br.eti.clairton.identificator;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.eti.clairton.identificator.Identificator.Type;
import net.vidageek.mirror.dsl.Mirror;
import net.vidageek.mirror.list.dsl.Matcher;
import net.vidageek.mirror.list.dsl.MirrorList;

public class Identificable implements Cloneable {
	private transient final static Mirror MIRROR = new Mirror();
	private transient final static ToStringStyle STYLE = new ToStringStyle() {
		private static final long serialVersionUID = 1L;

		@Override
		protected boolean isUseClassName() {
			return Boolean.FALSE;
		}

		@Override
		protected boolean isUseShortClassName() {
			return Boolean.TRUE;
		}

		protected boolean isUseIdentityHashCode() {
			return Boolean.TRUE;
		};
	};

	/**
	 * Clona o objeto.
	 * {@inheritDoc}.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final HashCodeBuilder builder = new HashCodeBuilder();
		for (final Field field : retrieveFields(Type.HASHCODE)) {
			final Object value = MIRROR.on(this).get().field(field);
			final Identificator identificator = field.getAnnotation(Identificator.class);
			if (identificator.field().length > 0 && value != null) {
				for (final String f : identificator.field()) {
					final Object v = MIRROR.on(value).get().field(f);
					builder.append(v);
				}
			} else {
				builder.append(value);
			}

		}
		return builder.toHashCode();
	}

	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this, STYLE);
		for (final Field field : retrieveFields(Type.TO_STRING)) {
			final Object value = MIRROR.on(this).get().field(field);
			final String name = field.getName();
			final Identificator identificator = field.getAnnotation(Identificator.class);
			if (identificator.field().length > 0 && value != null) {
				for (final String f : identificator.field()) {
					final Object v = MIRROR.on(value).get().field(f);
					builder.append(name + "." + f, v);
				}
			} else {
				builder.append(name, value);
			}
		}
		return builder.toString();
	}

	@Override
	public boolean equals(final Object obj) {
		if (getClass().isInstance(obj)) {
			final EqualsBuilder builder = new EqualsBuilder();
			for (final Field field : retrieveFields(Type.EQUALS)) {
				final Object lhs = MIRROR.on(this).get().field(field);
				final Object rhs = MIRROR.on(obj).get().field(field);
				final Identificator identificator = field.getAnnotation(Identificator.class);
				if (identificator.field().length > 0) {
					for (final String f : identificator.field()) {
						final Object l;
						if (lhs != null) {
							l = MIRROR.on(lhs).get().field(f);
						} else {
							l = null;
						}
						final Object r;
						if (rhs != null) {
							r = MIRROR.on(rhs).get().field(f);
						} else {
							r = null;
						}
						builder.append(l, r);
					}
				} else {
					builder.append(lhs, rhs);
				}
			}
			return builder.isEquals();
		}
		return Boolean.FALSE;
	}

	private MirrorList<Field> retrieveFields(final Type type) {
		return MIRROR.on(getClass()).reflectAll().fields().matching(new MatcherField(type));
	}

	private static class MatcherField implements Matcher<Field> {
		private final Type type;

		public MatcherField(final Type type) {
			super();
			this.type = type;
		}

		@Override
		public boolean accepts(final Field element) {
			if (!element.isAnnotationPresent(Identificator.class)) {
				return false;
			} else {
				final Identificator identificator = element.getAnnotation(Identificator.class);
				return Arrays.asList(identificator.value()).contains(type);
			}
		}

	}

}
