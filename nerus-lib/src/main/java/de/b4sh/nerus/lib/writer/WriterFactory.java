package de.b4sh.nerus.lib.writer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class WriterFactory {

    private static final Logger log = Logger.getLogger(WriterFactory.class.getName());

    public static IWriter constructWriterChain(final String... list) {
        try {
            IWriter last = null;
            for (int i = list.length - 1; i >= 0; i--) {
                last = WriterFactory.buildWriterInstance(list[i], (AbstractBaseWriter) last);
            }
            return last;
        } catch (final InstantiationException e) {
            WriterFactory.log.log(Level.WARNING, "Could not instantiate the given class", e);
        } catch (final InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            WriterFactory.log.log(Level.WARNING, "Could not access constructor or no method found with given parameters. See stacktrace for further informations", e);
        }
        // an error occurred and has been logged
        return null;
    }

    private static IWriter buildWriterInstance(final String key, final AbstractBaseWriter next) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Class writerClass = WriterImplementation.getClassByKey(key);
        //build writer
        final Constructor<?> ctor = writerClass.getDeclaredConstructor(AbstractBaseWriter.class);
        final IWriter instance = (IWriter) ctor.newInstance(next);
        return instance;
    }
}
