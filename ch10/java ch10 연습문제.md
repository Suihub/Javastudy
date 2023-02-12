# [10-1]
- 답: src 참조

- 해설: Calendar는 인스턴스 생성이 불가능하므로 getInstance를 통해 객체를 반환받는다.<br>
SimpleDateFormat클래스를 출력 결과에 맞추어 패턴을 작성해 생성한다.

1년 중 12개월을 전부 출력할 것이므로 조건식은 12월까지 돌아가도록 한다.<br>
앞서 만든 Calendar를 매번 2010년, 매개변수, 10일로 초기화한다.<br>
Calendar에서 달은 0부터 세므로 for문의 매개변수로 하는 것이 편하다.

위와 마찬가지로 set메서드를 통해 각각 필드로 DAY_OF_WEEK와 DAY_OF_WEEK_IN_MONTH를 지정해,<br>
요일은 일요일, 그달의 차례는 2번째로 고정한다.

마지막에는 getTime메서드로 Date클래스로 바꿔준 다음,<br>
이를 매개변수로 삼아 format메서드를 사용해서	출력한다.<br>
SimpleDateFormat의 format메서드는 Date밖에 못 다루기 때문이다.

# [10-2]
- 답:

```
int monDiff = 0;

if(from==null||to==null) return 0;
if(from.get(Calendar.DAY_OF_MONTH)==to.get(Calendar.DAY_OF_MONTH) && from.get(Calendar.DAY_OF_MONTH)==21) {
  return 1;
}

int fromYear = from.get(Calendar.YEAR);
int fromMonth = from.get(Calendar.MONTH);
int fromDay = from.get(Calendar.DAY_OF_MONTH);

int toYear = to.get(Calendar.YEAR);
int toMonth = to.get(Calendar.MONTH);
int toDay = to.get(Calendar.DAY_OF_MONTH);

monDiff = (toYear * 12 + toMonth) - (fromYear * 12 +fromMonth);

if(monDiff < 0) return 0;

if(fromDay<=21 && 21 < toDay) {
  monDiff++;
} else if(fromDay > 21 && 21> toDay) {
  monDiff--;
}

return monDiff;
```

- 해설: 차이를 담을 monDiff 변수를 만들어 0으로 초기화한다.<br>
매개변수로 받은 두 객체 중 하나라도 null일 시 0을 반환한다.<br>
get메서드를 통해 각각의 일자를 비교하여 동일하고 21일일 시, 1을 반환한다.

개월 수를 구할 경우, 개월마다 일자가 다르기에<br>
일괄적으로 1000분의 초를 받아 계산하는 방법은 사용하지 못한다.<br>
고로 from과 to, 양쪽의 연도와 개월을 변수에 담은 뒤,<br>
연도에 12를 곱하여 개월로 바꾸고	기존의 개월을 더함으로써 정확한 개월을 구한다.<br>
이때,	이들을 차감해서 만약 나중이어야 할 to가 더 이전이었을시 0을 반환하게 한다.

개월 수의 차이는 목적인 21일의 차이와 거의 동일하다.<br>
그러나 세세한 날짜에 의해 21일을 카운트하지 못한 경우,<br>
또는 21을 하나 더 카운트했을 경우를 대비해<br>
from이 21일 이전이면서 to가 21일 이후인 경우에는 마지막 달의 21일을 포함해야 하므로 ++.<br>
from이 21일 이후이면서 to가 21일 이전인 경우 본래 포함되지 않아야 할 경우가 포함됐으므로 --을 한다.

# [10-3]
- 답: src 참조

- 해설: 문자열을 double값으로 바꿀 때는 parse나 valueOf메서드가 그 역할을 하지만,<br>
래퍼 클래스의 parse메서드는 문자열의 ,를 처리하지 못한다.<br>
그러므로 형식화 클래스, 그중에서도 숫자를 다루는 DecimalFormat을 이용한다.

문자열에 맞춰 패턴 #,###.##로 DecimalFormat 인스턴스를 생성한 뒤,<br>
parse를 사용해 파싱한 숫자를 Number클래스로 반환받고, 이를 다시 doubleValue()를 통해 double로 바꿔준다.

try-catch문을 사용하는 이유는 형식화 클래스의 parse메서드가 예외를 선언한 메서드이기 때문이다.<br>
반올림과 만 단위로 나누는 것 또한 그에 맞춘 패턴 '#', '#,####'으로 형식화 클래스를 생성하고,<br>
앞서 만든 double값을 매개변수로 삼아 format메서드로 출력한다.

# [10-4]
- 답: src 참조

- 해설: Scanner클래스와 SimpleDateFormat클래스를 사용해야 하므로 해당 경로를 import문으로 추가한다.<br>
특정 패턴으로 날짜를 파싱해야 하므로 문제에서 요구하는 패턴을 토대로 형식화 클래스를 생성한다.<br>
그 외에 입력한 날짜가 무슨 요일인지 출력하는 패턴을 가진 클래스를 새로이 만든 뒤, while로 무한 반복문을 돌린다.

문제의 실행 결과를 보면 다른 걸 입력할 시에 같은 문장이 되풀이되는 걸 볼 수 있다.<br>
parse메서드에 대한 예외 처리로 쓰는 try-Catch문에서 catch블록은 공백으로 놔두고,<br>
만약 예외가 발생할 시(다른 문장이 들어올시) 도로 반복문의 앞으로 돌아가도록 짰다.

입력하라는 안내문을 출력한 뒤,<br>
try블록에서 입력값을 그대로 패턴에 맞추어 날짜로 파싱한다.<br>
그리고 이를 두 번째로 만든 패턴에 맞추어 format해서 출력한다.

# [10-5]
- 답:

```
int diff = 0;


try {
  Calendar date1 = Calendar.getInstance();
  Calendar date2 = Calendar.getInstance();

  int year1 = Integer.parseInt(yyyymmdd1.substring(0, 4));
  int month1 = Integer.parseInt(yyyymmdd1.substring(4, 6))-1;
  int day1 = Integer.parseInt(yyyymmdd1.substring(6, 8));

  int year2 = Integer.parseInt(yyyymmdd2.substring(0, 4));
  int month2 = Integer.parseInt(yyyymmdd2.substring(4, 6))-1;
  int day2 = Integer.parseInt(yyyymmdd2.substring(6, 8));

  date1.set(year1, month1, day1);
  date2.set(year2, month2, day2);

  diff = (int)((date1.getTimeInMillis()-date2.getTimeInMillis())/(24*60*60*1000));
} catch(Exception e) {	return 0; }

return diff;
```

- 해설:	날짜 간의 차이를 얻으려면 Calendar클래스에서 getTimeInMillis()를 통해 1000분의 1초로 환산하고,<br>
차이를 일자가 되도록 나누어야 한다. (1000 * 24시간 * 60분 * 60초)

문자열들의 형식은 정해져 있으므로 substring메서드를 통해 두 날짜의 각 연 월 일을 추출하고<br>
이를 토대로 Calendar의 날짜를 초기화한다.<br>
이때, 이 과정을 try-catch블록에 넣고 catch블록에서는 0을 반환하도록 만든다.<br>
예외가 발생했다는 것은 입력받은 문자열이 유효하지 않다는 뜻이기 때문이다.

# [10-6]
- 답: src 참조

- 해설: 생일과 오늘을 담아낼 Calendar 인스턴스.<br>
이들을 연-월-일로 출력할 형식화 클래스.<br>
그리고 날짜 차이를 담아낼 변수를 생성한 뒤, set()로 생일을 설정한다.

날짜의 차이는 1000분의 1초로 계산한 뒤에 (1000*24*60*60)으로 나누어 구한다.<br>
이때, int로의 형변환과 Math.abs를 사용함으로써 두 날짜 차이의 절댓값을 반환받는다.<br>
형식화 클래스의 format메서드는 Date만 매개변수로 받으므로 getTime()을 통해 Date로 변환시키는 걸 잊어선 안 된다.

그 밖에 Time패키지를 사용할 경우,<br>
LocalDateTime의 of와 now로 생일과 현재를 설정한 뒤 until메서드를 사용하여 날짜를 구한다.<br>
생일.until(now, ChronoUnit.DAYS);

# [10-7]
- 답: src 참조

- 해설: Time패키지로 구현했다.<br>
LocalDate클래스의 객체를 of를 통해 2016년 12월 첫날로 설정한 뒤,<br>
날짜 계산을 위한 메서드가 있는 TemporalAdjusters클래스를 이용한다.

dayOfWeekInMonth메서드는 특정 차례의 요일로 계산하며,<br>
이를 앞서 생성한 LocalDate 객체의 with메서드와 함께 사용해 값을 출력한다.

# [10-8]
- 답: src 참조

- 해설: 우선 뉴욕의 시간대를 얻기 위해 뉴욕의 시간대로 ZoneId를 생성하고,<br>
now메서드를 통해 현재 아시아/서울권의 시간대를 ZonedDateTime 인스턴스로 생성한다.<br>
이 클래스의 withZoneSameInstant메서드는 매개변수로 시간대를 받음으로써 다른 지역권의 같은 시간을 반환받는다.<br>
앞서 만들었던 ZoneId를 매개변수로 넣어 현재 뉴욕의 시간대도 획득한다.

시차를 초 단위로 얻기 위해선 각 지역의 Offset을 획득할 필요가 있다.<br>
getOffset()으로 Offset을 반환받은 뒤 해당 클래스의 getTotalSeconds()를 통해 이를 초 단위로 바꾼다.

시차를 구하는 문제이므로 서울과 뉴욕의 시차를 뺀 다음, 60(분)*60(초)으로 나눔으로써 시간 단위로 바꾼다.
