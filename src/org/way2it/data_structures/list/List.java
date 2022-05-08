package org.way2it.data_structures.list;

public class List {

    // Represent values in this list
    private String[] values = new String[4];

    // Represent the number of values that were added to this list
    private int length = 0;

    public List() {
    }

    // Should add new value to the end of the list, increment length and extend array by x2 if needed
    public void add(String value) {
        if (length < values.length){
            values[length] = value;
            length++;
        }
        else{
            int tempLength = values.length * 2;
            String[] tempValues = new String[tempLength];
            for (int i = 0; i < values.length; i++){
                tempValues[i] = values[i];
            }
            values = tempValues;
            values[length] = value;
            length++;
        }
        // TODO implement me
    }

    // Should add new value at the specified index, moving other values to the right,
    // increment length and extend array by x2 if needed
    public void addAtIndex(String value, int index) {
        if (length >= values.length){
            int tempLength = values.length * 2;
            String[] tempValues = new String[tempLength];
            for (int i = 0; i < values.length; i++){
                tempValues[i] = values[i];
            }
            values = tempValues;
        }
        for (int i = values.length - 2; i >= index; i--){
            values[i + 1] = values[i];
        }
        values[index] = value;
        length++;
        // TODO implement me
    }

    // Should return a value at specified index, or null if index is out of list bounds
    public String get(int index) {
        String valueOut;
        if (index >= values.length){
            valueOut = "0";
        }
        else {
            valueOut = values[index];
        }
        // TODO implement me
        return valueOut;
    }

    // Should return the index of the first occurrence of specified value in list
    // If the value does not exist - return -1
    public int indexOf(String value) {
        int indexOut = -1;
        for (int i = 0; i < values.length; i++){
            if (value.equals(values[i])){
                indexOut = i;
            }
        }
        // TODO implement me
        return indexOut;
    }

    // Should remove the value at specified index, decrementing the length of this list and moving next values to the left
    public void remove(int index) {
        for (int i = index; i < values.length - 1; i++){
            values[i] = values[i + 1];
        }
        values[values.length - 1] = null;
        length--;
        // TODO implement me
    }

    public int getLength() {
        return length;
    }
}
