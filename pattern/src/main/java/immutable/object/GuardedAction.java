package immutable.object;

import java.util.concurrent.Callable;

/**
 * @author chenhao.ych
 * @date 2018-06-21
 */
public abstract class GuardedAction<V> implements Callable {
    protected final Predicate guard;

    public GuardedAction(Predicate guard) {
        this.guard = guard;
    }
}
