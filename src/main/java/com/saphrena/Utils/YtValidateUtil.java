package com.saphrena.Utils;

import com.saphrena.Exception.YTArgumentException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 热河
 * @created 2022/6/16 11:18
 * @project saphrena
 * @Description
 */
public class YtValidateUtil {
    private static Class<? extends RuntimeException> exceptionClass = null;
    private static final int NUMBER_CHAR_CODE_0 = 48;
    private static final int NUMBER_CHAR_CODE_9 = 57;

    public YtValidateUtil() {
    }

    public static String notNumeric(String numStr, String message) {
        if (numStr == null || numStr.length() == 0) {
            throwError(message);
        }

        char[] chars = numStr.trim().toCharArray();
        int start = chars[0] == '-' ? 1 : 0;
        boolean isDecimal = false;

        for(int i = start; i < chars.length; ++i) {
            int c = chars[i];
            if (c < '0' || c > '9') {
                if (c == '.' && !isDecimal) {
                    isDecimal = true;
                } else {
                    throwError(message);
                }
            }
        }

        return numStr;
    }

    public static String notNumeric(String numStr, String message, Object... args) {
        return notNumeric(numStr, String.format(message, args));
    }

    public static void throwExceptionClass(Class<? extends RuntimeException> exceptionClass) {
        YtValidateUtil.exceptionClass = exceptionClass;
    }

    private static RuntimeException newException(String message, Throwable ex) {
        try {
            Constructor<? extends RuntimeException> constructor = exceptionClass.getConstructor(String.class, Throwable.class);
            constructor.setAccessible(true);
            return (RuntimeException)constructor.newInstance(message, ex);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException var3) {
            var3.printStackTrace();
            return new YTArgumentException(message, ex);
        }
    }

    private static RuntimeException newException(String message) {
        try {
            Constructor<? extends RuntimeException> constructor = exceptionClass.getConstructor(String.class);
            constructor.setAccessible(true);
            return (RuntimeException)constructor.newInstance(message);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException var2) {
            var2.printStackTrace();
            return new YTArgumentException(message);
        }
    }

    protected static void throwError(String message) {
        if (exceptionClass != null) {
            throw newException(message);
        } else {
            throw new YTArgumentException(message);
        }
    }

    private static void throwError(String message, Throwable ex) {
        if (exceptionClass != null) {
            throw newException(message, ex);
        } else {
            throw new YTArgumentException(message, ex);
        }
    }

    private static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static <V> V notNull(V val, String message) {
        if (val == null) {
            throwError(message);
        }

        return val;
    }

    public static <V> V notNull(V val, String message, Object... args) {
        return notNull(val, String.format(message, args));
    }

    public static String notEmpty(String str, String message) {
        if ("".equals(str)) {
            throwError(message);
            return null;
        } else if (str == null) {
            throwError(message);
            return null;
        } else if (isBlank(str)) {
            throwError(message);
            return null;
        } else {
            return str;
        }
    }

    public static String notEmpty(String str, String message, Object... args) {
        return notEmpty(str, String.format(message, args));
    }

    public static <K, V> Map<K, V> notEmpty(Map<K, V> map, String message) {
        if (map == null) {
            throwError(message);
            return null;
        } else {
            if (map.size() == 0) {
                throwError(message);
            }

            return map;
        }
    }

    public static <K, V> Map<K, V> notEmpty(Map<K, V> map, String message, Object... args) {
        return notEmpty(map, String.format(message, args));
    }

    public static <T extends Collection<?>> T notEmpty(T collection, String message) {
        if (collection == null) {
            throwError(message);
            return null;
        } else if (collection.isEmpty()) {
            throwError(message);
            return null;
        } else {
            return collection;
        }
    }

    public static <T extends Collection<?>> T notEmpty(T collection, String message, Object... args) {
        return notEmpty(collection, String.format(message, args));
    }

    public static <T> T[] notEmpty(T[] arr, String message) {
        if (arr == null) {
            throwError(message);
            return null;
        } else {
            if (arr.length == 0) {
                throwError(message);
            }

            return arr;
        }
    }

    public static <T> T[] notEmpty(T[] arr, String message, Object... args) {
        return notEmpty(arr, String.format(message, args));
    }

    public static <V> V[] noNullElements(V[] arr, String message) {
        notEmpty(arr, message);
        Object[] var2 = arr;
        int var3 = arr.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object t = var2[var4];
            notNull(t, message);
        }

        return arr;
    }

    public static <V> V[] noNullElements(V[] arr, String message, Object... args) {
        return noNullElements(arr, String.format(message, args));
    }

    public static <T extends Iterable<?>> T noNullElements(T iterable, String message) {
        notNull(iterable, message);
        int i = 0;

        for(Iterator<?> it = iterable.iterator(); it.hasNext(); ++i) {
            if (it.next() == null) {
                throwError(message);
            }
        }

        return iterable;
    }

    public static <T extends Iterable<?>> T noNullElements(T iterable, String pattern, Object... args) {
        return noNullElements(iterable, pattern, String.format(pattern, args));
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throwError(message);
        }

    }

    public static void isTrue(boolean expression, String message, Object... args) {
        isTrue(expression, String.format(message, args));
    }
}
