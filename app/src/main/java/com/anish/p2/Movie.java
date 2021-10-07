package com.anish.p2;

public class Movie {
    private String name;
    private String directorName;

    private String trailerLink;
    private String imdbLink;
    private String directorWikipediaLink;

    private int thumbnail;

    public Movie(String name,String directorName,String trailerLink, String imdbLink,String directorWikipediaLink, int thumbnail){
        this.name = name;
        this.directorName = directorName;
        this.trailerLink = trailerLink;
        this.imdbLink = imdbLink;
        this.directorWikipediaLink = directorWikipediaLink;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getImdbLink() {
        return imdbLink;
    }

    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
    }

    public String getDirectorWikipediaLink() {
        return directorWikipediaLink;
    }

    public void setDirectorWikipediaLink(String directorWikipediaLink) {
        this.directorWikipediaLink = directorWikipediaLink;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
