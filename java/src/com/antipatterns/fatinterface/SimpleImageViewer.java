package com.antipatterns.fatinterface;

/**
 * SIMPLE IMAGE VIEWER: Only needs image functionality
 * but forced to implement ALL methods from the fat interface.
 */
public class SimpleImageViewer implements MediaPlayerFatInterface {
    
    // Only these methods are relevant for an image viewer
    @Override
    public void displayImage(String imageFile) {
        System.out.println("Displaying image: " + imageFile);
    }
    
    @Override
    public void zoomIn() {
        System.out.println("Zooming in");
    }
    
    @Override
    public void zoomOut() {
        System.out.println("Zooming out");
    }
    
    @Override
    public void rotateImage(int degrees) {
        System.out.println("Rotating image by " + degrees + " degrees");
    }
    
    @Override
    public void flipImageHorizontal() {
        System.out.println("Flipping image horizontally");
    }
    
    @Override
    public void flipImageVertical() {
        System.out.println("Flipping image vertically");
    }
    
    @Override
    public String[] getSupportedImageFormats() {
        return new String[]{"JPEG", "PNG", "GIF", "BMP", "TIFF"};
    }
    
    // FORCED TO IMPLEMENT: All other methods - not needed for image viewer
    @Override public void playAudio(String audioFile) { throw new UnsupportedOperationException("Audio not supported in image viewer"); }
    @Override public void pauseAudio() { throw new UnsupportedOperationException("Audio not supported in image viewer"); }
    @Override public void stopAudio() { throw new UnsupportedOperationException("Audio not supported in image viewer"); }
    @Override public void setAudioVolume(int volume) { throw new UnsupportedOperationException("Audio not supported in image viewer"); }
    @Override public void muteAudio() { throw new UnsupportedOperationException("Audio not supported in image viewer"); }
    @Override public void unmuteAudio() { throw new UnsupportedOperationException("Audio not supported in image viewer"); }
    @Override public String[] getSupportedAudioFormats() { return new String[0]; }
    @Override public void playVideo(String videoFile) { throw new UnsupportedOperationException("Video not supported in image viewer"); }
    @Override public void pauseVideo() { throw new UnsupportedOperationException("Video not supported in image viewer"); }
    @Override public void stopVideo() { throw new UnsupportedOperationException("Video not supported in image viewer"); }
    @Override public void setVideoQuality(String quality) { throw new UnsupportedOperationException("Video not supported in image viewer"); }
    @Override public void toggleFullscreen() { throw new UnsupportedOperationException("Video not supported in image viewer"); }
    @Override public void setSubtitles(String subtitleFile) { throw new UnsupportedOperationException("Video not supported in image viewer"); }
    @Override public String[] getSupportedVideoFormats() { return new String[0]; }
    @Override public void openDocument(String documentFile) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void nextPage() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void previousPage() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void goToPage(int pageNumber) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void setZoomLevel(double zoomLevel) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void searchInDocument(String text) { throw new UnsupportedOperationException("Not supported"); }
    @Override public String[] getSupportedDocumentFormats() { return new String[0]; }
    @Override public void connectToStream(String streamUrl) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void disconnectFromStream() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void setStreamQuality(String quality) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void recordStream(String outputFile) { throw new UnsupportedOperationException("Not supported"); }
    @Override public boolean isStreamLive() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void insertDisc() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void ejectDisc() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void playDisc() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void skipTrack() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void previousTrack() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void setDiscRegion(int region) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void tuneToFrequency(double frequency) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void scanForStations() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void savePreset(int presetNumber, double frequency) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void loadPreset(int presetNumber) { throw new UnsupportedOperationException("Not supported"); }
    @Override public String[] getAvailableStations() { return new String[0]; }
    @Override public void createPlaylist(String name) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void addToPlaylist(String playlistName, String mediaFile) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void removeFromPlaylist(String playlistName, String mediaFile) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void shufflePlaylist(String playlistName) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void repeatPlaylist(String playlistName, boolean repeat) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void shareMedia(String mediaFile, String platform) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void likeMedia(String mediaFile) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void commentOnMedia(String mediaFile, String comment) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void followUser(String username) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void unfollowUser(String username) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void downloadMedia(String url, String localPath) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void uploadMedia(String localPath, String remoteUrl) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void pauseDownload(String downloadId) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void resumeDownload(String downloadId) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void cancelDownload(String downloadId) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void connectBluetooth(String deviceId) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void disconnectBluetooth() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void connectWifi(String networkName, String password) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void disconnectWifi() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void adjustScreenBrightness(int brightness) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void startRecording(String outputFile) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void stopRecording() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void pauseRecording() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void resumeRecording() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void setRecordingQuality(String quality) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void syncWithCloud() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void backupToCloud() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void restoreFromCloud() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void syncPlaylistsWithDevice(String deviceId) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void trackPlayback(String mediaFile, long playTime) { throw new UnsupportedOperationException("Not supported"); }
    @Override public void generateUsageReport() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void exportPlaybackHistory() { throw new UnsupportedOperationException("Not supported"); }
    @Override public void clearAnalyticsData() { throw new UnsupportedOperationException("Not supported"); }
}
