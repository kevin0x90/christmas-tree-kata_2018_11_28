package swkDuesseldorf;


import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChristmasTree {

    static final String LINE_BREAK = "\n";

    public String draw(int height) {

        if (height < 0) {
            throw new IllegalArgumentException();
        }

        String result = IntStream.range(0, height)
                .mapToObj(i -> treeTop((i + 1), height))
                .collect(Collectors.joining());
        return result + trunk(height);
    }

    private String trunk(int height) {
        return spaces(computeNumberOfSpaces(height)) + "I";
    }

    private int computeNumberOfSpaces(int height) {
        return height - 1;
    }

    private int computeNumberOfStars(int linenumber) {
        return 1 + 2 * (linenumber - 1);
    }

    private String treeTop(int lineNumber, int height){
        return  spaces(computeNumberOfSpaces(height - lineNumber + 1))
                + stars(computeNumberOfStars(lineNumber))
                + LINE_BREAK;
    }

    private String spaces(int amount) {
        return StringUtils.repeat(" ", amount);
    }

    private String stars(int amount) {
        return StringUtils.repeat("*", amount);
    }

    public String drawWithAngel(int height) {
        String result = spaces(computeNumberOfSpaces(height)) + "X" + LINE_BREAK;
        result += draw(height);
        return result;
    }
}
