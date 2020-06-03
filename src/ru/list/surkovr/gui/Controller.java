package ru.list.surkovr.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.list.surkovr.hashgenerator.App;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Controller {

    private String src;
    private String out;
    private App app = new App();
    boolean isResultWritten = false;
    boolean isGenerated = false;

    @FXML
    private TextField inputSrc;

    @FXML
    private Button btnGenerate;

    @FXML
    private TextField inputOutFile;

    @FXML
    private Button btnExport;

    @FXML
    private Button btnOpen;

    @FXML
    private TextArea fieldMsg;

    public void initialize() {
        btnGenerate.setOnAction(e -> {
            fieldMsg.clear();
            out = null;
            isResultWritten = false;
            isGenerated = false;
            src = inputSrc.getText();
            if (src == null || src.isBlank()) {
                fieldMsg.appendText("Введите исходную папку\n");
            } else if (!Files.isDirectory(Path.of(src))) {
                fieldMsg.appendText("Исходная папка не распознана, проверьте путь\n");
            } else {
                app.setSrcPath(src);
                isGenerated = app.generate();
                String res = isGenerated ? "Хэшкоды успешно сгенерированы\n" :
                        "Не удалось сгенерировать хэшкоды. Проверьте исходную папку и подпапки на наличие файлов\n";
                fieldMsg.appendText(res);
            }
        });

        btnExport.setOnAction(e -> {
            fieldMsg.clear();
            if (!isGenerated) {
                fieldMsg.appendText("Перед записью необходимо сгенерировать хэшкоды \n");
                return;
            }
            out = inputOutFile.getText();
            if (out == null || out.isBlank()) {
                fieldMsg.appendText("Введите папку назначения\n");
            } else {
                app.setResultFile(out);
                isResultWritten = app.writeResults();
                if (isResultWritten) {
                    fieldMsg.appendText("Результаты успешно экспортированы в файл " + out + "\n");
                } else {
                    fieldMsg.appendText("Не удалось экспортировать результаты в файл " + out + "\n");
                }
            }
        });

        btnOpen.setOnAction(e -> {
            fieldMsg.clear();
            if (isGenerated && isResultWritten) {
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c start " + out);
                } catch (IOException ioException) {
                    fieldMsg.appendText("Не удалось открыть найти файл " + out + "\n");
                    ioException.printStackTrace();
                }
            } else {
                fieldMsg.appendText("Требуется сгенерировать хэшкоды и экспортировать результаты\n");
            }
        });

//        btnOpen.setOnAction(e -> {
//            if (isResultWritten) {
//
//            }
//
//
//        });
    }
}
