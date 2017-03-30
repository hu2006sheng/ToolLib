package org.husheng.toolslibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片转字符串
 */
public class ReadImgToBinary2 {

    /**
     * 图片转base64
     * @param imgPath
     * @param bitmap
     * @param imgFormat 图片格式
     * @return
     */
    public static String imgToBase64(String imgPath, Bitmap bitmap) {
        if (!TextUtils.isEmpty(imgPath) && imgPath.length() > 0) {
            bitmap = readBitmap(imgPath);
        }
        if(bitmap != null){
            ByteArrayOutputStream out = null;
            try {
                out = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.flush();
                out.close();
                byte[] imgBytes = out.toByteArray();
                return Base64.encodeToString(imgBytes, Base64.DEFAULT);
            } catch (Exception e) {
                return null;
            } finally {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            return null;
        }
    }

    private static Bitmap readBitmap(String imgPath) {
        try {
            return BitmapFactory.decodeFile(imgPath);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return null;
        }

    }

    /**
     *
     * @param base64Data
     * @param imgName
     * @param imgFormat 图片格式
     */
    public static void base64ToBitmap(String base64Data, String imgName, String imgFormat) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        File myCaptureFile = new File("/sdcard/", imgName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(myCaptureFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        boolean isTu = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        if (isTu) {
            // fos.notifyAll();
            try {
                fos.flush();
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
