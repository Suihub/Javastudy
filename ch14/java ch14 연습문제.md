# [14-1]
- 답: a) (name, i) -> System.out.println(name+"="+i)

b) x -> x * x

c) () -> (int)(Math.random * 6)

d) (int[] arr) -> {<br>
    int sum = 0;<br>
    for(int i : arr)<br>
        sum += i;<br>
    return sum;<br>
}

e) () -> new int[]{}

# [14-2]
- 답: 1) String::length<br>
2) int[]::new<br>
3) Arrays::stream<br>
4) String::equals<br>
5) Integer::compare<br>
6) Card::new<br>
7) System.out::println<br>
8) Math::random<br>
9) String::toUpperCase<br>
10) NullPointerException::new<br>
11) Optional::get<br>
12) StringBuffer::append<br>
13) System.out::println

# [14-3]
- 답: d

- 해설: 람다식의 매개변수와 반환 값의 타입이 동일하므로 Operator 인터페이스이며,<br>
매개변수가 두 개이므로 Operator 중 BinaryOperator가 맞다.

# [14-4]
- 답: src 참조

- 해설: 이 문제는 Stream을 사용한 경우와 사용하지 않고,<br>
함수형 인터페이스를 이용해서 풀이한 경우 두 가지로 나누어 작성했다.

우선 함수형 인터페이스를 이용한 경우,<br>
Predicate와 BinaryOperator, List를 매개변수로 받는 메서드를 만들었다.<br>
주사위의 눈이 들어있는 List 두 개를 매개변수로 받아 향상된 for문을 중첩해 돌리고,<br>
Predicate로 구현한 람다식으로 결과를 확인하는 것이다.

BinaryOperator, Predicate 모두 람다식을 사용했을 뿐,<br>
두 눈을 합하고 결과를 확인하는 논리는 일반적일 때와 같다.

Stream을 사용할 경우,<br>
미리 만들었던 List의 메서드 stream()을 이용해서 List를 요소로 Stream으로 만든다.

그 후, flatMap()을 사용하는데 이는 Stream<int[]>가 되도록 하기 위함이다.<br>
map으로 배열을 요소로 가진 스트림을 다룰 경우 내부가 별도의 스트림으로 변해 Stream<Stream<T[]>>가 되기 때문이다.<br>
배열을 요소로 가진 스트림을 다룰 시에는 flatMap()을 사용한다.

이 flatMap의 매개변수로 대입하는 람다식을 통해,<br>
앞서 만든 List 내의 요소 하나마다 또 다른 1~6까지의 숫자와 조합하여 int[i, i2]의 배열이 되도록 한다.<br>
한 문장씩 풀어서 해설하면 아래와 같다.

i -> Stream.of(1, 2, 3, 4, 5, 6).map(i2 -> new int[]{i, i2})

Stream<List<Integer>>에서 flatMap을 쓰고 있으므로,<br>
람다식으로 적혀있는 매개변수 i는 List에 저장된 요소들이다.

Stream클래스의 of는 매개변수를 가변 인자로 받으므로,<br>
1~6까지의 숫자를 넣으면 내부에 배열이 만들어져 이들을 토대로 또 다른 스트림이 생성된다.<br>
이 1~6까지의 int가 들어있는 스트림이 map을 통해 int[]로 바뀌는 것이다.

스트림은 내부에서 반복문을 통해 모든 요소가 하나씩 반복되므로,<br>
앞서 스트림을 사용하지 않고 구현했던 이중 for문과 같은 내용이 스트림 내부에서 반복된다.

이렇게 생성된 내부 요소(int[])들을 filter()를 통해 걸러내고,<br>
해당 조건에 만족하는 배열들만 forEach로 출력한다.<br>
이때 Arrays클래스의 toString으로 배열을 String의 형식으로 반환받아 출력한다.

# [14-5]
- 답: src 참조

- 해설: String[]을 요소로 스트림을 만든 뒤,<br>
mapToInt()를 통해 기본형 스트림으로 변환한다.<br>
이때의 기준은 문제에서 요구하는 대로 문자열의 길이여야 하므로 String::length를 매개변수로 준다.<br>
이는 s -> s.length라는 람다식을 메서드 참조로 줄인 것이다.

기본형 스트림에는 sum()을 비롯한 편리한 메서드가 있으므로,<br>
이를 호출해 출력한다.

# [14-6]
- 답: src 참조

- 해설: 5번과 마찬가지로 기본형 스트림의 max()를 활용한다.<br>
단, 이 메서드의 반환타입은 Optional이므로 getAsInt()로 저장된 요소를 출력한다.

만약 문자열이 가장 긴 요소를 출력하는 문제라면,<br>
기본형 스트림으로 만들지 않고 sorted()를 사용한다.

중간 연산인 sorted, 그 매개변수로 Comparator의 static메서드인 comparingInt를 대입하고<br>
정렬 기준을 문자열의 길이로 줘서 Comparator를 반환시키면 된다.<br>
이때, 문자열이 가장 긴 경우를 묻고 있으므로 reversed(Comparator의 default메서드)로 역순으로 만들어야 한다.<br>

그 후, limit(1)로 가장 앞쪽의 요소만 담긴 스트림으로 만든 뒤,<br>
최종 연산인 forEach로 출력하면 된다.

# [14-7]
- 답: src 참조

- 해설: java.util 패키지의 Random클래스에는 기본형 스트림을 반환하는 메서드가 있다.<br>
이 ints메서드를 사용해서 1~45까지의 숫자를 요소로 가진 스트림을 반환받는다.

이 스트림은 무한 스트림이므로 중간 연산 limit()로 자르던가,<br>
오버로딩된 ints메서드 중 streamSize를 정할 메서드를 사용한다.

그 후, distinct와 sorted로 중복 제거 후 정렬하고 내용을 최종 연산 forEach로 출력한다.

# [14-8]
- 답:

```
Map<Boolean, Map<Boolean, Long>> failedStuBySex = Stream.of(stuArr)
    .collect(Collectors.partitioningBy(Student::getIsMale,
         Collectors.partitioningBy(s -> s.getScore() < 150, Collectors.counting())));
```

- 해설: Stream의 요소들을 특정 기준으로 분할하는 것이므로,<br>
여기서는 groupingBy보다 partitioningBy가 더 적합하다.

우선 Student클래스의 getIsMale메서드를 메서드 참조로 호출해 그 결과 값으로 나누고,<br>
다시 한번 partitioningBy를 사용해 value에 Map을 저장시킨다.

문제에선 150점 미만 대상자를 가리도록 하고 있으므로,<br>
Predicate를 매개변수로 받는 key 부분은 getScore로 얻은 값이 150명 미만인 이들이 true가 되도록 했다.<br>
value는 Map의 지네릭스 타입이 Long이므로 해당하는 인물의 숫자를 저장한다는 걸 알 수 있다.<br>
고로 Collectors클래스의 static메서드인 couning()의 결과값을 저장한다.

# [14-9]
- 답:

```
Map<Integer, Map<Integer, Long>> totalScoreByHakAndBan = Stream.of(stuArr)
    .collect(Collectors.groupingBy(Student::getHak,
         Collectors.groupingBy(Student::getBan,
             Collectors.summingLong(Student::getScore))));
```

- 해설: Map의 지네릭스 타입을 보면 알 수 있듯이,<br>
그룹화시키는 조건이 단순한 boolean이 아니므로 groupingBy()를 사용한다.

이를 이중으로 사용해 학년과 반으로 나누고,<br>
Collectors의 static메서드인 summingLong메서드를 사용해 총점을 전부 합한 값을 저장시킨다.
