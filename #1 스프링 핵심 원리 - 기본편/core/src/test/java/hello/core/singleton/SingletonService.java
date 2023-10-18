package hello.core.singleton;

public class SingletonService {

    /**
     * static 으로 선언했기 때문에 딱 하나만 존재하게 됨!
     * 아무도 밖에서 instance를 생성하지 못하고, 조회만 가능함!
     * 자바 jvm 이 실행되면 instance 객체를 new해서 새로 생성해서, 인스턴스에 참조를 넣어놈.
     */
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){ // 인스턴스 조회!!
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
