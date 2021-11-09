package ru.omsu.RomanQrr.Java_07;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class HouseService {
    //6
    public static void serialize(OutputStream out, House house) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(house);
        os.close();
    }

    public static House deserialize(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(in);
        return (House) is.readObject();
    }

    public static void serializeHouse(House house, String file) throws IOException {
        try (ObjectOutput out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            out.writeObject(house);
        }
    }

    public static House deserializeHouse(String filename) throws IOException, ClassNotFoundException, ClassCastException {
        try (ObjectInput in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            return (House) in.readObject();
        }
    }
    public static String serializeHouseJSON(House house) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(house);
    }

    public static House deserializeHouseJSON(String jsonString) throws IOException {
        return new ObjectMapper().readValue(jsonString, House.class);
    }

}
