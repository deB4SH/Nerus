package de.b4sh.nerus.lib.writer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Factory class to builds a writer stack from a given string array.
 * The following code example generates you a stacked writer starting with buffered writer followed by a null writer.
 *
 * <pre>
 *     {@code
 *          final String[] param = new String[2];
 *          param[0] = "buffered";
 *          param[1] = "null";
 *          final IWriter writer = WriterFactory.constructWriterChain(param);
 *     }
 * </pre>
 */
public final class WriterFactory {

    private static final Logger log = Logger.getLogger(WriterFactory.class.getName());

    /**
     * Function to construct the writer chain based on the given array of strings.
     *
     * @param list chain that should be instantiated
     * @return null (on issue) or instantiated list of writers
     */
    public static IWriter constructWriterChain(final String... list) {
        if (list == null) {
            WriterFactory.log.log(Level.WARNING, "Could not build writer chain. Parameter list was null. Returning null.");
            return null;
        }
        try {
            IWriter last = null;
            for (int i = list.length - 1; i >= 0; i--) {
                if (WriterImplementation.isKeyExisting(list[i])) {
                    last = WriterFactory.buildWriterInstance(list[i], (AbstractBaseWriter) last);
                } else {
                    WriterFactory.log.log(Level.WARNING, String.format("Seems that the key %s is not a valid implementation. Please review your chain.", list[i]));
                    return null;
                }
            }
            return last;
        } catch (final InstantiationException e) {
            WriterFactory.log.log(Level.WARNING, "Could not instantiate the given class", e);
        } catch (final InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            WriterFactory.log.log(Level.WARNING, "Could not access constructor or no method found with given parameters. See stacktrace for further informations", e);
        }
        return null; // an error occurred and has been logged
    }

    private static IWriter buildWriterInstance(final String key, final AbstractBaseWriter next) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Class writerClass = WriterImplementation.getClassByKey(key);
        if (writerClass == null) {
            WriterFactory.log.log(Level.WARNING, "Could not retrieve writer class by key. returning null.");
            return null;
        }
        //build writer
        final Constructor<?> ctor = writerClass.getDeclaredConstructor(AbstractBaseWriter.class);
        return (IWriter) ctor.newInstance(next);
    }
}
