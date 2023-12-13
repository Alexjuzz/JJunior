package ru.geekbrains.Serialize;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;

public class SerializeStudent {
    private final String FILE_JSON = "Student.json";
    private final String FILE_BIN = "Student.bin";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void saveStudentToFiles(Student student) {
        try {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(FILE_JSON), student);
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_BIN))) {
                    objectOutputStream.writeObject(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openStudentFile(String filename){
        File file = new File(filename);
        Student st = null;
        if(file.exists()){
            try {
                if(filename.endsWith(".json")){
                  st = objectMapper.readValue(file,objectMapper.getTypeFactory().constructType(Student.class));
                }else {
                    try (ObjectInputStream objectInputStream = new ObjectInputStream( new FileInputStream(file))){
                        st = (Student) objectInputStream.readObject();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        showStudents(st);
    }
    public void showStudents(Student student){
        System.out.println(student);
    }
}
