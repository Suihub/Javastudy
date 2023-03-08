# [13-1]
- 답: src 참조

- 해설: Runnable을 구현하면서 run()을 오버라이딩한다.<br>
그 후, Thread 생성자의 매개변수로 Runnable을 구현한 클래스를 대입한다.

# [13-2]

- 답: src 참조

- 해설: start()로 서로 다른 호출 스택에서 수행했다면 섞여서 출력됐을 테지만,<br>
이 문제에서는 run()을 호출했으므로 main쓰레드에서 작업을 수행한다.<br>
고로 run()이 작업을 마친 뒤, 두 번째 반복문이 돌아가므로 결과는 순서대로 출력된다.

# [13-3]

- 답: b, f

- 해설: 일시 정지로 만드는 메서드로는 suspend(), wait(), join(), sleep()가 있으며,<br>
이들을 실행 대기 상태로 되돌리는 메서드는 interrupt(), notify(), resume()이다.

# [13-4]

- 답: d

- 해설: sleep(), wait(), join() 모두 interrupt()를 호출하면 InterruptedException이 발생하고,<br>
쓰레드는 실행 대기로 바뀐다.<br>
그러나 suspend()는 내부 구조로 인해 resume()에만 반응한다.

# [13-5]

- 해설: main쓰레드와 멀티 쓰레드는 다른 호출 스택에서 작업하므로,<br>
5초가 지난 후 main쓰레드에서 예외가 발생해 종료되어도,<br>
다른 호출 스택에서 작업하는 run()은 멈추지 않는다.

# [13-6]

- 해설: 데몬 쓰레드는 일반 쓰레드를 보조하기 위한 쓰레드로,<br>
일반 쓰레드가 모두 종료하면 그 역할을 잃기에 함께 강제 종료한다.<br>
run()은 아직 수행할 작업이 남았으나 일반 쓰레드인 main쓰레드가 종료했으므로 이 또한 함께 정지한다.

# [13-7]
- 답: src 참조

- 해설: stopped는 true로 바뀌었으니 곧바로 쓰레드가 종료해야 할 것 같으나,<br>
run()은 출력한 후 3초간 sleep하므로 변경이 곧바로 반영되지 않는다.<br>
고로 interrupt()를 호출해 예외를 발생시켜 실행대기로 만들고 곧바로 멈추게 한다.

# [13-8]
- 답:
```
class WordGenerator extends Thread{
  public void run() {
    while(true) {
      int idx = (int)(Math.random()*data.length);
      words.add(data[idx]);

      try {
        Thread.sleep(interval);
      } catch(InterruptedException e) {}
    }
  }
}
```

- 해설: 무한반복문으로 쓰레드를 돌린다.<br>
우선 배열의 개수만큼 난수를 받도록 하고, 이를 통해 얻은 String을 words에 추가한다.<br>
그 후, sleep을 통해 interval만큼 쓰레드를 일시정지한다.

# [13-9]
- 답: src 참조

- 해설: 본 문제의 구조는 interrupt()로 interrupt를 false에서 true로 바꾸고,<br>
  이를 통해 해당 반복문에서 빠져나오는 걸 의도로 삼고 있다.<br>
  단, 출력마다 Thread가 sleep 상태에 있다는 게 논리적 오류를 일으킨다.

  interrupt()를 호출하면 sleep되어 있던 쓰레드에서 InterruptedException이 발생해 실행 대기로 돌아간다.<br>
  이때, 자동으로 true였던 interrupt가 false로 초기화된다.<br>
  그 때문에 쓰레드는 계속 움직이면서 카운트다운이 지속되는 것이다.

  고로 catch블럭에 interrupt()를 추가해 다시금 true로 변경할 필요가 있다.
