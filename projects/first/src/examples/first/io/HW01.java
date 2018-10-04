package examples.first.io;

import java.io.File;

/**
 * 현재 디렉토리 이하의 파일들을 탐색하여, 전체 파일 크기의 합을 출력하시오.
 */
public class HW01 {
    public static void main(String[] args) {
        File file = new File(".");
        File[] files = file.listFiles();    // 현재 경로에 있는 모든 파일 리스트(배열)를 리턴

        long projectSize = 0L;
        if (files.length != 0)
            projectSize = getSize(files);

        System.out.println("현재 경로에 있는 모든 파일의 size는 " + projectSize + " byte입니다.");
//        DecimalFormat df = new DecimalFormat("###,###");
//        System.out.println("현재 경로에 있는 모든 파일의 size는 " + df.format(projectSize) + " byte입니다.");
    }

    public static long getSize(File[] files) {
        long size = 0L;

        for (File f : files) {
            if (f.isDirectory()) {
                File[] children = f.listFiles();
                size += getSize(children);
            }
            else
                size += f.length();
        }

        return size;
    }
}
