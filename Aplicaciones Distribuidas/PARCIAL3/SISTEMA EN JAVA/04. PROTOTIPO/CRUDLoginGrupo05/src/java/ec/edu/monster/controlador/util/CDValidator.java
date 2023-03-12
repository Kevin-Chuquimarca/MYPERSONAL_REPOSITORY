/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author santi
 */
@FacesValidator("cDValidator")
public class CDValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (!(value instanceof String)) {
            return;
        }
        
        String cedula = (String) value;
        if (cedula == null || cedula.length() != 10) {
            FacesMessage message = new FacesMessage("La cédula ingresada es inválida");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        
        int total = 0;
        int digitoVerificador = Integer.parseInt(cedula.substring(9, 10));
        for (int i = 0; i < 9; i++) {
            int digito = Integer.parseInt(cedula.substring(i, i + 1)) * (i % 2 == 0 ? 2 : 1);
            total += digito > 9 ? digito - 9 : digito;
        }
        
        int modulo = total % 10;
        if (!((modulo == 0 && digitoVerificador == 0) || (10 - modulo == digitoVerificador))) {
            FacesMessage message = new FacesMessage("La cédula ingresada es inválida");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
