package benchmark;

public class TimeMeasurement {
    private long startTime;
    private long endTime;
    public interface TimeMeasurementExecutor{
        void execute();
    }
    public long getTime(TimeMeasurementExecutor timeMeasurementExecutor){
        startTime = System.nanoTime();
        timeMeasurementExecutor.execute();
        endTime = System.nanoTime();
        return endTime-startTime;
    }

}
