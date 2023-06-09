/**
* Student Class.
*
* @author Logan S
* @version 1.0
* @since 2023-06-05
*/

public class Student {

    // Variables for this class.
    private String _firstName;
    private String _lastName;
    private char _midInitial;
    private int _grade;
    private boolean _iep;
    private String _info;

    /**
    * Constructor to initialize values.
    *
    * @param firstName Self-explanatory.
    * @param lastName Self-explanatory.
    * @param midInitial Self-explanatory.
    * @param grade Self-explanatory.
    * @param iep "Individualized Education Program".
    */

    public Student(String firstName, String lastName, char midInitial,
        int grade, boolean iep) {
        this._firstName = firstName;
        this._lastName = lastName;
        this._midInitial = midInitial;
        this._grade = grade;
        this._iep = iep;
    }


    /**
    * Constructor to initialize values.
    *
    * @param firstName Self-explanatory.
    * @param lastName Self-explanatory.
    * @param grade Self-explanatory.
    * @param iep "Individualized Education Program".
    */

    public Student(String firstName, String lastName, int grade, boolean iep) {
        this._firstName = firstName;
        this._lastName = lastName;
        this._grade = grade;
        this._iep = iep;
        this._midInitial = ' ';
    }


    /**
    * Print all student info.
    *
    * @return Student info.
    */

    public String print() {
        // Check if there is a middle initial.
        if (this._midInitial == ' ') {
            this._info = this._firstName + " "+ this._lastName
                    + " is in Grade " + this._grade;
        } else {
            this._info = this._firstName + " " + this._midInitial + ". "
                + this._lastName + " is in Grade " + this._grade;
        }


        // Check if the student has an iep.
        if (this._iep) {
            this._info = this._info + " with an iep.";
        } else {
            this._info = this._info + " without an iep.";
        }
        return this._info;
    }
}
