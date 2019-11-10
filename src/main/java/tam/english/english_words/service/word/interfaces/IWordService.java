package tam.english.english_words.service.word.interfaces;

import tam.english.english_words.model.Word;

import java.util.List;

public interface IWordService {
    List<Word> getAll();
    Word get(String id);
    Word create(Word word);
    Word update(Word word);
    Word delete(String id);
    boolean findUaWord(Word word, String uaWord);
    boolean findEnWord(Word word, String uaWord);
}
