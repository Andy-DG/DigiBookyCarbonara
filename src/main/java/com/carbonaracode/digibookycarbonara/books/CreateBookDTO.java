package com.carbonaracode.digibookycarbonara.books;

public class CreateBookDTO {
    //http://localhost:4200/books/add

    private final String isbn;
    private final String title;
    private final String authorFirstName;
    private final String authorLastName;
    private final double price;
    private final int copies;
    private final String imageURL;


    public CreateBookDTO(String isbn, String title, String authorFirstName, String authorLastName, double price, int copies, String imageURL) {
        this.isbn = isbn;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.price = price;
        this.copies = copies;
        this.imageURL = imageURL;
    }




    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public double getPrice() {
        return price;
    }

    public int getCopies() {
        return copies;
    }

    public String getImageURL() {
        return imageURL;
    }


}
