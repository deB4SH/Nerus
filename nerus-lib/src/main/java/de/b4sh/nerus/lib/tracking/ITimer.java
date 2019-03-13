package de.b4sh.nerus.lib.tracking;

public interface ITimer {

    /**
     * Function to add a timestamped data with a specific data length.
     *
     * @param startTime  the start time of the tracked operation (system nanotime e.g.)
     * @param endTime    the end time of the tracked operation (system nanotime e.g.)
     * @param dataLength the written data length
     */
    void trackTime(long startTime, long endTime, long dataLength);
}
