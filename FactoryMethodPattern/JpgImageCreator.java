// 实例化JpgImage,具体工厂
class JpgImageCreator implements Creator {

    public Image buildImage() {
        return new JpgImage();
    }
}