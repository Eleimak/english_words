package tam.english.english_words.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class Word {
    @Id
    private String id;
    private String enWord;
    private List<String> uaWord;

    public Word() {
    }

    public Word(String enWord, List<String> uaWord) {
        this.enWord = enWord;
        this.uaWord = uaWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnWord() {
        return enWord;
    }

    public void setEnWord(String enWord) {
        this.enWord = enWord;
    }

    public List<String> getUaWord() {
        return uaWord;
    }

    public void setUaWord(List<String> rusWord) {
        this.uaWord = rusWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(id, word.id) &&
                Objects.equals(enWord, word.enWord) &&
                Objects.equals(uaWord, word.uaWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Word{" +
                "id='" + id + '\'' +
                ", enWord='" + enWord + '\'' +
                ", uaWord=" + uaWord +
                '}';
    }
}
