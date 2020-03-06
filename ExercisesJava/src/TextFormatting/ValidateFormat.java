package TextFormatting;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateFormat {


    private Pattern pattern;
    private Matcher matcher;

    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";

    public ValidateFormat(){
        pattern = Pattern.compile(USERNAME_PATTERN);
    }

    public boolean validate(String name){

        matcher = pattern.matcher(name);

        return matcher.matches();
    }
    
    public String getValidNames(String[] usernames){

        String validNames = "";
        for (String username:usernames) {
            if (validate(username.trim())){
                validNames = String.join("," , username);
            }
        }
        return  validNames;
    }


}
