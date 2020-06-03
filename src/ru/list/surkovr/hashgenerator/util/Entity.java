package ru.list.surkovr.hashgenerator.util;

import java.nio.file.Path;
import java.util.List;

public class Entity {

    private Path rootDir;
    private List<Path> files;
    private int hash;

    public Path getRootDir() {
        return rootDir;
    }

    public void setRootDir(Path rootDir) {
        this.rootDir = rootDir;
    }

    public List<Path> getFiles() {
        return files;
    }

    public void setFiles(List<Path> files) {
        this.files = files;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "rootDir=" + rootDir +
                ", files=" + files +
                ", hash=" + hash +
                '}';
    }
}
