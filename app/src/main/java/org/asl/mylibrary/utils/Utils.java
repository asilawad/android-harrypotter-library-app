package org.asl.mylibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.asl.mylibrary.models.Book;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {
    public static final String BOOK_ID_KEY = "bookId";
    private  static final String ALL_BOOKS_KEY = "all_books";
    private  static final String ALREADY_READ_BOOKS = "already_read_books";
    private  static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private  static final String CURRENTLY_READING_BOOKS = "currently_reading_books";
    private  static final String FAVORITE_BOOKS = "favorite_books";



    private static Utils instance;
    private SharedPreferences sharedPreferences;


    private Utils(Context context) {

        sharedPreferences = context.getSharedPreferences("alternate_db",Context.MODE_PRIVATE);
        if(null == getAllBooks()){
            initdata();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();


        if(null ==  getAlreadyReadBooks()){
            editor.putString(ALREADY_READ_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

        if(null == getWantToReadBooks()){
            editor.putString(WANT_TO_READ_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();        }

        if(null == getCurrentlyReadingBooks()){
            editor.putString(CURRENTLY_READING_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if(null == getFavoriteBooks()){
            editor.putString(FAVORITE_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

    }

    private void initdata() {

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1,"The Philosopher’s Stone","J.K Rowling",221,"https://images.moviesanywhere.com/143cdb987186a1c8f94d4f18de211216/fdea56fa-2703-47c1-8da8-70fc5382e1ea.jpg",
                "The first book of the mega Harry Potter series","        As this is the first book of the series, the story unravels in the first few chapters. The story of the Harry Potter and the Philosopher’s Stone PDF revolves around an 11-year old boy named Harry Potter who lives with his maternal aunt, uncle and age-fellow cousin. Harry was orphaned when he was just 1 year old and brought home to his Aunt. Always treated as a servant throughout his childhood years, life changes for Harry when on his eleventh birthday he receives an acceptance and welcome letter by the Hogwarts School of Witchcraft and Wizardry. This is the when he finds out he is a wizard and also understands why he never fit into the muggle world.\n" +
        "\n" +
                "He begins his first year at school where he befriends Ron Weasley and Hermione Granger – both become his best friends by the end of the novel. Everything is good and exciting until Harry comes face to face with the darkest secret about his life, how his parents died and why he has the lightning-shaped scar on his end. Harry finds out and faces his biggest enemy and the darkest lord that the Wizardry world fears; Lord Voldemort but only briefly at the end.\n\n\n"));
        books.add(new Book(2,"Chamber of Secrets","J.K Rowling",338,"https://cdn.europosters.eu/image/1300/art-photo/harry-potter-chamber-of-secrets-i132717.jpg",
                "The second book of the mega Harry Potter series","        Harry Potter and the Chamber of Secrets begins to unfold when Dobby arrives at Harry’s relatives home during the summer break to beware him from returning to school. Harry is frustrated and on the edge and cannot wait to return to Hogwarts – a place that has become his home in just one year. An excited Harry Potter returns to Hogwarts to pursue his second year alongside best friend Ron in the most unexpected way.\n\n\n"));

        books.add(new Book(3,"The Prisoner of Azkaban"," J.K Rowling",454,"https://static.wikia.nocookie.net/harrypotter/images/f/f7/Prisoner_of_Azkaban_New_UK_Cover.jpg/revision/latest?cb=20170109011341",
                "The third book of the mega Harry Potter series","        Harry returns to Hogwarts for his third year as learning wizard. He is as excited as ever to be back to the place that he calls home and has loved ones in. The story unfolds to reveal that Harry is having flashbacks of the past and hearing the voice of Lord Voldemort in his head – which is definitely scariest for Harry and his friends too. However, the flashbacks have a deep connection with what’s happening in the present. Harry meet’s his dead father’s best friends in the novel. He comes face to face for the first time with his Godfather Sirius Black as well. This book is both an emotional ride for Harry and many other characters in the novel.\n" +
                "\n" +
                "The readers and critics cannot help but feel a little overwhelmed after reading this novel. It is the third year of Harry at Hogwarts and the bond that the readers have developed with Harry, his friends and Hogwarts is stronger than ever. Moreover, this book was less dramatic and more emotional with regular flashbacks going on throughout the novel. We all go to see a lot of important characters being introduced in this novel; all having a deep emotional connection the Harry.\n\n\n"));

        books.add(new Book(4,"Goblet of Fire"," J.K Rowling",755,"https://resizing.flixster.com/EUx-SL2GSszzvhWg6PGCR9tNixc=/206x305/v2/https://flxt.tmsimg.com/assets/p90599_p_v8_aq.jpg",
                "The fourth book of the mega Harry Potter series","        Harry Potter And The Goblet of Fire PDF begins with Harry having a dream during his summer break about the rise of the dark lord. Till the end of this novel, his dream had indeed turned into reality. The story unfolds as Harry returns to Hogwarts and finds himself unwillingly as a participant of the Triwizard tournament. It is later revealed in the story that it is indeed only a plot of the Death Eaters to make Harry come face to face with Lord Voldemort in a deadly encounter. The novel ends when the world expects a few close friends refuse to believe Harry’s story about the return of the Dark Lord.\n" +
                "\n" +
                "Harry Potter And The Goblet of Fire PDF Epub won hearts all over. It was the first of its own kind because this was the first time we got to see a dancing ball in Hogwarts! This was a much pleasant and unexpected thing that the readers did not expect but were very happy about. This book was all heart racing because for the first time ever we saw Harry come face to face with his biggest enemy Lord Voldemort. The book ended when we saw that the Dark Lord had risen from death and now Harry’s life is in danger more than ever before.\n\n\n"));

        books.add(new Book(5,"The Order of The Phoenix"," J.K Rowling",649,"https://www.mobygames.com/images/covers/l/131310-harry-potter-and-the-order-of-the-phoenix-playstation-2-front-cover.jpg",
                "The fivth book of the mega Harry Potter series","        In Harry Potter And The Order of the Phoenix PDF, Harry Potter returns to Hogwarts for his 5th year at Hogwarts. This turns out to be his most challenging year at Hogwarts yet. It is emotionally draining and haunting for him too as he senses the rise of the Dark Lord from the beginning of this year and the world believes him to the end of the year too. The time at Hogwarts is not easy this year too as he as to give his OWL examinations this year which is an important turning point in his academic career. But he is unable to focus on his studies or relationships as he is facing life threats from the Death Eaters lurking all around – even within Hogwarts. By the end, there is no option for Harry but to turn up at The Ministry of Magic to save the prophecy from Voldemort.\n\n\n"));


        books.add(new Book(6,"The Half-blood Prince"," J.K Rowling",	427,"https://m.media-amazon.com/images/I/91OqpahmwrL._RI_.jpg",
                "The sixth book of the mega Harry Potter series","        The plot of the sixth novel revolves around the past. The good and better side of Snape is revealed. It is shown how he is the better man and has always been protecting Harry as a promise to Lily. Dumbledore feels Harry is adult enough to handle the truth and the time is right to reveal at least the most important facets of the past to him. This is the only way Harry would be able to prepare for the future – which is very dark indeed.\n\n\n"));


        books.add(new Book(7,"The Deathly Hallows"," J.K Rowling",638,"https://m.media-amazon.com/images/I/81Whkax7IGL.jpg",
                "The seventh book of the mega Harry Potter series","        The evil wizard Voldemort, who killed Harry Potter’s parent and now he wants all-in-all control over this whole world so that no one gets to challenge his monarchy. Harry has been fighting him during his whole life and now is the time when he has to finish this all. However, this is the most dangerous of times as well since Voldemort is even more powerful and beating him couldn’t get any difficult than this.\n\n\n"));


        books.add(new Book(8,"The Cursed Child"," J.K Rowling",252,"https://cdn.images.express.co.uk/img/dynamic/36/590x/secondary/cursed-child-play-harry-potter-4569153.jpg?r=1678966367293",
                "The eighth book of the mega Harry Potter series","        People thought that the Harry Potter would be living happily forever after he had beaten Lord Voldemort and got married and had kids. Well, the writer had something else in her mind. Harry is now a husband, the father of three beautiful kids, and now he works under the ministry of magic.\n" +
                "\n" +
                "Doesn’t matter what he tried, magic is a part of him and he cannot separate himself from that. His children are now studying in Hogwarts and there are a lot of troubles which are about to befall in their path. How Harry Potter and his family are going to face that? This is up to for discovery.\n\n\n"));



        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEY , gson.toJson(books));
        editor.commit();
    }


    public static Utils getInstance( Context context) {
        if (null != instance) {
            return instance;
        } else {
            instance = new Utils(context);
            return instance;
        }
    }


    public  ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY , null) , type);
        return books;
            }

    public  ArrayList<Book> getAlreadyReadBooks() {

                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Book>>(){}.getType();
                ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS , null) , type);
                return books;
            }

            public  ArrayList<Book> getWantToReadBooks() {
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Book>>(){}.getType();
                ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS , null) , type);
                return books;
            }

            public  ArrayList<Book> getCurrentlyReadingBooks() {
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Book>>(){}.getType();
                ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS , null) , type);
                return books;    }

            public  ArrayList<Book> getFavoriteBooks() {
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Book>>(){}.getType();
                ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS , null) , type);
                return books;
    }

            public Book getBookById (int id ){
                ArrayList<Book> books = getAllBooks();
                if(null != books){
                    for(Book b : books){
                        if(b.getId() == id){
                            return b;
                        }
                    }
                }

        return null;
    }

    public boolean addToAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if(null!= books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS,gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToWantToRead(Book book){

        ArrayList<Book> books = getWantToReadBooks();
        if(null!= books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS,gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;    }

    public boolean addToCurrentlyReading(Book book){

        ArrayList<Book> books = getCurrentlyReadingBooks();
        if(null!= books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS,gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;    }

    public boolean addToFavourite(Book book){

        ArrayList<Book> books = getFavoriteBooks();
        if(null!= books){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS);
                editor.putString(FAVORITE_BOOKS,gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;    }

    public boolean removeFromAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if(null!= books){
            for(Book b: books){
                if(b.getId()== book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS);
                        editor.putString(ALREADY_READ_BOOKS,gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromWantToRead(Book book){

        ArrayList<Book> books = getWantToReadBooks();
        if(null!= books){
            for(Book b: books){
                if(b.getId()== book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS,gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromFavorites(Book book){

        ArrayList<Book> books = getFavoriteBooks();
        if(null!= books){
            for(Book b: books){
                if(b.getId()== book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS);
                        editor.putString(FAVORITE_BOOKS,gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromCurrentlyReading(Book book){

        ArrayList<Book> books = getCurrentlyReadingBooks();
        if(null!= books){
            for(Book b: books){
                if(b.getId()== book.getId()){
                    if(books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS,gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }


}