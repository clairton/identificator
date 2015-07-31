# identificator [![Build Status](https://drone.io/github.com/clairton/identificator/status.png)](https://drone.io/github.com/clairton/identificator/latest)
Helper para ajudar na implementação de hashCode, toString e equals.
	
Para usar annotar os attibutos com @Identificator extendendo de Identificable.
```java
public class Aplicacao extends Identificable{
	private @Identificator Collection<String> recursos = new HashSet<String>();
	private @Identificator String nome;
	...
}
```
A anotação @Identificator pode receber um parametro limitando para quais métodos ele será usado, por exemplo:
```java
@Identificator(Type.TO_STRING) String nome;
```
Também é possível se basear em um atributo.:
```java
@Identificator(field={"nome"}) Aplicacao aplicacao;
```

Download através do maven, dependência:
```xml
<dependency>
	<groupId>br.eti.clairton</groupId>
    <artifactId>identificator</artifactId>
	<version>0.2.0</version>
</dependency>
```
E adicionar o repositório
```xml
<repository>
	<id>mvn-repo-releases</id>
	<url>https://raw.github.com/clairton/mvn-repo/releases</url>
</repository>
```
