package com.proficiency_app.proficiency_api.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proficiency_app.proficiency_api.Data.Data;

@Service
public class ImageService extends Data {
    @Autowired
    private ImageRepository ImageRepository;

    public ImageService(ImageRepository ImageRepository) {
        this.ImageRepository = ImageRepository;
    }

    public List<Image> findAll() {
        return ImageRepository.findAll();
    }

    public Optional<Image> findById(String id) {
        return ImageRepository.findById(id);
    }

    public Image save(Image Image) {
        return ImageRepository.save(Image);
    }

    public List<Image> saveAll(List<Image> Images) {
        return ImageRepository.saveAll(Images);
    }

    public List<Image> criarOuAtualizarImages(List<Image> Images) {
        List<Image> novasImages = new ArrayList<>();

        for(Image Image : Images) {
            Optional<Image> ImageExistente = ImageRepository.findById(Image.getId());
            Image _Image =
                ImageExistente.isPresent() ?
                    ImageExistente.get()
                    : new Image();

            _Image.setRaw_data(Image.getRaw_data());
            _Image.setQuestions(Image.getQuestions());
            novasImages.add(
                ImageRepository.save(_Image)
            );
        }

        return novasImages;
    }
}
