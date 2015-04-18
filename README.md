# identificator [![Build Status](https://drone.io/github.com/clairton/identificator/status.png)](https://drone.io/github.com/clairton/identificator/latest)
Helper para ajudar na implementação de hashCode, toString e equals.
	
Para usar annotar os attibutos com @Identificator 
extendendo de Identificable, a anotação @Identificator pode receber um parametro limitando para quais métodos ele será usado, por exemplo:
```java
public class Test extends Identificable{	
  private @Identificator(Type.TO_STRING) Collection<String> resources = new HashSet<>();	
  private @Identificator String name;
}
```
Download através do maven, dependência:
```xml
<dependency>
	<groupId>br.eti.clairton</groupId>
    <artifactId>identificator</artifactId>
	<version>0.1.0</version>
</dependency>
```
E adicionar o repositório
```xml
<repository>
	<id>mvn-repo-releases</id>
	<url>https://raw.github.com/clairton/mvn-repo/releases</url>
</repository>
```
