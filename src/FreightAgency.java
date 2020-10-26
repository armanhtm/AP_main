import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Keeps Cargoes data
 *
 * @author Narges Salehi & Mohammadreza Ghaderi
 * @version 1.1
 * @since October 2020
 */
public class FreightAgency {
    //keeps cargoes
    ArrayList<Cargo> cargoes;
    //keeps Clients
    ArrayList<Client> clients;
    String [] validAir = {"10","11","12","13","20","21"};
    String [] validGround = {"10","11","12","13","16","17"};
    String [] validSea = {"20","21"};

    /**
     * Create a new FreightAgency
     */
    public FreightAgency() {
        cargoes = new ArrayList<>();
        clients=new ArrayList<>();
    }

    /**
     * Add Cargo to CargoList
     *
     */
    public void addCargo() {
        int flag = 0;
        String temp;
        Scanner input = new Scanner(System.in);
        Client client = new Client();
        temp = input.nextLine();
        String [] tempString = temp.split(" ");
        if(tempString[6].equals("Ground")) {
            if (Arrays.asList(validGround).contains(tempString[2]) && Arrays.asList(validGround).contains(tempString[3])) {
                if (tempString[7].equals("Fast")) {
                    FastGroundCargo cargo = new FastGroundCargo();
                    cargo.origin = Integer.parseInt(tempString[2]);
                    cargo.destination = Integer.parseInt(tempString[3]);
                    if (tempString[5].equals("Yes"))
                        cargo.insurance = true;
                    cargo.weight = Integer.parseInt(tempString[4]);
                    cargoes.add(cargo);
                    for (Client clnt:
                         clients)
                        if (clnt.ClienttoString().equals(tempString[0] + " " + tempString[1])) {
                            clnt.addCargo(cargo);
                            flag = 1;
                            break;
                        }
                    if (flag == 0) {
                        client.setName(tempString[0] + " " + tempString[1]);
                        client.addCargo(cargo);
                        clients.add(client);
                        System.out.println("Client registered");
                    }
                    System.out.println("total cost " + cargo.calculatePrice());
                    flag = 2;
                } else if (tempString[7].equals("Normal")) {
                    NormalGroundCargo cargo = new NormalGroundCargo();
                    cargo.origin = Integer.parseInt(tempString[2]);
                    cargo.destination = Integer.parseInt(tempString[3]);
                    if (tempString[5].equals("Yes"))
                        cargo.insurance = true;
                    cargo.weight = Integer.parseInt(tempString[4]);
                    cargoes.add(cargo);
                    for (Client clnt:
                         clients)
                        if (clnt.ClienttoString().equals(tempString[0] + " " + tempString[1])) {
                            clnt.addCargo(cargo);
                            flag = 1;
                            break;
                        }
                    if (flag == 0) {
                        client.setName(tempString[0] + " " + tempString[1]);
                        client.addCargo(cargo);
                        clients.add(client);
                        System.out.println("Client registered");
                    }
                    System.out.println("total cost " + cargo.calculatePrice());
                    flag = 2;
                } else if (tempString[7].equals("Breakable")) {
                    BreakableGroundCargo cargo = new BreakableGroundCargo();
                    cargo.origin = Integer.parseInt(tempString[2]);
                    cargo.destination = Integer.parseInt(tempString[3]);
                    if (tempString[5].equals("Yes"))
                        cargo.insurance = true;
                    cargo.weight = Integer.parseInt(tempString[4]);
                    cargoes.add(cargo);
                    for (Client clnt:
                         clients)
                        if (clnt.ClienttoString().equals(tempString[0] + " " + tempString[1])) {
                            clnt.addCargo(cargo);
                            flag = 1;
                            break;
                        }
                    if (flag == 0) {
                        client.setName(tempString[0] + " " + tempString[1]);
                        client.addCargo(cargo);
                        clients.add(client);
                        System.out.println("Client registered");
                    }
                    System.out.println("total cost " + cargo.calculatePrice());
                    flag = 2;
                }
            }

        }
        else {
            if (tempString[6].equals("Sea")) {
                if (Arrays.asList(validSea).contains(tempString[2]) && Arrays.asList(validSea).contains(tempString[3])) {
                    SeaCargo cargo = new SeaCargo();
                    cargo.origin = Integer.parseInt(tempString[2]);
                    cargo.destination = Integer.parseInt(tempString[3]);
                    if (tempString[5].equals("Yes"))
                        cargo.insurance = true;
                    cargo.weight = Integer.parseInt(tempString[4]);
                    cargoes.add(cargo);
                    for (Client clnt:
                         clients)
                        if (clnt.ClienttoString().equals(tempString[0] + " " + tempString[1])) {
                            clnt.addCargo(cargo);
                            flag = 1;
                            break;
                        }
                    if (flag == 0) {
                        client.setName(tempString[0] + " " + tempString[1]);
                        client.addCargo(cargo);
                        clients.add(client);
                        System.out.println("Client registered");
                    }
                    System.out.println("total cost " + cargo.calculatePrice());
                    flag = 2;
                }
            } else if (tempString[6].equals("Air")) {
                if (Arrays.asList(validAir).contains(tempString[2]) && Arrays.asList(validAir).contains(tempString[3])) {
                    SeaCargo cargo = new SeaCargo();
                    cargo.origin = Integer.parseInt(tempString[2]);
                    cargo.destination = Integer.parseInt(tempString[3]);
                    if (tempString[5].equals("Yes"))
                        cargo.insurance = true;
                    cargo.weight = Integer.parseInt(tempString[4]);
                    cargoes.add(cargo);
                    for (Client clnt:
                         clients)
                        if (clnt.ClienttoString().equals(tempString[0] + " " + tempString[1])) {
                            clnt.addCargo(cargo);
                            flag = 1;
                            break;
                        }
                    if (flag == 0) {
                        client.setName(tempString[0] + " " + tempString[1]);
                        client.addCargo(cargo);
                        clients.add(client);
                        System.out.println("Client registered");
                    }
                    System.out.println("total cost " + cargo.calculatePrice());
                    flag = 2;
                }
            }
        }
        if(flag != 2)
            System.out.println("Transportation not available");

    }
    /**
     * Remove a cargo from CargoList
     *
     * @param cargo we want to add
     */
    public void removeCargo(Cargo cargo) {
        cargoes.remove(cargo);
    }

    /**
     * Show list of cargoes
     */
    public void showCargoList() {
        for (Cargo cargo : cargoes)
            cargo.showCargo();
    }
    /**
     * Show list of clients
     */
    public void showClients(){
        for(Client client : clients)
            System.out.println(client.FirstName + " " + client.LastName);
    }
    public ArrayList<String> getclients(){
        ArrayList<String> names = new ArrayList<>();
        for(Client client : this.clients)
            names.add(client.ClienttoString());
        return names;
    }
    public void addClient(){
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        for(Client client : clients)
            if(client.ClienttoString().equals(name)){
                System.out.println("Client has already registered");
                return;
            }
        Client client = new Client();
        client.setName(name);
        clients.add(client);
    }

}
