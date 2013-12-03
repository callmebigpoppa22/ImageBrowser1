package imagebrowser;

public abstract class ImageViewer {
    
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        refresh();
    }
    
    public abstract void refresh();

}
