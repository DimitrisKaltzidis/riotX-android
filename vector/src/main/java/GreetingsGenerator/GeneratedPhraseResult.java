package GreetingsGenerator;

public class GeneratedPhraseResult {

    private String phrase, youtubeLink;

    public GeneratedPhraseResult(String phrase, String youtubeLink) {
        this.phrase = phrase;
        this.youtubeLink = youtubeLink;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }
}
