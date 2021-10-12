package autocomplete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Sequential search implementation of the {@link Autocomplete} interface.
 *
 * @see Autocomplete
 */
public class SequentialSearchAutocomplete implements Autocomplete {
    /**
     * {@link List} of added autocompletion terms.
     */
    private final List<CharSequence> terms;

    /**
     * Constructs an empty instance.
     */
    public SequentialSearchAutocomplete() {
        this.terms = new ArrayList<>();
    }

    @Override
    public void addAll(Collection<? extends CharSequence> terms) {
        // TODO: Replace with your code
        this.terms.addAll(terms);
        System.out.println(terms);
//        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<CharSequence> allMatches(CharSequence prefix) {
        System.out.println("term size: " + terms.size());
        List<CharSequence> result = new ArrayList<>();
        // TODO: Replace with your code
        for (int i = 0; i < terms.size(); i++){
            if (prefix.length() <= terms.get(i).length()) {
                CharSequence part = terms.get(i).subSequence(0, prefix.length());
                if (CharSequence.compare(prefix, part) == 0) {
                    result.add(terms.get(i));
                }
            }
        }
        return result;
//        throw new UnsupportedOperationException("Not implemented yet");
    }
}
