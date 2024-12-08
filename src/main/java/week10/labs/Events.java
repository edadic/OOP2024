package week10.labs;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

class Events {
    private static final String[] EVENT_TYPES = {"Login", "Logout", "Purchase", "ViewPage", "Error"};

    public void generateEventsFile(String filename, int recordCount) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Random random = new Random();
            for (int i = 0; i < recordCount; i++) {
                String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String eventType = EVENT_TYPES[random.nextInt(EVENT_TYPES.length)];
                int userId = random.nextInt(1000);
                writer.write(String.format("%s | Event Type: %s | User ID: %d%n", timestamp, eventType, userId));
            }
        }
    }

    public void printEventsFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public ArrayList<String> readEventsFromFile(String filename) throws IOException {
        ArrayList<String> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                events.add(line);
            }
        }
        return events;
    }

    public static void main(String[] args) throws IOException {
        Events events = new Events();
        String filename = "events.txt";

        events.generateEventsFile(filename, 5);
        events.printEventsFromFile(filename);

        ArrayList<String> allEvents = events.readEventsFromFile(filename);
        System.out.println("Retrieved Events:");
        for (String event : allEvents) {
            System.out.println(event);
        }
    }
}

