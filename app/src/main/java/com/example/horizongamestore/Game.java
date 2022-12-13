package com.example.horizongamestore;

public class Game {
    String title;
    String thumbnail;
    String short_description;
    String genre;
    String release_date;
    String publisher;


    public Game(String title, String thumbnail, String short_description,
                String genre, String release_date, String publisher) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.short_description = short_description;
        this.genre = genre;
        this.release_date = release_date;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "title='" + title + '\'' +
                ", Thumbnail='" + thumbnail + '\'' +
                ", Description='" + short_description + '\'' +
                ", Genre='" + genre + '\'' +
                ", Release='" + release_date + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}