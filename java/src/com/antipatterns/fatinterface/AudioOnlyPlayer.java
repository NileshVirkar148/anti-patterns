package com.antipatterns.fatinterface;

/**
 * AUDIO-ONLY PLAYER: This class only needs audio functionality
 * but is forced to implement ALL methods from the fat interface.
 */
public class AudioOnlyPlayer implements MediaPlayerFatInterface {
    
    // These are the only methods this class actually needs
    @Override
    public void playAudio(String audioFile) {
        System.out.println("Playing audio: " + audioFile);
    }
    
    @Override
    public void pauseAudio() {
        System.out.println("Audio paused");
    }
    
    @Override
    public void stopAudio() {
        System.out.println("Audio stopped");
    }
    
    @Override
    public void setAudioVolume(int volume) {
        System.out.println("Audio volume set to: " + volume);
    }
    
    @Override
    public void muteAudio() {
        System.out.println("Audio muted");
    }
    
    @Override
    public void unmuteAudio() {
        System.out.println("Audio unmuted");
    }
    
    @Override
    public String[] getSupportedAudioFormats() {
        return new String[]{"MP3", "WAV", "FLAC", "AAC"};
    }
    
    // FORCED TO IMPLEMENT: All these methods that this class doesn't need
    @Override public void playVideo(String videoFile) { throw new UnsupportedOperationException("Video playback not supported in audio-only player"); }
    @Override public void pauseVideo() { throw new UnsupportedOperationException("Video playback not supported in audio-only player"); }
    @Override public void stopVideo() { throw new UnsupportedOperationException("Video playback not supported in audio-only player"); }
    @Override public void setVideoQuality(String quality) { throw new UnsupportedOperationException("Video playback not supported in audio-only player"); }
    @Override public void toggleFullscreen() { throw new UnsupportedOperationException("Video playback not supported in audio-only player"); }
    @Override public void setSubtitles(String subtitleFile) { throw new UnsupportedOperationException("Video playback not supported in audio-only player"); }
    @Override public String[] getSupportedVideoFormats() { return new String[0]; }
    @Override public void displayImage(String imageFile) { throw new UnsupportedOperationException("Image viewing not supported in audio-only player"); }
    @Override public void zoomIn() { throw new UnsupportedOperationException("Image viewing not supported in audio-only player"); }
    @Override public void zoomOut() { throw new UnsupportedOperationException("Image viewing not supported in audio-only player"); }
    @Override public void rotateImage(int degrees) { throw new UnsupportedOperationException("Image viewing not supported in audio-only player"); }
    @Override public void flipImageHorizontal() { throw new UnsupportedOperationException("Image viewing not supported in audio-only player"); }
    @Override public void flipImageVertical() { throw new UnsupportedOperationException("Image viewing not supported in audio-only player"); }
    @Override public String[] getSupportedImageFormats() { return new String[0]; }
    @Override public void openDocument(String documentFile) { throw new UnsupportedOperationException("Document reading not supported in audio-only player"); }
    @Override public void nextPage() { throw new UnsupportedOperationException("Document reading not supported in audio-only player"); }
    @Override public void previousPage() { throw new UnsupportedOperationException("Document reading not supported in audio-only player"); }
    @Override public void goToPage(int pageNumber) { throw new UnsupportedOperationException("Document reading not supported in audio-only player"); }
    @Override public void setZoomLevel(double zoomLevel) { throw new UnsupportedOperationException("Document reading not supported in audio-only player"); }
    @Override public void searchInDocument(String text) { throw new UnsupportedOperationException("Document reading not supported in audio-only player"); }
    @Override public String[] getSupportedDocumentFormats() { return new String[0]; }
    @Override public void connectToStream(String streamUrl) { throw new UnsupportedOperationException("Streaming not supported"); }
    @Override public void disconnectFromStream() { throw new UnsupportedOperationException("Streaming not supported"); }
    @Override public void setStreamQuality(String quality) { throw new UnsupportedOperationException("Streaming not supported"); }
    @Override public void recordStream(String outputFile) { throw new UnsupportedOperationException("Streaming not supported"); }
    @Override public boolean isStreamLive() { throw new UnsupportedOperationException("Streaming not supported"); }
    @Override public void insertDisc() { throw new UnsupportedOperationException("Disc operations not supported"); }
    @Override public void ejectDisc() { throw new UnsupportedOperationException("Disc operations not supported"); }
    @Override public void playDisc() { throw new UnsupportedOperationException("Disc operations not supported"); }
    @Override public void skipTrack() { throw new UnsupportedOperationException("Disc operations not supported"); }
    @Override public void previousTrack() { throw new UnsupportedOperationException("Disc operations not supported"); }
    @Override public void setDiscRegion(int region) { throw new UnsupportedOperationException("Disc operations not supported"); }
    @Override public void tuneToFrequency(double frequency) { throw new UnsupportedOperationException("Radio not supported"); }
    @Override public void scanForStations() { throw new UnsupportedOperationException("Radio not supported"); }
    @Override public void savePreset(int presetNumber, double frequency) { throw new UnsupportedOperationException("Radio not supported"); }
    @Override public void loadPreset(int presetNumber) { throw new UnsupportedOperationException("Radio not supported"); }
    @Override public String[] getAvailableStations() { return new String[0]; }
    @Override public void createPlaylist(String name) { throw new UnsupportedOperationException("Playlists not supported"); }
    @Override public void addToPlaylist(String playlistName, String mediaFile) { throw new UnsupportedOperationException("Playlists not supported"); }
    @Override public void removeFromPlaylist(String playlistName, String mediaFile) { throw new UnsupportedOperationException("Playlists not supported"); }
    @Override public void shufflePlaylist(String playlistName) { throw new UnsupportedOperationException("Playlists not supported"); }
    @Override public void repeatPlaylist(String playlistName, boolean repeat) { throw new UnsupportedOperationException("Playlists not supported"); }
    @Override public void shareMedia(String mediaFile, String platform) { throw new UnsupportedOperationException("Social features not supported"); }
    @Override public void likeMedia(String mediaFile) { throw new UnsupportedOperationException("Social features not supported"); }
    @Override public void commentOnMedia(String mediaFile, String comment) { throw new UnsupportedOperationException("Social features not supported"); }
    @Override public void followUser(String username) { throw new UnsupportedOperationException("Social features not supported"); }
    @Override public void unfollowUser(String username) { throw new UnsupportedOperationException("Social features not supported"); }
    @Override public void downloadMedia(String url, String localPath) { throw new UnsupportedOperationException("Downloads not supported"); }
    @Override public void uploadMedia(String localPath, String remoteUrl) { throw new UnsupportedOperationException("Uploads not supported"); }
    @Override public void pauseDownload(String downloadId) { throw new UnsupportedOperationException("Downloads not supported"); }
    @Override public void resumeDownload(String downloadId) { throw new UnsupportedOperationException("Downloads not supported"); }
    @Override public void cancelDownload(String downloadId) { throw new UnsupportedOperationException("Downloads not supported"); }
    @Override public void connectBluetooth(String deviceId) { throw new UnsupportedOperationException("Device control not supported"); }
    @Override public void disconnectBluetooth() { throw new UnsupportedOperationException("Device control not supported"); }
    @Override public void connectWifi(String networkName, String password) { throw new UnsupportedOperationException("Device control not supported"); }
    @Override public void disconnectWifi() { throw new UnsupportedOperationException("Device control not supported"); }
    @Override public void adjustScreenBrightness(int brightness) { throw new UnsupportedOperationException("Device control not supported"); }
    @Override public void startRecording(String outputFile) { throw new UnsupportedOperationException("Recording not supported"); }
    @Override public void stopRecording() { throw new UnsupportedOperationException("Recording not supported"); }
    @Override public void pauseRecording() { throw new UnsupportedOperationException("Recording not supported"); }
    @Override public void resumeRecording() { throw new UnsupportedOperationException("Recording not supported"); }
    @Override public void setRecordingQuality(String quality) { throw new UnsupportedOperationException("Recording not supported"); }
    @Override public void syncWithCloud() { throw new UnsupportedOperationException("Cloud sync not supported"); }
    @Override public void backupToCloud() { throw new UnsupportedOperationException("Cloud sync not supported"); }
    @Override public void restoreFromCloud() { throw new UnsupportedOperationException("Cloud sync not supported"); }
    @Override public void syncPlaylistsWithDevice(String deviceId) { throw new UnsupportedOperationException("Device sync not supported"); }
    @Override public void trackPlayback(String mediaFile, long playTime) { throw new UnsupportedOperationException("Analytics not supported"); }
    @Override public void generateUsageReport() { throw new UnsupportedOperationException("Analytics not supported"); }
    @Override public void exportPlaybackHistory() { throw new UnsupportedOperationException("Analytics not supported"); }
    @Override public void clearAnalyticsData() { throw new UnsupportedOperationException("Analytics not supported"); }
}
