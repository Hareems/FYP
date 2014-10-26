package com.example.beansbookmarks;

public class RowItembookmarks {
    
    private String surah_name;
    private String verses;
    private String till_verses;
    public RowItembookmarks(String surah_name, String verses, String till_verses) {
            this.surah_name = surah_name;
        this.verses = verses;
        this.till_verses = till_verses;
    }
    
    public String getVerses() {
        return verses;
    }
    public void setVerses(String verses) {
        this.verses = verses;
    }
    public String getTill_Verses() {
        return till_verses;
    }
    public void setTill_Verses(String till_verses) {
        this.till_verses = till_verses;
    }
    
    public String getSurah_name() {
        return surah_name;
    }
    public void setSurah_name(String surah_name) {
        this.surah_name = surah_name;
    }
    @Override
    public String toString() {
        return surah_name  + "\n" + verses + "  to  "+ till_verses;
    }   
}