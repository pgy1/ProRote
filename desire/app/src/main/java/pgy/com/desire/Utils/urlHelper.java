package pgy.com.desire.Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by pengguangyu on 2015/7/8.
 */
public class urlHelper {
    public byte[] getUrlBytes(String url) throws IOException {
        URL weburl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) weburl.openConnection();

        try{
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();

            if(connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                return null;
            }

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while((bytesRead = in.read(buffer))>0){
                out.write(buffer,0,bytesRead);
            }
            out.close();
            return out.toByteArray();

        }finally {
            connection.disconnect();
        }
    }

    public String getUrl(String url) throws IOException {
        return new String(getUrlBytes(url));
    }
}
