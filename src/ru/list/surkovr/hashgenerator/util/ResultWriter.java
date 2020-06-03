package ru.list.surkovr.hashgenerator.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Queue;
import java.util.stream.Collectors;

public class ResultWriter {

    private Queue<Entity> entities;

    public ResultWriter(Queue<Entity> entities) {
        this.entities = entities;
    }

    public Queue<Entity> getEntities() {
        return entities;
    }

    public void setEntities(Queue<Entity> entities) {
        this.entities = entities;
    }

    public boolean writeResultsToFile(String pathToFile) {
        try {
            if (Files.notExists(Path.of(pathToFile))) {
                Files.createDirectories(Paths.get(pathToFile).getParent());
                Files.createFile(Path.of(pathToFile));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        File resultFile = new File(pathToFile);
        try (
                FileWriter fileWriter = new FileWriter(resultFile, StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(fileWriter)) {
            while (!entities.isEmpty()) {
                Entity temp = entities.poll();
                String s = temp.getRootDir().toString() + ";" + temp.getHash() + ";"
                        + temp.getFiles().stream().map(Path::toString).collect(Collectors.joining(";"));
                System.out.println("Пишем " + s);
                bw.write(s + "\n");
            }
            bw.flush();
            System.out.println("Файлы записаны");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
