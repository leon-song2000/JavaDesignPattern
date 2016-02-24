##工厂方法模式（Factory Method Pattern）

###场景
Java中的关键字**new**用来实例化一个类。当更改了构造器参数的时候，就需要更改每个**new**出现的地方，这样带来了额外的工作量，并且容易遗漏。这种场景下可以考虑采用工厂方法模式。

###定义
工厂方法模式是一种类创建型模式，它定义了一个用于创建对象的接口，让子类来决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。

###结构图
![工厂模式结构图](/images/factoryMethod.png)

* Product(抽象产品)： 产品对象的公共父类
* ConcreteProduct(具体产品): 实现了抽象产品，由具体工厂类创建
* Creator(抽象工厂): 声明工厂方法
* ConcreteCreator(具体工厂): 实现抽象工厂，创建具体产品

###例子
设计一个程序来读取各种不同类型的图片格式，针对每一种图片格式都设计一个图片读取器，如GIF图片读取器用于读取GIF格式的图片，JPG图片读取器用于读取JPG格式的图片。

	// 图片读取器接口，抽象产品
	interface Image {

    	public void getFormat();
	}

	// GIF格式读取器，具体产品
	class GifImage implements Image {
	
	    public void getFormat() {
	        System.out.println("this is gif");
	    }
	}

	// Jpg格式读取器，具体产品
	class JpgImage implements Image {
	    
	    public void getFormat() {
	        System.out.println("this is Jpg");
	    }
	}

	// 抽象工厂
	interface Creator {
	    
	    public Image buildImage();
	}
	
	// 实例化GifImage,具体工厂
	class GifImageCreator implements Creator {
	
	    public Image buildImage() {
	        return new GifImage();
	    }
	}

	// 实例化JpgImage,具体工厂
	class JpgImageCreator implements Creator {
	
	    public Image buildImage() {
	        return new JpgImage();
	    }
	}

测试代码

	// 测试
	class FactoryTest {
	    
	    public static void main(String[] args) {
	        Creator creator = new GifImageCreator();
	        Image image = creator.buildImage();
	        image.getFormat();
	    }
	}

输出结果: this is gif

###说明
* 优点： 对象创建与使用分离，易扩展
* 缺点： 系统复杂性提高
* 使用场景： 客户端不知道它需要的具体类，让具体类的创建延迟到工厂方法中

###参考
<http://blog.csdn.net/lovelion/article/details/17517213>

<http://howtodoinjava.com/design-patterns/creational/implementing-factory-design-pattern-in-java>

<http://www.javaworld.com/article/2077386/learn-java/factory-methods.html>

