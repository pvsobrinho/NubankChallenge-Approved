Calculadora de Imposto sobre Ganho de Capital - README

Decisões Técnicas e Arquiteturais

A Calculadora de Imposto sobre Ganho de Capital é uma aplicação de linha de comando em Java projetada para calcular os impostos sobre operações no mercado financeiro de ações. Este projeto segue uma arquitetura modular e simples, priorizando a clareza do código e a facilidade de manutenção.

Frameworks e Recursos

Spring Boot: Escolhido pela sua capacidade de configuração rápida e fácil, o Spring Boot permite que nos concentremos na lógica do negócio sem nos preocuparmos com a configuração inicial do projeto.

Maven: Utilizado para gerenciamento de dependências e build do projeto, proporcionando uma maneira padronizada de construir a aplicação.
Lombok: Adotado para reduzir o boilerplate de código Java, especialmente para métodos getter, setter, equals, hashCode e toString.

Decisões de Design de Código

Orientação a Objetos: O código é estruturado em torno de objetos que representam entidades do domínio (transações de ações e impostos), promovendo um design claro e manutenível.
Serviço de Cálculo de Impostos: Uma classe de serviço encapsula a lógica de cálculo de impostos, mantendo-a separada da lógica de entrada/saída.
Tratamento de Exceções: Erros durante o processamento de entradas são tratados e comunicados ao usuário, mantendo a robustez da aplicação.

Justificativa para o Uso de Frameworks ou Bibliotecas

Spring Boot: Utilizado para aproveitar as funcionalidades de autoconfiguração e facilitar o empacotamento da aplicação para execução.

Jackson: Biblioteca para desserialização de JSON, permitindo transformar os dados de entrada em objetos Java de maneira eficiente e direta.

JUnit e Mockito: Utilizados para garantir a qualidade do código através de testes unitários e isolamento de componentes durante o teste.

Como Compilar e Executar o Projeto

1-Clone o repositório para sua máquina local.
2-Navegue até a pasta do projeto através do terminal.
3-Execute o comando mvn clean install para compilar o projeto e criar o pacote JAR.
4-Para iniciar a aplicação, execute java -jar target/nome-do-artefato.jar.

Como Executar os Testes da Solução

Após clonar o projeto e navegar até a pasta do projeto, execute o comando mvn test.
Os testes serão automaticamente executados e os resultados serão exibidos no terminal.

Notas Adicionais

É importante garantir que a versão do Java instalada corresponda à versão utilizada no projeto (Java 17).
A aplicação espera entradas de linha de comando em formato JSON, cada linha representando uma série de transações.
O estado não é mantido entre as execuções de diferentes linhas, garantindo que cada simulação seja independente.
A aplicação foi construída e testada em diferentes sistemas operacionais para garantir compatibilidade cruzada.


Existe um arquivo PDF que descreve com imagens o funcionamento do programa e testes.