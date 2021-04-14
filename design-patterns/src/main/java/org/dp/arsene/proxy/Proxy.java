package org.dp.arsene.proxy;

public class Proxy {
    void init() {
        ThirdPartyYoutube youtubeService = new ThirdPartyYoutube();
        CachedYoutube youtubeProxy = new CachedYoutube(youtubeService);
        YoutubeManager manager = new YoutubeManager(youtubeProxy);
        manager.reactOnUserInput(5);
    }
}


interface ThirdPartyYoutubeLib {

    String listVideos();

    String getVideoInfo(int id);

    void downloadVideo(int id);
}

class CachedYoutube implements ThirdPartyYoutubeLib {

    private final ThirdPartyYoutubeLib service;
    private String listCache, videoCache;
    boolean needReset;

    CachedYoutube(ThirdPartyYoutubeLib service) {
        this.service = service;
    }

    @Override
    public String listVideos() {
        if (listCache.isBlank() || needReset) {
            listCache = service.listVideos();
        }
        return listCache;
    }

    @Override
    public String getVideoInfo(int id) {
        if (videoCache.isBlank() || needReset) {
            videoCache = service.getVideoInfo(id);
        }
        return videoCache;
    }

    @Override
    public void downloadVideo(int id) {
        service.downloadVideo(id);
    }
}

class ThirdPartyYoutube implements ThirdPartyYoutubeLib {

    @Override
    public String listVideos() {
        return null;
    }

    @Override
    public String getVideoInfo(int id) {
        return null;
    }

    @Override
    public void downloadVideo(int id) {

    }
}

class YoutubeManager {

    private final ThirdPartyYoutubeLib service;

    YoutubeManager(ThirdPartyYoutubeLib service) {
        this.service = service;
    }

    void renderVideoPage(int id) {
        String info = service.getVideoInfo(id);
    }

    void renderListPanel() {
        String list = service.listVideos();
    }

    void reactOnUserInput(int id) {
        renderVideoPage(id);
        renderListPanel();
    }
}