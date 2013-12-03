package imagebrowser;

public class RealImage extends Image {
    
    private final Dimension dimension;

    public RealImage(Dimension dimension) {
        this.dimension = dimension;
    }
    
    @Override
    public Dimension getDimension() {
        return dimension;
    }

    @Override
    public Image getNext() {
        return null;
    }

    @Override
    public Image getPrev() {
        return null;
    }

    @Override
    public void setNext(Image image) {
    }

    @Override
    public void setPrev(Image image) {
    }

}
