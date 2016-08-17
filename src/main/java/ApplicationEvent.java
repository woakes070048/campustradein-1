/**
 * @author ifeify
 */
public class ApplicationEvent {
    private long timestamp;

    public ApplicationEvent() {
        timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

}
