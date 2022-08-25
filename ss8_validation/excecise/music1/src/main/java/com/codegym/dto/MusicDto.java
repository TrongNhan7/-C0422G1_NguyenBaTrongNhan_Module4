package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {

    private Integer id;

    @NotBlank(message = "Nhập vào đi bạn ơi!")
    @Size(max = 800, message = "Nhập ít thôi cha")
    private String name;

    @NotBlank(message = "Nhập vào đi bạn ơi!")
    @Size(max = 300, message = "Nhập vừa thôi mỏi tay")
    @Pattern(regexp = "[a-zA-Z0-9]+[\\sa-zA-Z0-9]*", message = "Không nhập ký tự đặc biệt !")
    private String artist;

    @NotBlank(message = "Nhập vào đi bạn ơi!")
    @Size(max = 1000, message = "Nhập vừa thôi mỏi tay")
    @Pattern(regexp = "[a-zA-Z0-9]+[\\sa-zA-Z0-9\\,]*", message = "Không nhập ký tự đặc biệt ngoài dấu ',' !")
    private String typeMusic;

    public MusicDto() {
    }

    public MusicDto(@NotBlank(message = "Nhập vào đi bạn ơi!") @Size(max = 800, message = "Nhập ít thôi cha") String name, @NotBlank(message = "Nhập vào đi bạn ơi!") @Size(max = 300, message = "Nhập vừa thôi mỏi tay") @Pattern(regexp = "[a-zA-Z0-9]*", message = "Không nhập ký tự đặc biệt !") String artist, @NotBlank(message = "Nhập vào đi bạn ơi!") @Size(max = 1000, message = "Nhập vừa thôi mỏi tay") @Pattern(regexp = "[a-zA-Z0-9/,]*", message = "Không nhập ký tự đặc biệt ngoài dấu ',' !") String typeMusic) {
        this.name = name;
        this.artist = artist;
        this.typeMusic = typeMusic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;

        if (!musicDto.name.matches("[a-zA-Z0-9]+[\\sa-zA-Z0-9]*")) {
            errors.rejectValue("name",
                    "create.name",
                    "Không nhập ký tự đặc biệt !");
        }
    }
}
