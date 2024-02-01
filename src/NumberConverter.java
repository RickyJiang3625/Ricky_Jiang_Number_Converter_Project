import java.util.Arrays;

public class NumberConverter {
    int[] digits;
    int base;
    String correctBinaryNumberIfGreaterThanLimit="";

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int[] sum = new int[1];
        int y =0;
        for(int i=digits.length-1;i>=0;i--){
            sum[0]+= (int) (digits[i]*Math.pow(base,y));
            y++;
        }
        return sum;}

    public int[] convertToBinary() {
        String notReversed="";
        String quotient="";
        int realQuotient=0;
        if(base==8){
            int[] sum = new int[1];
            int y =0;
            for(int i=digits.length-1;i>=0;i--){
                sum[0]+= (int) (digits[i]*Math.pow(base,y));
                y++;
            }
            realQuotient=sum[0];
        }
        else {
            for (int i = 0; i < digits.length; i++) {
                quotient += Integer.toString(digits[i]);
            }
            realQuotient = Integer.parseInt(quotient);
        }
        while(realQuotient != 0){
            notReversed+=Integer.toString(realQuotient%2);
            realQuotient=realQuotient/2;
        }

        String correctOrder="";
        for(int i=notReversed.length();i>0;i--){
            correctOrder+=notReversed.substring(i-1,i);

        }
        int[] number =new int[1];
        correctBinaryNumberIfGreaterThanLimit=correctOrder;
        int correctNumber=Integer.parseInt(correctOrder);
        number[0]=correctNumber;

        return number;
    }

    public int[] convertToOctal() {
        String notReversed="";
        String quotient="";
        int realQuotient=0;
        if(base==2){
            int[] sum = new int[1];
            int y =0;
            for(int i=digits.length-1;i>=0;i--){
                sum[0]+= (int) (digits[i]*Math.pow(base,y));
                y++;
            }
            realQuotient=sum[0];
        }
        else {
            for (int i = 0; i < digits.length; i++) {
                quotient += Integer.toString(digits[i]);
            }
            realQuotient = Integer.parseInt(quotient);
        }
        while(realQuotient != 0){
            notReversed+=Integer.toString(realQuotient%8);
            realQuotient=realQuotient/8;
        }

        String correctOrder="";
    for(int i=notReversed.length();i>0;i--){
        correctOrder+=notReversed.substring(i-1,i);

    }
    int[] number =new int[1];
    int correctNumber=Integer.parseInt(correctOrder);
    number[0]=correctNumber;
    return number;
    }

    public String getCorrectBinaryNumberIfGreaterThanLimit() {
        return correctBinaryNumberIfGreaterThanLimit;
    }
}

