package org.dp.arsene.facade;

import java.io.File;

public class FacadeVideoConverter {

    public static void main(String[] args) {
        final VideoConversionFacade facade = new VideoConversionFacade();
        facade.convertVideo("rihanna_ft_tpain.mkv","mp4");
    }
}

interface Codec {

}

class VideoFile {
    private final String name;
    private final String codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }

    public String getName() {
        return name;
    }

    public String getCodecType() {
        return codecType;
    }
}

class MPEG4CompressionCodec implements Codec {
    public String type = "mp4";
}


class OggCompressionCodec implements Codec {
    public String type = "ogg";
}

class CodecFactory {

    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();

        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        } else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}


class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}


class AudioMixer {
    public File fix(VideoFile result) {
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}

class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");

        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;

        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }

        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed. ");

        return result;
    }
}