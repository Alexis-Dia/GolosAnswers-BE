package com.golosanswers.portal.jackson;

import com.golosanswers.portal.jackson.serializer.RoundingNumberSerializer;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = RoundingNumberSerializer.class)
public @interface JsonRounding {

	int rounding() default 1;
}
