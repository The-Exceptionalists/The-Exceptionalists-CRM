package com.ironhack.crm.classes;


import com.ironhack.crm.utils.ValidateHelpers;

public class Lead {

    private static int counter;
    private String id;
    private String name;
    private String email;
    private String companyName;
    private String phoneNumber;

    public Lead(String name, String email, String companyName, String phoneNumber) {
        counter++;
        setId();
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNumber(phoneNumber);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Lead.counter = counter;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = "" + counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

       //ValidateHelpers.validateString(name, );

        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //"\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b"
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        /*@Test
        public void whenMatchesPhoneNumber_thenCorrect() {
            String patterns
                    = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                    + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                    + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

            String[] validPhoneNumbers
                    = {"2055550125","202 555 0125", "(202) 555-0125", "+111 (202) 555-0125",
                    "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89"};

            Pattern pattern = Pattern.compile(patterns);
            for(String phoneNumber : validPhoneNumbers) {
                Matcher matcher = pattern.matcher(phoneNumber);
                assertTrue(matcher.matches());
            }
        }*/
        this.phoneNumber = phoneNumber;
    }
}
