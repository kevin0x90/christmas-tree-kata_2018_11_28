package swkDuesseldorf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ChristmasTreeTest {
    private final ChristmasTree christmasTree = new ChristmasTree();

    @Test
    void negativeHeightNotAllowed() {
        assertThatThrownBy(() -> christmasTree.draw(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void treeWithHeightZeroContainsOnlyTheTrunk() {
        String tree = christmasTree.draw(0);
        assertThat(tree).isEqualTo("I");
    }

    @Test
    void treeWithHeightOne() {
        String tree = christmasTree.draw(1);

        assertThat(tree).isEqualTo(
                "*" + System.lineSeparator() +
                "I");
    }

    @Test
    void treeWithHeightTwo() {
        String tree = christmasTree.draw(2);
        assertThat(tree).isEqualTo(
                        " *" + System.lineSeparator() +
                        "***" + System.lineSeparator() +
                        " I");
    }

    @Test
    void treeWithHeightThree() {
        String tree = christmasTree.draw(3);
        assertThat(tree).isEqualTo(
                        "  *" + System.lineSeparator() +
                        " ***" + System.lineSeparator() +
                        "*****" + System.lineSeparator() +
                        "  I");
    }

    @Test
    void treeWithHeightFour() {
        String tree = christmasTree.draw(4);
        assertThat(tree).isEqualTo(
                        "   *" + System.lineSeparator() +
                        "  ***" + System.lineSeparator() +
                        " *****" + System.lineSeparator() +
                        "*******" + System.lineSeparator() +
                        "   I");
    }

    @Test
    void treeWithHeightFourAndAngel() {
        String tree = christmasTree.drawWithAngel(4);
        assertThat(tree).isEqualTo(
                        "   X" + System.lineSeparator() +
                        "   *" + System.lineSeparator() +
                        "  ***" + System.lineSeparator() +
                        " *****" + System.lineSeparator() +
                        "*******" + System.lineSeparator() +
                        "   I");
    }
    @Test
    void treeWithHeightZeroAndAngel() {
        String tree = christmasTree.drawWithAngel(0);
        assertThat(tree).isEqualTo(
                        "X" + System.lineSeparator() +
                        "I");
    }
}
