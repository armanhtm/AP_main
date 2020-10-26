import java.util.ArrayList;

/**
 * Acts on Client information
 *  @author Narges Salehi & Mohammadreza Ghaderi
 *  @version 1.1
 *  @since October 2020
 */
public class Client {
    //first name of client
    public String FirstName;
    //last name of client
    public String LastName;
    //list of client cargoes
    public ArrayList<Cargo> cargoes;

    public Client(){
        cargoes=new ArrayList<>();
    }

    public void addCargo(Cargo crg){
        String name = "cargo" + (cargoes.size() + 1);
        crg.setName(name);
        cargoes.add(crg);
    }
    public String ClienttoString(){
        return this.FirstName + " " + this.LastName;
    }
    public void ShowCargoes(){
        if(cargoes.size() != 0)
            for(Cargo cargo : cargoes)
                System.out.println(cargo.getName());
        else
            System.out.println("No cargo set");
    }
    public void setName(String name){
        String [] temp;
        temp = name.split(" ");
        this.FirstName = temp[0];
        this.LastName = temp[1];
    }
}
