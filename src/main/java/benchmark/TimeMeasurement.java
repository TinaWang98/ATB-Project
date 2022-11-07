package benchmark;
/**
 * TimeMeasurement Class is for getting the execution time of a method
 *
 * @author tina
 */
public class TimeMeasurement {
    public interface TimeMeasurementExecutor{
        void execute();
    }
    public long getTime(TimeMeasurementExecutor timeMeasurementExecutor){
        long startTime = System.nanoTime();
        timeMeasurementExecutor.execute();
        long endTime = System.nanoTime();
        return endTime-startTime;
    }
}
