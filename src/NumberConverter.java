import java.util.Arrays;

public class NumberConverter {
    int[] digits;
    int base;

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
            sum[0]+= digits[i]*Math.pow(base,y);
            y++;
        }
        return sum;}

    public int[] convertToBinary() {
        return null;
    }

    public int[] convertToOctal() {
        String notReversed="";
        int quotient=Integer.parseInt(Arrays.toString(digits));

    }
}

