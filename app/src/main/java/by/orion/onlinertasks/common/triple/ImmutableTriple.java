package by.orion.onlinertasks.common.triple;

public final class ImmutableTriple<L, M, R> extends Triple<L, M, R> {

    /** Serialization version */
    private static final long serialVersionUID = 1L;

    /** Left object */
    private final L left;
    /** Middle object */
    private final M middle;
    /** Right object */
    private final R right;

    /**
     * <p>Obtains an immutable triple of from three objects inferring the generic types.</p>
     *
     * <p>This factory allows the triple to be created using inference to
     * obtain the generic types.</p>
     *
     * @param <L> the left element type
     * @param <M> the middle element type
     * @param <R> the right element type
     * @param left  the left element, may be null
     * @param middle  the middle element, may be null
     * @param right  the right element, may be null
     * @return a triple formed from the three parameters, not null
     */
    public static <L, M, R> ImmutableTriple<L, M, R> of(final L left, final M middle, final R right) {
        return new ImmutableTriple<>(left, middle, right);
    }

    /**
     * Create a new triple instance.
     *
     * @param left  the left value, may be null
     * @param middle the middle value, may be null
     * @param right  the right value, may be null
     */
    public ImmutableTriple(final L left, final M middle, final R right) {
        super();
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    //-----------------------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public L getLeft() {
        return left;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public M getMiddle() {
        return middle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R getRight() {
        return right;
    }
}