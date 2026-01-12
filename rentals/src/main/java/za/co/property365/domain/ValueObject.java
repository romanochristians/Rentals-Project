package za.co.property365.domain;

public interface ValueObject {
    /**
     * Indicates whether some other object is "equal to" this value object.
     *
     * @param other the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    boolean equals(Object other);

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this value object.
     */
    int hashCode();
}