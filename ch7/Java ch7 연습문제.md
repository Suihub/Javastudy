# [7-1]

```
for(int i=0; i<cards.length; i++) {
			int num = i%10+1;
			boolean isKwang = (i<10)&&(num==1||num==3||num==8);

			cards[i] = new SutdaCard(num, isKwang);

		}
```

SutdaCard를 초기화할 때 필요한 매개변수 int와 boolean을 아예 별도로 선언해 저장하고,<br>
이를 대입하는 식으로 식을 짰다.

num의 경우, 1~10을 배열에 순서대로 넣기 위해서는 10으로 나머지 연산자를 사용하여 여기에 +1을 한다.<br>
0~9까지는 나머지로서 온전히 그 값이 나올 테니 여기에 +1을 하면 card[0]부터 차례대로 1~10까지 값이 저장될 것이다.<br>
또한 boolean의 경우 두 쌍 중 한 쌍만 1, 3, 8이 true여야 하므로 10보다 작다는 조건과 함께,<br>
&& 연산자로 숫자가 1, 3, 8일 경우에만 true가 되도록 했다.

# [7-2]

```
void shuffle() {
		for(int i=0; i<cards.length; i++) {
			int j = (int)(Math.random()*cards.length);
			SutdaCard tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
	}

	SutdaCard pick(int index) {
		if(index<0 || index>=CARD_NUM)
			return null;

		return cards[index];
	}

	SutdaCard pick() {
		int j = (int)(Math.random()*cards.length);
		return cards[j];
	}
```

shuffle메서드의 경우, 배열의 길이만큼 반복시켜 반복할 때마다 난수를 만들었다.<br>
중간에 저장할 SutdaCard타입 변수 tmp를 이용해,<br>
난수가 가리키는 자리의 배열 값과 반복문의 매개변수가 가리키는 자리의 값을 무작위로 바꾼다.

매개변수가 있어야 하는 pick메서드의 경우, 우선 매개변수의 유효성 검사를 한다.<br>
총 카드 개수보다 많거나 index의 첫 자리인 0보다 적은 음수인 경우 null을 반환시킨다.<br>
이 조건을 클리어한 경우, 이를 index로 삼아 해당 자리에 위치한 SutdaCard를 반환한다.

매개변수가 필요하지 않은 pick메서드는 해당 값을 난수로 만들 뿐,<br>
나머지는 위와 동일하다.

# [7-3]
- 오버라이딩은 상속받은 메서드를 새로이 쓰는 것으로,<br>
선언부는 동일하되 구현부의 내용을 다르게 하는 것이다.

메서드는 클래스에 따라 쓰임이 다르기에,<br>
이를 새로 쓰는 것이다.

# [7-4]
- 답: c, d

- 해설: 오버라이딩을 할 때, 접근 제어자는 조상의 메서드와 같거나 더 넓어야 한다.<br>
그렇기에 public이 기본인 추상 메서드를 상속받은 클래스들은 해당 메서드를 전부 public 메서드로 해야 한다.

또한 조상의 메서드보다 더 많은 수의 예외를 선언해선 안 된다.<br>
예외는 조상과 같거나 더 적어야 하며,<br>
단순히 예외의 숫자가 아니라 Exception과 같은 모든 예외의 최고 조상도 고려하여<br>
조상보다 적은 수를 선언하도록 해야 한다.

# [7-5]

- 상속 관계에 있는 클래스들은 생성자로 초기화할 때,<br>
this()나 super()를 첫 줄로 둬야 한다.
이는 자손 클래스를 초기화할 때, 그보다 먼저 조상의 변수들을 초기화시키기 위함이다.

조상 클래스들의 변수는 각 클래스에서 직접 초기화시키는 게 이득이므로,<br>
super()를 사용하여 직접 초기화시키는 것이다.<br>
만약 자손의 생성자에 this()나 super()가 존재하지 않을 경우, 컴파일러가 자동으로 super()를 붙여주는 것도 같은 이유이다.

문제는 자손 클래스인 Tv의 기본 생성자 TV()이다.<br>
기본 생성자의 첫 줄에 아무것도 없으므로 자동으로 super()가 추가되는데,<br>
정작 조상 클래스인 Product에는 기본생성자가 존재하지 않는다.<br>
결국 조상 클래스에 호출할 기본 생성자가 없어 컴파일 에러가 뜨는 것이다.

이를 해결하려면 Product에 기본생성자를 추가하던가,<br>
Tv의 생성자에 Product(int price)를 호출하도록 super(price)을 적어 자동으로 super()가 추가되지 않도록 해야 한다.

# [7-6]

위에서 설명.

# [7-7]

- 답: Child() -> Child(int x) -> Parent() -> Parent(int x) -> Object()<br>
실행 결과 - 200

- 해설: 우선 기본생성자가 호출된 뒤에, this()를 통하여 Child(int x)가 호출된다.<br>
Child(int x) 생성자에는 this()나 super()처럼 다른 생성자를 호출하는 것이 첫 줄에 없으므로,<br>
(참조변수 this와 생성자 this()는 this만 쓸 뿐, 전혀 다르다)<br>
컴파일러에 의해 super()가 자동 추가되어 Parent()가 호출된다.<br>
그 후, this를 통해 Parent(int x)가 호출되고, 위와 같은 논리로 최고조상인 Object()가 호출된다.

getX() 메서드는 조상 클래스로부터 상속받은 메서드이다.<br>
변수가 하나뿐이라면 해당 변수를 반환하겠으나,<br>
이름이 겹칠 경우 해당 메서드는 소속한 클래스의 변수를 반환한다.

고로 이곳에서 return으로 반환받는 x는 조상 클래스의 변수이며,<br>
인스턴스 변수의 명시적 초기화로 처음에는 100이 저장되었으나,<br>
앞서 정리한 생성자의 호출로 인해 이는 200으로 덮어씌워졌다.<br>
결국 최종적으로 반환받는 값은 200이다.

# [7-8]

- 답: a

- 해설: 접근제어자의 범위는 넓은 순서대로 public(어디에서든 접근 가능) - <br>
protected(패키지 및 상속 클래스면 접근 가능) - (default)(같은 패키지에서 접근 가능) - <br>
private(같은 클래스에서 접근 가능)이다.

# [7-9]

- 답: c

- 해설: 메서드에 final이 붙은 경우는 자손 클래스에서 오버라이딩을 할 수 없는 경우를 말한다.

# [7-10]

```
boolean getIsPowerOn(){
  return isPowerOn;
}

int getChannel() {
  return channel;
}

int getVolume() {
  return volume;
}

void setChannel(int channel) {
  if(channel<MIN_CHANNEL || channel >MAX_CHANNEL)
    return;

  this.channel = channel;
}

void setVolume(int volume) {
  if(volume<MIN_VOLUME || volume>MAX_VOLUME)
    return;

  this.volume = volume;
}

void setIsPowerOn() {
  isPowerOn = !isPowerOn;
}
```

외부의 접근을 막고자 멤버 변수에는 접근제어자 private를 붙여 해당 클래스 내에서만 다룰 수 있게 했다.<br>
이에 따라 외부에서 값을 변경하려면 메서드를 사용하여 접근하지 않으면 안 된다.

실제로 값을 얻기 위한 get메서드들과 값을 변경시키는 set메서드를 생성했다.<br>
여기서 중요한 건 매개변수의 유효성 검사를 하는 것이다.<br>
채널과 볼륨 모두 최솟값과 최댓값이 존재하므로 이 범위에 속하는 값만 변경할 수 있도록,<br>
if문을 통해 걸러낸다.

# [7-11]

이전 채널을 담아낼 변수 prechannel을 새로이 추가시킨 뒤,<br>
setchannel을 변경시켰다.

```
void setChannel(int channel) {
  if(channel<MIN_CHANNEL || channel >MAX_CHANNEL)
    return;

  prechannel = this.channel;
  this.channel = channel;
}
```

이전 채널에 현재 채널 값을 저장시킨 뒤, 매개변수로 받은 값으로 갱신시킨다.

이전 채널로 이동하는 메서드도 결국 위와 같은 과정을 거치므로,<br>
코드의 중복을 피하고자 setChannel메서드를 호출하는 과정을 거친다.

# [7-12]

- 답: c

- 해설:  지역변수는 해당 메서드에서만 쓰이고 사라지기에 접근 제어자를 붙일 수 없다.

# [7-13]
- Math클래스의 메서드는 모두 static 메서드이므로 객체 생성 없이도 사용할 수 있다.<br>
고로 실제 인스턴스를 생성할 일이 없으므로 애초에 객체 생성을 막고자 private로 한 것.

# [7-14]
- 숫자와 광은 변함이 없으므로 두 멤버 변수에 final을 붙인다.<br>
원래 상수는 선언과 동시에 초기화해야 하나, 인스턴스 변수인 경우 생성자로 초기화가 가능하다.

# [7-15]

- 답: e

- 해설: 우선 단순히 참조변수의 형변환만을 보면 보기의 문제들은 전부 문제가 없다.<br>
참조변수는 같은 상속 관계일 경우, 형변환 생략과 생략 불가를 잘 가리면 문제가 없기 때문이다.

문제는 실제로 실행할 때 발생한다.<br>
조상 클래스 참조변수가 자손의 객체를 가리키는 건 가능하나, 그 반대는 허용되지 않는다.<br>
자손 클래스 참조변수는 기능이 더 많기에 가리키는 객체가 없는 기능을 선언할 가능성이 있기 때문이다.<br>
참조변수의 형변환 자체는 맞게 되었다 하더라도 실제로 이를 실행하면 에러가 뜬다.

a, b의 경우 Unit 참조변수에다가 Aircraft 객체를 담는 것이므로 가능하며,<br>
c는 GroundUnit에 GroundUnit을 담는 것이므로 가능하다.<br>
d와 f도 마찬가지.

단, e만이 다르다.<br>
t는 Tank 타입으로 GroundUnit의 자손 클래스이기에 조상 클래스인 GroundUnit을 가리키게 하면 에러가 난다.

# [7-16]

- 답: e

- 해설: instanceof 연산자는 참조변수를 형변환 가능한지를 묻는 연산자이다.<br>
그러나 FireEngine 클래스와 Ambulance 클래스는 조상이 같을 뿐, 서로 연관이 없으므로 연산 결과는 false가 된다.

# [7-17]

```
abstract class Unit{
	int x, y;
	abstract void move(int x, int y);
	void stop() {}
}
```

공통된 변수, 메서드들을 모아 Unit을 만들되,<br>
move를 추상 메서드로 만들어 Unit을 추상 클래스로 했다.<br>
지상 유닛과 공중 유닛은 작동하는 것이 다를 것이므로,<br>
실제 구현은 다를 거로 생각했기 때문이다.

참고로 인터페이스는 추상 메서드의 집합이라 추상 메서드와 static 메서드, 디폴트 메서드, 상수밖에 쓰지 못하나,<br>
추상 클래스는 추상 메서드가 들어있단 점 외에는 일반 클래스와 같기에 인스턴스 변수도 가질 수 있다.

# [7-18]

```
static void action(Robot r) {
		if(r instanceof DanceRobot) {
			((DanceRobot) r).dance();
		} else if(r instanceof SingRobot){
			((SingRobot) r).sing();
		} else if(r instanceof DrawRobot) {
			((DrawRobot) r).draw();
		}
	}
```

main메서드에서 객체 생성 없이 사용하므로 static 메서드로 만들었다.<br>
우선 참조변수가 실제로 가리키는 객체를 가릴 필요가 있으므로,<br>
조건문과 instanceof 연산자를 사용해 매개변수로 들어오는 객체를 가려냈다.

이후에 각 클래스에 정의된 메서드를 사용해야 하므로,<br>
참조변수를 Robot에서 각각의 자손 클래스로 형변환시켰다.

# [7-19]

```
void buy(Product p) {

  if(money < p.price) {
    System.out.println("잔액이 부족하여 "+p+"을/를 살 수 없습니다.");
    return;
  }

  money -= p.price;
  add(p);

}

void add(Product p) {

  if(i>=cart.length) {
    Product[] tmp = new Product[cart.length*2];
    System.arraycopy(cart, 0, tmp, 0, cart.length);
    cart = tmp;
  }
  cart[i++] = p;
}

void summary() {

  String itemlist="";
  int sum = 0;

  for(int i=0; i<cart.length; i++) {
    if(cart[i]==null)
      break;

    itemlist += (i==0) ? cart[i]+"" : ", "+cart[i];

    sum += cart[i].price;
  }
```
- add 메서드

기존의 장바구니는 3자리지만,<br>
그 이상 구매할 경우를 상정하여 index를 가리키는 변수가 배열의 길이와 같거나 높을 경우를 조건식으로 삼아 if문을 만들었다.

배열의 길이가 2개인 배열을 새로이 만들고,<br>
System클래스의 arraycopy메서드를 통하여 값을 복사했다.<br>
그 후에는 참조변수가 새로 생성한 배열을 가리키도록 하여, cart를 갱신했다.

위 조건을 수행, 또는 조건에 해당하지 않은 경우,<br>
i를 배열 index에 삽입해 매개변수로 받은 제품을 추가시킨 뒤, 증감 연산자로 i의 값을 1 증가시켰다.

- buy 메서드

우선 기존 잔액과 매개변수로 받은 제품의 가격을 비교하여 잔액이 더 적을 경우,<br>
구입할 수 없다는 출력문과 함께 메서드를 강제종료시킨다.<br>
이때 오버라이딩한 toString()을 통하여 제품의 이름을 출력시켰다.

위 조건에 해당하지 않을 경우 제품의 가격만큼 잔액에서 차감시킨 뒤,<br>
add메서드를 호출하여 매개변수로 받은 제품을 배열에 추가시킨다.

- summary 메서드

남은 금액은 잔액을 통해 나타내면 되나,<br>
구입한 물건과 사용한 금액을 나타낼 변수를 따로 생성할 필요가 있다.

금액은 int, 구입한 물건 목록은 참조형 변수로 타입을 지정하였다.<br>
양쪽 모두 Product[]인 cart를 사용해야 하므로,<br>
하나의 조건문으로 묶어 배열에 저장된 제품들의 이름 및 가격을 더해나갔다.

특히 구입목록의 경우 삼항 연산자를 통하여 첫 자리 외에는 ", "가 선행하도록 했다.<br>
또한 배열 길이만큼 반복했을 때, 실제 저장된 값이 먼저 동날 경우를 상정하여<br>
조건문을 통해 해당 객체값이 존재하지 않을 경우, break을 통해 조건문에서 빠져나와 출력으로 이행시켰다.    

# [7-20]

- 답: 100<br>
Child Method<br>
200<br>
Child Method

- 해설: 메서드를 오버라이딩한 경우, 어디에서 메서드를 호출한다 해도 오버라이딩한 메서드가 호출된다.<br>
그러나 같은 이름의 인스턴트 변수가 존재한 상태에서 이를 호출할 때는 참조변수의 타입이 영향을 끼치게 된다.

두 참조변수 모두 자손 객체를 가리키고 있으나,<br>
참조변수 p.x는 조상인 Parent의 참조변수이니 Parent의 x가 호출되고, c.x는 자손의 변수를 호출한다.

# [7-21]

- 답: null, 인터페이스 타입의 참조변수 및 이를 실제로 구현한 클래스를 타입으로 한 참조변수, 그 자손의 인스턴스

- 해설: 인터페이스 참조변수의 다형성에 의해 이를 실제로 구현한 클래스들도 매개변수로 받을 수 있다.

# [7-22]

```
class Circle extends Shape{
	double r;

	Circle(){
		this(new Point(0,0), 10.0);
	}

	Circle(double r){
		this(new Point(0,0), r);
	}

	Circle(Point p, double r){
		super(p);
		this.r = r;
	}

	double calcArea() {
		return Math.PI*(r*r);
	}
}

class Rectangle extends Shape{
	double width;
	double height;

	Rectangle(){
		this(new Point(0,0), 10.0, 10.0);
	}

	Rectangle(double width, double height){
		this(new Point(0,0), width, height);
	}

	Rectangle(Point p, double width, double height){
		super(p);
		this.width = width;
		this.height = height;
	}

	double calcArea() {
		return width*height;
	}

	boolean isSquare() {
		return (width>0&&height>0&&width==height);
	}
}
```

도형을 조상 클래스로 삼으며, 문제에서 요구하는 대로 반지름을 인스턴스 변수로 가진다.<br>
매개변수로 삼은 생성자와 기본생성자를 만드는 데 있어 잊지 말아야 할 것이 조상의 초기화이다.

원 클래스에서는 점이 쓰이지 않을 테고,<br>
자동으로 컴파일러가 super()을 추가시켜 조상의 클래스를 초기화시켜줄 테지만,<br>
그래도 명확하게 가시화하는 것이 좋을 거로 생각했다.

고로 매개변수가 있는 생성자에서 직접 Point 타입의 매개변수를 받아 super를 통해 조상에서 직접 초기화시켰다.<br>
기본 생성자에서는 같은 논리로 0,0을 입력시켜 초기화했다. 앞서 말했듯 이 클래스에서는 쓰이지 않을 것이기 때문이다.<br>
매개변수가 있는 생성자로 Point 외에 int만 매개변수로 설정한 생성자를 만들었는데,<br>
이는 23번 문제와 연계하기 위함이다.

조상 클래스인 도형은 추상 클래스이며 당연히 추상 메서드를 상속받으므로,<br>
원의 면적을 구하는 공식인 파이*반지름의 제곱에 맞추어 메서드를 완성했다.

사각형의 경우, 생성자와 상속받은 추상 메서드의 완성까지는 위와 동일하다.<br>
이와 별개로 정사각형인지 알리는 메서드를 작성했는데,<br>
정사각형의 경우 폭과 넓이의 값이 같을 것이므로,<br>
== 연산자를 통하여 맞는다면 true, 아니면 false를 반환하게 했다.<br>
이때, 값이 음수이거나 0일 경우도 존재할 거로 생각해 && 연산자를 통하여 이 경우를 제외했다.

# [7-23]

```
static double sumArea(Shape[] arr) {
  double sum = 0;
  for(int i=0; i<arr.length; i++) {
    sum += arr[i].calcArea();
  }

  return sum;
}
```

객체 생성 없이 메서드를 사용했으므로 static 메서드로 만들었다.<br>
총합을 넣을 변수가 필요하므로 double타입의 변수를 만든 뒤,<br>
면적을 구하는 calcArea()메서드를 반복문으로 호출시켜 이를 계속해서 변수에 더해 반환시켰다.

# [7-24]

- 답: e

- 해설: 인터페이스와 패키지 간의 연결은 상관없다.

# [7-25]

```
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
System.out.println(inner.iv);
```

인스턴스 내부 클래스를 생성하기 위해선 우선 외부 클래스를 먼저 생성해야 한다.<br>
외부클래스이름.내부클래스이름으로 참조변수의 타입을 지정한 뒤, 외부클래스 참조변수.new 내부클래스로 생성한다.<br>
위 과정을 거친 뒤에 내부 클래스의 변수를 사용할 수 있다.

# [7-26]

```
Outer2.Inner inner = new Outer2.Inner();
System.out.println(inner.iv);
```

static 변수라면 애초에 생성이 필요 없으나, 인스턴스 변수이면 객체를 생성해야 사용할 수 있다.<br>
static 내부 클래스는 인스턴스와 달리 외부 클래스 생성 없이 바로 만들 수 있다.

# [7-27]

```
System.out.println(value);
System.out.println(this.value);
System.out.println(Outer3.this.value);
```

메서드 내에서 변수를 가리키면 가장 가까운 지역변수를 가리키게 된다.<br>
이를 가리기 위해서 참조변수 this를 쓸 경우,<br>
해당 메서드가 정의된 내부 클래스가 this의 대상이 된다.<br>
외부 클래스를 가리키게 하려면, 외부 클래스 이름을 지정하여 그 후에 this를 사용해야 한다.

# [7-28]

```
f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		});
```

익명 클래스는 클래스의 정의와 생성을 동시에 행하며, 이름이 없으므로 조상 혹은 구현하는 인터페이스의 이름으로 행한다.<br>
new 연산자를 쓴 뒤 조상 클래스의 이름으로 선언 후, 구현부에서 실제로 사용할 메서드를 옮겨 적으면 된다.   

# [7-29]
내부 클래스는 외부 클래스의 멤버 취급이므로<br>
외부 클래스의 인스턴스, static멤버 접근은 가능하지만,<br>
지역 내부 클래스에서 지역변수에 접근할 때는 상수만 가능하다.

이는 생성된 지역 내부 클래스 객체가 메서드보다 더 오래 남아있을 경우가 존재하므로,<br>
먼저 사라지는 메서드의 지역변수는 사용하지 못하도록 한 것이다.<br>
상수는 컨스턴트 풀에서 별도로 저장, 관리하므로 사용할 수 있다.
