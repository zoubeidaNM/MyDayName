package com.example.mydayname;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DateNameParser {
    private LocalDate date;
    private String dayName;
    private String femaleName;
    private String maleName;
    private Map maleMap;
    private Map femaleMap;

    public DateNameParser() {
        femaleMap = new HashMap();

        femaleMap.put("Monday","Adjoa");
        femaleMap.put("Tuesday", "Abena");
        femaleMap.put("Wednesday","Akua");
        femaleMap.put("Thursday","Yaa");
        femaleMap.put("Friday","Afua");
        femaleMap.put("Saturday","Ama");
        femaleMap.put("Sunday","Akosua");

        maleMap = new HashMap();

        maleMap.put("Monday","Kojo");
        maleMap.put("Tuesday", "Kwabena");
        maleMap.put("Wednesday","KweKu");
        maleMap.put("Thursday","Yaw");
        maleMap.put("Friday","Kofi");
        maleMap.put("Saturday","Kwami");
        maleMap.put("Sunday","Kwesi");

    }

    public String getCaption()

    {
        String str = "";
        if (maleName.equalsIgnoreCase("Kwesi") || femaleName.equalsIgnoreCase("Akosua"))
        {
            str = "Born leader, guide, protector";}
        if (maleName.equalsIgnoreCase("kojo") || femaleName.equalsIgnoreCase("Adjoa"))
        {
            str = "Calm, peaceful";}
        if (maleName.equalsIgnoreCase("Kwabena") || femaleName.equalsIgnoreCase("Abena"))
        {
            str = "Warrior, fearce and compassionate";}
        if (maleName.equalsIgnoreCase("KweKu") || femaleName.equalsIgnoreCase("Akua"))
        {
            str = "Advocate and controlling";}
        if (maleName.equalsIgnoreCase("Yaw") || femaleName.equalsIgnoreCase("Yaa"))
        {
            str = "Confrontational and aggressive";}
        if (maleName.equalsIgnoreCase("Kofi") || femaleName.equalsIgnoreCase("Afua"))
        {
            str = "Adventurous , creative and innovative ";}
        if (maleName.equalsIgnoreCase("Kwame") || femaleName.equalsIgnoreCase("Ama"))
        {
            str = "The ancient wise one";}
            return str;

    }

    public DateNameParser(LocalDate date) {
        this.date = date;
        femaleMap = new HashMap();

        femaleMap.put("Monday","Adjoa");
        femaleMap.put("Tuesday", "Abena");
        femaleMap.put("Wednesday","Akua");
        femaleMap.put("Thursday","Yaa");
        femaleMap.put("Friday","Afua");
        femaleMap.put("Saturday","Ama");
        femaleMap.put("Sunday","Akosua");

        maleMap = new HashMap();

        maleMap.put("Monday","Kojo");
        maleMap.put("Tuesday", "Kwabena");
        maleMap.put("Wednesday","KweKu");
        maleMap.put("Thursday","Yaw");
        maleMap.put("Friday","Kofi");
        maleMap.put("Saturday","Kwame");
        maleMap.put("Sunday","Kwesi");
    }

    public String parseDayName(){
        DayOfWeek today = date.getDayOfWeek();
        dayName = today.getDisplayName(TextStyle.FULL, Locale.US);
        return dayName;

    }

    public String parseFemaleName(){
        femaleName = (String) femaleMap.get(dayName);
        return femaleName;
    }

    public String parseMaleName(){
        maleName = (String) maleMap.get(dayName);
        return maleName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getFemaleName() {
        return femaleName;
    }

    public void setFemaleName(String femaleName) {
        this.femaleName = femaleName;
    }

    public String getMaleName() {
        return maleName;
    }

    public void setMaleName(String maleName) {
        this.maleName = maleName;
    }
}
