import java.util.ArrayList;

public class Chats {
    
    ArrayList<Usuario> user = new ArrayList();
    ArrayList<String> mensagens = new ArrayList();
    
    String nome;

        //Métodos especiais

    public Chats(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Usuario> getUser() {
        return user;
    }

    public void setUser(ArrayList<Usuario> user) {
        this.user = user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
    
}
