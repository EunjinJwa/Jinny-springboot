import dev.jinny.java.utils.FileUtils;

public class FileUtilsTest {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\eunji\\Desktop/";
        String fileName = "";
        String resultText = FileUtils.findTextRows(filePath + fileName, "sessionId");
        boolean writeResult = FileUtils.writeFile(filePath + "handList_sessionIds.json" , resultText);
        System.out.println(writeResult);

    }
}
