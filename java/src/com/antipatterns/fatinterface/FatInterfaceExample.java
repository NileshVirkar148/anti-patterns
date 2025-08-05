package com.antipatterns.fatinterface;

/**
 * FAT INTERFACE ANTI-PATTERN EXAMPLE
 * 
 * This demonstrates the "Fat Interface" anti-pattern where an interface
 * has too many methods, forcing implementing classes to implement
 * methods they don't need.
 * 
 * Problems with this approach:
 * - Violates Interface Segregation Principle
 * - Forces unnecessary method implementations
 * - Creates tight coupling
 * - Hard to maintain and evolve
 */

/**
 * Demonstration of the Fat Interface anti-pattern problems
 */
public class FatInterfaceExample {
    
    public static void main(String[] args) {
        System.out.println("=== Fat Interface Anti-Pattern Example ===\n");
        
        // Create instances
        AudioOnlyPlayer audioPlayer = new AudioOnlyPlayer();
        SimpleImageViewer imageViewer = new SimpleImageViewer();
        
        System.out.println("--- Audio Player (only needs audio methods) ---");
        audioPlayer.playAudio("song.mp3");
        audioPlayer.setAudioVolume(75);
        audioPlayer.pauseAudio();
        
        try {
            // This will throw UnsupportedOperationException
            audioPlayer.playVideo("movie.mp4");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("\n--- Image Viewer (only needs image methods) ---");
        imageViewer.displayImage("photo.jpg");
        imageViewer.zoomIn();
        imageViewer.rotateImage(90);
        
        try {
            // This will throw UnsupportedOperationException
            imageViewer.playAudio("music.mp3");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("\n--- Problems with Fat Interface ---");
        System.out.println("1. Violates Interface Segregation Principle");
        System.out.println("2. Forces classes to implement methods they don't need");
        System.out.println("3. Creates many UnsupportedOperationException throws");
        System.out.println("4. Makes code harder to understand and maintain");
        System.out.println("5. Increases coupling between unrelated functionalities");
        System.out.println("6. Makes testing more complex");
        System.out.println("7. AudioOnlyPlayer has to implement 50+ methods it doesn't use");
        System.out.println("8. SimpleImageViewer has to implement 40+ methods it doesn't use");
        System.out.println("9. Changes to the interface affect all implementations");
        System.out.println("10. Difficult to evolve and extend the interface");
    }
}
