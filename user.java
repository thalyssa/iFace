import java.util.ArrayList;

public class user {

    public int id;
    public String login;
    public String password;
    public String username;
    public ArrayList<user> friends = new ArrayList<user>();
    public ArrayList<user> request = new ArrayList<user>(); //Lista para os pedidos de amizade
    public int communities; //IDs das comunidades que o usuário participa
    public ArrayList<String> messages = new ArrayList();

    public String getFriendshipRequests(){
        return request.toString();
    }

    public user(int id, String login, String password, String username){
        this.id = id;
        this.login = login;
        this.password = password;
        this.username = username;
    }
}
