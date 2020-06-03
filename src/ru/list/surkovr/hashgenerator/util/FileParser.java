package ru.list.surkovr.hashgenerator.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class FileParser {

    public FileParser() {
    }

    public Queue<Entity> getFileList(String dir) {
        Queue<Entity> entities = null;
        try {
            entities = Files.list(Path.of(dir))
                    .filter(p -> Files.isDirectory(p))
                    .map(d -> {
                        Entity e = new Entity();
                        List<Path> fileList = null;
                        try {
                            fileList = Files.list(d).filter(Files::isRegularFile).collect(Collectors.toList());
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        e.setRootDir(d);
                        e.setFiles(fileList);
                        return e;
                    })
                    .collect(Collectors.toCollection(ConcurrentLinkedQueue::new));
        } catch (IOException e) {
            System.out.println("IN getFilesList: Не удалось получить список файлов в директории " + dir);
            e.printStackTrace();
        }
        return entities;
    }
}
