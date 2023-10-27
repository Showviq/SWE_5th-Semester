interface Video {
    void play();
}

class ConcreteVideo implements Video {
    private String videoUrl;

    public ConcreteVideo(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public void play() {
        System.out.println("Playing video from " + videoUrl);
    }
}

class VideoProxy implements Video {
    private String videoUrl;
    private ConcreteVideo concreteVideo;

    public VideoProxy(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public void play() {
        if (concreteVideo == null) {
            concreteVideo = new ConcreteVideo(videoUrl);
        }
        System.out.println("Proxy checks access for the user.");
        concreteVideo.play();
    }
}

public class Main {
    public static void main(String[] args) {
        String videoUrl = "https://youtu.be/1LHxu22X9t0?si=wl5iwXiU3DQzGDBU";
        VideoProxy proxy = new VideoProxy(videoUrl);
        proxy.play();
    }
}