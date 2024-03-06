package com.example.bv111hospital.controller;

import com.example.bv111hospital.entity.Image;
import com.example.bv111hospital.service.DoctorService;
import com.example.bv111hospital.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ImageController {


    private ImageService imageService;

    private DoctorService doctorService;


    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }


    @PostMapping("/upload/{doctorId}")
    public String uploadImageToDoctor(@RequestParam("file") MultipartFile file,
                                   @PathVariable("doctorId") Integer doctorId) throws IOException {
        imageService.uploadImageToDoctor(file, doctorService.getById(doctorId));
        return "redirect:/doctor/info/{doctorId}";
    }

//    @PostMapping("/upload_add/{carId}")
//    public String uploadImageToAddCar(@RequestParam("file") MultipartFile file,
//                                    @PathVariable("carId") Long carId) throws IOException {
//        imageUploadService.uploadImageToCar(file, carService.findCarById(carId));
//        return "redirect:/add_car";
//    }

    @GetMapping("/image/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
        Image image = imageService.getImageToDoctor(id);
        if (image == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(image.getContent());
    }

    @GetMapping("{doctorId}/image")
    public String getImageForDoctor(@PathVariable("doctorId")Integer doctorId, Model model) {
        Image carImage = imageService.getImageToDoctor(doctorId);
        model.addAttribute("img", carImage);
        return "doctor-info";
    }





}
