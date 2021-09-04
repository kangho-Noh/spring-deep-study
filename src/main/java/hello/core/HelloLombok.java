package hello.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString //tostring 생성
//@NoArgsConstructor // 파라미터가 없는 생성자
//@RequiredArgsConstructor // final과 @NonNull인 필드만 파라미터로 받는 생성자
//@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdfas");
        String name = helloLombok.getName();
        System.out.println("name = " + name);
        System.out.println("helloLombok = " + helloLombok);
    }

}
