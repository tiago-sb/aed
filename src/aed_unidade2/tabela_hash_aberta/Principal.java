import java.util.Scanner;
import hashAberto.HashAberto;

public class Principal {
  public static void menu(){
    System.out.println("============ MENU ============");
    System.out.println(" ESCOLHA O METODO DE SONDAGEM ");
    System.out.println("[1] - SONGAGEM LINEAR.........");
    System.out.println("[2] - SONGAGEM QUADRATICA.....");
    System.out.println("[3] - SONGAGEM DUPLA..........");
    System.out.print("DIGITE O NUMERO CORRESPONDENTE: ");
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    HashAberto<String, String> hashAberto = new HashAberto<String, String>();

    // aparece o menu no terminal e o usuario escolhe o tipo de sondagem
    menu();  
    int songademEscolhida = scan.nextInt();
    hashAberto.put("Tiago", "ocupada", songademEscolhida);
    hashAberto.put("Santos", "ocupada", songademEscolhida);
    hashAberto.put("Bela", "ocupada", songademEscolhida);
    hashAberto.put("Quinta", "ocupada", songademEscolhida);
    hashAberto.put("AED", "ocupada", songademEscolhida);

    hashAberto.imprimir();
    scan.close();
  }
}
