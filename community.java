public class community {

    public int id;
    public int members[]; //Guarda os ids dos membros da comunidade
    public int owner; //ID do dono da comunidade
    public String name;
    public String description;

    public community(int id, int owner, String name, String description){
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.description = description;
    }

}
