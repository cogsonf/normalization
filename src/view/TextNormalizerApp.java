package view;

import controller.TextNormalizerController;
import model.TextNormalizerModel;

public class TextNormalizerApp {
    public static void main(String[] args) {
        TextNormalizerModel model = new TextNormalizerModel();
        TextNormalizerView view = new TextNormalizerView();
        TextNormalizerController controller = new TextNormalizerController(model, view);

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            controller.processTextFile(inputFile, outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}