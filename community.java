import java.util.ArrayList;

public class community {

    public int id;
    public ArrayList<user> members = new ArrayList<user>();
    public int owner; //ID do dono da comunidade
    public String name;
    public String description;

    public community(int id, int owner, String name, String description){
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.description = description;
    }

    public void addMember(user newMember){
        members.add(newMember);
    }

    public void getMembersList(){
        System.out.println("--MEMBROS--");
        for(int i=0;i<members.size();i++) {
            System.out.println(members.get(i).username);
        }//Fim do for
    }
}
