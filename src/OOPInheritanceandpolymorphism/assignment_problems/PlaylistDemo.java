package OOPInheritanceandpolymorphism.assignment_problems;

import java.util.Arrays;

public class PlaylistDemo {
    public static class Playlist {
        private String[] songs;
        private int count;

        public Playlist(int capacity) {
            this.songs = new String[capacity];
            this.count = 0;
        }

        public void addSong(String song) {
            if (count < songs.length) {
                songs[count++] = song;
            }
        }

        public String[] getSongs() {
            return Arrays.copyOf(songs, count);
        }

        public int getSongCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Songs in copy: " + Arrays.toString(copy));
        System.out.println("Song count: " + p.getSongCount());

        // Modifying returned array should not affect original playlist
        copy[0] = "Hacked";
        System.out.println("Original Playlist[0] after modifying copy: " + p.getSongs()[0]);
    }
}
