package Demo01;

import java.util.Optional;

interface IMessage{
    public void send(String msg);
}
class NewsPaper implements IMessage{
    @Override
    public void send(String msg) {
        System.out.println("lalala"+msg);
    }
}
public class FactoryTest {
    private  FactoryTest(){}
    public static IMessage getInstance(String msg){
        if ("newspaper".equalsIgnoreCase(msg)){
            return new NewsPaper();
        }return null;
    }
}
class Factory{
    private Factory(){}
    public static IMessage getInstance(String className){

        IMessage instance = null;
        try {
            instance = (IMessage) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return instance;
    }
}
class newtest{
    public static void main(String[] args) {
        IMessage newspaper = Factory.getInstance("Demo01.NewsPaper");
        Optional.ofNullable(newspaper).orElse(newspaper);
        newspaper.send("hehe");
    }
}
