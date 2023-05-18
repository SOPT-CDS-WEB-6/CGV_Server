package com.cds.cgv.controller;

import com.cds.cgv.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;
    @PostMapping("")
    public ResponseEntity<Object> uploadFiles(
            @RequestPart("file") MultipartFile[] multipartFileList,
            @RequestParam String fileType
    ) throws Exception {
        List<String> imagePathList = fileService.uploadFiles(multipartFileList, fileType);

        return new ResponseEntity<>(imagePathList, HttpStatus.OK);
    }
}
