import java.io.*;
import java.util.*;

public class personMain {
    public static void main(String [] args){
        try (Scanner input = new Scanner(System.in)) {
            // GET FILE person.txt
            FileReader fr = new FileReader("person.txt");
            BufferedReader in = new BufferedReader(fr);  
            
            // Create new file
            FileWriter fw = new FileWriter("UpdatedPerson.txt");
            PrintWriter updatePerson = new PrintWriter(fw);

            Person personArr[] = new Person[10];
            Person personArrBefore[] = new Person[10];
            String name, pass, address;
            String answer = "yes";
            String indata = null;
            int count= 0;
            int countBefore = 0;

            while((indata = in.readLine()) != null){
                StringTokenizer st = new StringTokenizer(indata,",");
                name = st.nextToken();
                pass = st.nextToken();
                address = st.nextToken();

                personArrBefore[count] = new Person(name, pass, address); // 0, 1, 2, 3

                count++;
            }

            countBefore = count;
            personArr = personArrBefore;

            System.out.println("--------GET DATA FROM TEXT FILE--------");

            System.out.println("\n-----ADD NEW PERSON-----");

            while(answer.equalsIgnoreCase("yes")){
                    System.out.print("\nEnter your name: ");
                    name = input.next();
                    System.out.print("Create your password: ");
                    pass = input.next();
                    input.nextLine();
                    System.out.print("Enter your address: ");
                    address = input.nextLine(); 

                    personArr[count] = new Person(name, pass, address);

                    System.out.print("\nContinue? Yes or No: ");
                    answer = input.next();

                    count++;
            }

            System.out.println("\n-------------------------------------------------------"); 
            System.out.println("List of person in person.txt :"); 
            for(int j = 0; j<countBefore; j++){
                System.out.println(personArrBefore[j].toString()); 
            }
            
            System.out.println("\n-------------------------------------------------------");
            System.out.println("List of person in UpdatedPerson.txt :");
            for(int j = 0; j<count; j++){
                System.out.println(personArr[j].toString()); 
                updatePerson.println(personArr[j].getName() + "," + personArr[j].getPassword() + "," + personArr[j].getAddress());
            }

            System.out.println("\nTotal person in person.txt: " + countBefore); 
            System.out.println("\nTotal person in UpdatedPerson.txt: " + count); 

            System.out.println();
            in.close();
            fw.close();
        }
        catch(FileNotFoundException fnf){
          System.out.println(fnf.getMessage());
        } 
        catch(IOException io){
          System.out.println(io.getMessage());
        } 

        
    }
}   
