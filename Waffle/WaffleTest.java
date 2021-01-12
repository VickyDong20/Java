import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * test getter of expenditure
 * and makePercentage of waffle
 * @author Vicky Dong
 * @version 2019-12-02
 */
public class WaffleTest {
    //initialise variables for test
    private Expenditure[] expenditure1;
    private int[] amounts;

    @BeforeEach
    public void init() {
        expenditure1 = new Expenditure[]{
                new Expenditure("education", 2800),
                new Expenditure("travel", 2400),
                new Expenditure("food", 2000),
                new Expenditure("cloths", 700),
                new Expenditure("shoes", 600),
                new Expenditure("enjoyment",500 ),
                new Expenditure("books", 400),
                new Expenditure("transportation", 300),
                new Expenditure("games", 200),
                new Expenditure("paper", 100)};

        Waffle waffle = new Waffle();
    }

    //test getter of expenditure
    @Test
    public void testGetter() {
        // the first element of expenditure1 is the one with the largest value, whose description is "5"
        String expectedDescription = "education";
        String actualDescription = expenditure1[0].getDescription();
        assertEquals(expectedDescription, actualDescription);

        int expectedValue = 2800;
        int actualValue = expenditure1[0].getValue();
        assertEquals(expectedValue, actualValue);
    }
}
