import java.util.ArrayList;

public class Controle {

    ArrayList<Chats> grupos = new ArrayList();
    ArrayList<Usuario> usuario = new ArrayList();

    public boolean adduser(String nome) {
        for (int i = 0; i < this.usuario.size(); i++) {
            if (this.usuario.get(i).nome.equals(nome)) {
                return false;
            }
        }

        Usuario user = new Usuario(nome);
        this.usuario.add(user);
        return true;
    }

    public void users(String nome) {
        for (int i = 0; i < this.grupos.size(); i++) {
            if (this.grupos.get(i).nome.equals(nome)) {
                System.out.println(this.grupos.get(i).user);
            }
        }
    }

    public void allusers() {
        System.out.println(this.usuario);
    }

    public void allchats() {
        System.out.println(this.grupos);
    }

    public boolean newchat(String nome1, String nome2) {
        for (int i = 0; i < this.grupos.size(); i++) {
            if (this.grupos.get(i).nome.equals(nome2)) {
                return false;
            }
        }
        Usuario user = new Usuario(nome1);
        Chats chat = new Chats(nome2);
        chat.user.add(user);
        this.grupos.add(chat);
        return true;
    }

    public boolean chats(String nome) {
        System.out.print("[");
        for (int i = 0; i < this.grupos.size(); i++) {
            if (this.grupos.get(i).user.size() == 0) {
                continue;
            }
            if (this.grupos.get(i).user.get(0).nome.equals(nome)) {
                System.out.print(this.grupos.get(i) + " ");
            }
            for (int j = 1; j < this.grupos.get(i).user.size(); j++) {
                if (this.grupos.get(i).user.get(j).nome.equals(nome)) {
                    System.out.print(this.grupos.get(i) + " ");
                }
            }
        }
        System.out.println("]");
        return true;
    }

    public boolean invite(String nome0, String nome1, String nome2) {
        int flag = 0;
        for (int i = 0; i < this.grupos.size(); i++) {
            if (this.grupos.get(i).nome.equals(nome2)) {
                for (int j = 0; j < this.grupos.get(i).user.size(); j++) {
                    if (this.grupos.get(i).user.get(j).nome.equals(nome0)) {
                        flag = 1;

                    }
                }
            }
        }

        if (flag == 1) {
            for (int i = 0; i < this.grupos.size(); i++) {
                if (this.grupos.get(i).nome.equals(nome2)) {
                    for (int j = 0; j < this.usuario.size(); j++) {
                        if (this.usuario.get(j).nome.equals(nome1)) {
                            this.grupos.get(i).user.add(this.usuario.get(j));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean leave(String nome1, String nome2) {
        for (int i = 0; i < this.grupos.size(); i++) {
            if (this.grupos.get(i).nome.equals(nome2)) {
                //System.out.println(this.grupos.get(i).nome);
                for (int j = 0; j < this.grupos.get(i).user.size(); j++) {
                    if (this.grupos.get(i).user.get(j).nome.equals(nome1)) {
                        this.grupos.get(i).user.remove(j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean zap(String nome, String grupo, String msg) {

        for (int i = 0; i < this.grupos.size(); i++) {
            if (this.grupos.get(i).nome.equals(grupo)) {
                for (int j = 0; j < this.grupos.get(i).user.size(); j++) {
                    if (this.grupos.get(i).user.get(j).nome.equals(nome)) {

                        this.grupos.get(i).mensagens.add(nome + ": " + msg);
                        return true;

                    }
                }
            }
        }
        return false;
    }

    public boolean ler(String nome, String grupo) {

        for (int i = 0; i < this.grupos.size(); i++) {
            if (this.grupos.get(i).nome.equals(grupo)) {
                for (int j = 0; j < this.grupos.get(i).user.size(); j++) {
                    if (this.grupos.get(i).user.get(j).nome.equals(nome)) {
                        for (int k = 0; k < this.grupos.get(i).mensagens.size(); k++) {
                            System.out.println(this.grupos.get(i).mensagens.get(k));
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
