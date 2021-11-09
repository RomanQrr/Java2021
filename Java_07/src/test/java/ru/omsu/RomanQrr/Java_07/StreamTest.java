package ru.omsu.RomanQrr.Java_07;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;

public class StreamTest {

    @Test
    public void testWriteArrayToStream() throws IOException {
        int[] array = {1, 2, 3, 4, 5};
        byte[] expected = {0,0,0,1, 0,0,0,2, 0,0,0,3, 0,0,0,4, 0,0,0,5};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5* Integer.BYTES);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        Stream.writeArrayToStream(array,byteArrayOutputStream);
        assertArrayEquals(expected,byteArrayOutputStream.toByteArray());
    }

    @Test
    public void testReadArrayFromStream() throws IOException {
        byte[] bytes = {0,0,0,1, 0,0,0,2, 0,0,0,3, 0,0,0,4, 0,0,0,5};
        int[] expected = {1,2,3,4,5};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int[] arr = Stream.readArrayFromStream(byteArrayInputStream);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testWriteArrayFromStreamWithSpace() throws IOException {
        int[] array = {1, 2, 3, 4, 5};
        byte[] expected = {1, 32, 2, 32, 3, 32, 4, 32, 5, 32};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5* Integer.BYTES);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        Stream.writeArrayToStreamWithSpace(array,byteArrayOutputStream);
        assertArrayEquals(expected,byteArrayOutputStream.toByteArray());
    }

    @Test
    public void testReadArrayFromStreamWithSpace() throws IOException {
        byte[] bytes = {1, 32, 2, 32, 3, 32, 4, 32, 5, 32};
        int[] expected = {1,2,3,4,5};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int[] arr = Stream.readArrayFromStreamWithSpace(byteArrayInputStream);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testReadArrayRandomAccessFile() throws IOException {
        int[] arr = {1,2,3,4,5};
        int[] expected = {3,4,5};
        Stream.writeArrayToStream(arr,new FileOutputStream("test.txt"));
        int[] res = Stream.readArrayRandomAccessFile(2, "test.txt");
        assertArrayEquals(expected,res);
    }

    @Test
    public void testFindFilesWithExtension(){
        ArrayList<String> expected = new ArrayList<>();
        Stream dataService = new Stream();
        Collections.addAll(expected, "Flat.java", "House.java", "HouseService.java", "Person.java", "Stream.java");
        ArrayList<String> actual = dataService.findFilesWithExtension("java", new File("./src/main/java/ru/omsu/RomanQrr/Java_07"));
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFindFilesWithExtensionException (){
        Stream dataService = new Stream();
        ArrayList<String> actual = dataService.findFilesWithExtension("java", new File("..\\src\\main\\java\\com\\omsu\\streams"));
    }
}
