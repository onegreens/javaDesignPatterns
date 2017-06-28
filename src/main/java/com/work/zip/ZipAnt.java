package com.work.zip;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Enumeration;

import static com.work.zip.Zip.unzip;

/**
 * Created by cl on 2017/6/27.
 * ant中的解压方式
 */
public class ZipAnt {

    public static void main(String[] args) {
//        String dir = "D:\\project\\ziptest\\english";
//        String zipPath = "d:\\project\\ziptest\\input";
//        String zipFileName = "0621englsij.zip";
//        try {
//            zip(dir, zipPath, zipFileName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String  unzipFilePath= "D:\\project\\ziptest\\zip\\int\\go_act_comment_315.zip";
        String zipFilePath = "D:\\project\\ziptest\\zip\\out";
        try {
            unZip(unzipFilePath,zipFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 解析附件zip包
     *
     * @param unZipFileName   解压的zip文件
     * @param outputDirectory 输出目录
     */
    public static void unZip(String unZipFileName, String outputDirectory) {
        FileOutputStream fileOut = null;
        InputStream inputStream = null;
        ZipFile zipFile = null;
        File file = null;
        int readedBytes;
        try {

            //创建输出目录
            File outputDirFile = new File(outputDirectory);
            if (!outputDirFile.exists()) {
                outputDirFile.mkdir();
            }

            //这里需要考虑压缩工具是什么，如果是好压的话就需要把它改为UTF-8的编码，如果是WinRAR的话就是GBK编码
            // 然后具体如何判断压缩包是什么压缩的需要参考 http://blog.csdn.net/songylwq/article/details/6139753 这篇文章
            zipFile = new ZipFile(unZipFileName, "UTF-8");
            //不断遍历zip中的文件
            for (Enumeration entries = zipFile.getEntries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String filename = entry.getName();
                file = new File(outputDirectory + File.separator + filename);
                //如果是文件夹先创建
                if (entry.isDirectory()) {
                    file.mkdirs();
                    continue;
                } else { //如果是文件，先查看文件目录是否存在，不存在就创建他
                    File parent = file.getParentFile();
                    if (parent != null && !parent.exists()) {
                        parent.mkdirs();
                    }
                }
                file.createNewFile(); //创建文件
                // 输出文件
                inputStream = zipFile.getInputStream(entry);
                fileOut = new FileOutputStream(file);
                byte[] buf = new byte[1024];
                while ((readedBytes = inputStream.read(buf)) > 0) {
                    fileOut.write(buf, 0, readedBytes);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭文件流
            try {
                if (fileOut != null) {
                    fileOut.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
