import java.util.Scanner;
import static java.lang.System.exit;

public class main {

    //RELATIVO AO USUÁRIO
    public static user[] users = new user[1000];
    public static int countUsers = 0;
    public static int userActualID; //Id do usuário que está com a sessão aberta

    //RELATIVO ÀS COMUNIDADES
    public static community[] communities = new community[1000];
    public static int countCom = 0; //Quantidade de comunidades existentes;

    //Cria uma conta de usuario no iFace;
    //PRONTA - TESTADA
    public static void createUser(){
        Scanner board = new Scanner(System.in);
        String login;
        String password;
        String username;

        if(countUsers >= 1000){
            System.out.println("Máximo de usuários!");
        }else{
            System.out.println("CRIAÇÃO DE USUÁRIO");
            System.out.println("Por favor, digite um e-mail: ");
            login = board.nextLine();
            System.out.println("Agora digite uma senha: ");
            password = board.nextLine();
            System.out.println("Por último, digite um nome de usuário: ");
            username = board.nextLine();

            users[countUsers] = new user(countUsers, login, password, username);
            countUsers++;
        }
    }

    //Loga com um usuário no iFace e exibe a interface inicial
    //PRONTA - TESTADA
    public static void signIn(){
        Scanner board = new Scanner(System.in);
        String login;
        String password;

        System.out.println("TELA DE LOGIN");
        System.out.println("E-mail: ");
        login = board.nextLine();
        System.out.println("Senha: ");
        password = board.nextLine();

        for(int i=0;i<countUsers;i++){
            if(login.equals(users[i].login)){
                if(!password.equals(users[i].password)){
                    System.out.println("Senha incorreta");
                }else {
                    //Exibe a tela de login e armazena o ID do usuário para usar nas operações como: Envio de mensagens, edição de perfil, etc.
                    userActualID = users[i].id;
                    System.out.println("\n");
                    userLoggedScreen();
                    return;
                }
            }
        }//Fim do for

        System.out.println("ERRO! Usuário não encontrado\nPor favor, verifique suas informações");
        exit(0);
    }

    //Edita o perfil de um usuário
    //PRONTA - TESTADA
    public static void editProfile(){
        int option;
        String data;
        Scanner board = new Scanner(System.in);

        System.out.println("EDIÇÃO DE PERFIL");
        System.out.println("Dados atuais");
        System.out.println("Login: " + users[userActualID].login);
        System.out.println("Senha: " + users[userActualID].password);
        System.out.println("Usuário: " + users[userActualID].username);
        System.out.println("Favor, escolha o campo que deseja alterar: ");
        System.out.println("1 - Login\n2 - Senha\n3 - Usuário");

        option = board.nextInt();

        switch(option){
            case 1:
                System.out.println("Digite o novo login: ");
                data = board.next();
                users[userActualID].login = data;
                System.out.println("Login alterado com sucesso!");
                break;
            case 2:
                System.out.println("Digite a nova senha: ");
                data = board.next();
                users[userActualID].password = data;
                System.out.println("Senha alterada com sucesso!");
                break;
            case 3:
                System.out.println("Digite o novo usuário: ");
                data = board.next();
                users[userActualID].username = data;
                System.out.println("Usuário alterado com sucesso!");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    //Deleta o perfil de um usuário
    //NÃO TESTADA
    public static void deleteProfile(){
        //DELETANDO AS INFORMAÇÕES DO PERFIL
        users[userActualID].id = -1;

        //DELETANDO AS COMUNIDADES EXISTENTES OERTENCENTES AO USUÁRIO
        for(int i=0;i<countCom;i++){
            if(communities[i].owner == userActualID){
                communities[i].id = -1;
            }
        }

        System.out.println("Perfil deletado com sucesso!");
    }

    //Retorna o ID do usuário
    //PRONTA - TESTADA
    public static int getUserID(String login){
        for(int i=0;i<countUsers;i++){
            if(login.equals(users[i].login) && users[i].id!=-1) {
                return users[i].id;
            }
        }//Fim for
        return -1;
    }//Fim getUserID

    /*Envia um pedido de amizade registrando o usuário remetente na lista de solicitações pendentes do destinatário
    Se o usuário destinatário recusar o pedido, o remetente é removido da sua lista*/
    //INCOMPLETA
    public static void sendFriendshipRqst(){
        Scanner board = new Scanner(System.in);
        String login;
        int id;

        System.out.println("Digite o login do seu amigo: ");
        login = board.nextLine();

        id = getUserID(login);

        if(id == -1){
            System.out.println("Usuário não encontrado!");
            return;
        }

        users[id].request.add(users[userActualID]);
        System.out.println("Pedido enviado");
    }

    //Verificar pedidos de amizade
    //INCOMPLETA
    public static void seeFrendshipRqst(){

        int option;
        int aux = users[userActualID].request.size();
        Scanner keyboard = new Scanner(System.in);

        if(aux>0){
            System.out.println(users[userActualID].getFriendshipRequests());
        }else{
            System.out.println("Você não tem novos pedidos de amizade");
        }

    }

    //Criar uma comunidade e atribuir um dono
    //TESTADA
    public static void createCommunity(){
        Scanner board = new Scanner(System.in);
        String cName;
        String description;

        System.out.println("Digite um nome para a comunidade: ");
        cName = board.nextLine();

        System.out.println("Digite uma descrição para a comunidade: ");
        description = board.nextLine();

        communities[countCom] = new community(countCom, userActualID, cName, description);
        countCom++;
    }

    //Exibe todas as comunidades existentes
    public static void seeCommunities(){
        for(int i=0;i<countCom;i++){
            System.out.println(communities[i].name);
            System.out.println("Dono: " + users[communities[i].id].username);
            System.out.println(communities[i].description);
            System.out.println("ID de ingresso: " + communities[i].id + "\n");
        }
    }

    //Interface para o usuário logado
    //INCOMPLETA
    public static void userLoggedScreen(){
        Scanner keyboard = new Scanner(System.in);
        int option;

        System.out.println("Bem vindo ao iFace, " + users[userActualID].username + "!\n Escolha o que deseja fazer: ");

        System.out.println("1 - Editar perfil");
        System.out.println("2 - Adicionar amigo");
        System.out.println("3 - Ver pedidos de amizade");
        System.out.println("4 - Criar comunidade");
        System.out.println("5 - Ver comunidades");
        System.out.println("6 - Se juntar a uma comunidade");
        System.out.println("7 - Verificar caixa de mensagens");
        System.out.println("8 - Enviar uma mensagem");
        System.out.println("9 - Pesquisar usuário");
        System.out.println("10 - Deletar conta");
        System.out.println("11 - Sair");

        option = keyboard.nextInt();

        switch (option){
            case 1:
                editProfile();
                break;
            case 2:
                sendFriendshipRqst();
                break;
            case 3:
                seeFrendshipRqst();
                break;
            case 4:
               createCommunity();
                break;
            case 5:
                seeCommunities();
                break;
            case 6:
                //joinCommunity();
                break;
            case 7:
                getMessages();
                break;
            case 8:
                sendMessage();
                break;
            case 9:
                //searchProfile();
                break;
            case 10:
                //deleteProfile();
                break;
            case 11:
                return;
            default:
                System.out.println("Opção inválida!");
                break;

        }

    }

    //Enviar uma mensagem para outro usuário
    //PRONTA - TESTADA
    public static void sendMessage(){
        String message;
        String sendTo;
        int id;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Digite o destinatário: ");
        sendTo = keyboard.nextLine();

        id = getUserID(sendTo);

        if(id == -1){
            System.out.println("Usuário não encontrado!");
        }else{
            System.out.println("Digite a mensagem a ser enviada: ");
            message = keyboard.nextLine() + "\nENVIADA POR: " + users[userActualID].username;

            users[id].messages.add(message);
        }

    }

    //Exibe as mensagens do usuário
    //PRONTA - TESTADA
    public static void getMessages(){
        int aux = users[userActualID].messages.size();
        System.out.println("MENSAGENS PESSOAIS");
        for(int i=0;i<aux;i++){
            System.out.println(users[userActualID].messages.get(i)+"\n");
        }

    }

    //Texto da tela inicial
    public static void initialScreen(){
        System.out.println("\n\n\n");
        System.out.println("Bem vindo ao iFace!\nPor favor, escolha uma opção: ");
        System.out.println("1. Registrar-se");
        System.out.println("2. Login");
        System.out.println("3. Sair");
    }

    public static void main(String args[]){

        Scanner keyboard = new Scanner(System.in);
        int option;

        initialScreen();

        option = keyboard.nextInt();

        while(option!=3){
            switch (option){
                case 1:
                    createUser();
                    System.out.println("\n");
                    initialScreen();
                    break;
                case 2:
                    signIn();
                    initialScreen();
                    break;
                case 3:
                    exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!\nFavor, tente novamente");
                    break;
            }
            option = keyboard.nextInt();
        }

    }
}
