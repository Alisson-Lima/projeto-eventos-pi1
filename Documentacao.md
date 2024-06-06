# Projeto X - Sistema de Organização e Gerenciamento de Eventos

O Projeto X é um sistema desenvolvido para facilitar a organização e gerenciamento de eventos. O sistema permite o cadastro, edição, busca e listagem de diferentes tipos de eventos, incluindo shows, festas, comícios e reuniões.

## 1. Equipe de Desenvolvedores

- Eric 
- Alisson 
- Guilherme Denobi 
- Wersington
- Walssimon

## 2. Funcionalidades

### Login
- Ao iniciar o sistema, é solicitado que efetue o login para ter acesso a todas as demais funcionalidades do sistema. Caso possua um usuário válido, você acessa o sistema e pode utilizá-lo.

### Cadastro de usuário
- Ao iniciar o sistema, é solicitado que efetue o login para ter acesso a todas as demais funcionalidades do sistema. Caso não tenha um usuário, ele irá solicitar que você efetue seu cadastro para que possa acessar o sistema.

### Criar 
- Cada tipo de evento tem a opção de permitir ao usuário cadastrar novos eventos no sistema, especificando detalhes como nome, tipo, data, local, descrição e outros pontos que são específicos de cada tipo de evento.

### Buscar 
- Cada tipo de evento tem a opção de permitir ao usuário buscar eventos cadastrados no sistema utilizando seus IDs específicos, como por exemplo o nome do evento, dando mais segurança e capacidade para gerenciar seus eventos.

### Listar 
- Cada tipo de evento tem a opção de listar todos os eventos que foram cadastrados a partir do usuário que foi usado para efetuar o login.

## 3. Tipos de Eventos:
- Comício
- Show
- Reunião
- Festa

## 4. Fluxograma das Funcionalidades do Sistema

### Fluxograma da funcionalidade de Login
* Ao iniciar, o usuário recebe três opções: executar o login, cadastrar um novo usuário ou sair do sistema. Ao escolher executar o login, você deverá digitar seu e-mail e senha para que seja verificada a existência desse usuário no sistema e, assim, possa acessar a plataforma. Na opção de cadastrar, você deverá digitar suas informações para que seu usuário seja criado no sistema. Por último, a opção de sair apenas termina a execução do sistema.

### As exceções
* Ao digitar o e-mail sem "@" ou ".com", ele pede novamente.
* Caso a data de aniversário esteja fora do modelo, solicita que escreva novamente.
* Caso o CPF ou CNPJ esteja errado, solicita novamente.

![imagem](/Fluxogramas/LOGIN.jpg)
### Nessa imagem é possível visualizar a lógica por trás das funcionalidades 

### Fluxograma das funcionalidades de opção de Comício
* Ao iniciar, o usuário recebe uma lista de opções: cadastrar um novo comício, editar um comício, pesquisar e listar todos os comícios. Ao escolher executar o cadastro, você deverá digitar todas as informações solicitadas para que seja verificada a disponibilidade dessa data e local e, assim, possa concluir a criação do comício. Na opção de editar, você deverá selecionar qual deseja editar e, logo após, editar o que deseja. Na opção de pesquisar, você deve digitar o nome do comício que deseja e, assim, será mostrado. Por fim, na opção listar, ele mostrará todos os comícios criados.

### As exceções
* Caso a data ou horário esteja fora do modelo, solicita que escreva novamente.
* Caso a data ou horário seja do passado, ele solicita uma data válida, pois não é possível organizar um evento com data anterior à atual.
* Caso na opção de "possui autorização" marque a opção "não", ele não cria o evento.

![imagem](/Fluxogramas/COMICIO.jpg)
### Nessa imagem é possível visualizar a lógica por trás das funcionalidades 

### Fluxograma das funcionalidades de opção de Festa
* Ao iniciar, o usuário recebe uma lista de opções: cadastrar uma nova festa, editar uma festa, pesquisar e listar todas as festas. Ao escolher executar o cadastro, você deverá digitar todas as informações solicitadas para que seja verificada a disponibilidade dessa data e local, juntamente com a lista de convidados, e, assim, possa concluir a criação da festa. Na opção de editar, você deverá selecionar qual deseja editar e, logo após, editar o que deseja. Na opção de pesquisar, você deve digitar o nome da festa que deseja e, assim, será mostrado. Por fim, na opção listar, ele mostrará todas as festas criadas.

### As exceções
* Caso a data ou horário esteja fora do modelo, solicita que escreva novamente.
* Caso a data ou horário seja do passado, ele solicita uma data válida, pois não é possível organizar um evento com data anterior à atual.

![imagem](/Fluxogramas/FESTA.jpg)
### Nessa imagem é possível visualizar a lógica por trás das funcionalidades 

### Fluxograma das funcionalidades de opção de Reunião
* Ao iniciar, o usuário recebe uma lista de opções: cadastrar uma nova reunião, editar uma reunião, pesquisar e listar todas as reuniões. Ao escolher executar o cadastro, você deverá digitar todas as informações solicitadas para que possa concluir a criação da reunião. Na opção de editar, você deverá selecionar qual deseja editar e, logo após, editar o que deseja. Na opção de pesquisar, você deve digitar o nome da reunião que deseja e, assim, será mostrado. Por fim, na opção listar, ele mostrará todas as reuniões criadas.

### As exceções
* Caso a data ou horário esteja fora do modelo, solicita que escreva novamente.
* Caso a data ou horário seja do passado, ele solicita uma data válida, pois não é possível organizar um evento com data anterior à atual.

![imagem](/Fluxogramas/REUNIAO.jpg)
### Nessa imagem é possível visualizar a lógica por trás das funcionalidades 

### Fluxograma das funcionalidades de opção de Show
* Ao iniciar, o usuário recebe uma lista de opções: cadastrar um novo show, editar um show, pesquisar e listar todos os shows. Ao escolher executar o cadastro, você deverá digitar todas as informações solicitadas para que possa concluir a criação do show e definir o número de ingressos disponíveis. Na opção de editar, você deverá selecionar qual deseja editar e, logo após, editar o que deseja. Na opção de pesquisar, você deve digitar o nome do show que deseja e, assim, será mostrado. Por fim, na opção listar, ele mostrará todos os shows criados.

### As exceções
* Caso a data ou horário esteja fora do modelo, solicita que escreva novamente.
* Caso a data ou horário seja do passado, ele solicita uma data válida, pois não é possível organizar um evento com data anterior à atual.
* Caso, na opção de editar, ao definir a quantidade de ingressos vendidos, coloque um número maior que o disponível, ele impede a venda.

![imagem](/Fluxogramas/SHOW.jpg)
### Nessa imagem é possível visualizar a lógica por trás das funcionalidades 




## - Os Fluxogramas foram gerado pelo [app.diagrams](https://app.diagrams.net)



