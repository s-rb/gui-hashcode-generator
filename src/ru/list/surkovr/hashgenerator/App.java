package ru.list.surkovr.hashgenerator;

import ru.list.surkovr.hashgenerator.util.Entity;
import ru.list.surkovr.hashgenerator.util.FileParser;
import ru.list.surkovr.hashgenerator.util.HashGenerator;
import ru.list.surkovr.hashgenerator.util.ResultWriter;

import java.util.Queue;

public class App {

    private String srcPath;
    private String resultFile;
    private Queue<Entity> hashedEntities;

    public boolean generate() {
        // Используем без учета поддиректорий
        FileParser fileParser = new FileParser();
        Queue<Entity> entities = getFiles(fileParser);
        System.out.println("В переданной папке найдено " + entities.size() + " субдиректорий");
        HashGenerator hashGenerator = new HashGenerator();
        hashedEntities = hashGenerator.generateHashes(entities);
        System.out.println("Количество хэшсущностей: " + hashedEntities.size());
        return !hashedEntities.isEmpty();
    }

    public boolean writeResults() {
        ResultWriter resultWriter = new ResultWriter(hashedEntities);
        resultWriter.writeResultsToFile(resultFile);
        System.out.println("Результаты записаны в файл " + resultFile);
        return true;
    }


    private Queue<Entity> getFiles(FileParser fileParser) {
        Queue<Entity> entities;
        while (true) {
            entities = fileParser.getFileList(srcPath);
            if (entities != null && !entities.isEmpty()) break;
            System.out.println("Файлы отсутствут в указанной директории");
        }
        return entities;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getResultFile() {
        return resultFile;
    }

    public void setResultFile(String resultFile) {
        this.resultFile = resultFile;
    }
}
