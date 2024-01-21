package com.django.user.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RegisteredClientService {
    Integer uploadRegisteredClient(MultipartFile file) throws IOException;
}
