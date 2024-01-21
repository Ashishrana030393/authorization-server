package com.django.user.resource;

import com.django.user.service.RegisteredClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("client")
public class ClientResource {
    private final RegisteredClientService registeredClientService;

    public ClientResource(RegisteredClientService registeredClientService) {
        this.registeredClientService = registeredClientService;
    }

    @PostMapping(value = "upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadClient(@RequestPart("file")MultipartFile file) throws IOException {
        Integer integer = this.registeredClientService.uploadRegisteredClient(file);
        return ResponseEntity.ok(integer);
    }
}
