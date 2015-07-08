package pgy.com.desire.Utils;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by pengguangyu on 2015/7/7.
 */
public class fileHelper {

    private String SDPATH;

    public String getSDPATH() {
        return SDPATH;
    }

    public fileHelper() {
        // get the sdcard'path
        SDPATH = Environment.getExternalStorageDirectory() + "/";
    }


    /**
     * whether the file exsit or not
     *
     * @param fileName
     * @return
     */
    public boolean isFileExist(String filePath) {
        File file = new File(filePath);
        if(file.exists()){
            return true;
        }
        return false;
    }

    public boolean existCard() throws IOException {
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }

    /**
     * whether the file exsit ,create dir for this SDpath
     *
     * @param dirName
     * @return
     */
    public File createSDDir(String dirName) throws IOException {
        if (existCard()) {
            File dir = new File(SDPATH + dirName);
            dir.mkdir();
            return dir;
        } else {
            return null;
        }
    }

    /**
     * whether the file exsit ,create dir for this path
     *
     * @param filename
     * @return
     */
    public void createFile(String filename) throws IOException {
        File file = new File(filename);
        if(!file.exists()) {
            file.createNewFile();
        }
    }
}
