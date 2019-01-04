package com.cloud.api.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public class FileUtil {
	/**
	 * 文件夹备份
	 * @param source 源文件夹
	 * @param target 目标文件夹
	 * @throws
	 */
	public static void backUpFileDirectory(File source, File target){
		try {
			FileUtils.copyDirectory(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件备份
	 * @param sourcePath 源文件
	 * @param targetPath 目标文件
	 */
	public static void backUpFile(String sourcePath, String targetPath) {
		try {
			File sourceFile = new File(sourcePath);
			File targetFile = new File(targetPath);
			FileUtils.copyFile(sourceFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void backUpInputStreamToFile(InputStream is, File target) {
		try {
			FileUtils.copyToFile(is, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除一个目录
	 * @param dir
	 */
	public static void deleteFileDirectory(String dirPath) {
		try {
			File dir = new File(dirPath);
			FileUtils.deleteDirectory(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
