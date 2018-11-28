import java.util.ArrayList;
import java.util.Scanner;

public class user {

    public int id;
    public String login;
    public String password;
    public String username;
    public ArrayList<user> friends = new ArrayList<user>();
    public ArrayList<user> request = new ArrayList<user>(); //Lista para os pedidos de amizade
    public int communities; //IDs das comunidades que o usuário participa
    public ArrayList<String> messages = new ArrayList();

    public void getFriendshipRequests(){
        int option;
        Scanner key = new Scanner(System.in);

        for(int i=0;i<request.size();i++) {
            System.out.println("O usuário " + request.get(i).username + " deseja ser seu amigo");
            System.out.println("Digite 1 para aceitar ou 2 para recusar");

            option = key.nextInt();

            switch (option) {
                case 1:
                    //Colocar os usuários um na lista de amigos do outro;
                    break;
                case 2:
                    break;
            }//Fim switch

            //Excluir o usuário da lista de request

        }//Fim do for
    }

    public user(int id, String login, String password, String username){
        this.id = id;
        this.login = login;
        this.password = password;
        this.username = username;
    }
}
