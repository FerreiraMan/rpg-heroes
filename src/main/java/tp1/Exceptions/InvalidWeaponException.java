package tp1.Exceptions;

/*Custom exception created to be thrown when the hero tries to equip an invalid armor,
regarding it's type or the hero's level.
Created an extra condition to differentiate the specific reason the exception is thrown.
*/
public class InvalidWeaponException extends Throwable {
    boolean valid_type;
    boolean valid_level;

    public InvalidWeaponException(boolean valid_type, boolean valid_level){
        super();
        this.valid_type = valid_type;
        this.valid_level = valid_level;
    }
    @Override
    public String getMessage(){
        if ((!valid_type) && (!valid_level)) {
            return "";
        } else if (!valid_type) {
            return "This Hero class cannot equip this weapon!";
        } else if (!valid_level) {
            return "Your level is too low for this equipment!";
        }
        else return "This exception shouldn't have been thrown. Both level and type are valid";
    }
}
