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

        for(int i=0;i<request.size();i++) {

            int option;
            Scanner key = new Scanner(System.in);

            System.out.println("O usuário " + request.get(i).username + " deseja ser seu amigo");
            System.out.println("Digite 1 para aceitar ou 2 para recusar");

            option = key.nextInt();

            if(option == 1){
                //Colocar os usuários um na lista de amigos do outro;
                friends.add(request.get(i));
            }

            request.remove(request.get(i));
            getFriendsList();

        }//Fim do for
    }

    public void getFriendsList(){
        System.out.println("--LISTA DE AMIGOS--");
        for(int i=0;i<friends.size();i++) {
            System.out.println(friends.get(i).username);
        }//Fim do for
    }

    public user(int id, String login, String password, String username){
        this.id = id;
        this.login = login;
        this.password = password;
        this.username = username;
    }
    
}
