// 实例化GifImage,具体工厂
class GifImageCreator implements Creator {

    public Image buildImage() {
        return new GifImage();
    }
}