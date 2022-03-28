package com.qj.util;

import com.qj.framework.R;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


/**
 * 用于上传图片，下载图片等
 */
public class FileUploadUtil {

    public static void copyIMG(MultipartFile file,String path) {

        try {
            InputStream inputStream = file.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            //创建一个缓冲区
            byte buffer[] = new byte[1024];
            //判断输入流中的数据是否已经读完的标识
            int len = -1;
            //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
            while((len=inputStream.read(buffer)) != -1){
                //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(path)当中
                fileOutputStream.write(buffer, 0, len);
            }
            inputStream.close();
            fileOutputStream.close();
            //删除处理文件上传时生成的临时文件
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 文件的上传，记得前端上传的时候
     * @param
     * @return
     */
    public static R uploadIMG(MultipartFile file) {

        /**
         * 在后面放到服务器上面的时候，我们将这个放到绝对路径里面去，将图片也复制到那里。
         */

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static" +
                "\\images\\";
        if (file.isEmpty()) {
            HashMap<String, Object> resultMap = new HashMap<>();
            return R.err().put("message", "请上传图片");
        } else {
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
//            if (".jpg".equals(suffixName)) {
//                return R.err().put("message","图片类型不对，请上传为jpg格式");
//            }
            String filePath = path;//这个path就是你要存在服务器上的
            // 将本地时间格式化
            LocalDateTime time=LocalDateTime.now();
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String strDate2 = dtf2.format(time);

            // 生成的图片命名
            fileName = strDate2.replaceAll(" ","-").replaceAll(":","-") + suffixName;


//            fileName = UUID.randomUUID().toString().replaceAll("-","") + suffixName; // 新文件名
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                copyIMG(file,filePath + fileName);
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return R.ok().put("message","上传图片成功").put("file", dest.getAbsolutePath());
        }
    }
}
