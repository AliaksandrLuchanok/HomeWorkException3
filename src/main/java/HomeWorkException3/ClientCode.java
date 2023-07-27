package HomeWorkException3;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ClientCode {
    public static void main(String[] args) {
        try {
            ServiceCreateHuman.createHuman();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
