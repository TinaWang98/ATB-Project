package benchmark;

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
