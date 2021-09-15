package com.dx.project.controller;

import com.dx.project.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: dx
 * @CreateTime: 2021-09-14 14:15
 * @Description: ${Description}
 */

@Controller
@RequestMapping("/files")
public class FileController {
    @PostMapping("/upload")
    @ResponseBody
    public Result upload(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String rootFilePath = System.getProperty("user.dir") + "/spring-boot-project/src/main/resources/files/" + originalFilename;
        File newFile = new File("C:\\Users\\Administrator\\Desktop\\vue\\spring-boot-project\\src\\main\\resources\\files\\" + originalFilename);
        newFile.setWritable(true);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(newFile);
            byte[] bytes = file.getBytes();
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    return Result.success();
    }

    @GetMapping("/{flag}")
    public void getFiles(HttpServletResponse response, @PathVariable String flag){
        File newFile = new File("C:\\Users\\Administrator\\Desktop\\vue\\spring-boot-project\\src\\main\\resources\\files\\" + originalFilename);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(newFile);
            byte [] buf = new byte[512];
            int len = -1;
            ServletOutputStream os = response.getOutputStream();
            while((len = fis.read(buf)) != -1){
                os.write(buf,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
