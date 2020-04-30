@FunctionalInterface
public interface BiFunction<S,T,R> {
    R apply(S s, T t);
}
