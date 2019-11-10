package tam.english.english_words.form;

import java.util.List;
import java.util.Objects;

public class WordForm {
    private String id;
    private String idEnWord;
    private String enWord;
    private String idUaWord;
    private String uaWord;
    private List<String> uaWords;

    public WordForm() {
    }

    public WordForm(String id, String idEnWord, String enWord, String idUaWord, String uaWord, List<String> uaWords) {
        this.id = id;
        this.idEnWord = idEnWord;
        this.enWord = enWord;
        this.idUaWord = idUaWord;
        this.uaWord = uaWord;
        this.uaWords = uaWords;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEnWord() {
        return idEnWord;
    }

    public void setIdEnWord(String idEnWord) {
        this.idEnWord = idEnWord;
    }

    public String getEnWord() {
        return enWord;
    }

    public void setEnWord(String enWord) {
        this.enWord = enWord;
    }

    public String getIdUaWord() {
        return idUaWord;
    }

    public void setIdUaWord(String idUaWord) {
        this.idUaWord = idUaWord;
    }

    public String getUaWord() {
        return uaWord;
    }

    public void setUaWord(String uaWord) {
        this.uaWord = uaWord;
    }

    public List<String> getUaWords() {
        return uaWords;
    }

    public void setUaWords(List<String> uaWords) {
        this.uaWords = uaWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordForm wordForm = (WordForm) o;
        return Objects.equals(id, wordForm.id) &&
                Objects.equals(idEnWord, wordForm.idEnWord) &&
                Objects.equals(enWord, wordForm.enWord) &&
                Objects.equals(idUaWord, wordForm.idUaWord) &&
                Objects.equals(uaWord, wordForm.uaWord) &&
                Objects.equals(uaWords, wordForm.uaWords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WordForm{" +
                "id='" + id + '\'' +
                ", idEnWord='" + idEnWord + '\'' +
                ", enWord='" + enWord + '\'' +
                ", idUaWord='" + idUaWord + '\'' +
                ", uaWord='" + uaWord + '\'' +
                ", uaWords=" + uaWords +
                '}';
    }
}
