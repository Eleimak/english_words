package tam.english.english_words.service.word.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tam.english.english_words.model.Word;
import tam.english.english_words.repository.WordRepository;
import tam.english.english_words.service.word.interfaces.IWordService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements IWordService {
    @Autowired
    WordRepository wordRepository;

    @Override
    public List<Word> getAll() {
        return wordRepository.findAll().stream().sorted(Comparator.comparing(Word::getEnWord)).collect(Collectors.toList());
    }

    @Override
    public Word get(String id) {
        return wordRepository.findById(id).orElse(null);
    }

    @Override
    public Word create(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public Word update(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public Word delete(String id) {
        Word word = this.get(id);
        wordRepository.deleteById(id);
        return word;
    }

    @Override
    public boolean findUaWord(Word word, String uaWord) {
        for (String item: word.getUaWord()){
            if(item.equals(uaWord)){ return true;}
        }
        return false;
    }

    @Override
    public boolean findEnWord(Word word, String enWord) {
    if(word.getEnWord().equals(enWord)) {
        return true;
    }
    else {
        return false;
    }
    }
}
