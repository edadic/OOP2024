package week10.labs;

import java.util.*;

// Song Class
class Song {
    private String title;
    private String artist;
    private String genre;

    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}

// GenreFilterIterator
class GenreFilterIterator implements Iterator<Song> {
    private final Iterator<Song> iterator;
    private final String targetGenre;
    private Song nextSong;

    public GenreFilterIterator(List<Song> playlist, String targetGenre) {
        this.iterator = playlist.iterator();
        this.targetGenre = targetGenre;
        advance();
    }

    private void advance() {
        nextSong = null;
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.getGenre().equalsIgnoreCase(targetGenre)) {
                nextSong = song;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nextSong != null;
    }

    @Override
    public Song next() {
        if (!hasNext()) throw new NoSuchElementException();
        Song current = nextSong;
        advance();
        return current;
    }
}

// Main
class Playlist {
    public static void main(String[] args) {
        List<Song> playlist = Arrays.asList(
                new Song("Song1", "Artist1", "Rock"),
                new Song("Song2", "Artist2", "Pop"),
                new Song("Song3", "Artist3", "Rock"),
                new Song("Song4", "Artist4", "Jazz")
        );

        GenreFilterIterator rockIterator = new GenreFilterIterator(playlist, "Rock");
        while (rockIterator.hasNext()) {
            System.out.println(rockIterator.next());
        }
    }
}

