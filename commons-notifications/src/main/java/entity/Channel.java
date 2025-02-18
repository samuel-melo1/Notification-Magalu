package entity;

public class Channel {
    private Long channelId;
    private String description;
    public Channel() {}
    public Channel(Long channelId, String description) {
        this.channelId = channelId;
        this.description = description;
    }
    public Long getChannelId() {
        return channelId;
    }
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelId=" + channelId +
                ", description='" + description + '\'' +
                '}';
    }
}