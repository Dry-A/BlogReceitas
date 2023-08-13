# BlogReceitas
Projeto em Maven 

Diagrama de Classes do Projeto Blog de Receitas na figura abaixo:

<img  style="margin-top:20px" src="https://i.imgur.com/AUmhfGP.png">

<h3>O Projeto será composto por 3 Recursos (Conjunto de Classes e Interfaces responsáveis por
mapear um tipo de Objeto e persistir no Banco de dados Relacional) e uma Classe auxiliar: </h3> 

<img  style="margin-top:20px" src="https://i.imgur.com/V3yTgt7.png">

<h3> Os Recursos irão gerar tabelas no Banco de dados da aplicação. A Classe auxiliar não irá gerar
uma tabela no Banco de dados da aplicação, ela servirá de Classe auxiliar na implementação da
Segurança da aplicação. Os recursos serão implementados na mesma sequência da tabela acima</h3>

 <h3 style="color: green"> <strong>Foram utilizadas 6 dependências: Spring Web, Spring Boot Dev Tools, Lombok, Spring Data JPA, MySQL Driver e Validation. A configuração do Banco de dados será implementada no arquivo application.properties,
localizado na Source Folder src/main/resources</strong></h3>

<img  style="margin-top:20px" src="https://i.imgur.com/SrMCJ4e.png">
<br><br><br>
<h3>Neste projeto utilizei o VSCode por ter uma ótima integração com Git, como pode ser observado nessa imagem: </h3>
<img  style="margin-top:20px" src="https://i.imgur.com/oYmVinG.png">



<img  style="margin-top:20px" src="https://i.imgur.com/DEcXftI.png">

<img  style="margin-top:20px" src="https://i.imgur.com/CL6OYPw.png">

<img  style="margin-top:20px" src="https://i.imgur.com/bMtskM8.png">

<img  style="margin-top:20px" src="https://i.imgur.com/9X9jB9e.png">

<img  style="margin-top:20px" src="https://i.imgur.com/2Sbb2K6.png">

<img  style="margin-top:20px" src="https://i.imgur.com/ILaDN2B.png">
<br><br>
<h3>Criaçao da classe Categoria</h3>

<img  style="margin-top:20px" src="https://i.imgur.com/NNX5EcS.png">

<br><br>
<h3>Com o projeto em execução, inseri valores na tabela Categoria pelo MySql Workbench:</h3>
<img  style="margin-top:20px" src="https://i.imgur.com/YDERtbP.png">


<h2>Relacionamento de Classes</h2>
Mapeamento Objeto-Relacional (ORM) é o processo de conversão de Objetos Java em Tabelas (Entidades) de Banco de dados. Em outras palavras, isso nos permite interagir com um Banco de
dados Relacional sem nenhum código SQL. A Java Persistence API (JPA) é uma especificação que define como persistir dados em aplicativos Java. 
<br>
<br>
O foco principal do JPA é a camada ORM.
O JPA simplifica o tratamento do modelo de Banco de dados Relacional nos aplicativos Java quando mapeamos cada Tabela para uma única Classe de entidade (Model). No SQL, precisamos criar Relacionamentos entre as tabelas, no JPA também. 
<img  style="margin-top:20px" src="https://i.imgur.com/sdoeqX1.png">


o Relacionamento Bidirecional (1:N) entre as Classes Categoria e Receita

A Classe Receita será o <strong>lado N:1,</strong> ou seja, Muitas Receitas podem ter apenas <strong>Uma Categoria.</strong> 

<img  style="margin-top:20px" src="https://i.imgur.com/1Ta7ASC.png">
<br>

<h2>Tipos de Cascade -  Utilizei o ALL</h2>
<br><br>
<img   src="https://i.imgur.com/8avibSU.png">

<h2>Testes no Insomnia dos verbos HTTP da Classe Categoria: </h2>
<img  style="margin-top:20px" src="https://i.imgur.com/4UuE2hO.png">
<img  style="margin-top:20px" src="https://i.imgur.com/N4BLNNG.png">
<img  style="margin-top:20px" src="https://i.imgur.com/fiPdydq.png">
<img  style="margin-top:20px" src="https://i.imgur.com/E4bpEpb.png">

<h2>O relacionamento entre as classes visto no GET: </h2>
<img  style="margin-top:20px" src="https://i.imgur.com/DhuU9Pj.png">
