package src;
import src.Student.Major;

public class Profile {
    private String name;
    private Major major; //5 majors and 2-charater each: CS, IT, BA, EE, ME

    public Profile(String name, Major major){
        this.name = name;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public Major getMajor() {
        return major;
    }
}
