package model;

public class TextNormalizerModel {
    public String normalizeText(String input) {
        
        String normalizedText = input.replaceAll("\\s+", " ");

      
        normalizedText = normalizedText.replaceAll("\\s*,\\s*", ", ");
        normalizedText = normalizedText.replaceAll("\\s*\\.\\s*", ". ");
        normalizedText = normalizedText.replaceAll("\\s*:\\s*", ": ");

        String[] sentences = normalizedText.split("\\.");
        StringBuilder result = new StringBuilder();
        for (String sentence : sentences) {
            sentence = sentence.trim();
            if (!sentence.isEmpty()) {
                String[] words = sentence.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if (i == 0) {
                        words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
                    } else {
                        words[i] = words[i].toLowerCase();
                    }
                }
                result.append(String.join(" ", words)).append(". ");
            }
        }
       
        normalizedText = result.toString().replaceAll("\\s*\"\\s*", "\"").replaceAll("\\s*\"\\s*", "\"");

        String[] lines = normalizedText.split("\\n");
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].trim();
            if (!lines[i].isEmpty()) {
                if (i == 0) {
                    lines[i] = lines[i].substring(0, 1).toUpperCase() + lines[i].substring(1);
                }
                finalResult.append(lines[i]).append("\n");
            }
        }

        finalResult = new StringBuilder(finalResult.toString().replaceAll("\\n\\s*\\n", "\n"));

        finalResult = new StringBuilder(finalResult.toString().replaceAll("\\s*\\,", ",").replaceAll("\\s*\\.", "."));

        finalResult = new StringBuilder(finalResult.toString().trim() + ".");

        return finalResult.toString();
    }
}
