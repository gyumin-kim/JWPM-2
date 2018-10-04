package examples.first.io;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 특정 디렉토리 (ex. /tmp) 이하에 오늘의 날짜로 디렉토리(폴더)를 생성한다. (ex. /tmp/2018/09/11)
 */
public class HW02 {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr = dateFormat.format(new Date());                         // "2018/09/11"
        String pathName = File.separator + "tmp" + File.separator + dateStr;    // "/tmp/2018/09/11"

        File file = new File(pathName);
        if (!file.exists())
            file.mkdirs();
    }
}
