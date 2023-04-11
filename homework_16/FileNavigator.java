import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class FileNavigator {
    private HashMap<String, List<FileData>> file;

    public FileNavigator() {
        this.file = new HashMap<>();
    }

    public HashMap<String, List<FileData>> getFile() {
        return file;
    }

    public void setFile(HashMap<String, List<FileData>> file) {
        this.file = file;
    }

    public void add(String pathToFile, FileData fileData) {
        if (!pathToFile.equals(fileData.getPathToFile())) {
            throw new InvalidPathException(pathToFile, "Path to file: " + fileData.getPathToFile() + " doesn't match to key-path");
        }
        if (!file.containsKey(pathToFile)) {
            List<FileData> fileList = new ArrayList<>();
            fileList.add(fileData);
            file.put(pathToFile, fileList);
        } else {
            file.get(pathToFile).add(fileData);
        }
    }

    public List<FileData> find(String pathToFile) {
        if (file.containsKey(pathToFile)) {
            return file.get(pathToFile);
        }
        return new ArrayList<>();
    }

    public List<FileData> filterBySize(long fileSize) {
        List<FileData> filterList = new ArrayList<>();
        for (List<FileData> fileDataList : file.values()) {
            for (FileData fileData : fileDataList) {
                if (fileData.getFileSize() <= fileSize) {
                    filterList.add(fileData);
                }
            }
        }
        return filterList;
    }

    public void remove(String pathToFile) {
        if (file.containsKey(pathToFile)) {
            file.remove(pathToFile);
        }
    }

    public List<FileData> sortBySize() {
        TreeMap<Long, List<FileData>> map = new TreeMap<>();
        for (List<FileData> fileDataList : file.values()) {
            for (FileData fileData : fileDataList) {
                map.put(fileData.getFileSize(), fileDataList);
            }
        }

        List<FileData> sortedMap = new ArrayList<>();
        for (List<FileData> fileDataList : map.values()) {
            sortedMap.addAll(fileDataList);
        }
        return sortedMap;
    }
}
