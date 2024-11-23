package com.example.EmployeeManagement.configurations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.bson.types.ObjectId;

import java.io.IOException;

public class Deserialization extends JsonDeserializer<ObjectId> {

    @Override
    public ObjectId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText().trim();

        // Check if the value is a valid 24-character hex string
        if (value.length() == 24 && value.matches("[0-9a-fA-F]{24}")) {
            return new ObjectId(value);  // Valid ObjectId
        } else {
            // Log the invalid ObjectId and throw an exception with a detailed error message
            System.err.println("Invalid ObjectId: " + value);
            throw new IllegalArgumentException("Invalid ObjectId: " + value);  // Provide clear feedback
        }
    }
}

