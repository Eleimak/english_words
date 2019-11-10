package tam.english.english_words.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tam.english.english_words.model.Word;

@Repository
public interface WordRepository extends MongoRepository <Word, String> {
}
