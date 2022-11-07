package benchmark;
/**
 * MemoryMeasurement Class is for getting the used memory of a method
 *
 * @author tina
 */
public class MemoryMeasurement {
    public interface MemoryMeasurementExecutor{
        void execute();
    }
    public long getMemory(MemoryMeasurementExecutor memoryMeasurementExecutor){
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long beforeUsedMem = runtime.totalMemory()-runtime.freeMemory();
        memoryMeasurementExecutor.execute();
        long afterUsedMem  = runtime.totalMemory()-runtime.freeMemory();
        return afterUsedMem-beforeUsedMem;
    }
}
