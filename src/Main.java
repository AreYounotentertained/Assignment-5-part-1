/*
@author mark
*/

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println(new Telephone("(407)582-2213"));
        }catch (InvalidTelephoneException ite){
            ite.printStackTrace();
        }

        try {
            System.out.println(new Telephone("407.582.2213"));
        }catch (InvalidTelephoneException ite){
            ite.printStackTrace();
        }

        try {
            System.out.println(new Telephone("4075822213"));
        }catch (InvalidTelephoneException ite){
            ite.printStackTrace();
        }

        try {
            System.out.println(new Telephone("14075822213"));
        }catch (InvalidTelephoneException ite){
            ite.printStackTrace();
        }

        try {
            System.out.println(new Telephone("407582221"));
        }catch (InvalidTelephoneException ite){
            System.out.println(ite);
        }

        try {
            System.out.println(new Telephone("40758222131"));
        }catch (InvalidTelephoneException ite){
            System.out.println(ite);
        }

        try {
            System.out.println(new Telephone("407582221312"));
        }catch (InvalidTelephoneException ite){
            System.out.println(ite);
        }
    }
}
