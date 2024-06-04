# Trabalho 2 de Laboratório de Programação
## Instruções 
O trabalho poderá ser realizado em duplas.
O trabalho constará da entrega de 4 classes que compõem o aplicativo descrito no problema.
O trabalho deve ser desenvolvido em aula e com a participação integral dos participantes.
## Problema
Sua equipe é a responsável pelo desenvolvimento de uma aplicação em JAVA para gerenciamento dos
clientes de uma loja de informática. O contratante requisitou um aplicativo que deve ser capaz de cadastrar
clientes, verificar se clientes já estão cadastrados e exibir dados dos clientes já cadastrados. Esta aplicação
será posteriormente agregada a outro sistema já existente na loja de informática, sendo assim, o contratante
requisitou que a aplicação fosse desenvolvida em 4 classes:
1. `Classe GereciaClientes` – Classe JAVA principal que será executada pelo usuário da aplicação. 
2. `Classe Pessoas` – Classe que deve ser capaz receber informações cadastrais de uma pessoa. 
3. `Classe Data` – Classe para fazer o gerenciamento de datas no formato dia/mês/ano. 
4. `Classe GerenciaArquivosTxt` – Classe para ler, escrever, modificar e criar arquivos do tipo txt.  

A seguir são descritos os atributos e métodos e características exigidos pelo cliente em cada uma das classes.

### 1) Classe Data

Esta classe deve possuir 3 atributos:
1. `dia` – tipo inteiro – representa o dia. 
2. `mês` – tipo inteiro – representa o mês. 
3. `ano` – tipo inteiro – representa o ano.

Esta classe deve possuir um método construtor padrão, onde nenhum parâmetro deve ser
passado para se instanciar objetos dessa classe.
* A classe deve possuir o seguinte método (procedimento):
1. setData – Este método deve receber 3 valores inteiros, referentes ao dia, mês e ao ano
da data que se deseja informar como atributos do objeto instanciado (deve atualizar os
atributos do objeto da classe). Ela deve conter tratamento para entradas inválidas de
dia, mês e ano, de modo que.
* Os anos devem receber valores maiores que 1.
* Os meses devem receber valores inteiros de 1 a 12.
* Os dias devem respeitar os valores possíveis para cada mês, conforme descrito
na tabela a seguir.

![img.png](img.png)
A classe deve possuir os seguintes métodos (função):

* `getDia` – que deve retornar um inteiro com o dia informado para o objeto.
* `getMes` – que deve retornar um inteiro com o mês informado para o objeto.
* `getAno` – que deve retornar um inteiro com o ano informado para o objeto.
* `getData` – que deve retornar um string contendo a data separa por barras, ou seja, um
string com a data no formato dd/mm/aaaa.

###  2) Classe Pessoa

Esta classe deve possuir os seguintes atributos:
1. `nome` – tipo String – refere-se ao nome da pessoa. 
2. `cpf` – tipo String – refere-se ao C.P.F. da pessoa. 
3. `dataNascimento` – tipo String – refere-se à data de nascimento da pessoa. 
4. `email` – tipo String – refere-se ao endereço de e-mail da pessoa.

Esta classe deve possuir um método construtor que recebe uma String com o CPF da
pessoa cadastrada como parâmetro, ou seja, ao se instanciar um objeto desta classe o
atributo cpf deve ser atualizado com o parâmetro passado.   
Cada um dos atributos deve possuir um método get (função) e um método do tipo set
(procedimento). O atributo dataNascimento deve ser respeitar as condições de datas
descritas na classe Data.

### 4) Classe GerenciaArquivosTxt

Esta classe deve possuir os seguintes atributos:
1. **`urlPasta`** – tipo String – recebe o url da pasta onde ficará o arquivo txt
manipulado. 
2. **`nomeArquivo`** – tipo String – recebe o nome do arquivo a ser manipuloado
(não incluir “.txt” no nome).  

Esta classe deve possuir um método construtor que recebe duas Strings como
parâmetros, sendo a primeira referente ao nome do arquivo (atualiza o atributo
nomeArquivo) e a segunda referente à ao endereço da pasta (atualiza o atributo
urlPasta).  
A classe deve possuir as seguintes funções (métodos):
1. `getArquivo` – retorna um objeto do tipo Path com a url para o arquivo (urlPasta
+”\\” nomeArquivo +”.txt”)
2. `verificaArquivo` – retorna um booleano dizendo se um arquivo com nome e url
informados para o objeto existe ou não. Se existir retornar TRUE, se não
existir retornar FALSE.  

A classe também deve possuir os seguintes procedimentos (métodos):
1. `gravaArquivo` – Recebe um String como parâmetro e grava essa String em um
arquivo com nome informado no atributo nomeArquivo que ficará dentro da
pasta com caminho informado no atributo urlPasta.
2. `leArquivo` – Faz a leitura de arquivo .txt com nome contido no atributo
nomeArquivo e na pasta com caminho contido no atributo urlPasta.

### 4) Classe GerenciaClientes
   Esta classe deve fazer o cadastro de clientes mantendo as seguintes informações para cada cliente: Nome,
   CPF, Data de Nascimento, e-mail, salvando essas informações em um arquivo txt tendo o CPF do cliente
   como nome. Por exemplo Suponha o cliente Pedro Pafuncio, com CPF 001.222.356-85, nascido em
   12/02/1999 e email pedropafuncio@gmail.com seja cadastrado. O programa deve criar um arquivo com o
   nome 001.222.356-85.txt e registrar o seguinte conteúdo arquivo:  

   Nome: Pedro Pafuncio  
   CPF: 001.222.356-85  
   Data de Nascimento: 12/02/1999  
   e-mail: pedropafuncio@gmail.com

**Ao executar a classe a aplicação deve mostrar o menu inicial com as seguintes informações.**   
“Escolha uma opção:  
1 – Cadastrar Cliente  
2 – Exibir Cliente  
3 – Sair”

#### **Ao escolher 1 o programa deve:**  
Pedir para o usuário informar o CPF do cliente e verificar se o cliente já é cadastrado. Caso já tenha
sido cadastrado o programa deve apresentar a mensagem “Cliente já cadastrado” e em seguida apresentar
duas opções: “1 – Atualizar cadastro”, “2 – Exibir dados”. Se o cliente pressionar 2 deve-se exibir os dados
do cliente, se pressionar 1 o programa deve agir como o usuário não fosse cadastrado, substituindo o arquivo
de cadastro do cliente por um novo arquivo. **Caso o cliente não seja cadastrado** o programa deve pedir
para o usuário informar Nome, Data de Nascimento, e-mail do cliente. O programa deve então salvar estas
informações em um arquivo .txt na pasta de cadastros utilizando o CPF do cliente como nome do arquivo.
Após realizar o cadastro o programa deve mostrar a mensagem “Cliente cadastrado” e retornar ao menu
inicial.

#### Ao escolher 2 o programa deve:

O programa deve perguntar o CPF do cliente e verificar se o cliente já é cadastrado. Caso o cliente já
tenha sido cadastrado, devem ser mostradas as informações de cadastro do cliente (Nome, CPF, Data de
Nascimento e e-mail). Caso ainda não tenha sido cadastrado, o programa deve mostrar a mensagem “Cliente
NÃO cadastrado, deseja cadastrar?” em seguida mostrar as opções “1 – SIM” e “2 – NÃO”. Caso selecione
1 - SIM o programa deve proceder conforme descrito para a escolha da opção 1 no menu inicial para o caso
de um cliente não cadastrado. Caso seja escolhida a opção 2 – NÃO o programa deve retornar para o menu
inicial.

#### Ao escolher 3 o programa deve:

Ao se escolher a opção 3 o programa deve apresentar a mensagem “finalizando” e encerrar a
aplicação.