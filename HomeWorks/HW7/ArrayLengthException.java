package HW7;

public class ArrayLengthException extends Exception
{
    String message;

    ArrayLengthException(String str) {
        message = str;
    }

    public String toString() {
        return ("ArrayLengthException: " + message);
    }
}
