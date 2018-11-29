package swkDuesseldorf;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.StringUtils.repeat;

public class ChristmasTree {

    private static final String TRUNK = "I";
    private static final String STAR = "X";
    private static final String LEAF = "*";
    private static final String LINE_BREAK = System.lineSeparator();

    public String draw(final int height) {

        if (height < 0) {
            throw new IllegalArgumentException();
        }

        final String result = IntStream.range(1, height + 1)
                .mapToObj(lineNumber -> treeTop((lineNumber), height))
                .collect(Collectors.joining());
        return result + trunk(height);
    }

    public String drawWithAngel(final int height) {
        return spaces(computeNumberOfSpaces(height)) + STAR + LINE_BREAK + draw(height);
    }

    private String trunk(final int height) {
        return spaces(computeNumberOfSpaces(height)) + TRUNK;
    }

    private int computeNumberOfSpaces(final int height) {
        return height - 1;
    }

    private int computeNumberOfStars(final int linenumber) {
        return (2 * linenumber) - 1;
    }

    private String treeTop(final int lineNumber, final int height) {
        return spaces(computeNumberOfSpaces(height - lineNumber + 1))
                + stars(computeNumberOfStars(lineNumber))
                + LINE_BREAK;
    }

    private String spaces(final int amount) {
        return repeat(" ", amount);
    }

    private String stars(final int amount) {
        return repeat(LEAF, amount);
    }
}
