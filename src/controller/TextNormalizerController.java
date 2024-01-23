package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.TextNormalizerModel;
import view. TextNormalizerView;
public class TextNormalizerController {
    private TextNormalizerModel model;
    private TextNormalizerView view;

    public TextNormalizerController(TextNormalizerModel model, TextNormalizerView view) {
        this.model = model;
        this.view = view;
    }

    public void processTextFile(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            StringBuilder inputText = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                inputText.append(line).append("\n");
            }

            String normalizedText = model.normalizeText(inputText.toString());

            bw.write(normalizedText);

            view.displayOutput(normalizedText);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}