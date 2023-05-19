package com.cds.cgv.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cds.cgv.common.status.ErrorStatus;
import com.cds.cgv.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional()
@RequiredArgsConstructor
public class FileService {
    @Value("${cloud.aws.s3.bucket}")
    private String S3Bucket;
    private final AmazonS3Client amazonS3Client;

    public List<String> uploadFiles(MultipartFile[] multipartFileList, String fileType) throws Exception {
        List<String> imagePathList = new ArrayList<>();

        String uploadFilePath="";

        // 폴더명 붙이기
        if(fileType.equals("poster")) {
            uploadFilePath += ("movie/" + fileType);
        } else if (fileType.equals("trailer-thumbnail")) {
            uploadFilePath += ("movie/" + fileType);
        } else if (fileType.equals("inquiry-attach-file")) {
            uploadFilePath += fileType;
        } else if (fileType.equals("event")) {
            uploadFilePath += fileType;
        } else if (fileType.equals("still-cut")) {
            uploadFilePath += fileType;
        } else if (fileType.equals("test")) {
            uploadFilePath += fileType;
        }
        else {
            throw new BaseException(ErrorStatus.INVALID_FILE_TYPE);
        }

        for(MultipartFile multipartFile: multipartFileList) {
            String originalName = multipartFile.getOriginalFilename();  // 파일 이름
            String uploadFileName = getUuidFileName(originalName);      // 중복을 막기 위해 uuid로 문자열 생성

            long size = multipartFile.getSize(); // 파일 크기

            ObjectMetadata objectMetaData = new ObjectMetadata();
            objectMetaData.setContentType(multipartFile.getContentType());
            objectMetaData.setContentLength(size);

            String keyName = uploadFilePath + "/" + uploadFileName; // ex) 파일구분/년/월/일/파일.확장자

            // S3에 업로드
            amazonS3Client.putObject(
                    new PutObjectRequest(S3Bucket, keyName, multipartFile.getInputStream(), objectMetaData)
                            .withCannedAcl(CannedAccessControlList.PublicRead)
            );

            String imagePath = amazonS3Client.getUrl(S3Bucket, keyName).toString(); // 접근가능한 URL 가져오기
            imagePathList.add(imagePath);
        }

        return imagePathList;
    }

    /**
     * UUID 파일명 반환
     */
    public String getUuidFileName(String fileName) {
        String ext = fileName.substring(fileName.indexOf(".") + 1);
        return UUID.randomUUID().toString() + "." + ext;
    }
}

