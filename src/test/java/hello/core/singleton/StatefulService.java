package hello.core.singleton;

//실무에서 정말 자주 발생하는 싱글톤 컨테이너 이슈 : 상태를 저장한 경우
public class StatefulService {

    private int price; //상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제!

    }

    public int getPrice(){
        return price;
    }
}
