import javax.validation.*;
import java.util.Set;

/**
 * @author ifeify
 */
public class RegistrationService {
    ApplicationEventPublisher eventPublisher;
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    void register(RegistrationData registrationData) throws DataValidationException {
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RegistrationData>> violations = validator.validate(registrationData);
        if(violations.size() > 0) {
            DataValidationException validationException = new DataValidationException();
            for(ConstraintViolation violation : violations) {
                validationException.addValidationError(violation.getMessage());
            }
            throw validationException;
        }

        // ... registration logic ...
        // publish registration event
        // e.g observer can choose to send a notification email, text message etc
        // or count the number of users we have or do some kind of statistics
        ApplicationEvent event = new RegistrationCompleteEvent();
        eventPublisher.publish(event);
    }
}
