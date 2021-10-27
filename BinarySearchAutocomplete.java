package autocomplete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

/**
 * Binary search implementation of the {@link Autocomplete} interface.
 *
 * @see Autocomplete
 */
public class BinarySearchAutocomplete implements Autocomplete {
    /**
     * {@link List} of added autocompletion terms.
     */
    private final List<CharSequence> terms;

    /**
     * Constructs an empty instance.
     */
    public BinarySearchAutocomplete() {
        this.terms = new ArrayList<>();
    }

    @Override
    public void addAll(Collection<? extends CharSequence> terms) {
        // TODO: Replace with your code
        this.terms.addAll(terms);
        /*Sort terms*/
        Collections.sort(this.terms, CharSequence::compare);
    }

    @Override
    public List<CharSequence> allMatches(CharSequence prefix) {
        // TODO: Replace with your code
        List<CharSequence> result = new ArrayList<>();

        /*Binary search to find the first word*/
        int i = Integer.MAX_VALUE;
        int size = prefix.length();
        int start = 0;
        int end = terms.size();
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            int cmp = CharSequence.compare(prefix, terms.get(mid).subSequence(0, size));
            int cmpp = CharSequence.compare(prefix, terms.get(mid-1).subSequence(0, size));
            if(cmp < 0){
                end = mid + 1;
            }
            else if(cmp == 0 && cmpp == 0){
                end = mid + 1;
            }
            else if(cmp > 0){
                start = mid - 1;
            }
            else{
                i = mid;
                break;
            }
        }

        /*get all elements that fulfilled the requirement*/
        for(int j = i; j < terms.size(); j++){
            int jug = CharSequence.compare(prefix, terms.get(j).subSequence(0, size));
            if(jug == 0){
                result.add(terms.get(j));
            }
            else {
                break;
            }
        }
        return result;
        }
    }
