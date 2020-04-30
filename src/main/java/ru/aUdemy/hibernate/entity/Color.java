package ru.aUdemy.hibernate.entity;

public enum Color {
    WHITE(0),
    BLACK(1),
    YELLOW(2),
    RED(3),
    GREEN(4),
    BLUE(5),
    GRAY(6),
    BROWN(7),
    ORANGE(8),
    PINK(9),
    BEIGE(10),   // Beige — бежевый (бейж)
    GOLDEN(11),  //Golden — золотой, золотистый
    EMERALD(12), // Emerald — изумрудный
    CORAL(13),   // Coral — коралловый
    COPPER(14),  // Copper — медный
    OLIVE(15),   //Olive — оливковый
    PURPLE(16),  //Purple — фиолетовый, пурпупный
    SILVER(17),  //Silver — серебряный, серебристый
    LILAC(18),   //Lilac — сиреневый
    KHAKI(19);   //Khaki — хаки

    int colorCode;

    Color() {
    }

    Color(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getColorCode() {
        return this.colorCode;
    }

    public static Color getColor(int colorCode) {
        for (Color c : Color.values()) {
            if (c.getColorCode() == colorCode)
                return c;
        }
        return Color.WHITE;
    }

}


