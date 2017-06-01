package kit.starter.com.starterkit;

/**
 * Created by shaunakdas2020 on 01/06/17.
 */

public class Book {
    private String id;
    private String author;
    private String title;

    public void setAuthor(String bookAuthor){
        this.author = bookAuthor;
    }
    public void setTitle(String bookTitle){
        this.title = bookTitle;
    }
    public void setId(String bookId){
        this.id = bookId;
    }
    public String getAuthor(){
        return this.author;
    }

}
