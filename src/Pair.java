import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * Represents two associated objects. Those could be be a Key-Value-Pair.
 * @param <A> First type parameter
 * @param <B> Second type parameter
 */
@Data
@AllArgsConstructor
public class Pair<A, B> {

    @NonNull
    private A first = null;
    @NonNull
    private B second = null;

}
