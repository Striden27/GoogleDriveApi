package com.example.drive;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Collections;

@Service
public class GoogleDriveService {

    private final Drive driveService;

    public GoogleDriveService() throws Exception {
        this.driveService = GoogleDriveConfig.getInstance();
    }

    public String uploadFile(MultipartFile multipartFile) throws Exception {
        File fileMetadata = new File();
        fileMetadata.setName(multipartFile.getOriginalFilename());

        InputStream inputStream = multipartFile.getInputStream();
        var mediaContent = new com.google.api.client.http.InputStreamContent(
                multipartFile.getContentType(), inputStream);

        File file = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();

        return file.getId();
    }

    public InputStream downloadFile(String fileId) throws Exception {
        return driveService.files().get(fileId).executeMediaAsInputStream();
    }

    public void deleteFile(String fileId) throws Exception {
        driveService.files().delete(fileId).execute();
    }
}
