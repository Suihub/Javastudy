# [11-1]
- 답 :

```
kyo.addAll(list1);
kyo.retainAll(list2);

cha.addAll(list1);
cha.removeAll(list2);

hap.addAll(list1);
hap.removeAll(list2);
hap.addAll(list2);
```

- 해설:	addAll()은 해당 Collection에 저장된 모든 객체를 객체 배열에 저장하는 메서드다.<br>
이를 통해 교집합, 차집합, 합집합에 모두 list1의 객체들을 집어넣는다.

교집합은 두 List에서 중복되는 객체들만 있어야 하므로,<br>
매개변수로 두 번째 List를 넣어 retainAll메서드를 사용한다.<br>
이 메서드는 매개변수로 받은 Collection의 내용과 동일한 객체만 남기고 나머지를 삭제하는 메서드다.

차집합은 같은 논리로 removeAll()을 사용한다.<br>
이는 매개변수로 받은 Collection의 내용과 동일한 걸 전부 삭제하는 메서드다.

합집합도 도중까지 차집합과 동일하나,<br>
마지막에 addAll()로 list2의 객체들을 전부 추가한다.<br>
앞서 removeAll()로 중복되는 객체들을 삭제한 뒤이므로 중복 없는 집합이 된다.

# [11-2]
- 답: <br>
7<br>
6<br>
3<br>
2

- 해설: 이 코드는 다음과 같은 과정을 거친다.

1) ArrayList에 [3, 6, 2, 2, 2, 7]이 저장 (Integer객체)

2) HashSet은 중복을 허락하지 않으므로 이로 옮길 시에 Integer(2)는 하나만 저장된다.

3) TreeSet은 자동으로 정렬하는데,<br>
정렬 기준인 Integer의 내부 Comparable은 오름차순이므로 2, 3, 6, 7의 순서가 된다.

4) 새로운 Stack에 오름차순으로 정렬된 각 객체를 순차적으로 추가한다.<br>
stack은 마지막에 들어간 것이 가장 먼저 빠져나가므로 pop()을 사용한 출력 순서는 7, 6, 3, 2가 된다.

# [11-3]
- 답: a

- 해설: ArrayList는 순차적인 추가 및 삭제가 빠르지만,<br>
중간에 새로운 요소를 추가하거나 삭제할 경우,<br>
요소의 재배치를 위해 값들을 이동시키거나 배열의 복사가 이루어지므로 비용이 많이 발생한다.<br>
순차적인 추가와 삭제는 어디까지나 마지막 요소의 추가 및 삭제를 말하는 것이며,<br>
첫 번째 요소를 삭제한다면 이를 앞당기기 위해 모든 요소가 움직여야 하므로<br>
중간에 첨삭하는 경우보다 더욱 큰 비용이 발생한다.

# [11-4]
- 답: 6번째 요소

- 해설: 이중 원형 연결리스트는 오버플로우처럼 첫 번째 요소가 마지막 요소와 이어져 있으므로,<br>
필연적으로 접근 시간이 오래 걸리는 건 어느 방향으로 접근하든 거리가 먼 가운데 요소이다.

# [11-5]
- 답:

```
public int compareTo(Object o) {
  if(o instanceof Student) {
    Student tmp = (Student)o;

    return name.compareTo(tmp.name);
  } else {
    return -1;
  }
}
```

- 해설:	Comparable 인터페이스를 구현하려면,<br>
추상 메서드인 compareTo를 완성해야 한다.

본 문제에서는 name을 기준으로 정렬하고자 하므로,<br>
우선 매개변수의 유효성 검사로 Student 클래스로 형변환이 가능한지 확인한다.<br>
만약 형변환이 불가능하면 -1을 반환한다.

형변환이 가능하다면 매개변수로 받은 Object를 형변환시켜 Student 참조변수로 참조한다.<br>
그 후, this의 name이 String인 걸 이용해 String클래스의 compareTo를 호출한다.<br>
이는 String 내부에 구현된 Comparable을 이용하는 것으로,<br>
해당 결과를 통해 오름차순으로 정렬한다.

# [11-6]
- 답: src 참조

- 해설: Comparator의 익명 클래스로 새로운 정렬 기준을 만들어,<br>
이를 기준으로 삼은 TreeSet을 생성해 사용하는 문제다.

평균을 사용해 오름차순으로 정렬할 것이나,<br>
그에 앞서 두 객체 모두 Student로 형변환할 수 있는지를 검사한다.<br>
만약 형변환할 수 없으면 -1을 반환한다.

변환할 수 있다면 두 객체를 형변환시켜 Student 참조변수로 참조한 다음,<br>
getAverage()를 호출해 반환받은 평균값을 차감해,<br>
이를 int로 형변환시킨 값을 반환한다.

getGroupCount()의 경우, subSet을 사용하면 간단히 완성할 수 있다.<br>
매개변수로 받는 TreeSet은 앞서 구현한 Comparator를 기준으로 값을 정렬하므로,<br>
이에 걸맞게 subSet을 사용한다.

매개변수로 받는 from과 to는 평균값들이며,<br>
Student객채에서 평균이 이처럼 나오려면 평균을 구하기 위한 각 점수를 전부 해당 변수와 동일하게 설정해야 한다.

from과 to로 int값들을 채워 넣은 Student객체를 두 개 만든 뒤,<br>
이 두 객체로 subSet()을 사용하면 앞서 구현한 기준에 따라 정렬한 Set을 반환한다.<br>
이 Set의 size()가 해당 범위에 속한 학생(객체)들의 숫자다.

# [11-7]
- 답:

```
public int compare(Object o1, Object o2) {
  if(!(o1 instanceof Student && o2 instanceof Student)) return -1;

  Student s1 = (Student)o1;
  Student s2 = (Student)o2;

  if(s1.ban==s2.ban) return s1.no-s2.no;

  return s1.ban-s2.ban;
```

- 해설: 두 객체의 ban 또는 no로 정렬하기에 앞서 매개변수의 유효성을 검사한다.<br>
! 연산자를 사용해서 형변환이 불가한 경우에는 -1을 반환한다.

위 조건을 통과한 경우 두 객체를 Student로 형변환시킨 후, <br>
두 객체의 ban을 차감시킨 값을 반환해 오름차순으로 만든다.<br>
ban이 같을 경우에는 if문을 사용해 no로 두 객체를 비교해서 정렬시킨다.

# [11-8]
- 답:

```
public int compareTo(Object o) {
  if(o instanceof Student2) {
    Student2 s = (Student2)o;

    return s.total - total;
  } else {
    return -1;
  }
}

public static void calculateSchoolRank(List list) {
  Collections.sort(list);

  int prevRank = -1; 	
  int prevTotal = -1;
  int length = list.size();

  for(int i=0; i<length; i++) {
    Student2 s = (Student2)list.get(i);

    if(s.total==prevTotal) {
      s.schoolRank = prevRank;
      continue;
    }

    s.schoolRank = i+1;

    prevRank = s.schoolRank;
    prevTotal = s.total;
  }
}
```

- 해설: compareTo의 설명은 생략한다.<br>
앞선 문제들과 논리가 같으며, 내림차순이 목적이므로 차감시키는 변수의 위치가 반대란 점만 주의한다.

calculateSchoolRank()의 경우,<br>
우선 리스트의 객체들을 get()으로 받아낸 뒤, 이들을 Stdent2로 형변환시킨다.<br>
반환타입이 Object이므로 형변환하지 않으면 Stdent2의 멤버를 사용할 수 없기 때문이다.

만약 이전 점수와 해당 객체의 total이 동일하다면,<br>
이전 등수를 그대로 입력시킨 후 continue를 통해 반복문의 처음으로 돌아간다.<br>
그렇지 않다면 등수는 반복문의 매개변수에 +1을 시킨 값을 대입한다.

중복되는 점수일 경우, if문을 통해 이전 등수를 그대로 대입한다.<br>
위의 절차를 마친 후, 이전 등수와 이전 총합을 갱신한 뒤 마지막까지 이 과정을 반복한다.

# [11-9]
- 답:

```
public int compare(Object o1, Object o2) {
  if(o1 instanceof Student2 && o2 instanceof Student2) {
    Student2 s1 = (Student2)o1;
    Student2 s2 = (Student2)o2;

    return ((s1.ban*100) - (s2.ban*100)) + (s2.total - s1.total);

  }else {
    return -1;
  }

  public static void calculateClassRank(List list) {
		Collections.sort(list, new ClassTotalComparator());

		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();

		for(int i=0; i<length; i++) {
			Student2 s = (Student2)list.get(i);

			if(prevBan != s.ban) {
				prevRank = -1;
				prevTotal = -1;
			} else if(prevTotal == s.total) {
				s.classRank = prevTotal;
				continue;
			}

			s.classRank = i%3+1;

			prevBan = s.ban;
			prevRank = s.classRank;
			prevTotal = s.total;
		}
	}  
```

- 해설: compare()의 경우,<br>
매개변수의 유효성을 검사하고 이를 통과하면 두 객체 모두 Student2로 형변환한다.<br>
여기서는 먼저 반별로 오름차순을 한 뒤,<br>
반 내에서 점수별로 내림차순으로 정렬해야 한다.

이를 위해 멤버 변수 ban에 100씩 곱한 뒤에 ban끼리 차감시켜 오름차순 식으로,<br>
총점은 내림차순이 되도록 차감한 뒤 이들을 합한다.

백의 자리로 인해 반 별 오름차순으로 정렬되면서,<br>
십의 자리 이하인 총점 간에 차이로 인해 반 내에서는 내림차순이 된다.  

calculateClassRank()는 문제 8번의 calculateSchoolRank와 거의 비슷하다.<br>
다른 점은 반이 달라졌을 경우, prevRank와 prevTotal을 초기화시키는 것이다.

규칙을 찾아보면 반별로 no가 3이 될 때마다 등수가 초기화되는 걸 확인할 수 있다.<br>
반마다 학생 수는 같을 것이므로,<br>
3을 피연산자로 삼아 나머지 연산자로 나온 결과에 +1한 값을 클래스 등수로 삼았다.

만약 반마다 학생 수가 다르다고 가정한다면,<br>
등수를 따로 담기 위한 변수를 새로 만들 필요가 있다.

calculateSchoolRank메서드에서는<br>
등수를 위한 변수를 따로 만들지 않고 반복문의 매개변수가 그 역할을 맡았으나,<br>
반 별 등수는 반마다 초기화되어야 하므로 또 다른 변수가 꼭 필요하다.

이 경우, 메서드 내에서 count할 지역변수를 새로 만들던가.<br>
반복문 매개변수에 변수를 하나 더 추가해 이를 반 등수를 위한 변수로 사용한다.<br>
어느 쪽이든 +1을 하며 카운트하고, 반이 초기화될 시에 함께 0으로 초기화하면 된다.

# [11-10]
- 답: src 참조

- 해설: HashSet은 저장하는 순서를 보장하지 않고 내부에서 해싱 알고리즘에 따라 값들을 저장하므로,<br>
무작위로 생성된 값들이라 하더라도 HashSet 내부에서 일정한 경향으로 저장이 되고 만다.

고로 set 참조변수로 참조할 객체는 HashSet이 아니라,<br>
순서를 보장하고자 보완된 LinkedHashSet을 사용한다.

그도 아니면 ArrayList의 생성자로 set을 넣어 List로 만든 뒤,<br>
Collections의 sort()메서드를 사용해서 섞는 것도 가능하다.

# [11-11]

- 답:

```
public int hashCode() {
  return toString().hashCode();
}
```

- 해설:	HashSet과 HashMap, HashTable과 같이 해싱 기법을 사용하는 경우,<br>
hashCode와 equals는 필히 오버라이딩해야 한다.<br>
객체의 동일성을 확인해야 하기 때문이다.

hashCode를 반환받는 방법은 두 가지가 있는데,<br>
하나는 JDK1.8부터 추가된 Objects클래스의 hash메서드를 사용하는 것이다.<br>
구분을 위한 인스턴스 변수들을 매개변수 칸에 전부 넣으면 된다. <br>
이는 해당 메서드가 매개변수를 가변 인자로 받기 때문이다.

또 하나는 답지와 같은 방법으로,<br>
구분을 위한 인스턴스 변수들을 String으로 만든 뒤 String클래스의 hashCode메서드를 사용한다.<br>
이 클래스에선 오버라이딩한 toString을 호출해 hashCode()를 사용했다.

# [11-12]
- 답: src 참조

- 해설: 족보는 HashMap의 put메서드로 key가 되는 카드값들과 실제 점수를 value로써 추가한다. 	

jokbo에서 value를 얻으려면 해당 key가 실제하는지르 확인해야 한다.<br>
우선 KK인 경우를 확인하기 위한 조건문을 작성하고,<br>
이에 해당한다면 "KK"를 매개변수로 삼아 value값을 얻어 result에 저장한다.<br>
get()의 반환 타입은 Object이므로 Integer로 형변환시켜야 한다.

그 밖에 조합이 족보에 있는 key인지는 containsKey메서드로 확인한다.<br>
각 카드의 num들을 합친 문자열이 jokbo에 존재한다면 반환 값은 true가 된다.

true라면 위의 KK 처리와 같은 수순으로 처리하고,<br>
false라면 나머지 else문으로 이동해 (c1.num+c2.num)% 10 +1000식으로 점수를 구한다.<br>
곧바로 result에 대입하는 것처럼 보이지만,<br>
이는 오토박싱을 이용한 것으로 int에서 래퍼 클래스로 바꾸는 과정이 생략되었다.

마지막으로 위의 과정을 거쳐 구한 점수를 플레이어의 point 변수에 대입한 뒤,<br>
result를 int로 바꿔 반환한다.

# [11-13]
- 답:

```
TreeMap rank = new TreeMap(new Comparator() {
  public int compare(Object o1, Object o2) {
    if(o1 instanceof Player && o2 instanceof Player) {
      Player p1 = (Player)o1;
      Player p2 = (Player)o2;

      return p2.point - p1.point;
    }

    return -1;
  }
});
```

- 해설:	매개변수의 유효성 검사는 필수라는 점.<br>
내림차순일 경우, 빼는 순서가 반대라는 점을 유의한다.

# [11-14]
- 답: src 참조

- 해설: displayMenu()의 경우,<br>
while문으로 무한반복문을 돌리면서 try-catch를 통해 예외를 처리시켰다.<br>
이는 입력받은 값이 숫자가 아닌 때와 숫자는 숫자이되 범위 밖인 경우를 동시에 처리하기 위함이다.

예외가 발생했을 시 catch블록이 수행되어,<br>
다시 입력하라는 내용과 원하는 메뉴를 선택하라는 내용의 안내문을 출력한다.<br>
이 while문은 무한반복이므로 해당 안내가 출력된 뒤에 다시 값을 입력받는다.<br>
제대로 된 값이 입력되면 이를 menu에 대입하고 break으로 반복문을 빠져나간다.

여기서 중요한 건 nextLine()으로 값을 받아 이를 래퍼 클래스의 parse로 int화 시킨다는 점이다.<br>
애초에 int로 받아내면 된다는 생각으로 nextInt()를 사용하면 예외 처리로도 처리할 수 없는 예외가 발생한다.<br>
Scanner의 nextInt()나 다른 값으로 받는 경우는 예기치 못한 오류가 발생할 확률이 높으므로,<br>
가급적 nextLine()으로 입력값을 받아 이를 parse로 적절하게 형변환시키는 방식을 택하자.

inputRecord()의 경우,<br>
nextLine()으로 입력받은 값들을 String의 참조변수로 참조한다.<br>
이때, trim()으로 좌우 공백을 없애는 걸 습관화한다.

입력받은 값이 q인지 어떤지를 if문으로 확인한 뒤, q라면 곧바로 메서드를 종료시킨다.<br>
메서드가 끝나면 도로 무한반복문으로 돌아가므로 프로그램 첫 화면이 나올 것이다.

q가 아니라면 그대로 try-catch블록을 수행한다.<br>
앞서 만든 String을 대상으로 새롭게 Scanner 객체를 만들어 이를 읽어낸다.<br>
여기서 Scanner의 useDelimiter메서드를 사용해 ","를 구분자로 삼아 token으로 담아낸다.<br>
굳이 이런 식으로 나누는 이유는 parse메서드가 ','를 처리할 수 없기 때문이다.

두 번째 Scanner에 구분자를 통해 나눈 결과를 저장한 뒤,<br>
next메서드와 nextInt메서드를 사용해서 차례대로 값을 반환받아 Student2 객체를 생성한다.<br>
이들 메서드는 Scanner 내에 저장된 token을 각각 String, Int로 반환받는 메서드이다.<br>
여기서 next()대신 nextLine()을 쓰지 않도록 조심한다.<br>
반환타입이 같은 String이라 해도 내부의 구조가 다르기에 nextLine()으로는 제대로 값을 읽어내지 못한다.

위 과정에서 예외가 발생한다면 catch 블록이 수행되어 입력 오류를 알리고,<br>
발생하지 않으면 그대로 add메서드를 사용해 생성한 Student2 객체를 ArrayList에 추가한다.<br>
q 입력으로 종료할 때까지 위 과정을 반복한다.
