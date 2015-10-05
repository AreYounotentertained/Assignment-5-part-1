/**
 * Created by student on 10/5/2015.
 */
public class Telephone {
    private String telephone;
    private final int NORMALPHONENUMBER = 10;
    private final int TELEPHONEWITHCOUNTRYCODE = 11;

    public Telephone(String telephone) throws InvalidTelephoneException{
        StringBuilder numericTelephone = new StringBuilder(telephone);
        int telephoneDigits = 0;

        for (int i = telephone.length()-1; i >= 0; i--){
            if(Character.isDigit(telephone.charAt(i))){
                telephoneDigits++;
            }else {
                numericTelephone.deleteCharAt(i);
            }
        }

        if(telephoneDigits < NORMALPHONENUMBER){
            throw new InvalidTelephoneException("Telephone Number Contains less than 10 digits: " + telephone);
        }else if(telephoneDigits > TELEPHONEWITHCOUNTRYCODE){
            throw new InvalidTelephoneException("Telephone Number Contains more than 11 digits: " + telephone);
        }else if(telephoneDigits == TELEPHONEWITHCOUNTRYCODE && telephone.charAt(0) != '1'){
            throw new InvalidTelephoneException("Telephone Number Contains 11 digits but does not start with 1: " + telephone);
        }

        this.telephone = numericTelephone.toString();
    }

    @Override
    public String toString(){
        String result;
        if(telephone.length() == TELEPHONEWITHCOUNTRYCODE){
            result = "1" + "(" + new StringBuilder(getAreaCode()).deleteCharAt(0).toString() + ")" + getExchange() + "-" + getLocalNumber();
        }else {
            result = "(" + getAreaCode() + ")" + getExchange() + "-" + getLocalNumber();
        }

        return result;
    }


    public String getAreaCode(){
        StringBuilder result = new StringBuilder(telephone);
        if(result.length() == TELEPHONEWITHCOUNTRYCODE){
            result.delete(4, result.length());
        }else {
            result.delete(3, result.length());
        }

        return result.toString();
    }

    public String getExchange(){
        StringBuilder result = new StringBuilder(telephone);
        if(result.length() == TELEPHONEWITHCOUNTRYCODE){//14073516205
            result.delete(7, result.length());
            result.delete(0, 4);
        }else {
            result.delete(6, result.length());
            result.delete(0,3);
        }

        return result.toString();
    }

    public String getLocalNumber(){
        StringBuilder result = new StringBuilder(telephone);
        if(result.length() == TELEPHONEWITHCOUNTRYCODE){//14073516205
            result.delete(0, 7);
        }else {
            result.delete(0, 6);
        }

        return result.toString();
    }

}
