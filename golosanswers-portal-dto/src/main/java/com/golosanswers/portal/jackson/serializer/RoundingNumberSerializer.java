package com.golosanswers.portal.jackson.serializer;

import com.golosanswers.portal.jackson.JsonRounding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class RoundingNumberSerializer extends JsonSerializer<Double> implements ContextualSerializer {

	private final int rounding;

	/**
	 * Used for call from other libraries
	 */
	private RoundingNumberSerializer() {

		this(0);
	}

	private RoundingNumberSerializer(int rounding) {

		this.rounding = rounding;
	}

	@Override
	public void serialize(Double value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

		if (Objects.isNull(value)) {
			jsonGenerator.writeNull();

		} else {

			if (rounding == 0) {
				jsonGenerator.writeNumber(value);
			} else {
				BigDecimal decimal = new BigDecimal(value).setScale(rounding, RoundingMode.HALF_UP);
				jsonGenerator.writeNumber(decimal);
			}
		}
	}

	@Override
	public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {

		JsonRounding annotation = beanProperty.getAnnotation(JsonRounding.class);

		if (Objects.nonNull(annotation)) {
			return new RoundingNumberSerializer(annotation.rounding());
		}

		return this;
	}

}
