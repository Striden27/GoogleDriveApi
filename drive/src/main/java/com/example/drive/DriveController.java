package com.example.drive;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;

@RestController
@CrossOrigin
public class DriveController {

    @Autowired
    private GoogleDriveService googleDriveService;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        return googleDriveService.uploadFile(file);
    }

    @GetMapping("/download/{id}")
    public void download(@PathVariable String id, HttpServletResponse response) throws Exception {
        var inputStream = googleDriveService.downloadFile(id);
        response.setContentType("application/octet-stream");

        OutputStream out = response.getOutputStream();
        inputStream.transferTo(out);
        out.flush();
        out.close();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) throws Exception {
        googleDriveService.deleteFile(id);
    }
}
