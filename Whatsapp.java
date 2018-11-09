
import java.util.Scanner;

public class Whatsapp {
    public static void main(String[] args) {
        
        
        
        Controle cont = new Controle();
        
        Scanner sc = new Scanner(System.in);
        String[] comando;
        
        
        System.out.println("       Bem vindo a Whatsapp!"
                
                + "\n       Os comando são:"
                + "\n adduser:   Adicionar usuario.                     ex: addUser goku"
                + "\n alluser:   Exibir todos os usuarios.              ex: allUsers"
                + "\n newchat:   Adicionar um chats/grupo.              ex: newChat goku guerreiros"
                + "\n chats:     Para exibir chats de um usuario.       ex: chats goku"
                + "\n invite:    Para pessoas a um grupo.               ex: invite goku sara guerreiros"
                + "\n users:     Para exibir usuarios de um grupo.      ex: users guerreiros"
                + "\n leave:     Para sair de um grupo.                 ex: leave goku guerreiros"
                + "\n zap:       Para enviar mensagens em um grupo.     ex: zap goku guerreiros sou goku"
                + "\n ler:       Para ler mensagens em um grupo.        ex: ler goku guerreiros"
        
        );
        
        while(true){
            comando = sc.nextLine().split(" ");
            
            if(comando[0].equals("end")){
                System.out.println("  Até a proxima :)");
                break;
            }
            
            switch(comando[0]){
                case ("adduser"):
                    if (cont.adduser(comando[1])){
                        System.out.println("  done");
                    } else {
                        System.out.println("  fail: Usuario " + comando[1] + " ja existe");
                    }
                    break;
                
                case ("allusers"):
                    cont.allusers();
                    break;
                    
                case ("users"):
                    cont.users(comando[1]);
                    break;
                    
                case ("allchats"):
                    cont.allchats();
                    break;
                
                case ("newchat"):
                    if (cont.newchat(comando[1], comando[2])){
                        System.out.println("  done");
                    } else {
                        System.out.println("  fail: chat " + comando[2] + " ja existe");
                    }
                    break;
                    
                case ("chats"):
                    if (cont.chats(comando[1])){
                        System.out.print("\n");
                    }
                    break;
                    
                case ("invite"):
                    if (cont.invite(comando[1],comando[2], comando[3])){
                        System.out.println("  done");
                    } else {
                        System.out.println("   fail: user "+ comando[1] +" nao esta em chat " + comando[3]);
                    }
                    break;
                    
                case ("leave"):
                    if (cont.leave(comando[1], comando[2])){
                        System.out.println("  done");
                    } else {
                        System.out.println("falha");
                    }
                    break;
                    
                case ("zap"):
                    String msg = "";
                    for (int i=3 ; i<comando.length ; i++){
                        msg += comando[i] + " ";
                    }
                    if (cont.zap(comando[1], comando[2], msg)){
                        System.out.println("   done");
                    } else {
                        System.out.println("   fail: user "+ comando[1] +" nao esta em chat " + comando[2]);
                    }
                    break;
                
                case ("ler"):
                   if (!cont.ler(comando[1],comando[2])){
                        System.out.println("   fail: user "+ comando[1] +" nao esta em chat " + comando[2]);
                   }
                    break;
                    
                default:
                    System.out.println("   Tente novamente");
            }
        }
    }
}
