package model.beans.JSF;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class BeanEmailValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String correo = (String) value;
		if (!correo
				.toLowerCase()
				.matches(
						"^[a-z0-9]+([_\\.-][a-z0-9]+)*@([a-z0-9]+([\\.-][a-z0-9]+)*)+\\.[a-z]{2,}")) {
			FacesMessage message = new FacesMessage(
					"La dirección de email, no es correcta");
			throw new ValidatorException(message);
		}

	}
}
