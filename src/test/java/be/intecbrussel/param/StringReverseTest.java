package be.intecbrussel.param;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.runners.Parameterized;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringReverseTest {
    private StringReverse stringReverse;

    @BeforeAll
    public void initializeStringReverse() {
        stringReverse = new StringReverse();
    }

    //static tests
    @Test
    public void test() {
        StringReverse s = new StringReverse();
        assertEquals("cba", s.reverse("abc"));
        assertEquals("", s.reverse(""));
        assertNotEquals("abc", s.reverse("abc"));

    }

    //Parametrized with Method Source
    @ParameterizedTest
    @MethodSource("StringReverse")
    void testConverter_WithMethodSource_WhenReversingString(String s, String expected) {
       Assertions.assertEquals( StringReverse.reverse(s), expected);
    }

    static Stream<Arguments> StringReverse() {
        return Stream.of(
                Arguments.arguments("data", "atad"),
                Arguments.arguments("Shelbatra", "artablehS"),
                Arguments.arguments("Dawud", "duwaD")
        );
    }

    //Parametrized with CsvSource
    @ParameterizedTest
    @CsvSource({"Draak , kaarD",
                 " Life , efiL",
                 " MyBrainIsWarm , mraWsIniarByM",
                 " abc , cba",
                 " shell , llehs"
    })
    public void reverseStringWithSpace(String input, String output) {
        StringReverse s = new StringReverse();
        assertEquals(output, s.reverse(input));

    }

    //maybe more options to test???
}

