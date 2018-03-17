/**
 * 
 */
package validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import model.Product;

/**
 * @author suleymancan Mar 15, 2018
 */

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	// target, validasyonu yapılan obje. (product)
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Product product = (Product) target;

		if (product.getProductId() == null || product.getProductId().trim().length() < 5) {
			errors.rejectValue("productId", "required.productId");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name");
		if (product.getUnitPrice() <= 0) {
			errors.rejectValue("unitsInStock", "required.unitsInStock");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.description");

		if (product.getUnitsInStock() <= 0) {
			errors.rejectValue("unitsInStock", "required.unitsInStock");
		}
		System.out.println(errors);

	}

}
