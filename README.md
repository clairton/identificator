# Identidicator
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
	
	
	Segue algumas informações interessantes sobre o projeto.	

# Versionamento
		As versões seguem o padrão especificado http://semver.org/lang/pt-BR/, portanto tire um tempo para ler e entender.
		Utiliza o GIT(http://git-scm.com/) como sistema de versionamento para o fontes.

# Convenção de nomes de classes, variavéis e pacotes	e banco de dados
	Como padrão de codificação foi estabelecido usar o https://google-styleguide.googlecode.com/svn/trunk/javaguide.html.
	Porém destaca-ser alguns pontos:
		*Nome da classe como Substantivo
		*Nome de método como Verbo
		*Notação polonesa, hungara, alemã ou de qualquer nacionalidade estão extremamente proibidas
		*Use nomes expressivos e simples, mas não exóticos