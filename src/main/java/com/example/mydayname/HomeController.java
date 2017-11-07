package com.example.mydayname;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {
    @RequestMapping("/loadform")
    public String loadFormPage(){
        return "dateinput";
    }

    @RequestMapping("/processdate")
    public String loadFromPage(@RequestParam("birthdate") String birthdate, @RequestParam ("genderflag") String genderflag, Model model ){

        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date=null;

        System.out.println("before try"+ birthdate);
        String returnedHtml="processdate";
        try {
            System.out.println("parsing the date");

            date = LocalDate.parse(birthdate, dTF);

            DateNameParser dateNameParser = new DateNameParser(date);
            String dayName = dateNameParser.parseDayName();
            String femaleName = dateNameParser.parseFemaleName();
            String maleName = dateNameParser.parseMaleName();
            String caption = dateNameParser.getCaption();
            model.addAttribute("dayname", dayName);
            model.addAttribute("femalename", femaleName);
            model.addAttribute("malename", maleName);
            model.addAttribute("caption", caption);
            if (genderflag.equalsIgnoreCase("male")) {

                returnedHtml = "processdatemale";
            } else if (genderflag.equalsIgnoreCase("female")) {

                returnedHtml = "processdatefemale";
            } else {

                returnedHtml = "processdate";

            }
        }catch(Exception e)
        {

            System.out.println("Unable to convert the string you entered to date. Please try again!");
            returnedHtml="dateinputerror";
        }

        return returnedHtml;
    }
}
