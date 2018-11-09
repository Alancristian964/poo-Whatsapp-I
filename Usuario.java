import java.util.ArrayList;

public class Usuario {
    
    ArrayList<Chats> chat = new ArrayList();
    
    String nome;

        //Métodos especiais

    public Usuario(String nome) {
        this.nome = nome;
    }
    
    

    public ArrayList<Chats> getChat() {
        return chat;
    }

    public void setChat(ArrayList<Chats> chat) {
        this.chat = chat;
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
