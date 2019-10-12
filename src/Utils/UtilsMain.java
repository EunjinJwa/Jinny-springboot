package Utils;

public class UtilsMain {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\eunji\\Desktop/";
        String fileName = "";
        String resultText = FileUtils.findTextRows(filePath + fileName, "sessionId");
        boolean writeResult = FileUtils.writeFile(filePath + "handList_sessionIds.json" , resultText);
        System.out.println(writeResult);

    }
}
