package array.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>.
 * Below are some examples of word abbreviations:

 a) it                      --> it    (no abbreviation)

 1
 b) d|o|g                   --> d1g

 1    1  1
 1---5----0----5--8
 c) i|nternationalizatio|n  --> i18n

 1
 1---5----0
 d) l|ocalizatio|n          --> l10n
 Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
 A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

 Example:
 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") -> false
 isUnique("cart") -> true
 isUnique("cane") -> false
 isUnique("make") -> true
 */
public class UniqueWordAbbreviation {
    private Map<String, List<String>> map = new HashMap<>();

    public UniqueWordAbbreviation(String[] dictionary) {
        for (String word : dictionary) {
            String abbr = null;
            if (word.length() <= 2) {
                abbr = word;
            } else {
                abbr = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
            }

            if (map.containsKey(abbr)) {
                map.get(abbr).add(word);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(word);
                map.put(abbr, list);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr;
        if (word.length() <= 2) {
            abbr = word;
        } else {
            abbr = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
        }
        if (!map.containsKey(abbr)) {
            return true;
        } else
            return map.get(abbr).size() < 2 && map.get(abbr).contains(word);
    }

    public static void main(String[] args) {
        String[] dictionary = {"deer", "door", "cake", "card"};
        UniqueWordAbbreviation uniqueWordAbbreviation = new UniqueWordAbbreviation(dictionary);
        System.out.println(uniqueWordAbbreviation.isUnique("dear"));
        System.out.println(uniqueWordAbbreviation.isUnique("cart"));
    }
}
