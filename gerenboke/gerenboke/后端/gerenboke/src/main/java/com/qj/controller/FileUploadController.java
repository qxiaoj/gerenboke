package com.qj.controller;

import com.qj.entity.User;
import com.qj.framework.R;
import com.qj.util.FileUploadUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    @RequestMapping(value = "/imgUpload", method = { RequestMethod.POST})
    public R modifyData(@RequestParam("file")MultipartFile multipartFile) {

        System.out.println("访问");
        System.out.println(multipartFile.getOriginalFilename());
        return FileUploadUtil.uploadIMG(multipartFile);
    }
}

