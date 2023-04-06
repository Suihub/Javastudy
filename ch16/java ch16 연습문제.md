#[16-1]
- 답: src 참조

- 해설: 네트워크 주소와 호스트 주소를 담을 byte[]을 새로 만든 뒤,<br>
네트워크의 경우는 반복문을 통해 1byte씩 & 연산자를 수행하고<br>
호스트의 경우 서브넷 마스크를 ~ 연산자로 비트 전환한 뒤에 & 연산자를 수행한다.

비트 연산자 &는 양쪽 bit의 값이 모두 1일 때만 1을 결과로 얻기 때문에 IP주소의 마지막 8bit는 무조건 0이 된다.<br>
서브넷 마스크가 255.255.255.0일 경우, 호스트 주소인 마지막 8bit(1byte)는 00000000이기 때문이다.

반대로 이 호스트 자리만 뽑고 싶을 경우,<br>
서브넷 마스크를 비트 전환 연산자 ~를 통해 1과 0을 역전시킬 필요가 있다.<br>
255는 byte의 범위 중 최대값이기에(부호 없는 경우), 이는 2진수로 11111111이다.<br>
이를 ~ 연산자를 통해 0000000으로 바꾸고 위처럼 & 연산자를 수행하면 네트워크 주소 외에 호스트 주소만 뽑아낼 수 있다.

이 byte[]을 통해 다시금 InetAddress 객체를 반환받고,<br>
getHostAddress로 해당 Ip주소를 출력한다.

#[16-2]
- 답: c

- 해설: Tcp통신은 연결 지향적인 방식으로 순서를 보장하고 정확성을 보장하는 대신,<br>
Udp보다 속도가 느리다.

#[16-3]
- 답:

```
try {
  if(!address.startsWith("http://"))
    address = "http://"+address;

    url = new URL(address);
    input = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

    while((line = input.readLine())!=null) {
      ta.append(line);
      ta.append("\n");
    }

    input.close();
  } catch(Exception e) {
    ta.setText("유효하지 않은 URL입니다.");
  }
```

- 해설: 주소를 매개변수로 URL 객체를 생성한 다음<br>
openStream()을 통해 InputStream을 반환받아 보조스트림인 InputStreamReader, BufferedReader를 통해<br>
문장을 라인별로 읽어오도록 했다.

TextArea에 setText로 할 경우,<br>
이전 라인이 덮어씌워지므로 append()를 통해 기존의 문장에 이어서 출력하도록 했다.<br>
이 경우 개행문자를 넣어 줄 바꿈을 한다.

InputStreamReader는 바이트 기반 스트림을 문자 기반 스트림으로 바꾸는 보조 스트림으로,<br>
생성자에서 특정 인코딩을 지정하지 않으면 기반으로 하는 OS에 맞추어 인코딩이 설정된다.<br>
여기서는 한글 등이 깨지지 않도록 UTF-8을 지정했다.

#[16-4]
- 답:

```
try {
  serverSocket = new ServerSocket(7777);
  ta.setText("서버가 준비되었습니다.");
  socket = serverSocket.accept();
  ta.append("\r\n"+ "상대방과 연결되었습니다.");

  in = new DataInputStream(socket.getInputStream());
  out = new DataOutputStream(socket.getOutputStream());

  String msg = "";

  while(in!=null) {
    msg = in.readUTF();
    ta.append("\r\n"+msg);
  }

  try {
  out.writeUTF(nickname+">"+msg);
} catch(IOException ie) {
  ie.printStackTrace();
}
```

- 해설: 서버 소켓 객체를 생성한 뒤,<br>
이 서버 소켓에 연결하려 하면 accept()를 통해 이와 연결된 Socket을 생성해 반환받는다.

해당 소켓으로부터 InputStream과 OutputStream을 반환받아,<br>
입출력을 용이하게 하도록 보조스트림인 DataInput/OutputStream을 사용한다.

출력 부분에서 닉네임과 구분자, 내용을 합쳐서 출력하기에,<br>
입력에서는 그저 String 변수로 입력 내용을 참조하면 된다.
