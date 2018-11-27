import java.util.ArrayList;

public class user {

    public int id;
    public String login;
    public String password;
    public String username;
    public String friends;
    public int communities; //IDs das comunidades que o usuário participa
    public ArrayList<String> messages = new ArrayList();

    public int getID(){
        return id;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername(){
        return username;
    }

    public user(int id, String login, String password, String username){
        this.id = id;
        this.login = login;
        this.password = password;
        this.username = username;
    }

    public user(String login, String password, String username, String friend, int communities, String messages){
        this.login = login;
        this.password = password;
        this.username = username;
        this.friends = friend;
        this.communities = communities;
        this.messages = messages;
    }
}
