public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> characterDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            characterDeque.addLast(c);
        }
        return characterDeque;
    }

    public boolean  isPalindrome(String word){
        boolean flag = true;
        Deque<Character> characterDeque = this.wordToDeque(word);
        while (!characterDeque.isEmpty()){
            Character front = characterDeque.removeFirst();
            Character last = characterDeque.removeLast();
            if(!front.equals(last)){
                flag = false;
            }
        }
        return flag;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        boolean flag = true;
        Deque<Character> characterDeque = this.wordToDeque(word);
        while (!characterDeque.isEmpty()){
            Character front = characterDeque.removeFirst();
            Character last = characterDeque.removeLast();
            if(characterDeque.size() == 1){
                return flag;
            }
            if(!cc.equalChars(front,last)){
                flag = false;
            }
        }
        return flag;
    }


}
