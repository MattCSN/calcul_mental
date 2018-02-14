package manager;

import dao.CalculDAO;
import dao.impl.CalculDAOImpl;

public class Library {


    private static class CalculLibraryHolder {
        private final static Library instance = new Library();
    }

    public static Library getInstance() {
        return CalculLibraryHolder.instance;
    }
    private CalculDAO calculDAO= new CalculDAOImpl();

    private Library(){

    }



}
