package data;

import helpers.Randomizer;

public class ContactUsData {

    public String subject;
    public String email;
    public String order;
    public String pathToFile;
    public String message;

    public ContactUsData (){
        this.subject = Randomizer.getRandomSubjectHeading();
        this.email = Randomizer.getRandomEmail();
        this.order = Randomizer.getRandomAlphanumericString();
        this.pathToFile = "Test.txt";
        this.message = Randomizer.getRandomAlphabeticString();
    }


    public ContactUsData (String message){
        this.subject = Randomizer.getRandomSubjectHeading();
        this.email = Randomizer.getRandomEmail();
        this.order = Randomizer.getRandomAlphanumericString();
        this.pathToFile = "Test.txt";
        this.message = message;
    }

}
