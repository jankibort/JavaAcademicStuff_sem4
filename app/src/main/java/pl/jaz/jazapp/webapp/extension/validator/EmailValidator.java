package pl.jaz.jazapp.webapp.extension.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator<String> {
    private static final String WRONG_EMAIL_VALIDATOR_MESSAGE =
            "pl.jaz.jazapp.webapp.extension.validator.EmailValidator.WRONG_EMAIL_VALIDATOR_MESSAGE";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if (!value.matches("[a-z]+")) {
            var msg = getMsg(context);
            var message = msg.getString(WRONG_EMAIL_VALIDATOR_MESSAGE);
            throw new ValidatorException(new FacesMessage(message));
        }
    }

    public PropertyResourceBundle getMsg(FacesContext context) {
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class);
    }
}