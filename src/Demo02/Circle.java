package Demo02;

/*
定义一个Circle类，声明redius属性，提供getter和setter方法
 */
public class Circle {

    private Double radius;

    public Circle() {
        super();
    }

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Double getRadius(){
        return radius;
    }

    public void setRadius(Double radius){
        this.radius=radius;
    }

}
