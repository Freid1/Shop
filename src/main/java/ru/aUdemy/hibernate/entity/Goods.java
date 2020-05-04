package ru.aUdemy.hibernate.entity;

import javax.persistence.*;

@Entity
@Table
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int code;
    String name;
    String pathPhoto;
    int price;
    int quantityPiecesInPackage;
    int quantityPieces;
    @Enumerated(value = EnumType.STRING)
    Color color;

    public Goods() {
    }

    public Goods(int code, String name, String pathPhoto, int price, int quantityPiecesInPackage, int quantityPieces, Color color) {
        this.code = code;
        this.name = name;
        this.pathPhoto = pathPhoto;
        this.price = price;
        this.quantityPiecesInPackage = quantityPiecesInPackage;
        this.quantityPieces = quantityPieces;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityPiecesInPackage() {
        return quantityPiecesInPackage;
    }

    public void setQuantityPiecesInPackage(int quantityPiecesInPackage) {
        this.quantityPiecesInPackage = quantityPiecesInPackage;
    }

    public int getQuantityPieces() {
        return quantityPieces;
    }

    public void setQuantityPieces(int quantityPieces) {
        this.quantityPieces = quantityPieces;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", pathPhoto='" + pathPhoto + '\'' +
                ", price=" + price +
                ", quantityPiecesInPackage=" + quantityPiecesInPackage +
                ", quantityPieces=" + quantityPieces +
                ", color=" + color +
                '}';
    }
}
