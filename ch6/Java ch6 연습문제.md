# [6-1]
int num;
boolean isKwang;

# [6-2]

```
	int num;
	boolean isKwang;

	SutdaCard(){
		this(1, true);
	}

	SutdaCard(int n, boolean k){
		num = n;
		isKwang = k;
	}

	String info(){
		if(isKwang==true) {
			return num+"K";
		} else {
			return num+"";
		}
```

문제의 main메서드에서 기본 생성자와 매개변수가 있는 생성자를 쓰고 있으므로<br>
class에 두 생성자를 만들었다.

info()의 경우, 실행 결과가 한쪽은 3, 또 다른 건 1K인 걸로 보아,<br>
변수+isKwang의 true와 false 여부를 출력하는 거로 생각해 if문으로 두 경우를 나누었다.

# [6-3]
  String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

# [6-4]

```
int getTotal(){
		return kor+eng+math;
	}

float getAverage() {
		return (int)((getTotal()/3f)*10+0.5) / 10.0f;
```  

main메서드에서 객체를 만들어 메서드들을 사용했으므로 인스턴트 메서드로 정의했다.<br>
문제에서 요구하는 대로 총점과 평균을 구하게 되어있으며,<br>
평균의 경우 getTotal()를 호출해 사용한다는 점이 특징이다.

# [6-5]

```
  String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;


	Student2(){}

	Student2(String s, int b, int n, int k, int e, int m){
		name = s;
		ban = b;
		no = n;
		kor = k;
		eng = e;
		math = m;
	}

	int getTotal(){
		return kor+eng+math;
	}

	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5) / 10.0f;
	}

	String info() {

	return	name+", "+ban+", "+no+", "+kor+", "+eng+", "+math+", "+getTotal()+", "+getAverage();

	}
```

생성자는 main메서드에서 대입한 매개변수들을 참고해서 만들었다.<br>
info()메서드를 통해 호출되는 값들이 Student2 클래스의 정보들이므로,<br>
String을 반환타입으로 삼아 각각의 변수와 메서드들을 나열하는 식으로 출력했다.

# [6-6]
return Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));

두 좌표 사이의 거리를 구하는 공식은 두 점의 x 좌표와 y 좌표의 차이를 제곱하고,<br>
루트를 씌우는 것이다.<br>
이 공식에 맞추어 return값을 얻도록 식을 꾸렸다.

# [6-7]

```
double getdistance(int x1, int y1) {

		return Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));
	}
```

6번 문제와의 차이는 static 메서드가 아니라 인스턴트 메서드라는 점이다.<br>
실제 계산에 인스턴스 변수를 사용하기에 또 하나의 좌표를 나타내기 위한 매개변수를 설정했다.<br>
거리를 구하는 식 자체는 6번과 동일하다.

# [6-8]
클래스 변수 = width, height
인스턴스 변수 = kind, num
지역변수 = k, n, card(참조변수), args

# [6-9]
답: static 변수 - weapon과 armor <br>
static 메서드 - weaponUp(), armorUp()

모든 병사의 공격력과 방어력이 같아야 한다는 조건이 붙어있기 때문.<br>
static 변수는 모든 인스턴스가 같은 값을 가져야 하는 변수일 때 설정한다.

반면, 메서드에서 static은 구현부에서 인스턴스 멤버를 사용하지 않은 경우에 붙일 수 있다.<br>
weaponUp()와 armorUp()는 인스턴스 멤버를 사용하지 않으므로 static 메서드로서 정의할 수 있다.

# [6-10]
답:  b, e

생성자는 객체의 값을 초기화시키는 데 쓰이며,<br>
객체를 실제로 생성하는 건 new 연산자이다.<br>
또한 생성자도 오버로딩이 가능하며,<br>
여러 개의 생성자를 만들어 매개변수에 따라 적절한 생성자를 호출할 수 있다.

# [6-11]
답: b

this는 인스턴스 자신을 가리키는 지역변수로 오로지 인스턴스메서드에서만 사용할 수 있다.

# [6-12]
답: c, d

오버로딩의 조건은 a와 b뿐으로 나머지는 관계없다.

# [6-13]
답: b, c, d

# [6-14]
답: c, e

초기화 순서 중에서 생성자는 가장 마지막에 수행된다.<br>
클래스 변수는 클래스 파일이 메모리에 로딩될 때 생성 및 초기화되므로,<br>
순서상 가장 먼저 초기화되며 인스턴스와 달리 단 한 번만 초기화한다.

# [6-15]
답: a

# [6-16]
답: a, e

지역변수는 수동으로 초기화해야 하며, 자동 초기화는 어디까지나 멤버변수만 해당한다.<br>
지역변수는 해당 메서드 내에서 생성되고 저장되어 사용된다.<br>
힙 영역은 인스턴스(인스턴스변수)가 생성되는 영역으로,<br>
지역변수는 앞서 말했듯 해당 메서드(호출스택)에 생성된다.

# [6-17]
답: b

제일 윗단이 수행할 때 나머지들은 일시적으로 대기할 뿐, 종료한 게 아니다.

# [6-18]
답: A, B, D

static이 붙은 클래스멤버는 인스턴스 변수 및 메서드를 사용하지 못한다.

# [6-19]
답: ABC123<br>
After change:ABC123

change 메서드에 의해 ABC123456이 되지 않을까 싶으나, 결과는 바뀌지 않는다.<br>
String과 같은 참조형은 해당 문자열이 담기는 공간이 따로 만들어지고,<br>
이를 가리키는 주소가 저장되기 때문이다.

우선 change(str)이 수행되면 "ABC123"을 가리키는 주소값이 change 메서드의 참조변수 str에 그대로 옮겨진다.<br>
만약 이것이 단순한 배열이나 객체였다면 주소값을 통해 해당 내용을 바꿀 수 있었겠지만,<br>
참조형 변수의 경우 문자열이 서로 합쳐지면 아예 새로운 문자열이 만들어져 그 주소값을 반환받게 되어있다.

즉, "ABC123456"라는 문자열이 새로이 만들어지면서,<br>
이에 대한 주소가 change 메서드의 str에 그대로 덮어씌워지는 것이다.

change메서드가 역할을 끝내고 호출스택에서 사라진 뒤.<br>
"ABC123456"을 가리키는 주소값도 사라지게 되며, 이와 무관계한 기존의 str은 아무런 변화도 없다.


# [6-20]

```
static int[] Shuffle(int[] arr) {
		if(arr==null || arr.length==0)
			return arr;


		for(int i=0; i<arr.length; i++) {
			int j = (int)(Math.random()*arr.length);
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}

		return arr;
	}
```

우선 매개변수의 유효성 검사를 위하여 if문을 통해 참조변수가 가리키는 값이 없거나,<br>
길이가 0이면 입력한 값을 그대로 반환하게 했다.

이러한 유효성 검사에 걸리지 않는다면,<br>
해당 배열의 길이만큼 반복해서 배열의 위치를 랜덤하게 뒤바꾸도록 코드를 짰다.

# [6-21]
답: src파일 참조


# [6-22]

```
static boolean isNumber(String str) {
		if(str==null || str=="")
			return false;

		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);

			if(!('0'<=ch && ch<='9')) {
				return false;
			}

		}
		return true;

	}
```

우선 매개변수의 유효성 검사를 위하여,<br>
참조형 변수의 주소값이 가리키는 내용이 없거나 빈 문자열인 경우 false를 반환하도록 했다.

이 메서드의 주된 내용은 문자열이 전부 숫자인지 아닌지를 가리는 것이다.<br>
그렇기에 반복문으로 문자열의 모든 값을 char 변수에 저장하고 if문으로 검사하도록 했다.<br>
만약 해당 char 변수가 숫자가 아니면 false 값을 반환하고 메서드는 종료 한다.<br>
반대로 모두 숫자일 경우 해당 if문은 작동하지 않으므로 문자열의 길이만큼 반복하고 최종적으로 true 값을 반환한다.

# [6-23]

```
static int Max(int[] arr) {
		if(arr==null || arr.length==0)
			return -999999;

		int result = arr[0];

		for(int i=0; i<arr.length; i++) {
			if(result<arr[i]) {
				result = arr[i];
			}
		}

		return result;
	}
```

매개변수의 유효성 검사를 위해 길이가 0이거나 배열의 주소값이 존재치 않으면 -999999를 반환한다.

해당 메서드는 배열 중에서 최댓값을 출력하는 메서드이므로 배열의 각 값을 모두 비교할 필요가 있다.<br>
값을 담을 변수를 만들고 이를 배열의 첫 번째 자리에 저장된 값으로 초기화한다.<br>
이후에 반복문과 if문으로 각 배열의 값을 비교하며 만약 저장된 값보다 배열의 특정 요소가 클 경우,<br>
그 값을 다시 대입하는 식으로 처리했다.

# [6-24]

```
if(value>=0) {
			return value;
		} else {
			return value*-1;
		}
```

절대값을 구하는 메서드이므로 0과 같거나 양수이면 입력한 값을 그대로,<br>
음수일 경우에는 -1을 곱해 양수로 바꾸어 반환한다.
