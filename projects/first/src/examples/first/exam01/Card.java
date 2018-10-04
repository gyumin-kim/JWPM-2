package examples.first.exam01;

public class Card {

    private String type;
    private int number;

    public Card (String type, int number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return this.type;
    }

    public int getNumber() {
        return this.number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        String typeToStr = number + "";

        switch (number) {
            case 1:
                typeToStr = "A";
                break;
            case 2:
                typeToStr = "B";
                break;
            case 3:
                typeToStr = "C";
                break;
            case 4:
                typeToStr = "D";
                break;
            case 5:
                typeToStr = "E";
                break;
            case 6:
                typeToStr = "F";
                break;
            case 7:
                typeToStr = "G";
                break;
            case 8:
                typeToStr = "H";
                break;
            case 9:
                typeToStr = "I";
                break;
            case 10:
                typeToStr = "J";
                break;
            case 11:
                typeToStr = "K";
                break;
            case 12:
                typeToStr = "L";
                break;
            case 13:
                typeToStr = "M";
                break;
            case 14:
                typeToStr = "N";
                break;
            case 15:
                typeToStr = "O";
                break;
        }

        return type + " (" + typeToStr + ")";
    }
}
