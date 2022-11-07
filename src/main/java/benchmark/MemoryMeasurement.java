package benchmark;

public class MemoryMeasurement {
    public interface MemoryMeasurementExecutor{
        void execute();
    }
    public long getMemory(MemoryMeasurement.MemoryMeasurementExecutor memoryMeasurementExecutor){
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long beforeUsedMem = runtime.totalMemory()-runtime.freeMemory();
        memoryMeasurementExecutor.execute();
        long afterUsedMem  = runtime.totalMemory()-runtime.freeMemory();
        return afterUsedMem-beforeUsedMem;
    }
}
