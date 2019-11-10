package tam.english.english_words.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tam.english.english_words.form.WordForm;
import tam.english.english_words.model.Word;
import tam.english.english_words.service.word.impls.WordServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class WordWebController {
    @Autowired
    WordServiceImpl wordService;

    /*

    * List

     */

    @RequestMapping("/list")
    public String showAll(Model model){
        List<Word> list = wordService.getAll();
        model.addAttribute("Words", list);
        return "/wordList";
    }

    /*

    * CREATE GET

     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        WordForm wordForm = new WordForm();
        model.addAttribute("WordForm", wordForm);
        return "/wordAdd";
    }

    /*

     * CREATE POST

     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,@ModelAttribute("WordForm")
            WordForm wordForm){
        List<String> list = new ArrayList<>();
        list.add(wordForm.getUaWord());
        Word word = new Word(wordForm.getEnWord(), list);
        wordService.create(word);
        return "redirect:/list";
    }

    /*

     * LEARN ENGLISH GET

     */
    @RequestMapping(value = "/LearnEn", method = RequestMethod.GET)
    public String learnEn(Model model){
        WordForm wordForm = new WordForm();
        List<Word> wordList = wordService.getAll();
        int size = wordList.size();
        Word word = wordList.get(new Random().nextInt(size));
        wordForm.setEnWord(word.getEnWord());
        wordForm.setIdEnWord(word.getId());
        model.addAttribute("WordForm", wordForm);
        return "/learnEn";
    }

    /*

     * LEARN ENGLISH POST

     */
    @RequestMapping(value = "/LearnEn", method = RequestMethod.POST)
    public String learnEn(Model model,@ModelAttribute("WordForm")
            WordForm wordForm){
        Word word = wordService.get(wordForm.getIdEnWord());
        String error = "Wrong";
        if(wordService.findUaWord(word, wordForm.getUaWord())){
            return "redirect:/LearnEn";
        }
        else{
            model.addAttribute("errorMessage", error);
            return "/learnEn";
        }
    }

    /*

     * LEARN UKRAINIAN GET

     */
    @RequestMapping(value = "/LearnUa", method = RequestMethod.GET)
    public String learnUa(Model model){
        WordForm wordForm = new WordForm();
        List<Word> wordList = wordService.getAll();
        int size = wordList.size();
        Word word = wordList.get(new Random().nextInt(size));
        int sizeUa = new Random().nextInt(word.getUaWord().size());
        wordForm.setUaWord(word.getUaWord().get(sizeUa));
        wordForm.setIdEnWord(word.getId());
        model.addAttribute("WordForm", wordForm);
        return "/learnUa";
    }

    /*

     * LEARN UKRAINIAN POST

     */
    @RequestMapping(value = "/LearnUa", method = RequestMethod.POST)
    public String learnUa(Model model,@ModelAttribute("WordForm")
            WordForm wordForm){
        Word word = wordService.get(wordForm.getIdEnWord());
        String error = "Wrong";
        if(wordService.findEnWord(word, wordForm.getEnWord())){
            return "redirect:/LearnUa";
        }
        else{
            model.addAttribute("errorMessage", error);
            return "/learnUa";
        }
    }
}
