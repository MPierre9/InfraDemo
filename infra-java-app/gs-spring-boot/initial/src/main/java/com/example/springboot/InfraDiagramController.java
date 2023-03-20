package com.example.springboot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.apache.commons.io.IOUtils;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class InfraDiagramController {

    private static final String PASSWORD = "guerilla-games";
    private boolean isPasswordEntered = false;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/error")
    public String handleError() {
        return "index";
    }

    @GetMapping("/infra-diagram")
    public String infraDiagram(@RequestParam(value = "password", required = false) String password, RedirectAttributes redirectAttributes) {
        if (PASSWORD.equals(password)) {
            isPasswordEntered = true;
            return "infraDiagram";
        } else if (password != null) {
            redirectAttributes.addFlashAttribute("error", "Wrong password");
        } else {
            redirectAttributes.addFlashAttribute("error", "Password not entered");
        }
        redirectAttributes.addFlashAttribute("error", "Password not entered");
        return "index";
    }

    @GetMapping("/style.css")
    @ResponseBody
    public String style() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/static/style.css");
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
    }

    @GetMapping("/infrastructure.jpg")
    public ResponseEntity<byte[]> infrastructure() throws IOException {
        if (isPasswordEntered) {
            InputStream inputStream = getClass().getResourceAsStream("/static/infrastructure.jpg");
            byte[] imageBytes = IOUtils.toByteArray(inputStream);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(imageBytes.length);
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
