package task_0017;

public class NumberConvertor {

    public static final String[] UNITS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine"};
    public static final String[] TENS = {"zero", "special case", "twenty", "thirty", "forty", "fifty", "sixty",
            "seventy", "eighty",
            "ninety"};
    public static final String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen",
            "eighteen", "nineteen"};


    public String convertNumberToWord(int number) {
        int[] numberAsArray = toIntArray(number);
        StringBuilder builder = new StringBuilder();
        if (number < 0) {
            builder.append("minus ");
        }
        //thousands
        if (numberAsArray[0] > 0) {
            builder
                    .append(UNITS[numberAsArray[0]])
                    .append(" thousand ");
        }
        //hundreds
        if (numberAsArray[1] > 0) {
            builder
                    .append(UNITS[numberAsArray[1]])
                    .append(" hundred ");
        }
        //tens
        if (numberAsArray[2] > 0) {             //pokud je na řádu desítek číslo
            if (numberAsArray[1] > 0) {         //pokud je na řádu stovek nějaké číslo, přidám před desítky "and"
                builder
                        .append("and ");
            }
            if (numberAsArray[2] == 1) {        //pokud je desítkový řád == 1 --> použiju teens
                builder.append(TEENS[numberAsArray[3]]);
            } else {
                builder.append(TENS[numberAsArray[2]]);
            }
        }
        //units
        if (numberAsArray[2] != 1) {   //special case for teens
            if (numberAsArray[1] > 0 && numberAsArray[2] == 0) {
                //pokud je na řádu stovek nějaké číslo a v desítkách je 0 přidám před jednotky "and"
                builder.append("and ");
            }
            if (numberAsArray[2] > 1) {
                builder.append("-");
            }
            builder.append(UNITS[numberAsArray[3]]);
        }

        return builder.toString();
    }


    private int[] toIntArray(int number) {
        if (number < -9999 || number > 9999) {
            throw new IllegalArgumentException("Error: input number must be between (-9999 to 9999)");
        }
        String numberAsString = Integer.toString(number);
        int[] numberAsArray = new int[4];
        for (int i = 0; i < numberAsArray.length; i++) {
            int arrayIndex = numberAsArray.length - 1 - i;
            int stringIndex = numberAsString.length() - 1 - i;
            if (stringIndex < 0) {
                return numberAsArray;
            }
            numberAsArray[arrayIndex] = Character.getNumericValue(numberAsString.charAt(stringIndex));
        }
        return numberAsArray;
    }
}
