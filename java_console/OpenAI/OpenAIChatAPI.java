package OpenAI;

import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// import com.google.gson.JsonObject;

public class OpenAIChatAPI {

    private static final String OPENAI_API_KEY = "";

    // private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public static String requestChatCompletions(String imageUrl, String category) throws IOException {
        String apiUrl = "https://api.openai.com/v1/chat/completions";

        // Construct JSON payload with the provided image URL
        String jsonPayload = buildJsonPayload(imageUrl, category);

        // Create HTTP connection
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + OPENAI_API_KEY);
        connection.setDoOutput(true);

        // Write JSON payload to the connection output stream
        try (OutputStream os = connection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
            writer.write(jsonPayload);
            writer.flush();
        }

        // Get HTTP response code
        int responseCode = connection.getResponseCode();
        // System.out.println("Response Code: " + responseCode);
        StringBuilder response = new StringBuilder();

        // Read and build the response body (extracting content)
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                // StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                // System.out.println("Response Body: " + response);
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()))) {
                StringBuilder errorResponse = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    errorResponse.append(line);
                }
                System.out.println("Error Response Body: " + errorResponse.toString());
            }
        }
        

        // Close the connection
        connection.disconnect();

        return extractContentText(response.toString());
    }

    private static String extractContentText(String responseBody) {
        // Define a regular expression pattern to match the "content" value within "message"
        Pattern pattern = Pattern.compile("\"content\": \"(.*?)\"");

        // Use a Matcher to find the content value
        Matcher matcher = pattern.matcher(responseBody);
        if (matcher.find()) {
            String contentText = matcher.group(1);

            // Remove unwanted characters (\n, *, **)
            // contentText = contentText.replace("\\n", ""); // Remove \n
            // contentText = contentText.replace("*", "");   // Remove *
            // contentText = contentText.replace("---", ""); 
            // contentText = contentText.replace("-", "");   // Remove *  // Remove *
            // contentText = contentText.replace("**", "");  // Remove **

            // Trim leading and trailing spaces
            contentText = contentText.trim();
            // System.out.println(contentText);
            return contentText;
        } else {
            return null; // If no match is found, return null or handle accordingly
        }
    }

    // Method to build JSON payload with the provided image URL and category
private static String buildJsonPayload(String imageUrl, String category) {
    return "{\n" +
        "  \"model\": \"gpt-4-turbo\",\n" +
        "  \"messages\": [\n" +
        "    {\n" +
        "      \"role\": \"user\",\n" +
        "      \"content\": [\n" +
        "        {\n" +
        "          \"type\": \"text\",\n" +
        "          \"text\": \"Provide a complete information of the image to write a description for on the e-commerce platform under category "+category+". \"\n" +
        "        },\n" +
        "        {\n" +
        "          \"type\": \"image_url\",\n" +
        "          \"image_url\": {\n" +
        "            \"url\": \"" + imageUrl + "\"\n" +
        "          }\n" +
        "        }\n" +
        "      ]\n" +
        "    }\n" +
        "  ],\n" +
        "  \"max_tokens\": 300\n" +
        "}";
}


    public static String getResponseFromOpenAI(String imgURL, String category) {
        try {
            return requestChatCompletions(imgURL, category);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
