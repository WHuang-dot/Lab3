package com.company;

/* A node represents an artist */
class Artist {
    private String name;
    public Artist next;

    public Artist(String name){ //constructor
        this.name = name;
        next = null;
    }

    public String getName() {
        return name;
    }

    public void displayLink() {
        System.out.print(name + " ");
    }
}