# [8-1]
정의: 예외의 발생에 대비한 코드를 작성하는 것.<br>
목적: 프로그램의 비정상적 종료를 막고 마지막까지 실행하도록 만든다.

# [8-2]
답: d <br>
해설: method1이 method2를 호출했고, 그 위치가 ExceptionEx18.java파일의 8번째 줄이다.

# [8-3]
답: d, e <br>
해설: 오버라이딩을 할 때의 조건은 3가지 존재한다.<br>
선언부의 일치, 접근 제어자의 범위, 그리고 예외 처리의 숫자다.<br>
해당 문제는 그 중 예외 처리에 관한 조건을 묻고 있으며,<br>
자손 클래스는 조상 클래스와 예외 처리의 숫자가 같거나 더 적어야 한다.

d번의 경우 예외 선언을 Exception로 하였고,<br>
Exception은 모든 예외의 조상이므로 자손인 모든 예외가 throw될 수 있는 만큼 잘못된 오버라이딩이다.

e번의 NumberException은 자손 클래스로 InvalidNumberException과 NotANumberException 2개를 가지고 있으므로,<br>
오버라이딩 전과 숫자가 같다고 착각할 수 있다.<br>
그러나 NumberException을 예외로 선언할 경우,<br>
자손 2개만이 아니라 해당 예외도 발생할 수 있으므로 총 3개가 된다.

# [8-4]
답: c <br>
해설: try-catch문의 흐름은 try블록에서 예외가 발생할 시,<br>
곧장 try블록에서 빠져나가 catch블록을 위에서부터 차례대로 instanceof 연산자를 통해 확인해나간다.

c는 예외의 최고조상인 Exception이 위에 있고,<br>
어떤 예외가 발생하든 instanceof연산자가 true가 되므로 해당 catch블록에서 처리가 되고 만다.<br>
결국 밑에 어떤 catch블록을 준비하건 수행되지 않기에,<br>
Exception을 조건으로 삼은 catch블록은 맨 마지막에 위치해야 한다.

# [8-5]
실행 결과 : <br>
1 <br>
3 <br>
5 <br>
1 <br>
2 <br>
5 <br>
6 <br>

해설: method메서드는 중간에 매개변수가 true인 경우 ArithmeticException을 발생시킨다.<br>
이러면 try블록의 나머지 문장이 수행되지 않고 catch블록으로 이행하며,<br>
ArithmeticException은 RuntimeException의 자손이므로 해당 블록의 내용이 수행된다.
단, catch블록 내에 return문이 있다고 해도 finally문은 반드시 수행되므로 5도 출력한다.
이때 6은 출력하지 않는데 catch블록의 return문으로 인해 메서드가 종료하기 때문이다.

false인 경우, try블록의 문장을 전부 수행한 후 catch블록을 무시한 채 fianally블록으로 이행하고,<br>
나머지 메서드의 내용이 수행되어 6까지 온전히 출력된다.

# [8-6]
실행 결과:<br>
3<br>
5<br>

해설: 해당 코드의 실행과정은 다음과 같다.<br>
main메서드 실행, try블록에서 method1 호출<br?
-> method1에서 method2호출 <br>
-> method2에서 NullPointerException 예외를 발생시켜 이를 던짐.<br>
-> method1의 try블록에서 catch블록으로 이행하나 해당되는 예외가 없으므로 도로 main메서드로 내던진다.<br>
이때, finally문이 실행되어 3이 출력.<br>
-> main메서드의 try블록을 빠져나가 Exception을 조건으로 삼은 catch블록이 수행되어 5가 출력.

# [8-7]
실행 결과:<br>
1

해설: 여기서 문제는 System클래스의 exit메서드이다.<br>
exit메서드는 수행하면 현재 JVM으로 실행되는 프로그램을 종료시키는 메서드로,<br>
main메서드에서 method를 true와 false를 넣어 두 번 호출했으나,<br>
첫 번째 호출이 수행되는 과정에서 exit메서드가 실행되어 1만 출력한 뒤에 프로그램이 종료하고 만다.<br>
이때는 finally블럭도 수행되지 않는다.

# [8-8]
답:

```
try {
  input = new Scanner(System.in).nextInt();

  if(answer > input) {
    System.out.println("더 큰 수를 입력하세요.");
  }  else if(answer < input) {
    System.out.println("더 작은 수를 입력하세요.");
  } else {
    System.out.println("맞췄습니다.");
    System.out.println("시도횟수는 "+count+"번입니다.");
    break;
  }

} catch(InputMismatchException ie) {
  System.out.println("유효하지 않은 값입니다. 다시 입력해주세요.");
}
```

해설: 문제에 제시된 예외문을 보면 main메서드에서 nextint메서드를 호출하면서 예외가 발생한 걸 볼 수 있다.<br>
이는 int형과 맞지 않은 타입이 입력된 탓이다.

고로 예외가 발생할 수 있는 input = new Scanner(System.in).nextInt();를 비롯해,<br>
if문까지 전부 try 블록에 넣었다.<br>
try블록에서 예외가 발생해 catch블록으로 "다시 입력하라"는 메시지를 출력해도,<br>
try-catch문 뒤에 코드가 있으면 이들이 수행되므로 이를 방지하기 위함이다.

만약 try블록이 복잡해지는 걸 피하고자 if문을 별도로 빼고 싶다면<br>
catch블록 마지막에 continue문을 넣으면 된다.<br>
반복문을 완전히 빠져나가는 break문과 달리,<br>
continue문은 나머지 문장을 수행하지 않고 반복문의 맨 처음으로 돌아가기 때문이다.

# [8-9]
답:

```
class UnsupportedFuctionException extends RuntimeException{
	final private int ERR_CODE;

	UnsupportedFuctionException(String msg){
		this(msg, 100);
	}

	UnsupportedFuctionException(String msg, int err){
		super(msg);
		ERR_CODE = err;
	}

	public int getErrorCode() {
		return ERR_CODE;
	}

	public String getMessage() {
		return "["+getErrorCode()+"]"+super.getMessage();
	}
}
```

해설: 문제에서 요구하는 대로 private인 상수로 ERR_CODE를 만들고 에러 코드를 저장하도록 만들었다.<br>
인스턴스 변수라면 상수는 생성자로 한 번만 초기화할 수 있으므로,<br>
super()를 통하여 에러 메시지를 조상 클래스에서 초기화시킴과 동시에 본 클래스 내의 상수를 초기화시키는 생성자를 만들었다.

또한 문제에서 ERR_CODE의 기본값이 100이라고 요구하였으므로,<br>
위의 생성자를 this()로 호출하는 별도의 생성자도 준비했다.<br>
이때 상수의 기본값은 100으로 하고, 매개변수로 받는 건 에러 메시지만이다.

getErrorCode() 메서드는 ERR_CODE를 반환받는 메서드로,<br>
에러 코드가 private이므로 직접 접근이 불가능해 준비한 간접 접근법이다.

getMessage()를 오버라이딩할 때는 실행 결과와 같은 결과가 나오도록 return값을 만들었다.<br>
private로 캡슐화한 상수를 직접 사용하는 건 옳지 않으므로 getErrorCode()를 호출하였고,<br>
참조변수 super를 통해 조상의 getMessage()를 호출해 이를 반환시킨다.

# [8-10]
실행 결과:<br>
2<br>
4<br>
7

해설: main메서드에서 method1() 호출 <br>
-> method1()에서 method2()호출 <br>
-> method2()에서 NullPointerException 예외가 발생하며 던져짐<br>
-> method1의 try블록에서 빠져나와 catch블록이 수행, 2가 출력.<br>
해당 오류를 다시 main메서드로 되던지고 그 전에 finally블록이 수행되어 4가 출력.<br>
-> main메서드에서 try블록을 빠져나가 catch블록이 수행, 7이 출력.
