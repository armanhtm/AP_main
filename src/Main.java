import java.util.Scanner;

/**
 * Run and test the program
 *
 * @author Narges Salehi & Mohammadreza Ghaderi & Arman Hatami
 * @version 1.1
 * @since October 2020
 */

public class Main {
    public static void main(String[] args) {
        FreightAgency Arman = new FreightAgency();
        Scanner input = new Scanner(System.in);
        String select = null;
        String client = null;
        String cargo = null;
        while (true) {
            System.out.println("0.Return");
            System.out.println("1.Cargo list");
            System.out.println("2.Client list");
            System.out.println("3.Set a cargo");
            System.out.println("4.add a client");
            System.out.println("5.Turn off");
            System.out.print("enter your command : ");
            select = input.nextLine();
            switch (select) {
                case "0":
                    break;
                case "1":
                    Arman.showCargoList();
                    break;
                case "2":
                    while (true) {
                        Arman.showClients();
                        client = input.nextLine();
                        if (client.equals("0"))
                            break;
                        else {
                            for (Client clnt:
                                 Arman.clients)
                                if (clnt.ClienttoString().equals(client)) {
                                    while (true) {
                                        clnt.ShowCargoes();
                                        cargo = input.nextLine();
                                        if (cargo.equals("0"))
                                            break;
                                        else {
                                            for (Cargo crg:
                                                 clnt.cargoes)
                                                if (crg.getName().equals(cargo)) {
                                                    while(true){
                                                        crg.showCargo();
                                                        cargo = input.nextLine();
                                                        if(cargo.equals("0"))
                                                            break;
                                                    }
                                                    break;
                                                }
                                        }
                                    }
                                    break;
                                }
                        }
                    }
                    break;
                case "3":
                    Arman.addCargo();
                    break;
                case "4":
                    Arman.addClient();
                    break;
                case "5":
                    return;
            }

        }
    }
}
