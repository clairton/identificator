package br.eti.clairton.identificator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Identificator {
	Type[]value() default { Type.TO_STRING, Type.HASHCODE, Type.EQUALS };

	String[]field() default {};

	enum Type {
		TO_STRING, HASHCODE, EQUALS
	}
}
