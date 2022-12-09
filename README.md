# miniautorizador
Desafio de desenvolvimento de API de autorização de transações de cartões de benefícios da Empresa VR.
# OBSERVAÇÕES GERAIS
-> Toda aplicação foi desenvolvida em Spring Boot, em virtude da pouca quantidade de entidades e funcionalidades tentou-se utilizar uma arquitetura de código mais clean para melhor manutenção e entendimento do funcionamento da aplicação, porém é sabido que a medida em que a aplicação cresce se faz necessário de estruturas mais robustas, com mais reaproveitamento de código, como por exemplo padronizar as chamadas de erros como um padrão global para toda aplicação.
-> A utilização de servidores de aplicação tem sido amplamente trocada pela arquitetura de microsserviços, ainda mais no mundo cloud, ao se adotar um servidor de aplicação o nível de acoplação é muito alto, o risco de queda da aplicação inteira por causa de uma única funcionalidade, além disso ao se adotar um serviodr de aplicação, ao se aumentar a demanda de chamadas de uma determinada funcionalidade toda aplicação precisa ser igualmente escalada a fim de conseguir lidar com o todo processamento, com a utilização de microsserviços é possível alocar mais recursos para apenas um microsservicos e em caso de queda ou congestionamento o restante da aplicação não fica comprometida, em cloud principalmente isso significa economia de recursos, visto que a infraestrutura é cobrada sob demanda, conforme utilização, número de chamadas, espaço em disco, memória, processamento entre outras variáveis.

# REQUISITOS PARA RODAR O PROJETO

-> Rodar o docker-compose que foi enviado juntamente com o projeto, o SGDG escolhido foi o MySQL 5.7.
-> Clonar o projeto para um repositório local e utilizar uma IDE de sua preferência, neste projeto foi utilizado o Spring Tool Suite 4 Version: 4.16.1.RELEASE, trata-se de uma versão do Eclipse otimizada para se trabalhar com Spring, atente-se para que todas as depêndencias do maven sejam baixadas.

# REALIZAR CHAMADAS NA API
-> Será disponibilizado um arquivo .yml do Swagger onde contém uma descrição detalhada do funcionamento da API, nesta versão foi feito o documento de forma apartada afim de agilizar o desenvolvimento, em casos de maiores funcionalidades pode-se se fazer necessário a utilização das notações do Swagger dentro da aplicação a fim de que o processo de desenvolvimento da aplicação seja automatizado.
-> Também será disponibilizado uma collection do Postman para realização de chamadas na API.