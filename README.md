# Identificator
	Helper para ajudar na implementação de hashCode, toString e equals.
	
    Para usar para annotar os attibutos com Identificator:
```
	public class Test extends Identificable{	
		private @Identificator Collection<String> resources = new HashSet<>();	
		private @Identificator String name;
	}
```

	Download através do maven, dependência:
```
	<dependeny>
		<groupId>br.eti.clairton</groupId>
		<artifactId>identificator</artifactId>
		<version>0.1.0</version>
	</dependency>
```
	E adicionar o repositório
```
	<repository>
		<id>mvn-repo-releases</id>
		<url>https://raw.github.com/clairton/mvn-repo.git/releases</url>
	</repository>
```	
	E repositório:
```
	<repository>
		<id>identificator-mvn-repo</id>
		<url>https://raw.github.com/clairton/identificator/mvn-repo/</url>
		<snapshots>
			<enabled>true</enabled>
			<updatePolicy>always</updatePolicy>
		</snapshots>
	</repository>
```
