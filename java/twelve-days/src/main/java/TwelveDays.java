public class TwelveDays {
    private final String[] ordinalDays = {"first", "second", "third", "fourth", "fifth", "sixth",
                                          "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"
                                         };

    private final String[] things = {"a Partridge", "two Turtle Doves", "three French Hens",
                                     "four Calling Birds", "five Gold Rings", "six Geese-a-Laying",
                                     "seven Swans-a-Swimming", "eight Maids-a-Milking", "nine Ladies Dancing",
                                     "ten Lords-a-Leaping", "eleven Pipers Piping", "twelve Drummers Drumming"
                                    };

    private final String newline = "\n";
    private final String verseFmt1 = "On the %s day of Christmas my true love gave to me";
    private final String verseFmt2 = ", %s%s";
    private final String verseEnd  = " in a Pear Tree." + newline;


    public String verse(int n) {
        StringBuffer sb = new StringBuffer();

        sb.append(String.format(verseFmt1, ordinalDays[n - 1]));
        for (int i = n - 1; i >= 0; i--) {
            sb.append(String.format(verseFmt2, (n > 1 && i == 0) ? "and " : "",
                                    things[i]));
        }
        sb.append(verseEnd);

        return sb.toString();
    }


    public String verses(int ini, int fin) {
        StringBuffer sb = new StringBuffer();

        for (int i = ini; i <= fin; i++) {
            sb.append(verse(i));
            if (i < fin) {
                sb.append(newline);
            }
        }

        return sb.toString();
    }


    public String sing() {
        return verses(1, ordinalDays.length);
    }

}

