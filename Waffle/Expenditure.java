/**
 * we write a minimal class Expenditure.java that represents an expenditure with the two 
 field variables private String and the private int value
 * @author Vicky Dong
 * @version 2019-11-30
 */
public class Expenditure {
    private String description;
    private int value;

    /**
     * constructor of expenditure
     * @param description description of expenditure
     * @param value value of expenditure
     */
    public Expenditure(String description, int value) {
        this.description = description;
        this.value = value;
    }

    /**
     * getter of getDescription
     * @return the description of the updated expenditure is returned
     */
    public String getDescription() {
        return description;
    }

    /**
     * getter of value
     * @return the value of the updated expenditure is returned
     */
    public int getValue() {
        return value;
    }
}
