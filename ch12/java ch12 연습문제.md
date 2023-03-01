# [12-1]
- 답: a, b, c

- 해설: a. Box<Object> b = new Box<String>();<br>
지네릭 클래스의 참조변수와 생성자의 타입 변수는 서로 일치해야 한다.<br>
와일드 카드가 사용된 경우라면 참조변수간의 형변환이 가능할 수도 있으나,<br>
여기선 와일드 카드를 사용하고 있지 않으며 생성자와 참조 변수의 지네릭 타입이 불일치하고 있다.

b. Box<Object> b = (Object)new Box<String>();<br>
a와 동일.

c. new Box<String>().setItem(new Object());<br>
이미 Box 타입 변수에 String이 대입되었으므로 setItem의 매개변수 또한 String타입의 객체를 받는다.<br>
Object는 String의 조상이므로 이를 사용하지 못한다.

d. new Box<String>().setItem("ABC");<br>
String으로 타입이 대입된 상태에서, "ABC"라는 String 객체를 매개변수로 넣은 것이므로 허용한다.

# [12-2]
- 답: c, d

- 해설: a. Juicer.<Apple>makeJuice(new FruitBox<Fruit>());<br>
지네릭 메서드의 제한 조건은 'T extends Fruit'이므로 <Apple>을 타입으로 대입한 건 문제 없으나,<br>
실제 매개변수로 받는 생성자의 타입이 Apple과 불일치한다.<br>
와일드 카드가 아닌 이상, 타입은 서로 일치해야 한다.

b. Juicer.<Fruit>makeJuice(new FruitBox<Grape>());<br>
a와 동일.

c. Juicer.<Fruit>makeJuice(new FruitBox<Fruit>());<br>
타입을 <Fruit>으로 지정하였고 생성자 역시 이와 일치한다.

d. Juicer.makeJuice(new FruitBox<Apple>());<br>
타입 지정이 생략되었으나 실제 생성자의 타입에 따라 자동으로 대입되므로 문제없다.

e. Juicer.makeJuice(new FruitBox<Object>());<br>
해당 지네릭 메서드의 제한 조건은 Fruit과 그 자손뿐이기에, Object클래스는 타입 변수에 대입할 수 없다.

# [12-3]
- 답: c, d, g

- 해설: a. Box<?> b = new Box();<br>
Box<?> b에서 <?>는 와일드 카드 중, <? extends Object>를 줄여 쓴 것이다.<br>
Box는 Fruit과 그 자손으로 타입이 제한된 지넥스 클래스이므로 Object는 들어가지 못해 잘못되었다고 볼 수 있겠으나,<br>
참조변수에 와일드 카드를 사용하는 경우는 예외로 허용된다.

실제 객체가 String이라 하더라도 Object 참조변수로 다룰 수 있는 다형성처럼,<br>
와일드 카드를 사용하면 이와 비슷한 효과를 얻을 수 있는 것이다.

실제 객체를 생성하는 new Box()는 원시 타입이므로 지네릭을 사용하지 않아 경고가 뜨지만 에러는 아니다.<br>
이는 이전 버전과의 호환성을 중시한 결과다.

b. Box<?> b = new Box<>();<br>
참조변수는 와일드카드로 a와 동일하게 Object와 그 자손으로 지정해서 다형성을 이용하고 있다.<br>
실제 생성자의 타입은 <>로 생략되어 있는데, 이처럼 타입이 생략된 경우 같은 타입으로 간주한다.

여기서 중요한 건 참조변수의 타입을 따라가는 게 아니라,<br>
실제 지네릭 클래스의 타입을 따라가는 것이다.<br>
Box는 Fruit과 그 자손으로 제한된 지네릭 클래스이기에 여기서 <>는 Object가 아니라 Fruit으로 간주한다.
고로 new Box<> = new Box<Fruit>가 되므로 이 또한 문제없다.

c. Box<?> b = new Box<Object>();<br>
참조변수는 와일드 카드를 쓰고 있으며, <br>
new Box<Object>는 와일드 카드에 적힌 조건과 맞기에 얼핏 옳게 보이나,<br>
제한된 지네릭 클래스인 Box의 조건과 맞지 않으므로 에러가 뜬다.

d. Box<Object> b = new Box<Fruit>();<br>
지금까지와 달리 참조변수의 타입으로 와일드 카드를 쓰고 있지 않다.<br>
예외가 허용되는 건 와일드 카드인 경우만이므로, 명확한 타입을 대입할 거라면 제한 조건을 따라야 한다.<br>
참조변수의 타입이 제한 조건을 어기고 있을뿐더러, 양쪽의 타입도 일치하지 않으므로 에러가 난다.

e. Box b = new Box<Fruit>();<br>
원시 타입의 참조변수로 지네릭 클래스의 객체를 다루는 것도 허용한다.<br>
이 또한 a와 마찬가지로 호환성을 중시한 결과다.

f. Box<? extends Fruit> b = new Box<Apple>();<br>
참조변수에 와일드 카드를 사용해 다형성을 이용하고 있으며,<br>
실제 대입된 타입도 와일드 카드 및 지네릭 클래스의 제한 조건을 통과한다.

g. Box<? extends Object> b = new Box<? extends Fruit>();<br>
와일드 카드는 어디까지나 매개변수, 참조변수의 조건에 사용되는 것으로 실제 지네릭 클래스를 생성할 때는 사용하지 못한다.<br>
클래스 생성 시에는 대입해야 할 타입이 확실히 정해져야 하므로 new 연산자는 와일드 카드와 병용할 수 없다.<br>
이는 instanceof 연산자도 마찬가지다.

# [12-4]
- 답:

```
public static <T extends Product> ArrayList<T> merge(
    ArrayList<T> list, ArrayList<T> list2){
  ArrayList<T> newList = new ArrayList<>(list);

  newList.addAll(list2);

  return newList;
}
```

- 해설: 지네릭 메서드로 바꿀 것이므로 제어자인 static 오른쪽에 타입을 지정한다.<br>
원래의 메서드가 매개 변수로 와일드 카드를 사용해 Product클래스와 그 자손만 받았으므로 T extends Product로 제한을 둔다.

타입을 제한하였으니 매개변수의 ArrayList들의 타입도 간략히 <T>로 통일하며,<br>
내부에서 새로 생성하는 ArrayList의 타입과 반환시킬 List의 타입도 동일하게 처리한다.<br>
지네릭 메서드로 바꾸며 타입을 제한시켰으므로 와일드 카드를 사용할 필요가 없어진 것이다.

# [12-5]
- 답:

```
Deck() {
  int index = 0;

  for(Card.Kind kind : Card.Kind.values()) {
    for(Card.Number num : Card.Number.values()) {
      cardArr[index++] = new Card(kind, num);
    }
  }
}
```

- 해설: 열거형 2개에서 각각 값을 얻어 Card객체를 만들려면 이중 반복문을 돌릴 필요가 있다.<br>
반복문으로 이를 처리하기 위해 열거형을 배열로 반환받는 values()를 활용한다.<br>
cardArr의 index를 가리키는 변수를 따로 만들어 향상된 for문을 사용해 Card 객체를 생성해서 담아낸다.<br>
배열을 이용하는 반복문에서는 향상된 for문 쪽이 더 간결하다.

# [12-6]
- 답: c

- 해설: Documented는 애너테이션에 대한 정보가 javadoc으로 작성한 문서에 포함되도록 하는 애너테이션.<br>
Target은 애너테이션을 적용할 수 있는 대상을 지정하는 데 사용하며,<br>
Inherited는 해당 애너테이션이 상속할 수 있는 애너테이션이 되도록 할 때 붙이는 애너테이션이다.

메타 애너테이션은 애너테이션을 위한 애너테이션으로, 애너테이션에 붙이는 애너테이션들을 뜻한다.<br>
위에 3가지들은 각각 해당 애너테이션이 어떤 기능을 가지는지, 대상이 무엇인지를 붙이기 위해 사용하나,<br>
Native는 애너테이션에 붙이는 애너테이션이 아니라,<br>
네이티브 메서드에 의해 참조되는 상수 필드에 사용하는 애너테이션이다.

# [12-7]
- 답: b, d

- 해설: 요소의 반환 값들은 무조건 이름을 붙여야 한다.<br>
value가 이름일 경우에는 이를 생략할 수 있으나 해당 문제의 value는 String[] 쪽이고,<br>
int는 별개이므로 메서드의 이름을 함께 적어야 한다.<br>
또한 요소에 복수의 값을 넣을 때는 배열에서처럼 괄호{}를 추가로 사용해야 한다.
