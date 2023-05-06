import java.util.Objects;

public class FileData {
    private String fileName;
    private long fileSize;
    private String pathToFile;

    public FileData(String fileName, long fileSize, String pathToFile) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.pathToFile = pathToFile;
    }

    public String getName() {
        return fileName;
    }

    public void setName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return fileSize == fileData.fileSize && Objects.equals(fileName, fileData.fileName) && Objects.equals(pathToFile, fileData.pathToFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, fileSize, pathToFile);
    }

    @Override
    public String toString() {
        return "\nFileData{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", pathToFile='" + pathToFile + '\'' +
                '}';
    }
}
