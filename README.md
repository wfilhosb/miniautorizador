# miniautorizador
Desafio de desenvolvimento de API de autorização de transações de cartões de benefícios da Empresa VR.

# 1. Observações/problemas sobre essa solução.
-> O Spring Boot é um framework open source, que agiliza o desenvolvimento de API's em Java, devido as funcionalidades que já vem nativas com o framework, tais como, bibliotecas, servidor, dependências etc. Para uma boa implementação do código e garantir que o mesmo esteja de acordo com as regras de negócio, se faz necessário a implementação de testes unitários, a fim de garantir que o código entregue os comportamentos estabelecidos em contrato. Quanto a alguns responses que solicitavam mensagens do tipo "SALDO_INSUFICIENTE", "CARTAO_INEXISTENTE", "SENHA_INVALIDA", "SALDO", e "OK", se fez necessária uma pequena adaptação para que essas mensagens fossem retornadas dentro de um JSON, para que através do name o front-end consiga capturar essas mensagens e consiga exibi-las em tela.

# 2.	Descreva quais são as principais limitações ao se adotar servidores de aplicação em uma arquitetura orientada a microsserviços. 
-> A utilização de servidores de aplicação tem sido amplamente trocada pela arquitetura de microsserviços, ainda mais no mundo cloud, ao se adotar um servidor de aplicação o nível de acoplação é muito alto, o risco de queda da aplicação inteira por causa de uma única funcionalidade, além disso ao se adotar um servidor de aplicação, aumentando a demanda de chamadas de uma determinada funcionalidade toda aplicação precisa ser igualmente escalada a fim de conseguir lidar com o todo processamento, com a utilização de microsserviços é possível alocar mais recursos para apenas um microsservico e em caso de queda ou congestionamento o restante da aplicação não ficará comprometida, em cloud, principalmente, isso significa economia de recursos, visto que a infraestrutura é cobrada sob demanda, conforme utilização, número de chamadas, espaço em disco, memória, processamento entre outras variáveis.

# 3. Atualmente, diversas aplicações escritas em Java estão deixando de serem desenvolvidas para rodarem em servidores (JBoss, Tomcat), adotando ferramentas que disponibilizam um servidor embutido na própria ferramenta. Quais são os principais desafios ao se tomar uma decisão dessas? Justifique sua resposta.
-> Os principais desafios estão ligados principalmente a necessidade do programador ter que nas fases de programação e testes, se certificar de que o servidor acomplado se integre perfeitamente com as versões de bibliotecas e frameworks usados, com isso surge a Cultura de DevOps, que visa associar os trabalhos de desenvolvimento junto com operações, com isso o ambiente aonde as aplicações são codificadas será o ambiente onde elas serão homologadas e implantadas. Por último, servidores embutidos são fundamentais na implementação de microsserviços, visto que eles "sobem" de forma independente se comunicando um com os outros, e em caso de falha de um serviço, os demais não serão impactados, como aconteceria, por exemplo, com um sistema monolítico, que a queda de um servidor de aplicação "derrubaria" todos os demais serviços.

# REQUISITOS PARA RODAR O PROJETO


-> Rodar o docker-compose que foi enviado juntamente com o projeto, o SGDG escolhido foi o MySQL 5.7.

-> Clonar o projeto para um repositório local e utilizar uma IDE de sua preferência, neste projeto foi utilizado o Spring Tool Suite 4 Version: 4.16.1.RELEASE, trata-se de uma versão do Eclipse otimizada para se trabalhar com Spring, atente-se para que todas as depêndencias do maven sejam baixadas.

# REALIZAR CHAMADAS NA API

-> Será disponibilizado um arquivo .yml do Swagger onde contém uma descrição detalhada do funcionamento da API, nesta versão foi feito o documento de forma apartada afim de agilizar o desenvolvimento, em casos de maiores funcionalidades pode-se se fazer necessário a utilização das notações do Swagger dentro da aplicação a fim de que o processo de desenvolvimento da aplicação seja automatizado.

-> Também será disponibilizado uma collection do Postman para realização de chamadas na API.
