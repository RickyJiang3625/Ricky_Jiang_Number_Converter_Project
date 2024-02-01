import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);
        while(!(base==2 || base == 8 || base == 10)){
            System.out.print("Enter a valid base: ");
            choice= s.nextLine();
            base= Integer.parseInt(choice);
        }

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);
        while(base==8 && (number.contains("9") || number.contains("8") )){
            System.out.print("Enter a valid number: ");
            number=s.nextLine();
            n=Integer.parseInt(number);
        }
        int ten=10;
        if(base==2){
            for(int i=2;i<ten;i++){
                while(number.contains(Integer.toString(i))){
                    System.out.print("Enter a valid number: ");
                    number=s.nextLine();
                    n=Integer.parseInt(number);
                }
            }
        }




        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
        if(base==8){
        System.out.println("Decimal number: "+ Arrays.toString(nc.convertToDecimal()).replace("[", "").replace("]", ""));
        System.out.println("Binary number: "+Arrays.toString(nc.convertToBinary()).replace("[", "").replace("]", ""));}
        else if(base==10){
            boolean greaterLimitBaseTen=false;
        System.out.println("Octal number: "+Arrays.toString(nc.convertToOctal()).replace("[", "").replace("]", ""));
            try {
                nc.convertToBinary();
            }
            catch (NumberFormatException e) {
                System.out.println("Binary: "+nc.getCorrectBinaryNumberIfGreaterThanLimit());
                greaterLimitBaseTen=true;
            }
            if(greaterLimitBaseTen==false){
            System.out.println("Binary number: "+Arrays.toString(nc.convertToBinary()).replace("[", "").replace("]", ""));}
        }

        else {
            System.out.println("Octal number: "+Arrays.toString(nc.convertToOctal()).replace("[", "").replace("]", ""));
            System.out.println("Decimal number: "+Arrays.toString(nc.convertToDecimal()).replace("[", "").replace("]", ""));

        }
    }
}
