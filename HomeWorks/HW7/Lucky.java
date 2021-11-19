package HW7;

public class Lucky {
    public boolean random(int[] array, int index) throws Exception
    {
//        int[] array = {15, 8, 24, 41, 9, 84};
        if (array == null)
            throw new NullPointerException();
        if (index < 0)
            throw new ArrayLengthException("Invalid data");
        if (index > array.length)
            throw new ArrayLengthException("Invalid array length");
        if (array.length > 9)
            throw new ArrayLengthException("Array length is longer than specified");
        if (array.length < 6)
            throw new ArrayLengthException("Array length less than specified");
        int random = array[index];
        if (random % 2 == 0) {
            System.out.println(random + " - I am lucky!");
            return true;
        }
        else {
            System.out.println(random + " - Run again!");
            return false;
        }
    }
}