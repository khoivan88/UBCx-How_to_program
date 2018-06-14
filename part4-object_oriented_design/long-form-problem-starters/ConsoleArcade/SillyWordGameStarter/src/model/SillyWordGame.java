package model;

import java.util.Iterator;
import java.util.List;

public class SillyWordGame implements Iterable<Phrase> {

    private List<Phrase> phrases;
    //TODO: remove these fields
//    private int currentPhraseIndex;
//    private int numWordsNeeded;

    public SillyWordGame(List<Phrase> phrases) {
        this.phrases = phrases;
//        for(Phrase p : phrases) {
//            if (p.needsWord())
//                numWordsNeeded++;
//        }
    }

    //EFFECTS: returns all phrases in this game
    public List<Phrase> getAllPhrases() {
        return phrases;
    }

//    //MODIFIES: this
//    //EFFECTS: returns the next phrase in this game that needs a word
//    //TODO: remove this method
//    public Phrase getNextPhraseNeedingWord() {
////        for (int i = currentPhraseIndex; i < phrases.size(); i++){
////            if (!phrases.get(currentPhraseIndex).needsWord()){
////                currentPhraseIndex++;
////            } else {
////                numWordsNeeded--;
////                return phrases.get(currentPhraseIndex++);
////            }
////        }
////        throw new IllegalStateException();
//
//        for (Phrase phrase: phrases) {
//            if (!phrase.needsWord()) {
//                currentPhraseIndex++;
//            } else {
//                numWordsNeeded--;
//                return phrase;
//            }
//        }
//        throw new IllegalStateException();
//    }

//    //EFFECTS: returns true if more words are needed
//    //TODO: remove this method
//    public boolean needMoreWords() {
//        return numWordsNeeded > 0;
//    }

    @Override
    public Iterator<Phrase> iterator() {
        return new PhraseIterator();
    }

    private class PhraseIterator implements Iterator<Phrase> {
//        Iterator<Phrase> phraseIterator = phrases.iterator();
//
//        @Override
//        public boolean hasNext() {
//            return phraseIterator.hasNext();
//        }
//
//        @Override
//        public Phrase next() {
//            Phrase phrase = null;
//            if (phraseIterator.hasNext()) {
//                Phrase temp = phraseIterator.next();
//                if (temp.needsWord()) {
//                    phrase = temp;
//                }
//            }
//            return phrase;
//        }

        //Below is a nice implementation of this private class:
        // From:
        private Iterator<Phrase> iter = phrases.iterator();
        private Phrase currentPhrase;

        @Override
        public boolean hasNext() {
            while (iter.hasNext()) {
                currentPhrase = iter.next();
                return currentPhrase.needsWord();
            }
            return false;
        }

        @Override
        public Phrase next() {
            return currentPhrase;
        }
    }
}
