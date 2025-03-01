package main;

public class Field {
    public String[][] currentField;
    public int sideLength;

    public Field(int sideLength) {
        this.currentField = new String[sideLength][sideLength];
        this.sideLength = sideLength;
        for (int i = 0; i < currentField.length; i++) {
            for (int j = 0; j < currentField[i].length; j++) {
                currentField[i][j] = ".";
            }
        }
    }

    public void printField() {
        for (int i = 0; i < currentField.length; i++) {
            for (int j = 0; j < currentField[i].length; j++) {
                System.out.print(currentField[i][j] + " ");
            }
            System.out.println();
        }
    }
}
