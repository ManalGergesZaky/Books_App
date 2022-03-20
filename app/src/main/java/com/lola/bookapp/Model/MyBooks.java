package com.lola.bookapp.Model;

public class MyBooks {

    private String name_book , author , publisher ,publishedDate ,
            img_link , des ,page , web_link;

    public MyBooks(String name_book, String author, String publisher,
                   String publishedDate, String img_link ,
                   String des ,String page , String web_link) {

        this.name_book = name_book;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.img_link = img_link;
        this.des = des;
        this.page = page ;
        this.web_link = web_link ;
    }


    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getWeb_link() {
        return web_link;
    }

    public void setWeb_link(String web_link) {
        this.web_link = web_link;
    }
}
