package tp1.Exceptions;

/*Custom exception created to be thrown when the hero tries to equip an invalid armor,
regarding it's type or the hero's level.
Created an extra condition to differentiate the specific reason the exception is thrown.
*/
public class InvalidArmorException extends Throwable {
    public InvalidArmorException(boolean valid_type, boolean valid_level){
        if (valid_type == false) {
            System.out.println("This Hero class cannot equip this armor!");
        } else if (valid_level == false) {
            System.out.println("Your level is too low for this equipment!");
        }
    }
}
