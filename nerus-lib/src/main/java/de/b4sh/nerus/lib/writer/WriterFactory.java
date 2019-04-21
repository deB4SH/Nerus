package de.b4sh.nerus.lib.writer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class WriterFactory {

    private static final Logger log = Logger.getLogger(WriterFactory.class.getName());

    public static IWriter constructWriterChain(final String... list) {
        IWriter last = null;
        try {
            for (int i = list.length - 1; i >= 0; i--) {
                if (i == list.length - 1) { //construct last used writer implementation
                    last = (AbstractBaseWriter) WriterFactory.buildWriterInstance(list[i], null);
                    continue;
                }//construct first and middle ones
                last = WriterFactory.buildWriterInstance(list[i], (AbstractBaseWriter) last);
            }
        } catch (final InstantiationException e) {
            WriterFactory.log.log(Level.WARNING, "Could not instantiate the given class", e);
            return null;
        } catch (final InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            WriterFactory.log.log(Level.WARNING, "Could not access constructor or no method found with given parameters. See stacktrace for further informations", e);
            return null;
        }
        return last;
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
