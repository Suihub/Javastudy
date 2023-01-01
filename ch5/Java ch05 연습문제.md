# [5-1]
답: d,e <br>
배열은 생성과 동시에 자동으로 자신의 타입에 맞게 기본값이 초기화된다.<br>
new int[5]를 입력할 경우 길이가 5인 배열이 생성되어 그 안에 값들은 전부 기본값이 된다.<br>
만약 단순히 new int[]를 입력하고 그 뒤에 블럭으로 값들을 적을 경우,<br>
괄호 안에 들어간 값의 개수에 의해 배열의 길이가 자동으로 결정되며 괄호에 적은 값들이 입력된다.

d는 이 두 경우가 중복된 경우로 괄호의 값들이 저장될 공간을 잃어버린 상태이다.<br>
앞서서 new int[5]로 길이가 5인 배열이 생성되어 값들이 저장되었는데,<br>
뒤쪽에 괄호를 붙여 다른 값들을 적으니 이들을 저장할 장소가 마땅치 않아 에러가 뜨는 것이다.<br>
배열의 초기화가 진행됐을 경우 따로 괄호를 붙인다 한들 이를 정의할 수 없다.

e는 배열의 선언과 생성이 혼동된 경우이다.<br>
배열을 선언하는 건 단지 생성된 배열을 다루기 위한 참조변수의 공간을 만들 뿐이다.<br>
실제로 배열이 생성되려면 연산자 new와 함께 배열의 타입, 길이를 설정해야 하며,<br>
이렇게 생성해야만 비로소 값을 저장할 공간이 만들어진다.

e는 대입 연산자와 new 연산자가 없는 것으로 보아 단순히 배열을 선언한 단계임을 알 수 있다.<br>
그 상황에서는 배열의 길이를 지정해도 아무런 의미를 갖지 않는다.<br>
길이는 배열을 생성할 시에 지정해야 한다.

# [5-2]
답: 2 <br>
arr[3].length를 묻고 있으므로 arr배열의 참조변수 중 arr[3]번째의 길이를 보면 된다.


# [5-3]
답:
```
for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
```
반복문으로 총합에 계속 값을 더한다.

# [5-4]
답:
```
for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				total += arr[i][j];
			}
		}// for end

		average = total / (float)(arr.length*arr[0].length);
```
2차원 배열이므로 이중 반복문을 통해 총합을 구한다.<br>
이후 이차원 배열의 행, 열을 곱해서 총개수를 구한 뒤 이를 float타입으로 형변환시켜서 나누었다.

# [5-5]
답:
```
for(int i=0; i<ballArr.length; i++) {
			int j = (int)(Math.random()*ballArr.length);
			int tmp = 0;
			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;

		}

		for(int i=0; i<ball3.length; i++) {
			ball3[i] = ballArr[i];
		}
```
저장을 위한 변수 tmp를 사용하여 ball[i]와 난수로 정해지는 ball[j]의 값을 맞바꾼다.<br>
이후, 조건식을 3번만 돌아가게 만들어서 ballArr의 앞에서 세 자리를 ball3으로 저장한다.

System클래스의 Arraycopy메서드를 사용하는 방법도 있는데,<br>
이 경우 (ballArr, 0, ball3, 0, 3)으로 설정해<br>
ballArr의 0번째부터 ball3의 0번째로 세 자리를 옮긴다.

# [5-6]
답: src 참조<br>
우선 실행 결과를 출력할 때, 500원, 100원 같은 동전의 종류가 자동으로 출력되도록,<br>
참조형 배열을 따로 만들어 각 동전의 종류를 배열값으로 저장했다.<br>
또한 동전의 개수를 저장할 int형 변수를 따로 만들었다.

배열을 주목하면 index 0부터 서서히 값이 작아지는 걸 볼 수 있다.<br>
고로 money를 coinUnit[i]으로 나머지를 나누고 값이 존재하는 경우를 조건식으로 삼았다.<br>
나머지가 존재하면 money를 coinUnit[i]로 나눈 뒤, 그 값만큼 money를 차감시킨다.

문제는 coinUnit의 값이 10원일 때이다.<br>
10의 배수는 나머지가 0이 되기 쉬우므로, 조건식에 ||(or)을 부여해<br>
coinUnit[i]==10인 경우를 추가시켰다.


# [5-7]
답:
```
coinNum = money/coinUnit[i];

if(coin[i]-coinNum<0) {
  coinNum = coin[i];
  coin[i] = 0;
} else {
  coin[i] -= coinNum;
}

money -= coinNum*coinUnit[i];
```
우선 코인의 개수를 각 배열의 요소로 금액을 나누어 구한다.<br>
그리고 그 개수만큼 coin배열의 요소에서 숫자를 빼면 되는데,<br>
문제는 가진 동전보다 더 많은 동전이 필요한 경우이다.

이 경우, if문으로 조건을 건 뒤 사용한 동전 개수를 '가진 동전'에 대입하고,<br>
해당 배열의 요소값을 0으로 바꿔낸다.

이후 이 개수에 해당 요소의 값만큼 곱해서 지불한 금액을 구한 뒤 money에서 빼면 된다.<br>
coinNum은 반복될 때마다 초기화되므로 이를 반복하면 각 금액마다 사용한 금액과 남은 동전 수를 구할 수 있다.

# [5-8]
답:
```
int[] answer = {1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2};
int[] counter = new int[4];

for(int i=0; i<answer.length; i++) {
  counter[answer[i]-1]++;
}

for(int i=0; i<counter.length; i++) {
  System.out.print(counter[i]);
  for(int j=0; j<counter[i]; j++) {
    System.out.print("*");
  }

  System.out.println();
}

```
counter배열의 각 자릿수0~3에 answer의 요소 1~4가 들어올 때마다 증가 연산자로 카운트시킨다.<br>
이를 통해 1~4의 숫자를 세는데, 중요한 건 answer[i]을 불러온 뒤 -1을 시켜야 한다는 것이다.<br>
만약 -1을 시키지 않으면 counter[1]~counter[4]가 범위가 된다.<br>
counter 배열은 총 4자리이므로 counter[4]는 범위가 넘어가 버려 오류가 뜬다.

이후, 바깥쪽 반복문에 counter[i]을 출력시켜 *을 몇 개만큼 출력할지 보여준다.<br>
안쪽 반복문에서는 counter[i]을 조건식의 범위로 삼아 앞서 카운트한 숫자만큼 *을 찍어낸다.

# [5-9]
답:
```
for(int i=0; i<star.length; i++) {
	 for(int j=0; j<star[i].length; j++) {
		 int y = star.length-1-i;
		 result[j][y]=star[i][j];
	 }
 }
```


90도로 회전한다는 것은 원래 배열의 0열이 바뀐 배열의 0행이 된다는 것이다.<br>

표를 통해 확인해보면	x축은 원래 열의 끝까지 이어지고,<br>
y축은 0행에서 3, 1행에서 2, 2행에서 1로 1씩 줄어든다.<br>
x축은 처음에 짰던 코드와 마찬가지로 안쪽 for문의 매개변수로 삼으면 된다는 걸 재확인했다.

문제는 y축의 위치이다.<br>
바깥쪽 for문의 변수 i를 통해 위의 결과가 나오도록 구현한다면,<br>
조건식은 '3-i'로 할 수 있을 것이다.

그렇다고 해서 단순히 3을 적는 것은 다소 부적절하다.<br>
나중에 배열의 값이 달라질 경우, 일일이 이런 식으로 표를 그려서 확인하는 건 비효율적이다.

이를 방지하기 위해 재차 찾아낸 규칙이 '배열의 길이'이다.<br>
바깥쪽 for문에 속해있는 star.length는 = 4 이다.<br>
가장 위 행의 y축 좌표는 3이므로 원래 배열의 길이에서 1을 뺀 값과 같다는 걸 볼 수 있다.<br>

	3 = star.length - 1 <br>
	'3-i' = star.length-1-i

90도 회전시킬 시에는 원래 배열의 행에서 1을 뺀 뒤,<br>
매개변수로 출력되는 y축 좌표가 사용됨을 알 수 있다.

# [5-10]
답:
```
for(int i=0; i<src.length(); i++) {
			char ch = src.charAt(i);
			if('a'<=ch && ch<='z') {
				result += abcCode[ch-'a'];
			} else if('0'<=ch && ch<='9') {
				result += numCode[ch-'0'];
			}
		}
```
chatAt메서드로 한 글자씩 변수 ch에 저장한 뒤 if문으로 조건을 나눈다.<br>
영어 소문자인 경우와 숫자인 경우로 암호가 갈리기 때문이다.

소문자인 경우 'a'를 빼서 나온 값으로 abcCode배열의 요소를 불러온다.<br>
숫자인 경우는 가장 최소값인 '0'을 빼서 숫자를 산출해 numCode배열의 요소를 불러온다.

# [5-11]
답: src 참조<br>
우선 배열의 각 열에 대한 값을 저장할 int형 변수를 3개 생성한다.<br>
이 변수들을 바깥쪽 반복문에 위치시켜 += 연산자로 [i][0]~[i][2]의 값들을 각각 총점으로서 더해나간다.<br>
각각의 총점들은 마지막에 result의 위치에 직접 대입하며, 이들을 모두 합친 값을 result[5][3]에 저장한다.

또한 각 행의 총점도 따로 구해야 하므로,<br>
바깥쪽 반복문에 int형 변수를 0으로 초기화시켜 행의 매개변수가 바뀔 때마다 총점을 초기화시킨다.

안쪽 반복문에서는 score의 값들을 result에 옮김과 동시에,<br>
한 칸 늘어난 위치에 총점을 +=로 증가시키며 저장해나간다.


# [5-12]
답: src 참조<br>
int count를 만든 뒤 성공 시에 증가 연산자로 count를 증가시켰다.<br>
모든 문제가 끝나 반복문이 종료한 뒤에는 printf문으로 word.length와 count를 통하여,<br>
'전체 3문제 중 2문제를 맞췄습니다.' 문장을 출력했다.<br>
word.length를 쓴 이유는 나중에 문제가 늘어나거나 줄어도 대응하기 위해서다.

# [5-13]
답:
```
	for(int k=0; k<question.length; k++) {
		int r = (int)(Math.random()*question.length);
		char tmp = question[k];
		question[k] = question[r];
		question[r] = tmp;
	}

```
toCharArray메서드에 의해 words배열의 각 문자열이 문자형 배열로 변한다.<br>
고로 각 배열의 개수 수만큼 반복해서 위치를 바꿔주기만 하면 된다.<br>
주의해야 할 점은 random메서드를 쓸 때 범위를 개수로 맞춰줘야 한다는 것과,<br>
int와 char가 쓰이는 곳을 구별하는 것이다.
