// 测试
class FactoryTest {
    
    public static void main(String[] args) {
        Creator creator = new GifImageCreator();
        Image image = creator.buildImage();
        image.getFormat();
    }
}