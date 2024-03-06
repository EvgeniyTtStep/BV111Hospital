package com.example.bv111hospital.service;

import com.example.bv111hospital.entity.Doctor;
import com.example.bv111hospital.entity.Image;
import com.example.bv111hospital.repository.ImageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ImageService {

    private ImageRepo imageRepository;

    public static final Logger LOG = LoggerFactory.getLogger(ImageService.class);

    @Autowired
    public void setImageRepo(ImageRepo imageRepo) {
        this.imageRepository = imageRepo;
    }

    public void uploadImageToDoctor(MultipartFile file, Doctor doctor) throws IOException {

        Image doctorProfileImage = imageRepository.findByDoctorId((long)doctor.getIdDoctors());
        if (!ObjectUtils.isEmpty(doctorProfileImage)) {
            imageRepository.delete(doctorProfileImage);
        }
        Image image = new Image();
        image.setDoctorId((long)doctor.getIdDoctors());
        image.setContent(compressBytes(file.getBytes()));
        image.setContentType(file.getContentType());
        image.setName(file.getOriginalFilename());
        imageRepository.save(image);
    }


    public Image getImageToDoctor(Integer id) {
        Image image = imageRepository.findByDoctorId((long)id);
        if (!ObjectUtils.isEmpty(image)) {
            image.setContent(decompressBytes(image.getContent()));
        }
        return image;
    }


    private byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            LOG.error("Cannot compress Bytes");
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    private static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException e) {
            LOG.error("Cannot decompress Bytes");
        }
        return outputStream.toByteArray();
    }


}
