package io;

import java.io.*;


public class DirectoryCopyDemo {
    public static void main(String args[]) throws IOException {
        String source = "***";
        String target = "***";
        copy(source, target);
    }

    public static void copy(String source, String target) throws IOException {
        if (!new File(source).exists()) {
            (new File(target)).mkdirs();
        }
        File[] file = new File(source).listFiles();
        for (File value : file) {
            if (value.isFile()) {
                copyFile(value, new File(target + "/" + value.getName()));
            }
            if (value.isDirectory()) {
                String sourceDir = source + File.separator + value.getName();
                String targetDir = target + File.separator + value.getName();
                copyDirectory(sourceDir, targetDir);
            }
        }
    }

    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            outBuff.flush();
        } finally {
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }

    public static void copyDirectory(String sourceDir, String targetDir) throws IOException {
        (new File(targetDir)).mkdirs();
        File[] file = (new File(sourceDir)).listFiles();
        for (File value : file) {
            if (value.isFile()) {
                File sourceFile = value;
                File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + value.getName());
                copyFile(sourceFile, targetFile);
            }
            if (value.isDirectory()) {
                String dir1 = sourceDir + "/" + value.getName();
                String dir2 = targetDir + "/" + value.getName();
                copyDirectory(dir1, dir2);
            }
        }
    }
}
