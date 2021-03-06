package com.hooli.core.validator.annotation;

import com.hooli.core.validator.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/15 2:44 下午
 * @description：手机号码验证注解
 */
@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
public @interface Phone {

    String message() default "请输入正确的手机号码";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Phone[] value();
    }
}
