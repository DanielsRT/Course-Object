public class Course {
    private String crseName;
    private String discipline; 
    private String crseNumber;
    private int hours;
    
    // default constructor
    public Course() {
        crseName = "Data Structures";
        discipline = "CPSC";
        crseNumber = "2735";
        hours = 5;
    }
    
    // parameterized constructor
    public Course(String crseName_in,String discipline_in,String crseNumber_in,int hours_in) {
        crseName = crseName_in;
        discipline = discipline_in;
        crseNumber = crseNumber_in;
        hours = hours_in;
    }
 
    public String toString() {
        String retStr = String.format(
            "'%s', %s %s, %d hours",
            crseName,discipline,crseNumber,hours);
        return retStr;
    }
    
    // getter methods
    public String getCrseName() {
        return crseName;
    }

    public String getDiscipline() {
        return discipline;
    }

    public String getCrseNumber() {
        return crseNumber;
    }

    public int getHours() {
        return hours;
    }   
    
    
    // setter methods
    public void setCrseNumber(String crseNumber_in) {
        crseNumber = crseNumber_in;
    }

    public void setHours(int hours_in) {
        hours = hours_in;
    }   
    
}//class