package com.JustWeDemo.tool;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;

/**
 * 扫描文件名
 */
public class ScanFileName {

    //所有文件信息
    public static Map<String, String> fileInfo_All;//key: 文件编号 value:文件全名称

    //重复文件信息
    public static List<String> fileInfo_Existence;//key: 文件编号 value:文件全名称

    /**
     * 自测
     *
     * @param args
     */
    public static void main(String[] args) {
        String path_dir = "I:\\bigShow\\番号";//扫描路径
        List<String> filterFormat = new ArrayList<String>();//需过滤的文件格式
        filterFormat.add("jpg");
        filterFormat.add("gif");

        fileInfo_All = new HashMap<String, String>();
        fileInfo_Existence = new ArrayList<String>();

        scanAndFilterFileName(path_dir, filterFormat);

        System.out.println("扫描完毕，重复文件:");
        fileInfo_Existence = new ArrayList<String>(new TreeSet<String>(fileInfo_Existence));
        for (String fileName : fileInfo_Existence) {
            System.out.println(fileName);
        }
    }


    /**
     * 扫描出重复文件名
     *
     * @param path_scan    扫描路径
     * @param filterFormat 需过滤的文件格式
     */
    public static void scanAndFilterFileName(String path_scan, List<String> filterFormat) {
        if (StringUtils.isBlank(path_scan)) {
            System.out.println("扫描路径不正确!");
            return;
        }

        File file_dir = new File(path_scan);
        if (file_dir.isDirectory()) {
            File[] filelist = file_dir.listFiles();
            for (int i = 0; i < filelist.length; i++) {
                if (filelist[i].isDirectory()) {
                    /** 如果当前是文件夹，进入递归扫描文件夹 **/
                    scanAndFilterFileName(filelist[i].getAbsolutePath(), filterFormat);
                } else {
                    String fileNameTemp = filelist[i].getName();
                    String fileNumTemp = StringUtils.substring(fileNameTemp, 0, StringUtils.indexOf(fileNameTemp, " ")).toUpperCase();//文件编号
                    String formatNameTemp = StringUtils.substring(fileNameTemp, (StringUtils.lastIndexOf(fileNameTemp, ".") + 1));//文件后缀
                    /** 过滤文件格式 **/
                    if (!filterFormat.contains(formatNameTemp.toLowerCase())) {
                        /** 检查是否重复 **/
                        String fileNameExistence = fileInfo_All.get(fileNumTemp);
                        if (StringUtils.isEmpty(fileNameExistence)) {
                            fileInfo_All.put(fileNumTemp, fileNameTemp);
                        } else {
                            /** 将重复的文件名存入集合 **/
                            fileInfo_Existence.add(fileNameTemp);
                            fileInfo_Existence.add(fileNameExistence);
//                            System.out.println("存在重复编号文件:" + fileNameTemp);
                        }
                    }
                }
            }
        } else {
            System.out.println("就一个文件，玩闹呢?");
        }
    }

}
