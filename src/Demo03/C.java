package Demo03;

interface A {
    int x = 0;
}
class B {
    int x = 1;
}
class C extends B implements A {
    public void pX() {
        //编辑不通过，此时的x不确定是A的x，还是B的x
        //System.out.println(x);
        System.out.println(super.x);
        System.out.println(A.x);

    }
    public static void main(String[] args) {
        new C().pX();
    }
}