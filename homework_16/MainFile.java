public class MainFile {
    public static void main(String[] args) {
        FileData fileData = new FileData("File_1", 1024, "file_1.txt");
        FileData fileData2 = new FileData("File_2", 500, "file_2.txt");
        FileData fileData3 = new FileData("File_3", 2086, "file_3.txt");
        FileData fileData4 = new FileData("File_4", 500, "file_4.txt");
        FileData fileData5 = new FileData("File_5", 300, "file_5.txt");

        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("file_1.txt", fileData);
        fileNavigator.add("file_3.txt", fileData3);
        fileNavigator.add("file_4.txt", fileData4);
        fileNavigator.add("file_5.txt", fileData5);

        System.out.println("Find: " + fileNavigator.find("file_4.txt"));
        System.out.println("Filter by size: " + fileNavigator.filterBySize(2000));
        fileNavigator.remove("file_4.txt");
        System.out.println("Sort by size: " + fileNavigator.sortBySize());
        fileNavigator.add("file_1.txt", fileData2);
    }
}
