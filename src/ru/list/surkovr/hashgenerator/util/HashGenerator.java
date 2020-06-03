package ru.list.surkovr.hashgenerator.util;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class HashGenerator {

    public Queue<Entity> generateHashes(Queue<Entity> entities) {
        ExecutorService pool = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors() - 2);
        System.out.println("Пул создан");
        Queue<Entity> result = new ConcurrentLinkedQueue<>();
        while (!entities.isEmpty()) {
            Entity entity = Objects.requireNonNull(entities.poll(), "Элемент в очереди - null!");
            Future<Entity> f = pool.submit(getHashed(entity));
            try {
                Entity hashedEntity = f.get();
                if (hashedEntity != null) result.add(hashedEntity);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
        System.out.println("hash сгенерирован results: " + result.size());
        return result;
    }

    public Callable<Entity> getHashed(Entity entity) {
        return () -> {
            System.out.println(entity);
            List<Path> entityFiles = entity.getFiles();
            if (entityFiles == null || entityFiles.isEmpty()) return null;

            File[] files = new File[entityFiles.size()];
            entity.getFiles().stream().map(Path::toFile).collect(Collectors.toList()).toArray(files);
            int hash = Arrays.hashCode(files);
            entity.setHash(hash);
            return entity;
        };
    }
}
