package com.example.demo.domain.dto.s3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileResponseDTO {
    private String fileUrl;    // 파일 URL
}

