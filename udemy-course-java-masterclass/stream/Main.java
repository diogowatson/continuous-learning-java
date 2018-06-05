import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static  void main(String[] argv){
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53","G49", "G60", "G50","g45",
                "I26","I17","I29",
                "071"
        );

        List<String> gNumbers = new ArrayList<>();

/*
        someBingoNumbers.forEach(number-> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
                System.out.println(number);
            }
                }
        );
        gNumbers.sort((String s1, String s2) ->s1.compareTo(s2));
        gNumbers.forEach((String s)-> System.out.println(s));

    */

        someBingoNumbers
                .stream()//define as a sequence
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26", "I27", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17","I29","I71");
        Stream<String> concatStream = Stream.concat(inNumberStream,ioNumberStream);
        System.out.println(concatStream.distinct().count());
    }
}
