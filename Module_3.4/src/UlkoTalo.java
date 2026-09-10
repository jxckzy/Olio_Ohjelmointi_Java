import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UlkoTalo {
    private static final String URL = "https://users.metropolia.fi/~jarkkov/temploki.csv";
    public static void main(String[] args) {
        try {
            URL myURL = new URL(URL);
            InputStream inputStream = myURL.openStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);

            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("Error: Empty file");
                return;
            }

            String[] headers = headerLine.split(";");
            int ulkoTaloIndex = -1;
            int aikaIndex = -1;

            for (int i = 0; i < headers.length; i++) {
                if (headers[i].trim().equals("UlkoTalo")) {
                    ulkoTaloIndex = i;
                }
                if (headers[i].trim().equals("Aika") || headers[i].trim().equals("DateTime")) {
                    aikaIndex = i;
                }
            }

            if (ulkoTaloIndex == -1) {
                System.out.println("Error: UlkoTalo column not found");
                return;
            }

            if (aikaIndex == -1) {
                System.out.println("Error: DateTime column not found");
                return;
            }

            System.out.println("Found UlkoTalo column at index: " + ulkoTaloIndex);
            System.out.println("Found Aika column at index: " + aikaIndex);

            List<Double> temperatures = new ArrayList<>();
            String line;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] values = line.split(";");
                if (values.length > Math.max(ulkoTaloIndex, aikaIndex)) {
                    try {
                        String dateTimeStr = values[aikaIndex].trim();
                        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
                        if (dateTime.getYear() == 2023 &&
                                dateTime.getMonthValue() == 1 &&
                                dateTime.getDayOfMonth() == 1) {
                            String tempStr = values[ulkoTaloIndex].trim().replace(',', '.');
                            double temperature = Double.parseDouble(tempStr);
                            temperatures.add(temperature);
                        }
                    } catch (NumberFormatException | java.time.format.DateTimeParseException e) {
                        System.out.println("Skipping line with invalid data: " + line);
                    }
                }
            }
            br.close();

            if (temperatures.isEmpty()) {
                System.out.println("No data found for January 1st, 2023");
            } else {
                double sum = 0;
                for (double temp : temperatures) {
                    sum += temp;
                }
                double average = sum / temperatures.size();

                System.out.println("\nResults");
                System.out.println("Number of measurements on 1 January 2023: " + temperatures.size());
                System.out.println("Average temperature: " + String.format("%.2f", average) + "°C");
                System.out.println("Min temperature: " + String.format("%.2f", temperatures.stream().mapToDouble(Double::doubleValue).min().orElse(0)) + "°C");
                System.out.println("Max temperature: " + String.format("%.2f", temperatures.stream().mapToDouble(Double::doubleValue).max().orElse(0)) + "°C");
            }

        } catch (MalformedURLException e) {
            System.out.println("Error: Invalid URL. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}