package com.jinny.java.general.Utils;

import java.io.*;

public class FileUtils {


    /**
     * 파일내에 단어 찾기
     * 파일 내용 중 filterText가 포함 된 row 만 뽑아서 반환한다.
     * @param fileName
     * @param filterText
     * @return
     */
    public static String findTextRows( String fileName, String filterText ){
        StringBuffer fileContent = new StringBuffer("");
        BufferedReader br = null;
        try{
            br = new BufferedReader( new FileReader( fileName ));
            String line = "";
            while( ( line = br.readLine() ) != null ){
                if(line.indexOf(filterText) > -1){
                    fileContent.append(line);
                    System.out.println(line);
                }
            }
            System.out.println( "[" + fileName + "] read complete." );
        }catch( Exception e){
            e.printStackTrace();
        }finally{
            try{
                br.close();
                br = null;
            }catch( Exception ignored ){}
        }
        return fileContent.toString();
    }


    /**
     * 정해진 TEXT 로 파일 생성
     * @param fileName
     * @param fileContent
     * @return
     */
    public static boolean writeFile( String fileName, String fileContent ){
        boolean succeed = true;
        File file = null;
        BufferedWriter bw = null;
        try{
            file = new File( fileName );
            bw = new BufferedWriter( new FileWriter( file ) );
            bw.write( fileContent );
            System.out.println( "[" + fileName + "] write complete." );
        }catch( Exception e) {
            e.printStackTrace();
            succeed = false;
        }finally{
            try{
                bw.close();
                bw = null;
            }catch( Exception ignored){}
        }
        return succeed;
    }
}
