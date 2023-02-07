# [9-1]
- 답:

```
if(obj instanceof SutdaCard) {
  SutdaCard sc = (SutdaCard)obj;
  return this.num==sc.num && this.isKwang==sc.isKwang;
}

return false;
```

- 해설: 매개변수의 유효성 검사를 위해 instanceof 연산자를 사용하여 조건식으로 삼았다.<br>
매개변수로 받은 참조변수가 SutdaCard로 형변환이 가능하면 이를 형변환시킨 뒤, 인스턴스 변수를 비교한다.
Object 참조변수로는 SutdaCard의 멤버를 사용할 수 없기 때문.

이 식의 결과를 직접 return시킴으로써 true와 false 중 하나가 반환될 것이다.<br>
만약 SutdaCard클래스로 형변환이 불가능할 경우, 굳이 신경 쓸 필요가 없으므로 곧장 false를 반환한다.

# [9-2]
- 답:

```
public boolean equals(Object obj) {
  if(obj instanceof Point3D) {
    Point3D p3d = (Point3D)obj;

    return this.x==x && this.y==y && this.z==z;
  }
  return false;
}

public String toString() { return "["+x+","+y+","+z+"]"; }
```

- 해설: equals는 1번과 같은 논리.<br>
toString의 경우, 실행결과에서 [x,y,z]로 출력됨으로 이에 맞추어 문자열을 작성해 반환한다.

# [9-3]
- 답:

```
int index = fullPath.lastIndexOf("\\");

path = fullPath.substring(0, index);
fileName = fullPath.substring(index+1, fullPath.length());
```

- 해설: 실행결과를 보면 path와 fileName은 fullPath에서 경로와 파일 이름으로 갈라지는 걸 볼 수 있다.<br>
또한 이 셋 모두 String클래스의 참조변수이므로 해당 클래스의 메서드를 사용할 수 있다.

문자열에서 특정 위치까지의 문자열을 추출하여 저장하는 역할을 하는 메서드는 substring이다.<br>
대상인 fullPath에서 substring을 사용하고 각각 path와 fileName에 맞게 위치를 지정하여 나누면 된다.

문제는 이 두 경로를 나누는 부분의 위치를 어떻게 찾느냐이다.<br>
문자열에서 특정 문자의 위치를 찾아 반환하는 메서드는 indexOf이다.<br>
다만 일반적인 indexOf는 왼쪽에서부터 탐색하여 이를 반환한다.

work와 PathSeparateTest를 가리는 것은 \인데,<br>
만약 indexOf를 사용하고 매개변수로 "\\"를 입력한다면 c:다음에 있는 \의 위치(index)가 반환될 것이다.

고로 여기서는 indexOf가 아닌 오른쪽부터 문자열을 탐색하는 lastIndexOf메서드를 사용한다.<br>
이를 통해 찾아낸 위치를 int형 변수에 집어넣어 그대로 substring메서드의 매개변수로 활용한다.<br>
이 때, substring메서드에서 시작 위치는 포함되나, 끝은 미포함인 것에 주의한다.

# [9-4]
- 답:

```
for(int arr : dataArr) {
  char[] graph = new char[arr];
  for(int i=0; i<arr; i++)
    graph[i] = ch;			
  System.out.print(graph);
  System.out.println(arr);
}
```

- 해설: 향상된 for문으로 int배열의 값들마다 코드를 반복시킨다.<br>
char형 배열을 만들어 int배열의 값만큼 길이를 지정해 만들고,<br>
이중 for문을 통해 그 숫자만큼 매개변수로 받은 문자를 배열에 집어넣는다.<br>
마지막으로 char[]인 graph와 해당 반복시의 int배열 값을 출력한다.

# [9-5]
- 답:

```
while(true) {
  if(src.indexOf(target, pos)==-1)
    break;

  pos = src.indexOf(target, pos);
  count++;
  pos += target.length();			

}

return count;
```

- 해설: 무한 반복문으로 코드를 짜고 만약 indexOf메서드를 사용해서 -1이 반환되면 break문으로 빠져나가,<br>
체크 횟수를 반환한다.

위 조건에 부합하지 않고 target인 문자열이 존재한다면 해당 index를 위치를 뜻하는 변수에 대입시킨 뒤,<br>
count를 증감 연산자로 1 증가시킨다.

target이 AB로 총 두 자리인 만큼 위치를 저장한 변수에 그 길이만큼 +시켜, <br>
다시금 indexOf메서드를 통해 해당 index+target.lentgh부터 찾도록 반복한다.

이처럼 반복한 끝에 target인 문자열이 없으면 -1이 반환되고,<br>
break문으로 빠져나가 그 때까지 증감 연산자로 횟수를 센 숫자를 반환한다.

# [9-6]
- 답:

```
if(src==null || src.length()==length) {
  return src;
} else if(length <= 0) {
  return "";
} else if(src.length() > length) {
  return src.substring(0, length);
}

char[] cArr = new char[length];

for(int i=0; i<length; i++)
  cArr[i] = '0';

System.arraycopy(src.toCharArray(), 0, cArr, length-src.length(), src.length());

return new String(cArr);
```

- 해설: 매개변수의 유효성 검사를 위해 if-esle-if문으로 복수의 조건과 return을 설정한다.<br>
src가 널이거나 src.length()가 length와 같으면 src.<br>
length의 값이 0보다 같거나 작으면 빈 문자열.<br>
src의 길이가 length의 값보다 크면 substring메서드로 length만큼 잘라서 반환시킨다.

매개변수의 유효성 검사를 통과한 경우,<br>
length만큼 길이를 가진 char배열을 생성해 이를 '0'으로 채워넣는다.<br>
이후 src를 String클래스의 toCharArrya메서드를 통하여 같은 char[]로 변환시킨 뒤,<br>
System클래스의 arryacopy메서드를 통하여 src의 문자열들을 새로 생성한 char[]에 복사한다.

여기서 주의해야 할 점은 왼쪽의 빈 공간을 전부 0으로 채워넣어야 하므로,<br>
복사한 값들을 index 0부터 넣어선 안 된다는 점이다.<br>
고로 복사할 index를 설정할 때는 매개변수로 받은 length에 src.length를 차감하여 설정한다.

복사할 값들의 갯수는 src의 길이만큼 설정한다.<br>
만약 이를 오버할 경우 예외가 발생하니 주의.

마지막으로 String클래스의 생성자 매개변수에다가 해당 char[]을 집어넣어 만들어진 String을 반환한다.


# [9-7]
- 답:

```
return src.indexOf(target)!=-1;
```

- 해설: if문으로 indexOf메서드를 사용했을 때 반환되는 값이 -1이 아니면 true, -1이면 false를 반환한다.<br>
이는 해당 문자열이 존재하면 index를, 존재하지 않으면 -1을 반환하는 indexOf의 기능을 이용한 것.

# [9-8]
- 답:

```
if(n<0)
  return d;

return Math.round(d * Math.pow(10, n))/(double)Math.pow(10, n);
```

- 해설: 매개변수로 받는 반올림 자리가 0보다 작다면 double로 받은 값을 그대로 반환시킨다.

그렇지 않다면 반올림하는 식을 Math클래스의 round와 pow메서드를 사용하여 그대로 재현한다.<br>
여기서 중요한 건 반올림 하는 자리를 pow메서드의 매개변수인 10과 n으로 설정하여 구현한다는 점이다.

# [9-9]
- 답:

```
StringBuffer sb = new StringBuffer();

for(int i=0; i<src.length(); i++) {
  char ch = src.charAt(i);

  if(delCh.indexOf(ch)==-1)
    sb.append(ch);
}

return sb.toString();
```

- 해설: 기본 생성자만으로 StringBuffer클래스만 만들고,<br>
반복문과 charAt()로 src의 문자열을 문자형으로 하나하나 뽑아낸다.

이 문장형이 delCh라는 문자열에 존재하는지 어떤지를 indexOf의 반환값으로 구별하여,<br>
만약 존재한다면 무시하고 존재하지 않으면 append메서드를 통해 StringBuffer에 추가시킨다.

모든 과정이 끝나면 StringBuffer의 toString()로 String을 반환한다.
# [9-10]
- 답:

```
int distance = length - str.length();

if(distance<0)
  return str.substring(0, length);

char[] sorted = new char[length];

switch(alignment) {
  case 0:
    System.arraycopy(str.toCharArray(), 0, sorted, 0, str.length());
    break;
  case 1:
    System.arraycopy(str.toCharArray(), 0, sorted, distance/2, str.length());
    break;
  case 2:
    System.arraycopy(str.toCharArray(), 0, sorted, distance, str.length());
    break;
  default:
    return "다시 입력해주세요";
}

return new String(sorted);
```

- 해설: 여기서 중요한 건 오른쪽 정렬, 가운데 정렬, 왼쪽 정렬을 어떻게 나타낼 것인가다.<br>
오른쪽 정렬은 평범하게 출력하면 되지만 왼쪽 정렬인 경우에는 글자들이 전체에서 왼쪽에 붙어야 하며,<br>
가운데 정렬일 경우에는 한 가운데에 위치해야 한다.

이를 위해서는 바꾼 뒤의 길이(length)에 바뀌기 전 길이(str.length)를 뺄 필요가 있다.<br>
바꾼 뒤의 길이가 훨씬 긴 상태에서 바뀌기 전의 길이,<br>
즉 str의 문장들을 빼고 나온 수를 index로 삼으면 복사할 str의 문장들의 끝이 전체 길이의 맨 끝에 달할 것이다.

매개변수의 유효성 검사로서 만약 변환할 문자열의 길이보다 변환된 문자열의 길이가 더 작은 경우,<br>
substring메서드를 통해 그 길이만큼 str을 잘라내서 반환한다.

해당 검사를 통과하면 변환될 길이와 같은 길이의 char배열을 만든다.<br>
System클래스의 arraycopy메서드를 사용하여 str이 참조하는 문자열들을 새로 만든 char배열에 옮긴다.<br>
이 때, 주의점으로는 정렬 조건에 맞추어 저장되는 char배열의 index를 지정해야 한다는 것.<br>
그리고 char[]배열로 옮기는 것이므로<br>
str을 String클래스의 thCharArray()를 통하여 char형배열로 바꿔야 한다는 것이다.

조건문으로 if문을 써도 되지만 이리 할 경우,<br>
alignment==0, alignment==1, alignment==2로 조건이 중첩되기에 swich문을 쓰는게 더 간결하다.

이렇게 정렬조건에 맞춰 값들을 복사한 char형 배열을 매개변수로 String 인스턴스를 생성해 반환한다.

# [9-11]
- 답:

```
int table = 0;
int table2 = 0;
Scanner sc = new Scanner(System.in);

while(true) {

  String input = sc.nextLine();

  String[] arg = input.split(" +");

  try {
    if(arg.length < 2)
      throw new Exception("시작 단과 끝 단, 두 개의 정수를 입력해주세요.");

    table = Integer.parseInt(arg[0]);
    table2 = Integer.parseInt(arg[1]);				

    if(table<2 || table>9 || table2<2 || table2>9)
      throw new Exception("단의 범위는 2와 9 사이의 값이어야 합니다.");

  } catch(NumberFormatException NE) {
    System.out.println("숫자만 입력할 수 있습니다. 다시 입력해주세요.");
    continue;
  } catch(Exception e) {
    System.out.println(e.getMessage());
    System.out.println("USAGE: GugudanTest 3 5");
    continue;
  }

  if(table > table2) {
    int tmp = 0;
    tmp = table;
    table = table2;
    table2 = tmp;
  }

  for(int i=table; i<=table2; i++) {
    for(int j=1; j<=9; j++)
      System.out.printf("%d*%d=%d%n", i, j, i*j);
    System.out.println();
  }

  break;
```

- 해설: 우선 int table, table2를 만들고 초기화시켰다.<br>
이는 try-catch문에서 반복문을 try블럭에 쓰도록 강제되는 걸 방지하기 위함이다.

만약 이전 코드를 그대로 옮겨 try블럭에서 해당 변수들을 만들었을 경우,<br>
이중 for문 또한 try블럭에 존재해야 한다.

그러나 일찌감치 변수가 따로 존재한다면 이 값을 가지고 이중 for문을 작성하면 되기에<br>
굳이 try블럭에 반복문이 있을 필요가 없고,<br>
try블럭에서 예외가 발생하지 않으면 입력받은 숫자로 값이 바뀌니 구구단을 출력할 때도 문제가 발생하지 않는다.

while을 통해 무한반복문을 만들고 nextLine()로 입력받아,<br>
해당 값을 " +"처럼 공백을 구분자로 삼은 split()으로 나누어 String 배열에 저장한다.<br>
이 다음은 try-catch문과 if문을 통해 특정 조건을 처리한다.

if문이 실행될 경우, 각각의 메시지를 생성자로 담은 Exception을 발생(throw)시켜,<br>
catch블럭에서 Exception 인스턴스의 getMessage()를 통해 에러 메시지를 출력한다.<br>
이후 continue문으로 다시 처음으로 돌아가 입력받는다.

또한 try-catch블럭을 통하여 한글이나 영어를 입력받을 경우도 대비한다.<br>
만약 NumberFormatException이 발생하였을 경우,<br>
해당 catch블럭으로 이동하여 숫자만 입력 가능하니 다시 입력하라고 출력한다.<br>
이처럼 try-catch블럭을 통한 예외 처리는 조건에 따라 처리가 달라지는 식의 조건문처럼 활용이 가능하다.

마지막으로 해당 try-catch블럭이 수행된 뒤,<br>
if문을 통해 두 숫자를 비교하여 뒤가 더 클 경우 양쪽의 값을 맞바꾸고,<br>
이중 for문을 통하여 구구단을 출력한다.


# [9-12]
- 답:

```
return (int)(Math.random() * (Math.abs(to-from)+1)) + Math.min(from, to);
```

- 해설: Math.random을 사용하여 난수를 생성하여 반환할 때에는 곱하는 값으로 범위를 정하고,<br>
더하는 값으로 최소, 최대값을 설정한다.

여기서 중요한 건 to도 범위에 포함되어야 한다는 것이다.<br>
이를 위해서는 to에서 from을 뺸 절대값에 +1을 할 필요가 있다.

일반적으로 두 값의 차이만으로 범위를 정하면 to는 범위의 밖이 되어버린다.<br>
그렇기에 +1을 더해 to까지 범위에 포함시키는 것.

이를 코드로 나타내면 (Math.abs(to-from)+1)이며,
이를 Math.random으로 나오는 난수에 곱한 뒤	(int)로 형변환시킨다. <br>
Math.min 메서드를 통해 두 변수 중 작은 쪽을 반환받아 더하면 최소, 최대값이 설정된다.

앞서 사용한 abs는 절대값을 반환받고,<br>
min은 두 변수 중 작은 쪽을 반환하므로 변수의 순서는 상관없다.


# [9-13]
- 답:

```
int count = 0;
int index = 0;

if(key == null || key.length() == 0)
  return 0;

while((index=src.indexOf(key, pos))!=-1) {

  pos = index+key.length();
  count++;

}

return count;
```

- 해설:	while문의 조건으로 대상인 문자열에서 목적인 문자열(key)가 있는지 확인했을 때,<br>
key가 존재할 경우 계속 반복하도록 했다.

해당 조건식에서 조건을 확인함과 동시에 index를 변수에 저장한 뒤,<br>
key의 길이만큼 더해 pos의 값을 갱신한다.<br>
이는 indexOf의 두번째 매개변수가 문자열을 찾는 시작점을 의미하므로 앞서 찾은 문자열을 건너뛰기 위함이다.

이처럼 반복하면서 count를 증감 연산자로 증가시킨 뒤 최종적으로 해당 count를 반환한다.

# [9-14]
- 답:

```
Pattern p = Pattern.compile(".*"+input+".*");		


for(int i=0; i<phoneNumArr.length; i++) {
  String str = phoneNumArr[i].replace("-", "");
  Matcher m = p.matcher(str);
  if(m.matches()) {
    list.add(phoneNumArr[i]);
  }
```

- 해설: 우선 정규식 패턴으로 .*input.*을 만들어 입력받은 숫자가 포함된 것들을 조건으로 만들었다.<br>
이후, 반복문을 사용하여 String[]의 길이만큼 반복하면서 replace메서드를 사용한다.<br>
phoneNumArr[i]는 String이므로 replace를 통해 -를 빈 문자열로 치환하는 것이다.<br>
이렇게 반환받은 문자열을 matcher의 매개변수로 삼은 뒤, Matcher의 인스턴스를 반환받는다.

만약 matches메서드의 결과가 true라면(조건에 부합한다면),<br>
미리 만들어두었던 ArrayList클래스의 add메서드를 사용하여 해당 String을 list에 추가시킨다.
