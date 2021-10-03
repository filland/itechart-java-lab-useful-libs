package com.itechart.jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {

    private static void writeJSON(Student student) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/main/resources/jackson/student.json"), student);
    }

    private static Student readJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("src/main/resources/jackson/student.json"), Student.class);
    }

    public static void main(String[] args) {

        try {
            Student student = new Student();
            student.setAge(25);
            student.setName("Alex");
            writeJSON(student);

            Student studentFromJsonFile = readJSON();
            System.out.println(studentFromJsonFile);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
