package by.bsu.chat.entity;

public class Login {
    private String author;

    public Login(String author) {
        this.author = author;
    }

    public Login() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return author;
    }
}
