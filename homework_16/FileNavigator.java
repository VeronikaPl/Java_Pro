import java.nio.file.InvalidPathException;
import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> file = new HashMap<>();

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
        return Collections.emptyList();
    }

    public List<FileData> filterBySize(long fileSize) {
        if (fileSize <= 0) {
            throw new RuntimeException("File's size can't be less or equal 0");
        } else {
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
