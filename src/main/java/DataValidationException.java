import java.util.ArrayList;
import java.util.List;

/**
 * @author ifeify
 */
public class DataValidationException extends Exception {
    List<String> errors = new ArrayList<>();

    void addValidationError(String error) {
        errors.add(error);
    }

    List<String> getValidationErrors() {
        return errors;
    }
}
