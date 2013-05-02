/**
 * 
 */
package com.soullleo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class Description      
 *                            
 * @version  V1.0         
 * @Date     2011-3-17         
 * @author   E019481          
 * @Comment  Created     
 */
public class FileUtil {

	public static File copyFile(File sourceFile, String targetFilePath, String targetFileName) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd/HHmmss");
        File folder = new File(targetFilePath + f.format(new Date()) + "/");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File copyToFile = new File(folder, targetFileName);

        try {
            FileChannel srcChannel = new FileInputStream(sourceFile).getChannel();
            FileChannel dstChannel = new FileOutputStream(copyToFile).getChannel();
            dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
            srcChannel.close();
            dstChannel.close();
        } catch (FileNotFoundException fnfe) {
        	fnfe.printStackTrace();
        } catch (IOException ioe) {
        	ioe.printStackTrace();
        }
        return copyToFile;

    }
}
