package com.ues21.lib;

import java.util.Iterator;
import java.util.Map;

/**
 * <p>This class assists in validating arguments. The validation methods are
 * based along the following principles:
 * <ul>
 *   <li>An invalid {@code null} argument causes a {@link NullPointerException}.</li>
 *   <li>A non-{@code null} argument causes an {@link IllegalArgumentException}.</li>
 *   <li>An invalid index into an array/collection/map/string causes an {@link IndexOutOfBoundsException}.</li>
 * </ul>
 *
 * <p>All exceptions messages are
 * <a href="http://docs.oracle.com/javase/1.5.0/docs/api/java/util/Formatter.html#syntax">format strings</a>
 * as defined by the Java platform. For example:</p>
 *
 * <pre>
 * Validate.isTrue(i &gt; 0, "The value must be greater than zero: %d", i);
 * Validate.notNull(surname, "The surname must not be %s", null);
 * </pre>
 *
 * <p>#ThreadSafe#</p>
 * @see java.lang.String#format(String, Object...)
 * @since 2.0
 */
public final class Validate {
    
    private static final String DEFAULT_NOT_NAN_EX_MESSAGE = "The validated value is not a number";
    private static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
    private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
    private static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
    private static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
    private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
    private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
    private static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
    private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
    private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
    private static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
    private static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";
    private static final String DEFAULT_CONTAINS_INVALID_CHARACTERS_EX_MESSAGE = "The validated object: %s contains invalid characters";
    private static final String DEFAULT_IS_NOT_VALID_ARGENTINIAN_DNI_EX_MESSAGE = "The validated string is not a valid Argentinian DNI";
    private static final String DEFAULT_IS_NOT_VALID_PLATE =  "The validated input is not a valid plate: %s";
    private static final String DEFAULT_IS_NOT_ONLY_NUMBER_STRING_EX_MESSAGE = "The validated string does not contain only numbers: %s";
    private static final String DEFAULT_IS_NOT_VALID_BOOLEAN_EXPRESSION_EX_MESSAGE = "The validated string is not a valid boolean expression: %s";

    /**
     * Utility class, private constructor
     */
    private Validate() {
    }
    
    // isTrue
    //---------------------------------------------------------------------------------
    
    /**
     * <p>Validate that the argument condition is {@code true}; otherwise
     * throwing an exception with the specified message. This method is useful when
     * validating according to an arbitrary boolean expression, such as validating a
     * primitive number or using your own custom validation expression.</p>
     *
     * <pre>Validate.isTrue(i &gt; 0.0, "The value must be greater than zero: &#37;d", i);</pre>
     *
     * <p>For performance reasons, the long value is passed as a separate parameter and
     * appended to the exception message only in the case of an error.</p>
     *
     * @param expression  the boolean expression to check
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param value  the value to append to the message when invalid
     * @throws IllegalArgumentException if expression is {@code false}
     * @see #isTrue(boolean)
     * @see #isTrue(boolean, String, double)
     * @see #isTrue(boolean, String, Object...)
     */
    public static void isTrue(final boolean expression, final String message, final long value) {
        if (!expression) {
            throw new IllegalArgumentException(String.format(message, Long.valueOf(value)));
        }
    }
    
    /**
     * <p>Validate that the argument condition is {@code true}; otherwise
     * throwing an exception with the specified message. This method is useful when
     * validating according to an arbitrary boolean expression, such as validating a
     * primitive number or using your own custom validation expression.</p>
     *
     * <pre>Validate.isTrue(d &gt; 0.0, "The value must be greater than zero: &#37;s", d);</pre>
     *
     * <p>For performance reasons, the double value is passed as a separate parameter and
     * appended to the exception message only in the case of an error.</p>
     *
     * @param expression  the boolean expression to check
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param value  the value to append to the message when invalid
     * @throws IllegalArgumentException if expression is {@code false}
     * @see #isTrue(boolean)
     * @see #isTrue(boolean, String, long)
     * @see #isTrue(boolean, String, Object...)
     */
    public static void isTrue(final boolean expression, final String message, final double value) {
        if (!expression) {
            throw new IllegalArgumentException(String.format(message, Double.valueOf(value)));
        }
    }
    
    /**
     * <p>Validate that the argument condition is {@code true}; otherwise
     * throwing an exception with the specified message. This method is useful when
     * validating according to an arbitrary boolean expression, such as validating a
     * primitive number or using your own custom validation expression.</p>
     *
     * <pre>
     * Validate.isTrue(i &gt;= min &amp;&amp; i &lt;= max, "The value must be between &#37;d and &#37;d", min, max);
     * Validate.isTrue(myObject.isOk(), "The object is not okay");</pre>
     *
     * @param expression  the boolean expression to check
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param values  the optional values for the formatted exception message, null array not recommended
     * @throws IllegalArgumentException if expression is {@code false}
     * @see #isTrue(boolean)
     * @see #isTrue(boolean, String, long)
     * @see #isTrue(boolean, String, double)
     */
    public static void isTrue(final boolean expression, final String message, final Object... values) {
        if (!expression) {
            throw new IllegalArgumentException(String.format(message, values));
        }
    }
    
    /**
     * <p>Validate that the argument condition is {@code true}; otherwise
     * throwing an exception. This method is useful when validating according
     * to an arbitrary boolean expression, such as validating a
     * primitive number or using your own custom validation expression.</p>
     *
     * <pre>
     * Validate.isTrue(i &gt; 0);
     * Validate.isTrue(myObject.isOk());</pre>
     *
     * <p>The message of the exception is &quot;The validated expression is
     * false&quot;.</p>
     *
     * @param expression  the boolean expression to check
     * @throws IllegalArgumentException if expression is {@code false}
     * @see #isTrue(boolean, String, long)
     * @see #isTrue(boolean, String, double)
     * @see #isTrue(boolean, String, Object...)
     */
    public static void isTrue(final boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException(DEFAULT_IS_TRUE_EX_MESSAGE);
        }
    }
    
    // notNull
    //---------------------------------------------------------------------------------
    
    /**
     * <p>Validate that the specified argument is not {@code null};
     * otherwise throwing an exception.
     *
     * <pre>Validate.notNull(myObject, "The object must not be null");</pre>
     *
     * <p>The message of the exception is &quot;The validated object is
     * null&quot;.</p>
     *
     * @param <T> the object type
     * @param object  the object to check
     * @return the validated object (never {@code null} for method chaining)
     * @throws NullPointerException if the object is {@code null}
     * @see #notNull(Object, String, Object...)
     */
    public static <T> T notNull(final T object) {
        return notNull(object, DEFAULT_IS_NULL_EX_MESSAGE);
    }
    
    /**
     * <p>Validate that the specified argument is not {@code null};
     * otherwise throwing an exception with the specified message.
     *
     * <pre>Validate.notNull(myObject, "The object must not be null");</pre>
     *
     * @param <T> the object type
     * @param object  the object to check
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param values  the optional values for the formatted exception message
     * @return the validated object (never {@code null} for method chaining)
     * @throws NullPointerException if the object is {@code null}
     * @see #notNull(Object)
     */
    public static <T> T notNull(final T object, final String message, final Object... values) {
        if (object == null) {
            throw new NullPointerException(String.format(message, values));
        }
        return object;
    }
    
    // notEmpty array
    //---------------------------------------------------------------------------------
    
    /**
     * <p>Validate that the specified argument array is neither {@code null}
     * nor a length of zero (no elements); otherwise throwing an exception
     * with the specified message.
     *
     * <pre>Validate.notEmpty(myArray, "The array must not be empty");</pre>
     *
     * @param <T> the array type
     * @param array  the array to check, validated not null by this method
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param values  the optional values for the formatted exception message, null array not recommended
     * @return the validated array (never {@code null} method for chaining)
     * @throws NullPointerException if the array is {@code null}
     * @throws IllegalArgumentException if the array is empty
     * @see #notEmpty(Object[])
     */
    public static <T> T[] notEmpty(final T[] array, final String message, final Object... values) {
        if (array == null) {
            throw new NullPointerException(String.format(message, values));
        }
        if (array.length == 0) {
            throw new IllegalArgumentException(String.format(message, values));
        }
        return array;
    }
    
    /**
     * <p>Validate that the specified argument array is neither {@code null}
     * nor a length of zero (no elements); otherwise throwing an exception.
     *
     * <pre>Validate.notEmpty(myArray);</pre>
     *
     * <p>The message in the exception is &quot;The validated array is
     * empty&quot;.
     *
     * @param <T> the array type
     * @param array  the array to check, validated not null by this method
     * @return the validated array (never {@code null} method for chaining)
     * @throws NullPointerException if the array is {@code null}
     * @throws IllegalArgumentException if the array is empty
     * @see #notEmpty(Object[], String, Object...)
     */
    public static <T> T[] notEmpty(final T[] array) {
        return notEmpty(array, DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE);
    }

    // notEmpty map
    //---------------------------------------------------------------------------------
    
    /**
     * <p>Validate that the specified argument map is neither {@code null}
     * nor a size of zero (no elements); otherwise throwing an exception
     * with the specified message.
     *
     * <pre>Validate.notEmpty(myMap, "The map must not be empty");</pre>
     *
     * @param <T> the map type
     * @param map  the map to check, validated not null by this method
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param values  the optional values for the formatted exception message, null array not recommended
     * @return the validated map (never {@code null} method for chaining)
     * @throws NullPointerException if the map is {@code null}
     * @throws IllegalArgumentException if the map is empty
     * @see #notEmpty(Object[])
     */
    public static <T extends Map<?, ?>> T notEmpty(final T map, final String message, final Object... values) {
        if (map == null) {
            throw new NullPointerException(String.format(message, values));
        }
        if (map.isEmpty()) {
            throw new IllegalArgumentException(String.format(message, values));
        }
        return map;
    }

    // notEmpty string
    //---------------------------------------------------------------------------------
    
    /**
     * <p>Validate that the specified argument character sequence is
     * neither {@code null} nor a length of zero (no characters);
     * otherwise throwing an exception with the specified message.
     *
     * <pre>Validate.notEmpty(myString, "The string must not be empty");</pre>
     *
     * @param <T> the character sequence type
     * @param chars  the character sequence to check, validated not null by this method
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param values  the optional values for the formatted exception message, null array not recommended
     * @return the validated character sequence (never {@code null} method for chaining)
     * @throws NullPointerException if the character sequence is {@code null}
     * @throws IllegalArgumentException if the character sequence is empty
     * @see #notEmpty(CharSequence)
     */
    public static <T extends CharSequence> T notEmpty(final T chars, final String message, final Object... values) {
        if (chars == null) {
            throw new NullPointerException(String.format(message, values));
        }
        if (chars.length() == 0) {
            throw new IllegalArgumentException(String.format(message, values));
        }
        return chars;
    }
    
    /**
     * <p>Validate that the specified argument character sequence is
     * neither {@code null} nor a length of zero (no characters);
     * otherwise throwing an exception with the specified message.
     *
     * <pre>Validate.notEmpty(myString);</pre>
     *
     * <p>The message in the exception is &quot;The validated
     * character sequence is empty&quot;.</p>
     *
     * @param <T> the character sequence type
     * @param chars  the character sequence to check, validated not null by this method
     * @return the validated character sequence (never {@code null} method for chaining)
     * @throws NullPointerException if the character sequence is {@code null}
     * @throws IllegalArgumentException if the character sequence is empty
     * @see #notEmpty(CharSequence, String, Object...)
     */
    public static <T extends CharSequence> T notEmpty(final T chars) {
        return notEmpty(chars, DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE);
    }
    
    // notBlank string
    //---------------------------------------------------------------------------------

    public static <T extends CharSequence> T notBlank(final T chars, final String message, final Object... values) {
        if (chars == null) {
            throw new NullPointerException(String.format(message, values));
        }
        if (StringUtils.isBlank(chars)) {
            throw new IllegalArgumentException(String.format(message, values));
        }
        return chars;
    }
    
    /**
     * <p>Validate that the specified argument character sequence is
     * neither {@code null}, a length of zero (no characters), empty
     * nor whitespace; otherwise throwing an exception.
     *
     * <pre>Validate.notBlank(myString);</pre>
     *
     * <p>The message in the exception is &quot;The validated character
     * sequence is blank&quot;.</p>
     *
     * @param <T> the character sequence type
     * @param chars  the character sequence to check, validated not null by this method
     * @return the validated character sequence (never {@code null} method for chaining)
     * @throws NullPointerException if the character sequence is {@code null}
     * @throws IllegalArgumentException if the character sequence is blank
     * @see #notBlank(CharSequence, String, Object...)
     *
     * @since 3.0
     */
    public static <T extends CharSequence> T notBlank(final T chars) {
        return notBlank(chars, DEFAULT_NOT_BLANK_EX_MESSAGE);
    }
    
    // noNullElements array
    //---------------------------------------------------------------------------------
    
    /**
     * <p>Validate that the specified argument array is neither
     * {@code null} nor contains any elements that are {@code null};
     * otherwise throwing an exception with the specified message.
     *
     * <pre>Validate.noNullElements(myArray, "The array contain null at position %d");</pre>
     *
     * <p>If the array is {@code null}, then the message in the exception
     * is &quot;The validated object is null&quot;.</p>
     *
     * <p>If the array has a {@code null} element, then the iteration
     * index of the invalid element is appended to the {@code values}
     * argument.</p>
     *
     * @param <T> the array type
     * @param array  the array to check, validated not null by this method
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param values  the optional values for the formatted exception message, null array not recommended
     * @return the validated array (never {@code null} method for chaining)
     * @throws NullPointerException if the array is {@code null}
     * @throws IllegalArgumentException if an element is {@code null}
     * @see #noNullElements(Object[])
     */
    public static <T> T[] noNullElements(final T[] array, final String message, final Object... values) {
        Validate.notNull(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                final Object[] values2 = ArrayUtils.add(values, Integer.valueOf(i));
                throw new IllegalArgumentException(String.format(message, values2));
            }
        }
        return array;
    }
    
    /**
     * <p>Validate that the specified argument array is neither
     * {@code null} nor contains any elements that are {@code null};
     * otherwise throwing an exception.</p>
     *
     * <pre>Validate.noNullElements(myArray);</pre>
     *
     * <p>If the array is {@code null}, then the message in the exception
     * is &quot;The validated object is null&quot;.</p>
     *
     * <p>If the array has a {@code null} element, then the message in the
     * exception is &quot;The validated array contains null element at index:
     * &quot; followed by the index.</p>
     *
     * @param <T> the array type
     * @param array  the array to check, validated not null by this method
     * @return the validated array (never {@code null} method for chaining)
     * @throws NullPointerException if the array is {@code null}
     * @throws IllegalArgumentException if an element is {@code null}
     * @see #noNullElements(Object[], String, Object...)
     */
    public static <T> T[] noNullElements(final T[] array) {
        return noNullElements(array, DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE);
    }
    
    // noNullElements iterable
    //---------------------------------------------------------------------------------
    
    /**
     * <p>Validate that the specified argument iterable is neither
     * {@code null} nor contains any elements that are {@code null};
     * otherwise throwing an exception with the specified message.
     *
     * <pre>Validate.noNullElements(myCollection, "The collection contains null at position %d");</pre>
     *
     * <p>If the iterable is {@code null}, then the message in the exception
     * is &quot;The validated object is null&quot;.</p>
     *
     * <p>If the iterable has a {@code null} element, then the iteration
     * index of the invalid element is appended to the {@code values}
     * argument.</p>
     *
     * @param <T> the iterable type
     * @param iterable  the iterable to check, validated not null by this method
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param values  the optional values for the formatted exception message, null array not recommended
     * @return the validated iterable (never {@code null} method for chaining)
     * @throws NullPointerException if the array is {@code null}
     * @throws IllegalArgumentException if an element is {@code null}
     * @see #noNullElements(Iterable)
     */
    public static <T extends Iterable<?>> T noNullElements(final T iterable, final String message, final Object... values) {
        Validate.notNull(iterable);
        int i = 0;
        for (final Iterator<?> it = iterable.iterator(); it.hasNext(); i++) {
            if (it.next() == null) {
                final Object[] values2 = ArrayUtils.addAll(values, Integer.valueOf(i));
                throw new IllegalArgumentException(String.format(message, values2));
            }
        }
        return iterable;
    }
    
    /**
     * <p>Validate that the specified argument iterable is neither
     * {@code null} nor contains any elements that are {@code null};
     * otherwise throwing an exception.
     *
     * <pre>Validate.noNullElements(myCollection);</pre>
     *
     * <p>If the iterable is {@code null}, then the message in the exception
     * is &quot;The validated object is null&quot;.</p>
     *
     * <p>If the array has a {@code null} element, then the message in the
     * exception is &quot;The validated iterable contains null element at index:
     * &quot; followed by the index.</p>
     *
     * @param <T> the iterable type
     * @param iterable  the iterable to check, validated not null by this method
     * @return the validated iterable (never {@code null} method for chaining)
     * @throws NullPointerException if the array is {@code null}
     * @throws IllegalArgumentException if an element is {@code null}
     * @see #noNullElements(Iterable, String, Object...)
     */
    public static <T extends Iterable<?>> T noNullElements(final T iterable) {
        return noNullElements(iterable, DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE);
    }
    
  
    
    // notNaN
    //---------------------------------------------------------------------------------
    
    /**
     * <p>Validates that the specified argument is not {@code NaN}; otherwise
     * throwing an exception.</p>
     *
     * <pre>Validate.notNaN(myDouble);</pre>
     *
     * <p>The message of the exception is &quot;The validated value is not a
     * number&quot;.</p>
     *
     * @param value  the value to validate
     * @throws IllegalArgumentException if the value is not a number
     * @see #notNaN(double, java.lang.String, java.lang.Object...)
     *
     * @since 3.5
     */
    public static void notNaN(final double value) {
        notNaN(value, DEFAULT_NOT_NAN_EX_MESSAGE);
    }
    
    /**
     * <p>Validates that the specified argument is not {@code NaN}; otherwise
     * throwing an exception with the specified message.</p>
     *
     * <pre>Validate.notNaN(myDouble, "The value must be a number");</pre>
     *
     * @param value  the value to validate
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param values  the optional values for the formatted exception message
     * @throws IllegalArgumentException if the value is not a number
     * @see #notNaN(double)
     *
     * @since 3.5
     */
    public static void notNaN(final double value, final String message, final Object... values) {
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException(String.format(message, values));
        }
    }
    
    
    // isInstanceOf
    //---------------------------------------------------------------------------------
    
    /**
     * Validates that the argument is an instance of the specified class, if not throws an exception.
     *
     * <p>This method is useful when validating according to an arbitrary class</p>
     *
     * <pre>Validate.isInstanceOf(OkClass.class, object);</pre>
     *
     * <p>The message of the exception is &quot;Expected type: {type}, actual: {obj_type}&quot;</p>
     *
     * @param type  the class the object must be validated against, not null
     * @param obj  the object to check, null throws an exception
     * @throws IllegalArgumentException if argument is not of specified class
     * @see #isInstanceOf(Class, Object, String, Object...)
     *
     * @since 3.0
     */
    public static void isInstanceOf(final Class<?> type, final Object obj) {
        if (!type.isInstance(obj)) {
            throw new IllegalArgumentException(String.format(DEFAULT_IS_INSTANCE_OF_EX_MESSAGE, type.getName(),
                    obj == null ? "null" : obj.getClass().getName()));
        }
    }
    
    /**
     * <p>Validate that the argument is an instance of the specified class; otherwise
     * throwing an exception with the specified message. This method is useful when
     * validating according to an arbitrary class</p>
     *
     * <pre>Validate.isInstanceOf(OkClass.class, object, "Wrong class, object is of class %s",
     *   object.getClass().getName());</pre>
     *
     * @param type  the class the object must be validated against, not null
     * @param obj  the object to check, null throws an exception
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param values  the optional values for the formatted exception message, null array not recommended
     * @throws IllegalArgumentException if argument is not of specified class
     * @see #isInstanceOf(Class, Object)
     *
     * @since 3.0
     */
    public static void isInstanceOf(final Class<?> type, final Object obj, final String message, final Object... values) {
        if (!type.isInstance(obj)) {
            throw new IllegalArgumentException(String.format(message, values));
        }
    }
    
    // isAssignableFrom
    //---------------------------------------------------------------------------------
    
    /**
     * Validates that the argument can be converted to the specified class, if not, throws an exception.
     *
     * <p>This method is useful when validating that there will be no casting errors.</p>
     *
     * <pre>Validate.isAssignableFrom(SuperClass.class, object.getClass());</pre>
     *
     * <p>The message format of the exception is &quot;Cannot assign {type} to {superType}&quot;</p>
     *
     * @param superType  the class the class must be validated against, not null
     * @param type  the class to check, not null
     * @throws IllegalArgumentException if type argument is not assignable to the specified superType
     * @see #isAssignableFrom(Class, Class, String, Object...)
     *
     * @since 3.0
     */
    public static void isAssignableFrom(final Class<?> superType, final Class<?> type) {
        if (!superType.isAssignableFrom(type)) {
            throw new IllegalArgumentException(String.format(DEFAULT_IS_ASSIGNABLE_EX_MESSAGE, type == null ? "null" : type.getName(),
                    superType.getName()));
        }
    }
    
    /**
     * Validates that the argument can be converted to the specified class, if not throws an exception.
     *
     * <p>This method is useful when validating if there will be no casting errors.</p>
     *
     * <pre>Validate.isAssignableFrom(SuperClass.class, object.getClass());</pre>
     *
     * <p>The message of the exception is &quot;The validated object can not be converted to the&quot;
     * followed by the name of the class and &quot;class&quot;</p>
     *
     * @param superType  the class the class must be validated against, not null
     * @param type  the class to check, not null
     * @param message  the {@link String#format(String, Object...)} exception message if invalid, not null
     * @param values  the optional values for the formatted exception message, null array not recommended
     * @throws IllegalArgumentException if argument can not be converted to the specified class
     * @see #isAssignableFrom(Class, Class)
     */
    public static void isAssignableFrom(final Class<?> superType, final Class<?> type, final String message, final Object... values) {
        if (!superType.isAssignableFrom(type)) {
            throw new IllegalArgumentException(String.format(message, values));
        }
    }

    /**
     * Validates that the argument string contains only letters, if not throws and exception.
     *
     * <p>This method is useful when validating non alphanumeric input</p>
     *
     * <pre>Validate.containsOnlyLetters("125BAS")</pre>
     *
     * <p>The message of the exception is &quot;The validated object contains invalid characters&quot;</p>
     * @param value the string to be validated
     * @throws IllegalArgumentException if argument does not contain only letter chars
     */
    public static void containsOnlyLetters(final String value) {
        containsOnlyLetters(value, DEFAULT_CONTAINS_INVALID_CHARACTERS_EX_MESSAGE);
    }

    /**
     * Validates that the argument string contains only letters, if not throws and exception.
     *
     * <p>This method is useful when validating non alphanumeric input</p>
     *
     * <pre>Validate.containsOnlyLetters("125BAS")</pre>
     *
     * <p>The message of the exception is &quot;The validated object contains invalid characters&quot;</p>
     * @param value the string to be validated
     * @param message the {@link String#format(String, Object...)} exception message if invalid, not null
     * @throws IllegalArgumentException if argument does not contain only letter chars
     */
    public static void containsOnlyLetters(final String value, final String message) {
        if (value != null && !value.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException(String.format(message, value));
        }
    }

    /**
     * Validates that the argument string contains only letters, if not throws and exception.
     *
     * <p>This method is useful when validating non alphanumeric input</p>
     *
     * <pre>Validate.containsOnlyLetters("125BAS")</pre>
     *
     * <p>The message of the exception is &quot;The validated object contains invalid characters&quot;</p>
     * @param values the strings to be validated
     * @throws IllegalArgumentException if argument does not contain only letter chars
     */
    public static void containsOnlyLetters(final String[] values) {
        for (String value : values) {
            containsOnlyLetters(value, DEFAULT_CONTAINS_INVALID_CHARACTERS_EX_MESSAGE);
        }
    }

    /**
     * Validates that the argument string contains only letters, if not throws and exception.
     *
     * <p>This method is useful when validating non alphanumeric input</p>
     *
     * <pre>Validate.containsOnlyLetters("125BAS")</pre>
     *
     * <p>The message of the exception is &quot;The validated object contains invalid characters&quot;</p>
     * @param values the strings to be validated
     * @param message the {@link String#format(String, Object...)} exception message if invalid, not null
     * @throws IllegalArgumentException if argument does not contain only letter chars
     */
    public static void containsOnlyLetters(final String[] values, final String message) {
        for (String value : values) {
            containsOnlyLetters(value, message);
        }
    }

    /**
     * Validates that the argument string is a valid argentinian DNI, if not throws and exception.
     *
     * <p>This method is useful when validating argentinian DNI input</p>
     *
     * <pre>Validate.isDNI("1206548")</pre>
     *
     * <p>The message of the exception is &quot;The validated object is not a valid Argentinian DNI&quot;</p>
     * @param value the strings to be validated
     * @throws IllegalArgumentException if argument does not contain only letter chars
     */
    public static void isDNI(String value) {
        Validate.notNull(value);
        if (!value.matches("[0-9]{8}"))
            throw new IllegalArgumentException(DEFAULT_IS_NOT_VALID_ARGENTINIAN_DNI_EX_MESSAGE);
    }

    /**
     * Validates that the argument string is a valid argentinian DNI, if not throws and exception.
     *
     * <p>This method is useful when validating argentinian DNI input</p>
     *
     * <pre>Validate.isDNI("1206548")</pre>
     *
     * <p>The message of the exception is &quot;The validated object is not a valid Argentinian DNI&quot;</p>
     * @param value the strings to be validated
     * @throws IllegalArgumentException if argument does not contain only letter chars
     */
    public static void isDNI(String value, String message) {
        Validate.notNull(value);
        if (!value.matches("[0-9]{8}"))
            throw new IllegalArgumentException(message);
    }

    /**
     * Validates that the argument string is a valid argentinian DNI, if not throws and exception.
     *
     * <p>This method is useful when validating argentinian DNI input</p>
     *
     * <pre>Validate.isDNI("1206548")</pre>
     *
     * <p>The message of the exception is &quot;The validated object is not a valid Argentinian DNI&quot;</p>
     * @param value the strings to be validated
     * @throws IllegalArgumentException if argument does not contain only letter chars
     */
    public static void isDNI(int value) {
       isDNI(String.valueOf(value));
    }

    /**
     * Validates that the argument string is a valid argentinian DNI, if not throws and exception.
     *
     * <p>This method is useful when validating argentinian DNI input</p>
     *
     * <pre>Validate.isDNI("1206548")</pre>
     *
     * <p>The message of the exception is &quot;The validated object is not a valid Argentinian DNI&quot;</p>
     * @param value the strings to be validated
     * @throws IllegalArgumentException if argument does not contain only letter chars
     */
    public static void isDNI(int value, String message) {
        isDNI(String.valueOf(value), message);
    }

    /**
     * Validates that the argument is a valid argentinian plate, if not throws an exception.
     *
     * <p>This method is useful when validating if there will be no parsing errors.</p>
     *
     * <pre>Validate.isValidPlate("AA 1234 BB");</pre>
     * <pre>Validate.isValidPlate("AAA 123");</pre>
     *
     * <p>The message of the exception is &quot;The validated input is not a valid plate&quot;
     * followed by the method argument </p>
     *
     * @param input  the value to be validated
     * @throws IllegalArgumentException if argument can not be matched to the argentinian plate formats
     */
    public static void isValidPlate(String input) {
        if (!input.matches("([a-zA-z]{2} [0-9]{3} [a-zA-Z]{2}|[a-zA-Z]{3} [0-9]{3})"))
            throw new IllegalArgumentException(String.format(DEFAULT_IS_NOT_VALID_PLATE, input));
    }

    public static void containsOnlyNumbers(String input) {
        if (!input.matches("[0-9]+"))
            throw new IllegalArgumentException(String.format(DEFAULT_IS_NOT_ONLY_NUMBER_STRING_EX_MESSAGE, input));
    }

    /**
     * Validates that the argument is a valid boolean expression, if not throws an exception.
     *
     * <p>This method is useful when validating if there will be no parsing errors.</p>
     *
     * <pre>Validate.isBoolean("yes");</pre>
     * <pre>Validate.isBoolean("no");</pre>
     * <pre>Validate.isBoolean("0");</pre>
     * <pre>Validate.isBoolean("1");</pre>
     * <pre>Validate.isBoolean("si");</pre>
     *
     * <p>The message of the exception is &quot;The validated string is not a valid boolean expression&quot;
     * followed by the method argument </p>
     *
     * @param input  the value to be validated
     * @throws IllegalArgumentException if argument can not be represented as a boolean
     */
    public static void isBoolean(String input) {
        switch (input.trim().toLowerCase()) {
            case "yes":
                    return;
            case "no":
                return;
            case "si":
                return;
            case "0":
                return;
            case "1":
                return;
            default:
                throw new IllegalArgumentException(String.format(DEFAULT_IS_NOT_VALID_BOOLEAN_EXPRESSION_EX_MESSAGE, input));
        }
    }
}
