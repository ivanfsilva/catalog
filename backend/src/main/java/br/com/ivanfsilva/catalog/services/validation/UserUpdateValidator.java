package br.com.ivanfsilva.catalog.services.validation;

import br.com.ivanfsilva.catalog.dto.UserUpdateDTO;
import br.com.ivanfsilva.catalog.entities.User;
import br.com.ivanfsilva.catalog.repositories.UserRepository;
import br.com.ivanfsilva.catalog.resources.exceptions.FieldMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(UserUpdateValid ann) {
    }

    @Override
    public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {

        var uriVars = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        long userId = Long.parseLong(uriVars.get("id"));
        
        List<FieldMessage> list = new ArrayList<>();

        // Coloque aqui os testes de validação, acrescentando objetos FieldMessage à lista

        User user = repository.findByEmail(dto.getEmail());

        if (user != null && userId != user.getId()) {
            list.add(new FieldMessage("email", "Email já existe"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
