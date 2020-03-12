package Reflect;

interface ClothFactory{
    void produceCloth();
}

//被代理对象
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("nike生产AJ");
    }
}
//代理对象
class ProxyClothFactory implements ClothFactory{
    private ClothFactory clothFactory;
    ProxyClothFactory(ClothFactory clothFactory){
        this.clothFactory=clothFactory;
    }
    @Override
    public void produceCloth() {
        System.out.println("生产开始之前");
        clothFactory.produceCloth();
        System.out.println("生产完成之后");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}
