package examples.first.exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookSortTest {
    public static void main(String[] args) {
        List<MyBook> bookList = new ArrayList<>();
        bookList.add(new MyBook("aaa", 3000));
        bookList.add(new MyBook("abb", 2000));
        bookList.add(new MyBook("cbc", 7000));

//        Collections.sort(bookList);
        Collections.sort(bookList, new MyBookComparator());
        for (MyBook book : bookList) {
            System.out.println(book.getTitle() + ": " + book.getPrice());
        }
    }
}

class MyBook implements Comparable<MyBook> {
    private String title;
    private int price;

    public MyBook(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(MyBook o) {
        return price - o.price;
    }
}

class MyBookComparator implements Comparator<MyBook> {
    @Override
    public int compare(MyBook o1, MyBook o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}