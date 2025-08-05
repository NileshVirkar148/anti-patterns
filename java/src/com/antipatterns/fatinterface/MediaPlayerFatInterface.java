package com.antipatterns.fatinterface;

/**
 * FAT INTERFACE: This interface is too fat - it combines multiple
 * responsibilities and forces all implementations to implement
 * methods they might not need.
 */
public interface MediaPlayerFatInterface {
    
    // Audio playback methods
    void playAudio(String audioFile);
    void pauseAudio();
    void stopAudio();
    void setAudioVolume(int volume);
    void muteAudio();
    void unmuteAudio();
    String[] getSupportedAudioFormats();
    
    // Video playback methods
    void playVideo(String videoFile);
    void pauseVideo();
    void stopVideo();
    void setVideoQuality(String quality);
    void toggleFullscreen();
    void setSubtitles(String subtitleFile);
    String[] getSupportedVideoFormats();
    
    // Image viewing methods
    void displayImage(String imageFile);
    void zoomIn();
    void zoomOut();
    void rotateImage(int degrees);
    void flipImageHorizontal();
    void flipImageVertical();
    String[] getSupportedImageFormats();
    
    // Document reading methods
    void openDocument(String documentFile);
    void nextPage();
    void previousPage();
    void goToPage(int pageNumber);
    void setZoomLevel(double zoomLevel);
    void searchInDocument(String text);
    String[] getSupportedDocumentFormats();
    
    // Streaming methods
    void connectToStream(String streamUrl);
    void disconnectFromStream();
    void setStreamQuality(String quality);
    void recordStream(String outputFile);
    boolean isStreamLive();
    
    // CD/DVD methods
    void insertDisc();
    void ejectDisc();
    void playDisc();
    void skipTrack();
    void previousTrack();
    void setDiscRegion(int region);
    
    // Radio methods
    void tuneToFrequency(double frequency);
    void scanForStations();
    void savePreset(int presetNumber, double frequency);
    void loadPreset(int presetNumber);
    String[] getAvailableStations();
    
    // Playlist management
    void createPlaylist(String name);
    void addToPlaylist(String playlistName, String mediaFile);
    void removeFromPlaylist(String playlistName, String mediaFile);
    void shufflePlaylist(String playlistName);
    void repeatPlaylist(String playlistName, boolean repeat);
    
    // Social features
    void shareMedia(String mediaFile, String platform);
    void likeMedia(String mediaFile);
    void commentOnMedia(String mediaFile, String comment);
    void followUser(String username);
    void unfollowUser(String username);
    
    // Download/Upload features
    void downloadMedia(String url, String localPath);
    void uploadMedia(String localPath, String remoteUrl);
    void pauseDownload(String downloadId);
    void resumeDownload(String downloadId);
    void cancelDownload(String downloadId);
    
    // Device control methods
    void connectBluetooth(String deviceId);
    void disconnectBluetooth();
    void connectWifi(String networkName, String password);
    void disconnectWifi();
    void adjustScreenBrightness(int brightness);
    
    // Recording methods
    void startRecording(String outputFile);
    void stopRecording();
    void pauseRecording();
    void resumeRecording();
    void setRecordingQuality(String quality);
    
    // Synchronization methods
    void syncWithCloud();
    void backupToCloud();
    void restoreFromCloud();
    void syncPlaylistsWithDevice(String deviceId);
    
    // Analytics and reporting
    void trackPlayback(String mediaFile, long playTime);
    void generateUsageReport();
    void exportPlaybackHistory();
    void clearAnalyticsData();
}
